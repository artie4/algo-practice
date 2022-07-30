package leetcode

class WordSubsets {

    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val charsMaxCount = mutableMapOf<Char, Int>()
        val result = mutableListOf<String>()

        for (word in words2) {
            val charsStat = charsCount(word)
            for (entry in charsStat) {
                charsMaxCount.merge(entry.key, entry.value) { prev, new -> maxOf(prev, new) }
            }
        }

        for (word in words1) {
            if (checkWord(word, HashMap(charsMaxCount))) {
                result.add(word)
            }
        }
        return result
    }

    private fun charsCount(word: String): Map<Char, Int>  {
        val charArray = word.toCharArray()
        val map = mutableMapOf<Char, Int>()
        for (ch in charArray) {
            map.merge(ch, 1) { prev, _ -> prev + 1 }
        }
        return map
    }

    private fun checkWord(word: String, charsCount: HashMap<Char, Int>): Boolean {
        val chars = word.toCharArray()
        for (ch in chars) {
            var currValue = charsCount[ch] ?: continue
            if (currValue == 1) {
                charsCount.remove(ch)
            } else {
                charsCount[ch] = --currValue
            }
        }
        for (entry in charsCount) {
            if (entry.value > 0) return false
        }
        return true
    }
}

fun main() {
    val wordSubsets = WordSubsets()
    val result = wordSubsets.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e", "o"))
    val result2 = wordSubsets.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("lo","eo"))
    val result3 = wordSubsets.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e","o","o", "ce", "oo"))
    assert(result == listOf("facebook", "google", "leetcode"))
    assert(result2 == listOf("google", "leetcode"))
    assert(result3 == listOf("facebook"))
}