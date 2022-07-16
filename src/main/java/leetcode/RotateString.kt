package leetcode

class RotateString {

    fun rotateString(s: String, goal: String) =
        s.length == goal.length && (s + s).contains(goal)

    fun rotateStringWithReverse(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        if (s == goal) return true
        for (i in 1..s.lastIndex) {
            if (shift(s, i) == goal) return true
        }
        return false
    }

    private fun shift(str: String, shift: Int): String {
        val chars = str.toCharArray()
        reverse(chars, 0, chars.lastIndex)
        reverse(chars, 0, shift - 1)
        reverse(chars, shift, chars.lastIndex)
        return String(chars)
    }

    private fun reverse(chars: CharArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            left++
            right--
        }
    }
}

fun main() {
    val rotateString = RotateString()
    assert(rotateString.rotateString("abcde", "bcdea"))
    assert(rotateString.rotateString("abcde", "bcdea"))
    assert(rotateString.rotateStringWithReverse("abcde", "bcdea"))
    assert(!rotateString.rotateStringWithReverse("abcd", "bcdea"))

}