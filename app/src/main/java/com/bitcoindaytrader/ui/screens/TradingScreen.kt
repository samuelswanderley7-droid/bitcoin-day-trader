package com.bitcoindaytrader.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bitcoindaytrader.strategy.SignalType

@Composable
fun TradingScreen() {
    var currentPrice by remember { mutableStateOf(45250.50) }
    var ema7 by remember { mutableStateOf(45100.00) }
    var ema21 by remember { mutableStateOf(45000.00) }
    var sma50 by remember { mutableStateOf(44900.00) }
    var signal by remember { mutableStateOf(SignalType.HOLD) }
    var lastUpdate by remember { mutableStateOf("2026-02-21 12:30:45") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // Header
        Text(
            "Bitcoin Day Trader",
            fontSize = 28.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Current Price Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            backgroundColor = Color(0xFF2D2D2D),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text("Preço Atual (BTC)", color = Color.Gray, fontSize = 12.sp)
                Text(
                    "$ ${String.format("%.2f", currentPrice)}",
                    fontSize = 32.sp,
                    color = Color.Green,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text("Última atualização: $lastUpdate", color = Color.Gray, fontSize = 10.sp)
            }
        }

        // Indicators Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            backgroundColor = Color(0xFF2D2D2D),
            elevation = 8.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                IndicatorRow("EMA 7", ema7)
                Divider(color = Color(0xFF444444), thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                IndicatorRow("EMA 21", ema21)
                Divider(color = Color(0xFF444444), thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                IndicatorRow("SMA 50", sma50)
            }
        }

        // Signal Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            backgroundColor = when (signal) {
                SignalType.BUY -> Color(0xFF1B5E20)
                SignalType.SELL -> Color(0xFFB71C1C)
                SignalType.HOLD -> Color(0xFF2D2D2D)
            },
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Sinal: ${signal.name}",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    when (signal) {
                        SignalType.BUY -> "🟢 Hora de COMPRAR"
                        SignalType.SELL -> "🔴 Hora de VENDER"
                        SignalType.HOLD -> "⚪ Aguarde sinais"
                    },
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }

        // Action Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
            ) {
                Text("Comprar", color = Color.White)
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {
                Text("Vender", color = Color.White)
            }
        }
    }
}

@Composable
fun IndicatorRow(label: String, value: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = Color.Gray, fontSize = 14.sp)
        Text(
            "$ ${String.format("%.2f", value)}",
            color = Color.Yellow,
            fontSize = 14.sp
        )
    }
}