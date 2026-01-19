package com.example.erayandroidprjoe



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class eray : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorUI()
        }
    }
}

@Composable
fun CalculatorUI() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = num1,
            onValueChange = { newValue -> num1 = newValue },
            label = { Text("İlk Sayı") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = num2,
            onValueChange = { newValue -> num2 = newValue },
            label = { Text("İkinci Sayı") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Button(onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null) {
                    (n1 + n2).toString()
                } else {
                    "Geçersiz Giriş!"
                }
            }) { Text("➕ Topla") }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null) {
                    (n1 - n2).toString()
                } else {
                    "Geçersiz Giriş!"
                }
            }) { Text("➖ Çıkar") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Button(onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null) {
                    (n1 * n2).toString()
                } else {
                    "Geçersiz Giriş!"
                }
            }) { Text("✖️ Çarp") }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null && n2 != 0.0) {
                    (n1 / n2).toString()
                } else {
                    "Tanımsız!"
                }
            }) { Text("➗ Böl") }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Sonuç: $result")
    }
}