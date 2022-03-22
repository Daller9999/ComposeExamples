package data

data class MovieInfo(
    val title: String,
    val voteAverage: Float,
    val id: Int,
    val imageUrl: String,
    val isAdult: Boolean,
    val overview: String
)