package api.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonMovieData(
    @SerialName("title")
    val title: String,
    @SerialName("vote_average")
    val vote_average: Float,
    @SerialName("id")
    val id: Int,
    @SerialName("poster_path")
    val poster_path: String,
    @SerialName("overview")
    val overview: String,
    @SerialName("adult")
    val adult: Boolean
)