package com.cenkeraydin.sideeffects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectExample(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    var startCounting by remember { mutableStateOf(false) }

    // LaunchedEffect: startCounting değiştiğinde çalışır
    LaunchedEffect(startCounting) {
        if (startCounting) {
            while (count < 10) {
                delay(1000L)
                count++
            }
            startCounting = false // Sayım bittiğinde durdur
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sayaç: $count")
        Button(onClick = { startCounting = true }) {
            Text("Sayacı Başlat")
        }
    }
}