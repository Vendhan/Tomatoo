package com.vendhan.tomatoo.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun TextFieldComponent(
    value: Data,
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = {
            Text("Enter Something")
        },
        modifier = Modifier
            .fillMaxWidth()
    )
}
