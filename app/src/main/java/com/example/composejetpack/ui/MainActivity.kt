package com.example.composejetpack.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composejetpack.R
import com.example.composejetpack.shapes
import com.example.composejetpack.ui.components.softBlack
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: SWViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Greeting()
            }
        }
        viewModel.getPeople()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingView() {
    Greeting()
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = softBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.androidicon),
                    contentDescription = ""
                )
                Image(
                    painter = painterResource(id = R.drawable.androidicon),
                    contentDescription = ""
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Que bom te ver\naqui!\nVamos começar?",
                    style = MaterialTheme.typography.h4,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    enabled = true,
                    onClick = { },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 6.dp, bottom = 6.dp),
                        text = "Vamos!",
                        color = softBlack
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    enabled = true,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { },
                    border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White))
                ) {
                    Text(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 6.dp, bottom = 6.dp),
                        text = "Já sou cliente BTG",
                        color = Color.White
                    )
                }
            }
        }
    }
}