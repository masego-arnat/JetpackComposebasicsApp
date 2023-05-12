package com.example.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//
//                }
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
//    Text(text = "Hello $name!")
    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp) ){
//        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))


        Row(modifier = Modifier.padding(24.dp)){

            Column(modifier = Modifier.weight(1f))
            {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { /* TODO */
                    expanded.value = !expanded.value
                }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
//        Greeting("Android")
        MyApp()
    }
}

@Composable
private fun MyApp(  modifier: Modifier = Modifier,
                    names: List<String> = listOf("Masego", "Compose")) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }
//        Greeting("Masego")
    }
}