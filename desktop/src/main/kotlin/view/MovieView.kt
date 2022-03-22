package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
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
import api.ApiCall
import data.MovieInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MovieView {

    @Composable
    fun Movie(apiCall: ApiCall, movieInfo: MovieInfo, onClick: () -> Unit) {
        val image = remember { mutableStateOf<ImageBitmap?>(null) }

        Button(
            onClick = onClick,
            modifier = Modifier.background(color = HexToJetpackColor.getColor("2E4053")),
            colors = ButtonDefaults.buttonColors(backgroundColor = HexToJetpackColor.getColor("2E4053")),
            elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Column(modifier = Modifier.width(300.dp)) {
                Card(
                    modifier = Modifier.width(300.dp).height(400.dp).padding(all = 20.dp),
                    shape = RoundedCornerShape(size = 16.dp)
                ) {
                    Image(
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        bitmap = image.value ?: ImageBitmap(width = 300, height = 400)
                    )
                }
                Text(
                    modifier = Modifier.fillMaxWidth().height(70.dp),
                    text = movieInfo.title,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            delay(100)
            if (movieInfo.imageBitmap == null) {
                movieInfo.imageBitmap = apiCall.loadUrl(movieInfo.imageUrl) ?: ImageBitmap(width = 300, height = 400)
            }
            image.value = movieInfo.imageBitmap
        }
    }
}
