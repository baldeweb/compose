package com.example.composejetpack.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composejetpack.JetpackComposeTheme
import com.example.composejetpack.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: SWViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Greeting(viewModel)
            }
        }
        viewModel.getPeople()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingView() {
    Greeting(null)
}

@Composable
fun Greeting(viewModel: SWViewModel?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                }
            )
        }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.clip(shape = RoundedCornerShape(8.dp)),
                painter = painterResource(id = R.drawable.androidicon),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.height(4.dp))

            viewModel?.people?.observeAsState()?.value?.name?.let {
                Text(text = "Name:", style = MaterialTheme.typography.h6)
                Text(text = it, style = MaterialTheme.typography.body1)
            }

            Spacer(modifier = Modifier.height(32.dp))

            ListMovies(viewModel)
        }
    }
}

@Composable
fun ListMovies(viewModel: SWViewModel?) {
    viewModel?.people?.observeAsState()?.value?.films?.let {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = it) {
                Text(text = it, style = MaterialTheme.typography.body2)
            }
        }
    }
}