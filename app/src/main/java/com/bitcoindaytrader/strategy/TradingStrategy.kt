package com.bitcoindaytrader.strategy

enum class SignalType {
    BUY, SELL, HOLD
}

data class TradingSignal(
    val type: SignalType,
    val price: Double,
    val timestamp: Long,
    val reason: String
)

class TradingStrategy {
    
    fun analyzeCrossover(
        ema7: List<Double>,
        ema21: List<Double>,
        sma50: List<Double>,
        prices: List<Double>
    ): TradingSignal? {
        
        if (ema7.size < 2 || ema21.size < 2) return null
        
        val lastEma7 = ema7.last()
        val lastEma21 = ema21.last()
        val prevEma7 = ema7[ema7.size - 2]
        val prevEma21 = ema21[ema21.size - 2]
        val lastPrice = prices.last()
        val timestamp = System.currentTimeMillis()
        
        // BUY: EMA7 crosses above EMA21
        if (prevEma7 <= prevEma21 && lastEma7 > lastEma21) {
            return TradingSignal(
                type = SignalType.BUY,
                price = lastPrice,
                timestamp = timestamp,
                reason = "EMA7 crossed above EMA21"
            )
        }
        
        // SELL: EMA7 crosses below EMA21
        if (prevEma7 >= prevEma21 && lastEma7 < lastEma21) {
            return TradingSignal(
                type = SignalType.SELL,
                price = lastPrice,
                timestamp = timestamp,
                reason = "EMA7 crossed below EMA21"
            )
        }
        
        return TradingSignal(
            type = SignalType.HOLD,
            price = lastPrice,
            timestamp = timestamp,
            reason = "No crossover signal"
        )
    }
}