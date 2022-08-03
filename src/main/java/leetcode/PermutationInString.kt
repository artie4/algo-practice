package leetcode

class PermutationInString {
    fun checkInclusion(s1: String?, s2: String?): Boolean {
        if (s1 == s2) return true
        s1 ?: return false
        s2 ?: return false
        if (s1.length > s2.length) return false

        val chars1 = s1.toCharArray()
        val chars2 = s2.toCharArray()

        val charStats1 = charsCount(chars1, chars1.size)
        val charStats2 = charsCount(chars2, chars1.size)

        if (charStats1 == charStats2) return true

        var left = 0
        var right = chars1.size

        while (right < chars2.size) {
            val currLeft = charStats2[chars2[left]]!!
            if (currLeft > 1) {
                charStats2[chars2[left]] = currLeft - 1
            } else charStats2.remove(chars2[left])
            left++
            charStats2.merge(chars2[right++], 1) { prev, _ -> prev + 1 }
            if (charStats1 == charStats2) return true
        }
        return false
    }

    private fun charsCount(chars: CharArray, until: Int): MutableMap<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        for (i in 0 until until) {
            map.merge(chars[i], 1) { old, _ -> old + 1 }
        }
        return map
    }

}

fun main() {
    val permutationInString = PermutationInString()
    assert(permutationInString.checkInclusion("adc", "dcda"))
    assert(permutationInString.checkInclusion("odce", "leetcode"))
}