package json


data class JsonMovieData(
    val title: String,
    val voteAverage: Float,
    val id: Int,
    val imageUrl: String,
    val isAdult: Boolean,
    val overview: String
) {
    companion object {
        fun default(): JsonMovieData {
            return JsonMovieData(
                "Я краснею",
                7.5f,
                508947,
                "https://image.tmdb.org/t/p/w500/1pCx1fyB4w0tCtuhTFfMxqhiHZa.jpg",
                false,
                "Уверенная в себе тринадцатилетняя Мэй Ли разрывается между тем, чтобы оставаться прилежной и послушной маминой дочкой и справиться с хаосом подросткового возраста. И, казалось бы, перемен в её интересах и отношениях и подростковых изменений в собственном теле и так достаточно, но нет — всякий раз, когда она слишком волнуется (что с подростком случается практически всегда)), она моментально превращается в гигантскую красную панду!"
            )
        }
    }
}