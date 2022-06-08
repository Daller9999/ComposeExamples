package views.moview

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
fun FilmView(onButtonBack: () -> Unit) {
    MaterialTheme {
        Column {
            Button(
                modifier = Modifier.width(170.dp).height(80.dp).padding(all = 20.dp),
                onClick = onButtonBack
            ) {
                Text("Back")
            }
            val textName = remember { mutableStateOf("") }
            val textYear = remember { mutableStateOf("") }
            val textBudget = remember { mutableStateOf("") }
            val textCountry = remember { mutableStateOf("") }
            val textMoneyRu = remember { mutableStateOf("") }
            val textMoneyWorld = remember { mutableStateOf("") }
            val textGenre = remember { mutableStateOf("") }
            val textTime = remember { mutableStateOf("") }

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                EditTextView("Name", textName)
                EditTextView("Year", textYear)
                EditTextView("Budget", textBudget)
                EditTextView("Country", textCountry)
                EditTextView("Fees RU", textMoneyRu)
                EditTextView("Fees World", textMoneyWorld)
                DropDownViewText("Genre", DataBaseController.getGenres(), textGenre)
                EditTextView("Timing", textTime)
                ButtonView("Add") {
                    DataBaseController.addMovie(
                        name = textName.value,
                        year = textYear.value.toIntOrNull() ?: 0,
                        budget = textBudget.value.toIntOrNull() ?: 0,
                        country = textCountry.value,
                        moneyRu = textMoneyRu.value.toIntOrNull() ?: 0,
                        moneyWorld = textMoneyWorld.value.toIntOrNull() ?: 0,
                        genre = textGenre.value,
                        time = textTime.value.toIntOrNull() ?: 0
                    )
                    textName.value = ""
                    textYear.value = ""
                    textBudget.value = ""
                    textCountry.value = ""
                    textMoneyRu.value = ""
                    textMoneyWorld.value = ""
                    textGenre.value = ""
                    textTime.value = ""
                }
            }
        }
    }
}