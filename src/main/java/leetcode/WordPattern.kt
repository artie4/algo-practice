package leetcode

class WordPattern {

    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (words.size != pattern.length) return false
        val letterMap = mutableMapOf<Char, String>()
        val wordMap = mutableMapOf<String, Char>()
        for (i in 0..pattern.lastIndex) {
            val letter = pattern[i]
            val word = words[i]
            if (letterMap[letter] != null && letterMap[letter] != word) return false
            if (wordMap[word] != null && wordMap[word] != letter) return false
            letterMap.putIfAbsent(letter, word)
            wordMap.putIfAbsent(word, letter)
        }
        return true
    }
}

fun main() {

    val inst = WordPattern()

    assert(inst.wordPattern("aba", "cart mine cart"))
    assert(!inst.wordPattern("aba", "cart mine car"))
    assert(!inst.wordPattern("abc", "cart mine cart"))

}