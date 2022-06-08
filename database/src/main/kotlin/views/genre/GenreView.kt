package views.genre

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

@Composable
fun GenreView(onButtonBack: () -> Unit) {
    MaterialTheme {
        Column {
            val textGenre = remember { mutableStateOf("") }
            Button(
                modifier = Modifier.width(170.dp).height(80.dp).padding(all = 20.dp),
                onClick = onButtonBack
            ) {
                Text("Back")
            }
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                EditTextView("Genre", textGenre)
                ButtonView("Add") {
                    DataBaseController.addGenre(textGenre.value)
                    textGenre.value = ""
                }
            }
        }
    }
}