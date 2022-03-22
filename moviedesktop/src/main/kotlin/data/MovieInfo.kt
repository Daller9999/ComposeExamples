package data

import androidx.compose.ui.graphics.ImageBitmap

data class MovieInfo(
    val title: String,
    val voteAverage: Float,
    val imageBitmap: ImageBitmap?,
    val id: Int,
    val imageUrl: String,
    val isAdult: Boolean,
    val overview: String
)