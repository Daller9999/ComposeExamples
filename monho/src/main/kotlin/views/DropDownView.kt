package views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun DropDownView(suggestions: List<String>, selectedGenre: MutableState<String>) {

    Box(modifier = Modifier.height(70.dp).padding(all = 10.dp)) {
        val expanded = remember { mutableStateOf(false) }
        val textfieldSize = remember { mutableStateOf(Size.Zero) }

        val icon = Icons.Filled.ArrowDropDown

        Column {
            OutlinedTextField(
                value = selectedGenre.value,
                onValueChange = { selectedGenre.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textfieldSize.value = coordinates.size.toSize()
                    },
                trailingIcon = {
                    Icon(icon, "contentDescription", Modifier.clickable { expanded.value = !expanded.value })
                }
            )
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textfieldSize.value.width.toDp() })
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedGenre.value = label
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }
}

@Composable
fun DropDownViewText(text: String, suggestions: List<String>, selectedGenre: MutableState<String>) {
    Row {
        Text(
            modifier = Modifier.weight(1f).height(75.dp).padding(top = 30.dp),
            textAlign = TextAlign.Center,
            text = text
        )
        Box(modifier = Modifier.weight(2f).height(75.dp)) {
            DropDownView(suggestions, selectedGenre)
        }
    }
}