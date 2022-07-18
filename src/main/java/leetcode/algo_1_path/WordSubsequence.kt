package leetcode.algo_1_path

class WordSubsequence {
    fun maxRepeating(sequence: String, word: String): Int {
        var count = 0
        var sub = word
        while(sequence.contains(sub)) {
            count++
            sub += word
        }
        return count
    }
}

fun main() {
    val wordSubsequence = WordSubsequence()
    assert(wordSubsequence.maxRepeating("ababc", "ab") == 2)
    assert(wordSubsequence.maxRepeating("abcababab", "ab") == 3)
    assert(wordSubsequence.maxRepeating("bcd", "ab") == 0)
}