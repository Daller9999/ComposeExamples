package views.genre

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import views.ButtonView
import views.EditTextView

class GenreView {

    @Composable
    fun GenreView(onButtonBack: () -> Unit) {
        MaterialTheme {
            Column {
                val textGenre = remember { mutableStateOf("") }
                Button(
                    modifier = Modifier.width(170.dp).height(80.dp).padding(all = 20.dp),
                    onClick = onButtonBack
                ) {
                    Text("Назад")
                }
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    EditTextView("Жанр", textGenre)
                    ButtonView("Добавить") {
                        DataBaseController.addGenre(textGenre.value)
                        textGenre.value = ""
                    }
                }
            }
        }
    }
}