package com.uxstate.screenmediaquery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxstate.Dimensions
import com.uxstate.MediaQuery
import com.uxstate.lessThan
import com.uxstate.screenmediaquery.ui.theme.ScreenMediaQueryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            /*and only if this condition is not true will the content inside be shown*/
            MediaQuery(comparator = Dimensions.Width lessThan 400.dp) {

                //shown on portrait, absen on landscape
                Text(text = "I'm only shown below a width of 400.dp")
                
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScreenMediaQueryTheme {
        Greeting("Android")
    }
}