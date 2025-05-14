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
    var resetKey by remember { mutableStateOf(0) } // Her sıfırlamada değişen anahtar

    // LaunchedEffect: resetKey değiştiğinde yeniden başlar
    LaunchedEffect(resetKey) {
        count = 0 // Sayaç sıfırlanır
        while (count < 10) {
            delay(1000L)
            count++
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sayaç: $count")
        Button(onClick = { resetKey++ }) { // Her tıklamada resetKey artar
            Text("Sayacı Sıfırla ve Tekrardan Başlat")
        }
    }
}