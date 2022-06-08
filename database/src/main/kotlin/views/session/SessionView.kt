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


@Composable
fun SessionView(onButtonBack: () -> Unit) {
    MaterialTheme {
        Column {
            Button(
                modifier = Modifier.width(170.dp).height(80.dp).padding(all = 20.dp),
                onClick = onButtonBack
            ) {
                Text("Back")
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
                DropDownViewText("Movie name", listMovies, textName)
                DropDownViewText("Hall name", halls, textHall)
                EditTextView("Session start", start)
                EditTextView("Session end", end)
                EditTextView("Bought tickets", tickets)
                ButtonView("Add") {
                    DataBaseController.addSession(
                        textName.value,
                        textHall.value,
                        start.value,
                        end.value,
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