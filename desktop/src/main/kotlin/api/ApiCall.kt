package api

import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import data.MovieData
import mapper.toMovieData
import api.json.JsonMovie
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

// https://developers.themoviedb.org/3/movies/get-popular-movies

class ApiCall(private var client: HttpClient) {

    private val apiHelper = ApiHelper()

    init {
        client.config {
            expectSuccess = true
            defaultRequest {
                host = apiHelper.getServerUrl()
            }
        }
    }

    suspend fun loadUrl(url: String): ImageBitmap? {
        return try {
            val data = client.get<ByteArray>(url)
            org.jetbrains.skia.Image.makeFromEncoded(data).toComposeImageBitmap()
        } catch (ex: Exception) {
            null
        }
    }

    suspend fun getActualMovieListAutoDecode(): MovieData {
        val urlBase = "/3/movie/popular"
        val fullUrl = apiHelper.getServerUrl() + urlBase
        val jsonMovie: JsonMovie = client.request(fullUrl) {
            method = HttpMethod.Get
            parameter("api_key", apiHelper.getApiKey())
            parameter("language", "ru-RU")
            parameter("page", 1)
        }
        return jsonMovie.toMovieData("Популярное", apiHelper)
    }

    suspend fun getActualMovieListNowAutoDecode(): MovieData {
        val urlBase = "/3/movie/now_playing"
        val fullUrl = apiHelper.getServerUrl() + urlBase
        val jsonMovie: JsonMovie = client.request(fullUrl) {
            method = HttpMethod.Get
            parameter("api_key", apiHelper.getApiKey())
            parameter("language", "ru-RU")
            parameter("page", 1)
        }
        return jsonMovie.toMovieData("Рекомендуемое", apiHelper)
    }

    suspend fun getActualMovieListString(): String {
        val urlBase = "/3/movie/popular"
        val fullUrl = apiHelper.getServerUrl() + urlBase
        return client.request(fullUrl) {
            method = HttpMethod.Get
            parameter("api_key", apiHelper.getApiKey())
            parameter("language", "ru-RU")
            parameter("page", 1)
        }
    }
}