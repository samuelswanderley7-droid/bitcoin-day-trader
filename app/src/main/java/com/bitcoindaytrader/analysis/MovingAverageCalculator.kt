// MovingAverageCalculator.kt

package com.bitcoindaytrader.analysis

class MovingAverageCalculator {
    fun calculateMovingAverage(prices: List<Double>, period: Int): List<Double> {
        return if (prices.size < period) {
            emptyList()
        } else {
            prices.windowed(period).map { window -> window.average() }
        }
    }
}