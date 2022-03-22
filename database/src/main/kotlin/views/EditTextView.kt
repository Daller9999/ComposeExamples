package views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EditTextView(text: String, textChange: MutableState<String>) {
    Row {
        Text(
            modifier = Modifier.weight(1f).height(75.dp).padding(top = 30.dp),
            textAlign = TextAlign.Center,
            text = text
        )
        OutlinedTextField(
            textChange.value,
            modifier = Modifier.weight(2f).height(75.dp).padding(all = 10.dp),
            onValueChange = { textChange.value = it })
    }
}