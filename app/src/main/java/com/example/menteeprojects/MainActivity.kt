package com.example.menteeprojects

import android.os.Bundle
import androidx.compose.ui.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menteeprojects.ui.theme.MenteeProjectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenteeProjectsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingBox(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingBox(name: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            "This text will be drawn first",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Box(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight()
                .width(
                    50.dp
                )
                .background(Color.Blue)
        )
        Text(
            "This text will be drawn last",
            modifier = Modifier.align(Alignment.Center)
        )
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            onClick = { }
        ) {
            Text("+")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScaffoldScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),

        topBar = {
            TopAppBar(
                title = { Text("Scaffold Example") }
            )
        },

        bottomBar = {
            BottomAppBar {
                Text("Bottom Bar", modifier = Modifier.padding(16.dp))
            }
        },

        snackbarHost = {
            SnackbarHost(hostState = remember { SnackbarHostState() })
        },

        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO */ }) {
                Text("+")
            }
        },

        floatingActionButtonPosition = FabPosition.End,

        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,

        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,

        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Main content goes here")
            }
        }
    )
}
@Composable
fun GreetingSurface(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .height(150.dp)
            .width(250.dp)
            .padding(1.dp)
            .background(Color.Red)
            .border(5.dp, Color.Cyan),
        color = Color.Green,
        shadowElevation = 40.dp,
        shape = CircleShape
    ) {
        Text(
            "Basic Surface",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewSurface() {
    MenteeProjectsTheme {
        GreetingSurface()
    }
}

@Preview
@Composable
private fun PreviewScaffold() {
    MenteeProjectsTheme {
        ScaffoldScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MenteeProjectsTheme {
        GreetingBox("Android")
    }
}