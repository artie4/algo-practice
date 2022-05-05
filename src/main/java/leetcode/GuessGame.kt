package leetcode

class GuessGameImpl(picked: Int): GuessGame(picked) {
    override fun guessNumber(n:Int):Int {
        var low = 1
        var high = n
        while (low <= high) {
            val mid = low + (high - low) / 2
            val guess = guess(mid)
            if (guess == 0) {
                return mid
            } else if (guess == -1) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return -1
    }
}

abstract class GuessGame(
        private val picked: Int
) {
    abstract fun guessNumber(n:Int):Int
    fun guess(n: Int): Int {
        if (n > picked) return -1
        if (n < picked) return 1
        return 0
    }
}