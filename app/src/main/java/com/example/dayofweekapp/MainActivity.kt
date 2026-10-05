package com.example.dayofweekapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AverageScreen()
                }
            }
        }
    }
}

@Composable
fun AverageScreen() {
    // Состояния для полей ввода
    var numberA by remember { mutableStateOf("") }
    var numberB by remember { mutableStateOf("") }
    var numberC by remember { mutableStateOf("") }
    var symbol  by remember { mutableStateOf("") }
    var result  by remember { mutableStateOf("Здесь появится результат") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Средние значения трёх чисел",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Поле 1
        OutlinedTextField(
            value = numberA,
            onValueChange = { numberA = it },
            label = { Text("Первое число") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Поле 2
        OutlinedTextField(
            value = numberB,
            onValueChange = { numberB = it },
            label = { Text("Второе число") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Поле 3
        OutlinedTextField(
            value = numberC,
            onValueChange = { numberC = it },
            label = { Text("Третье число") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Поле для символа
        OutlinedTextField(
            value = symbol,
            onValueChange = { symbol = it },
            label = { Text("Символ (a или g)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Кнопка (пока ничего не делает)
        Button(onClick = {

        }) {
            Text("Вычислить")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Текст результата
        Text(
            text = result,
            fontSize = 18.sp
        )
    }
}
fun calculateAverage(a: Double, b: Double, c: Double, symbol: String): String {
    return when (symbol.lowercase()) {
        "a" -> {
            val avg = (a + b + c) / 3.0
            "Среднее арифметическое: $avg"
        }
        "g" -> {
            val geo = Math.cbrt(a * b * c)
            "Среднее геометрическое: $geo"
        }
        else -> "Ошибка: символ должен быть 'a' или 'g'"
    }
}