package com.example.composejetpack.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@Composable
//fun ListFilmsContent(filmsParam: ArrayList<String>) {
//    val films = remember { filmsParam }
//    LazyColumn(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
//    ) {
//        items(items = films) {
//            Text(text = it, style = MaterialTheme.typography.body2)
//        }
//    }
//}
//
//@Composable
//fun ComposableListItem(film: String) {
//    Row {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .padding(20.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "Name: ", style = MaterialTheme.typography.h6)
//            Text(text = film, style = MaterialTheme.typography.body1)
//        }
//    }
//}