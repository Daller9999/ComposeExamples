import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    val mainView = CoreView()
    DataBaseController.init()
    Window(title = "Maxno", onCloseRequest = ::exitApplication) {
        mainView.App()
    }
}
