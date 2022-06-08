package view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import api.ApiCall
import data.MovieData
import data.MovieInfo
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val state = mutableStateOf(true)
val movieInfo = mutableStateOf(MovieInfo("", 0f, null, 0, "", false, ""))

val movieList = arrayListOf<MovieData>()

@Composable
@Preview
fun App(apiCall: ApiCall, windowState: WindowState) {
    if (state.value) {
        MovieView(apiCall)
    } else {
        CurrentMovieView(apiCall, windowState)
    }
}

@Composable
private fun CurrentMovieView(apiCall: ApiCall, windowState: WindowState) {
    MaterialTheme {
        val movie = movieInfo.value
        val image = remember { mutableStateOf<ImageBitmap?>(null) }

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = HexToJetpackColor.getColor("2E4053"))
        ) {
            Button(
                modifier = Modifier.width(170.dp).height(80.dp).padding(all = 20.dp),
                onClick = { state.value = true }
            ) {
                Text("Назад")
            }

            Text(
                text = movie.title,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                modifier = Modifier.padding(all = 20.dp).fillMaxWidth()
            )

            val height = windowState.size.height * 0.8f
            Row {
                Card(
                    modifier = Modifier.width(height * 3 / 4).height(height).padding(all = 20.dp),
                    shape = RoundedCornerShape(size = 16.dp)
                ) {
                    Image(
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        bitmap = image.value ?: ImageBitmap(width = 400, height = 500)
                    )
                }
                Text(
                    text = movie.overview,
                    color = Color.White,
                    modifier = Modifier.padding(all = 20.dp)
                )
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            delay(100)
            if (movie.imageBitmap == null) {
                movie.imageBitmap = apiCall.loadUrl(movie.imageUrl) ?: ImageBitmap(width = 300, height = 400)
            }
            image.value = movie.imageBitmap
        }
    }
}

@Composable
private fun MovieView(apiCall: ApiCall) {
    val listRemember = remember { mutableStateOf(arrayListOf<MovieData>()) }
    if (movieList.isEmpty()) {
        CoroutineScope(Dispatchers.IO).launch {
            val list = arrayListOf<MovieData>()
            list.add(apiCall.getActualMovieListAutoDecode())
            list.add(apiCall.getActualMovieListNowAutoDecode())
            movieList.addAll(list)
            listRemember.value = list
        }
    } else {
        listRemember.value = movieList
    }

    MaterialTheme {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().background(color = HexToJetpackColor.getColor("2E4053")),
        ) {
            item {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    text = "Библиотека фильмов",
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    color = Color.White
                )
            }
            if (listRemember.value.size >= 2) {
                for (i in 0 until listRemember.value.size) {
                    val data = listRemember.value[i]
                    item {
                        Column {
                            Text(
                                text = data.type,
                                modifier = Modifier.padding(all = 20.dp),
                                fontSize = 24.sp,
                                color = Color.White
                            )
                            LazyRow {
                                for (movie in data.movies) {
                                    item {
                                        Movie(apiCall, movie) {
                                            movieInfo.value = movie
                                            state.value = false
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun main() = application {
    val apiCall = ApiCall(HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    })
    val stateWindow = rememberWindowState()
    Window(state = stateWindow, onCloseRequest = ::exitApplication, title = "Библиотека фильмов") {
        App(apiCall, stateWindow)
    }
}
