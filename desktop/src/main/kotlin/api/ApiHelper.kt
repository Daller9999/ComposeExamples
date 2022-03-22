package api

class ApiHelper {

    private val serverBaseUrl = "https://api.themoviedb.org"

    private val apiKey = "80dad15a6e9fc96df722cc8eb3da927a"

    private val imageUrl = "https://image.tmdb.org/t/p/w500"

    fun getApiKey(): String = apiKey

    fun getImageUrl() = imageUrl

    fun getServerUrl() = serverBaseUrl
}