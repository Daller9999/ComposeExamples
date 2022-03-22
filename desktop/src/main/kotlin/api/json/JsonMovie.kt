package api.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonMovie(
    @SerialName("results")
    val results: List<JsonMovieData>
)