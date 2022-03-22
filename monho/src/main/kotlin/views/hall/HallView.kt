package views.hall

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
import views.EditTextView

class HallView {

    @Composable
    fun HallView(onButtonBack: () -> Unit) {
        MaterialTheme {
            MaterialTheme {
                Column {
                    val textHallName = remember { mutableStateOf("") }
                    val textSeatCount = remember { mutableStateOf("") }
                    Button(
                        modifier = Modifier.width(170.dp).height(80.dp).padding(all = 20.dp),
                        onClick = onButtonBack
                    ) {
                        Text("Назад")
                    }
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        EditTextView("Имя зала", textHallName)
                        EditTextView("Колличество мест", textSeatCount)
                        ButtonView("Добавить") {
                            DataBaseController.addHall(textHallName.value, textSeatCount.value.toIntOrNull() ?: 0)
                            textHallName.value = ""
                            textSeatCount.value = ""
                        }
                    }
                }
            }
        }
    }

}