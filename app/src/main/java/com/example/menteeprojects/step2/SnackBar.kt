package com.example.menteeprojects.step2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackBarScreen(modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = rememberSaveable { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show SnackBar") },
                icon = { Icon(Icons.Filled.Home, contentDescription = "") },
                onClick = {
                    scope.launch {
                        val result = snackBarHostState
                            .showSnackbar(
                                message = "SnackBar",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Long
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                            }

                            SnackbarResult.Dismissed -> {
                            }
                        }
                    }
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = modifier.padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Screen content")
        }
    }
}

@Preview
@Composable
private fun PreviewSnackBarScreen() {
    SnackBarScreen()
}