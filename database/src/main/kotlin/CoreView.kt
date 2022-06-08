import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import views.genre.GenreView
import views.hall.HallView
import views.main.MainView
import views.main.MovieViewCallback
import views.moview.FilmView
import views.session.SessionView


private val state: MutableState<States> = mutableStateOf(States.MAIN)

@Composable
@Preview
fun App() {
    when (state.value) {
        States.MAIN -> showMainView()
        States.FILMS -> showFilmView()
        States.SEANS -> showSeansView()
        States.GENRE -> showGenreView()
        States.HOLLE -> showHolleView()
    }
}

@Composable
private fun showMainView() {
    MainView(object : MovieViewCallback {
        override fun onButtonGenre() {
            state.value = States.GENRE
        }

        override fun onButtonMovie() {
            state.value = States.FILMS
        }

        override fun onButtonSession() {
            state.value = States.SEANS
        }

        override fun onButtonHall() {
            state.value = States.HOLLE
        }
    })
}

@Composable
private fun showFilmView() {
    FilmView {
        state.value = States.MAIN
    }
}

@Composable
private fun showSeansView() {
    SessionView {
        state.value = States.MAIN
    }
}

@Composable
private fun showGenreView() {
    GenreView {
        state.value = States.MAIN
    }
}

@Composable
private fun showHolleView() {
    HallView {
        state.value = States.MAIN
    }
}

