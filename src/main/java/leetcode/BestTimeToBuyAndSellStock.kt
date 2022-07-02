package leetcode

import kotlin.math.min

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minPrice = Int.MAX_VALUE
        for (i in 0..prices.lastIndex) {
            if (minPrice > prices[i]) {
                minPrice = prices[i]
            }
            if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice
            }
        }
        return maxProfit
    }
}

fun main() {

    val inst = BestTimeToBuyAndSellStock()
    assert(inst.maxProfit(intArrayOf(5,4,2,1,3,6,3)) == 5)
    assert(inst.maxProfit(intArrayOf(5,4,2,1)) == 0)
}