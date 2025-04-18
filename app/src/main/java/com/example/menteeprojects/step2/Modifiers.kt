package com.example.menteeprojects.step2

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenForModifiers(modifier: Modifier = Modifier) {
    Column(modifier) {
        Greeting(modifier = modifier)
        TwoBoxesPow(modifier = modifier)
        ThreeBoxesRow(modifier = modifier)
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val localContext = LocalContext.current
    val reusableModifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .clickable {
            Toast.makeText(localContext, "Clicked", Toast.LENGTH_SHORT).show()
        }
        .background(Color.Yellow)
    Box {
        Text(
            text = "Wsap",
            modifier = reusableModifier.align(Alignment.Center)
        )
    }
}

@Composable
fun TwoBoxesPow(modifier: Modifier = Modifier) {
    Row(modifier) {
        Box(
            modifier = Modifier
                .weight(2f)
                .height(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun ThreeBoxesRow(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .weight(3f)
                .height(100.dp)
                .background(Color.Blue)
        )
        {
            Text(
                text = "Hello",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(34.dp)
                    .clickable {
                        println("Clicked")
                    }
                    .background(Color.Yellow)
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Green)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TwoBoxesPreview() {
    TwoBoxesPow(modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun ThreeBoxesPreview() {
    ThreeBoxesRow(modifier = Modifier)
}

@Preview
@Composable
private fun ScreenForModifiersPreview() {
    ScreenForModifiers()
}