package leetcode.algo_1_path


class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val chars = IntArray(26) { 0 }
        for(ch in magazine) {
            chars[ch - 'a']++
        }

        for(ch in ransomNote) {
            if (chars[ch - 'a'] == 0) return false
            chars[ch - 'a']--
        }
        return true
    }
}

fun main() {
    assert(RansomNote().canConstruct("ab", "aaabbb"))
}