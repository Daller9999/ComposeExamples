package views.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainView(movieViewCallback: MovieViewCallback) {
    MaterialTheme {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth().height(70.dp).padding(top = 20.dp),
                textAlign = TextAlign.Center,
                text = "Welcome to Manho"
            )
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Column(modifier = Modifier.padding(top = 10.dp)) {
                    Button(
                        modifier = Modifier.width(350.dp),
                        onClick = { movieViewCallback.onButtonMovie() }
                    ) {
                        Text("Add movie")
                    }
                    Button(
                        modifier = Modifier.width(350.dp),
                        onClick = { movieViewCallback.onButtonGenre() }
                    ) {
                        Text("Add genre")
                    }
                    Button(
                        modifier = Modifier.width(350.dp),
                        onClick = { movieViewCallback.onButtonSession() }
                    ) {
                        Text("Add session")
                    }
                    Button(
                        modifier = Modifier.width(350.dp),
                        onClick = { movieViewCallback.onButtonHall() }
                    ) {
                        Text("Add hall")
                    }
                }
            }
        }
    }
}
