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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlaceholderVerticalAlign
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        viewModel?.people?.observeAsState()?.value?.name?.let {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.clip(shape = RoundedCornerShape(8.dp)),
                    painter = painterResource(id = R.drawable.androidicon),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Name: $it", style = MaterialTheme.typography.body1)
            }
        }
    }
}