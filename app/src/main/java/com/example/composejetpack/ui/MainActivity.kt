package com.example.composejetpack.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val firstName =
        viewModel?.people?.observeAsState()?.value?.name?.substringBefore(" ") ?: "Wallace"
    val secondName =
        viewModel?.people?.observeAsState()?.value?.name?.substringAfter(" ") ?: "Baldenebre"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val typography = MaterialTheme.typography
        Image(
            modifier = Modifier.clip(shape = RoundedCornerShape(8.dp)),
            painter = painterResource(id = R.drawable.androidicon),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Hello,", style = typography.subtitle1)
        Row {
            Text(text = firstName, style = typography.h6)
            Text(text = " $secondName!", style = typography.h6)
        }
    }
}