package com.example.menteeprojects.step2

import android.widget.Toast
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FilledButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val localContext = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(localContext, "Clicked", Toast.LENGTH_SHORT).show()
        },
        shape = RoundedCornerShape(40),
        modifier = modifier
            .height(40.dp)
            .width(200.dp)
    ) {
        Text(text = "Filled Button")
    }
}

@Composable
fun FilledTonalButtonComposable(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val localContext = LocalContext.current
    FilledTonalButton(onClick = {
        Toast.makeText(localContext, "Clicked", Toast.LENGTH_SHORT).show()
        onClick()
    }, modifier = modifier) {
        Text(text = "Filled Tonal Button")
    }
}

@Composable
fun OutlinedButtonComposable(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val localContext = LocalContext.current
    OutlinedButton(onClick = {
        Toast.makeText(localContext, "Clicked", Toast.LENGTH_SHORT).show()
    }, modifier = modifier) {
        Text(text = "Outlined Button", modifier = modifier, color = Color.White)
    }
}

@Composable
fun ElevatedButtonComposable(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val localContext = LocalContext.current
    ElevatedButton(onClick = {
        Toast.makeText(localContext, "Clicked", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "Elevated Button")
    }
}

@Composable
fun FloatingActionButtonComposable(modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Icon(Icons.Filled.Add, "Add")
    }
}

@Composable
fun ExtendedFloatingActionButtonComposable(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Icon(Icons.Filled.Add, "Add")
        Text(text = "Add Item")
    }
}

@Preview
@Composable
private fun ExtendedFloatingActionButtonPreview() {
    ExtendedFloatingActionButtonComposable(onClick = {})
}

@Preview
@Composable
private fun FloatingActionButtonPreview() {
    FloatingActionButtonComposable(onClick = {})
}

@Preview
@Composable
private fun ElevatedButtonPreview() {
    ElevatedButtonComposable(onClick = {})
}

@Preview
@Composable
private fun OutlinedButtonPreview() {
    OutlinedButtonComposable(onClick = {})
}

@Preview
@Composable
private fun FilledTonalButtonPreview() {
    FilledTonalButtonComposable(onClick = {})
}

@Preview
@Composable
private fun FilledButtonPreview() {
    FilledButton(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    Greeting(modifier = Modifier)
}
