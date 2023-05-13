package com.gallopingtech.scrollme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gallopingtech.scrollme.ui.theme.ScrollMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
            sendText()
                }
            }
        }
    }
}

@Composable
fun sendText(){
    val userInput = remember{ mutableStateOf(TextFieldValue()) }
    Card(modifier = Modifier
        .padding(10.dp)
        .heightIn(min = 32.dp)
        .width(180.dp),
    shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White
    ) {
        Row(modifier = Modifier.padding(2.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center

        ) {
            Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = userInput.value,
                    onValueChange = { userInput.value = it },
                    placeholder = { Text(text = "Enter your question")},
                    modifier = Modifier
                        .weight(4f)
                        .widthIn(min = 32.dp)
                        .padding(10.dp),
                    singleLine = true,
                    maxLines = 1
                )


            IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .background(
                    shape = RoundedCornerShape(5.dp),
                    color = Color.White,
                )
                .padding(5.dp)

                ) {
                Icon(Icons.Default.Send,
                tint = Color.Green,
                contentDescription = null)

            }
            
        }

    }


}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScrollMeTheme {
        sendText()
    }
}