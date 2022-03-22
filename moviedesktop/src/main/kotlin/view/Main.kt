package view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import api.ApiCall
import data.MovieData
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
@Preview
fun App(apiCall: ApiCall) {
    val listRemember = remember { mutableStateOf(arrayListOf<MovieData>()) }
    CoroutineScope(Dispatchers.IO).launch {
        val list = arrayListOf<MovieData>()
        list.add(apiCall.getActualMovieListAutoDecode())
        list.add(apiCall.getActualMovieListNowAutoDecode())
        listRemember.value = list
        println(list)
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
                                        MovieView().Movie(movie)
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

    Window(onCloseRequest = ::exitApplication) {
        App(apiCall)
    }
}
