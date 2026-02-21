package com.bitcoindaytrader.analysis

class ExponentialMovingAverageCalculator {
    fun calculateEMA(prices: List<Double>, period: Int): List<Double> {
        if (prices.size < period) return emptyList()
        
        val ema = mutableListOf<Double>()
        val multiplier = 2.0 / (period + 1)
        
        // First EMA is SMA
        ema.add(prices.take(period).average())
        
        // Calculate subsequent EMAs
        for (i in period until prices.size) {
            val newEma = (prices[i] * multiplier) + (ema.last() * (1 - multiplier))
            ema.add(newEma)
        }
        
        return ema
    }
}