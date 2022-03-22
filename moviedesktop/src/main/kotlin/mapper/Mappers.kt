package mapper

import api.ApiHelper
import data.MovieData
import data.MovieInfo
import api.json.JsonMovie
import api.json.JsonMovieData

fun JsonMovie.toMovieData(type: String, apiHelper: ApiHelper): MovieData {
    val list = arrayListOf<MovieInfo>()

    for (jsonMovie in results) {
        list.add(jsonMovie.toMovieInfo(apiHelper))
    }
    return MovieData(type, list)
}

fun JsonMovieData.toMovieInfo(apiHelper: ApiHelper): MovieInfo {
    return MovieInfo(
        title = title,
        voteAverage = vote_average,
        id = id,
        imageUrl = "${apiHelper.getImageUrl()}${poster_path}",
        isAdult = adult,
        overview = overview
    )
}