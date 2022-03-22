package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import kotlinx.coroutines.launch


class MovieView {

    @Composable
    fun Movie(movieInfo: MovieInfo, apiCall: ApiCall) {
        val imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }
        CoroutineScope(Dispatchers.IO).launch {
            imageBitmap.value = apiCall.loadUrl(movieInfo.imageUrl)
        }

        Column(modifier = Modifier.width(300.dp)) {
            Card(
                modifier = Modifier.width(300.dp).height(400.dp).padding(all = 20.dp),
                shape = RoundedCornerShape(size = 16.dp)
            ) {
                Image(
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    bitmap = movieInfo.imageBitmap ?: ImageBitmap(width = 300, height = 400)
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
}
