package com.example.menteeprojects.step2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateListOf

data class ListItem(val id: Int, val value: String)

class AnimatedListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ListAnimatedItemsScreen()
            }
        }
    }
}

@Composable
fun ListAnimatedItemsScreen() {
    val items = remember {
        mutableStateListOf(
            ListItem(1, "Orange"),
            ListItem(2, "Apple"),
            ListItem(3, "Banana"),
            ListItem(4, "Grapes")
        )
    }

    var nextId by remember { mutableIntStateOf(5) }
    val originalOrder = remember { items.toList() }

    ListAnimatedItemsExample(
        data = items,
        onAddItem = {
            val newItem = ListItem(nextId++, "Item $nextId")
            items.add(newItem)
        },
        onRemoveItem = {
            if (items.isNotEmpty()) items.removeAt(items.lastIndex)
        },
        resetOrder = {
            items.clear()
            items.addAll(originalOrder)
        },
        onSortAlphabetically = {
            items.sortBy { it.value }
        },
        onSortByLength = {
            items.sortBy { it.value.length }
        }
    )
}

@Composable
private fun ListAnimatedItemsExample(
    data: List<ListItem>,
    modifier: Modifier = Modifier,
    onAddItem: () -> Unit = {},
    onRemoveItem: () -> Unit = {},
    resetOrder: () -> Unit = {},
    onSortAlphabetically: () -> Unit = {},
    onSortByLength: () -> Unit = {},
) {
    val canAddItem = data.size < 10
    val canRemoveItem = data.isNotEmpty()

    Scaffold(modifier) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            AddRemoveButtons(canAddItem, canRemoveItem, onAddItem, onRemoveItem)
            OrderButtons(resetOrder, onSortAlphabetically, onSortByLength)
            ListAnimatedItems(data)
        }
    }
}

@Composable
private fun AddRemoveButtons(
    canAddItem: Boolean,
    canRemoveItem: Boolean,
    onAddItem: () -> Unit,
    onRemoveItem: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(enabled = canAddItem, onClick = onAddItem) {
            Text("Add Item")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(enabled = canRemoveItem, onClick = onRemoveItem) {
            Text("Delete Item")
        }
    }
}

@Composable
private fun OrderButtons(
    resetOrder: () -> Unit,
    orderAlphabetically: () -> Unit,
    orderByLength: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        var selectedIndex by remember { mutableIntStateOf(0) }
        val options = listOf("Reset", "Alphabetical", "Length")

        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index, options.size),
                    onClick = {
                        Log.d("AnimatedOrderedList", "selectedIndex: $selectedIndex")
                        selectedIndex = index
                        when (label) {
                            "Reset" -> resetOrder()
                            "Alphabetical" -> orderAlphabetically()
                            "Length" -> orderByLength()
                        }
                    },
                    selected = index == selectedIndex
                ) {
                    Text(label)
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ListAnimatedItems(data: List<ListItem>) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        items(data, key = { it.id }) { item ->
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
                Text(text = item.value)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListAnimatedItemsPreview() {
    MaterialTheme {
        ListAnimatedItemsScreen()
    }
}