package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import data.MovieInfo
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Drawable
import org.jetbrains.skia.Image.Companion.makeFromEncoded
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.imageio.ImageIO


class MovieView {

    @Composable
    fun Movie(movieInfo: MovieInfo) {
        Column(modifier = Modifier.width(300.dp)) {
            Card(
                modifier = Modifier.width(300.dp).height(400.dp).padding(all = 20.dp),
                shape = RoundedCornerShape(size = 16.dp)
            ) {
                Image(
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    bitmap = loadNetworkImage(movieInfo.imageUrl) ?: ImageBitmap(width = 300, height = 400)
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

    private fun loadNetworkImage(link: String): ImageBitmap? {
        try {
            val url = URL(link)
            val connection = url.openConnection() as HttpURLConnection
            connection.connect()

            val inputStream = connection.inputStream
            val bufferedImage = ImageIO.read(inputStream)

            val stream = ByteArrayOutputStream()
            ImageIO.write(bufferedImage, "png", stream)
            val byteArray = stream.toByteArray()

            return makeFromEncoded(byteArray).toComposeImageBitmap()
        } catch (ex: Exception) {
            // ex.printStackTrace()
        }
        return null
    }
}
