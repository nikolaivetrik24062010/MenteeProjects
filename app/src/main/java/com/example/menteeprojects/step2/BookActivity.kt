package com.example.menteeprojects.step2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Book(val id: Int, val title: String)

class BookActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BookListScreen()
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BookListScreen() {
    var books by remember {
        mutableStateOf(
            listOf(
                Book(1, "1984"),
                Book(2, "Brave New World"),
                Book(3, "Fahrenheit 451"),
                Book(4, "The Great Gatsby"),
                Book(5, "To Kill a Mockingbird"),
                Book(6, "The Catcher in the Rye"),
                Book(7, "The Lord of the Rings"),
                Book(8, "The Hobbit"),
                Book(9, "The Da Vinci Code"),
                Book(10, "The Alchemist"),
                Book(11, "The Hunger Games"),
                Book(12, "The Fault in Our Stars"),
                Book(13, "The Kite Runner"),
                Book(14, "The Book Thief"),
                Book(15, "The Chronicles of Narnia"),
                Book(16, "The Hunger Games"),
                Book(17, "The Fault in Our Stars"),
                Book(18, "The Kite Runner"),
                Book(19, "The Book Thief"),
                Book(20, "The Chronicles of Narnia"),
                Book(21, "The Hunger Games"),
                Book(22, "The Fault in Our Stars"),
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("My Books", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(books, key = { it.id }) { book ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .animateItem(
                            fadeInSpec = tween(250),
                            fadeOutSpec = tween(100),
                            placementSpec = spring(
                                stiffness = Spring.StiffnessLow,
                                dampingRatio = Spring.DampingRatioMediumBouncy
                            )
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = book.title, style = MaterialTheme.typography.body1)
                    Button(onClick = {
                        books = books.filter { it.id != book.id }
                    }) {
                        Text("Remove")
                    }
                }
            }
        }
    }
}