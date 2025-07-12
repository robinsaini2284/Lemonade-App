package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx. compose. foundation. gestures. snapping. SnapPosition. Center
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                lemnoadeAppWorking()
            }
        }
    }
}

@Composable
fun lemnoadeApp(){
    lemnoadeAppWorking(modifier = Modifier
        .fillMaxSize()
    )

}

@Preview(showSystemUi = true)
@Composable
fun lemnoadeAppWorking(modifier: Modifier= Modifier) {
    Column {
        Row(
            modifier = modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.app_name),
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Serif

            )
        }

        var result by remember { mutableStateOf(1) }
        var clickCount by remember { mutableStateOf(0) }
        var pic = when (result) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        var command = when (result) {
            1 -> R.string.Lemon_tree
            2 -> R.string.Lemon
            3 -> R.string.Glass_of_lemonade
            else -> R.string.Empty_glass
        }

        Box(
            modifier=modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier
                    .padding(60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(pic),
                    contentDescription = stringResource(command),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(350.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color.LightGray)
                        .clickable {
                            if (result == 2) {
                                clickCount++
                                if (clickCount >= 3) {
                                    result = 3
                                    clickCount = 0
                                }
                            } else {
                                result = if (result < 4) result + 1 else 1
                                clickCount = 0
                            }
                        }
                )
                Spacer(modifier=modifier.height(16.dp))
                Text(
                    text = stringResource(command),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)

                )
            }
        }
    }
}