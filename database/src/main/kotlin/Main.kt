import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    DataBaseController.init()
    Window(title = "Maxno", onCloseRequest = ::exitApplication) {
        App()
    }
}
