import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import views.genre.GenreView
import views.hall.HallView
import views.main.MainView
import views.main.MovieViewCallback
import views.moview.MovieView
import views.session.SessionView

class CoreView {

    lateinit var state: MutableState<States>

    @Composable
    @Preview
    fun App() {
        val remember = remember {
            mutableStateOf(States.MAIN)
        }.apply {
            state = this
        }
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
        MainView().MainView(object : MovieViewCallback {
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
        MovieView().FilmView {
            state.value = States.MAIN
        }
    }

    @Composable
    private fun showSeansView() {
        SessionView().SessionView {
            state.value = States.MAIN
        }
    }

    @Composable
    private fun showGenreView() {
        GenreView().GenreView {
            state.value = States.MAIN
        }
    }

    @Composable
    private fun showHolleView() {
        HallView().HallView {
            state.value = States.MAIN
        }
    }

}