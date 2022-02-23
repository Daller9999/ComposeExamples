package views.session

import DataBaseController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import views.ButtonView
import views.DropDownViewText
import views.EditTextView

class SessionView {

    @Composable
    fun SessionView(onButtonBack: () -> Unit) {
        MaterialTheme {
            Column {
                Button(
                    modifier = Modifier.width(170.dp).height(80.dp).padding(all = 20.dp),
                    onClick = onButtonBack
                ) {
                    Text("Назад")
                }

                val textName = remember { mutableStateOf("") }
                val listMovies = arrayListOf<String>()
                for (movie in DataBaseController.getMovies()) {
                    listMovies.add(movie.Name)
                }

                val textHall = remember { mutableStateOf("") }
                val halls = arrayListOf<String>()
                for (hall in DataBaseController.getHalls()) {
                    halls.add(hall.Name)
                }

                val start = remember { mutableStateOf("") }
                val end = remember { mutableStateOf("") }
                val tickets = remember { mutableStateOf("") }
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    DropDownViewText("Имя фильма", listMovies, textName)
                    DropDownViewText("Имя зала", halls, textHall)
                    EditTextView("Начало сеанса", start)
                    EditTextView("Конец сеанса", end)
                    EditTextView("Куплено билетов", tickets)
                    ButtonView("Добавить") {
                        DataBaseController.addSession(
                            textName.value,
                            textHall.value,
                            start.value.toIntOrNull() ?: 0,
                            end.value.toIntOrNull() ?: 0,
                            tickets.value.toIntOrNull() ?: 0
                        )
                        textName.value = ""
                        textHall.value = ""
                        start.value = ""
                        end.value = ""
                        tickets.value = ""
                    }
                }
            }
        }
    }

}