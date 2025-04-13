package com.example.menteeprojects.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.menteeprojects.ui.theme.MenteeProjectsTheme
import com.example.menteeprojects.step2.AppNavHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenteeProjectsTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            onItemSelected = { navController.navigate(it) }
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavHost(navController)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onNavigateToAnimatedList: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Main Screen") })
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Welcome to the Main Screen!")
            }
        }
    }
}

@Composable
fun BottomNavigationBar(onItemSelected: (String) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected("main") },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected("animated") },
            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
            label = { Text("Animated") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected("books") },
            icon = { Icon(Icons.Default.Info, contentDescription = null) },
            label = { Text("Books") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected("scaffold") },
            icon = { Icon(Icons.Default.Build, contentDescription = null) },
            label = { Text("Scaffold") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MenteeProjectsTheme {
        BottomNavigationBar { }
    }
}