package mapper

import api.ApiCall
import api.ApiHelper
import data.MovieData
import data.MovieInfo
import api.json.JsonMovie
import api.json.JsonMovieData

suspend fun JsonMovie.toMovieData(apiCall: ApiCall, type: String, apiHelper: ApiHelper): MovieData {
    val list = arrayListOf<MovieInfo>()

    for (jsonMovie in results) {
        list.add(jsonMovie.toMovieInfo(apiCall, apiHelper))
    }
    return MovieData(type, list)
}

suspend fun JsonMovieData.toMovieInfo(apiCall: ApiCall, apiHelper: ApiHelper): MovieInfo {
    val url = "${apiHelper.getImageUrl()}${poster_path}"
    return MovieInfo(
        title = title,
        voteAverage = vote_average,
        imageBitmap = apiCall.loadUrl(url),
        id = id,
        imageUrl = url,
        isAdult = adult,
        overview = overview
    )
}