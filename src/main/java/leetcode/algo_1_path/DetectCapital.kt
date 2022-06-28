package leetcode.algo_1_path

class DetectCapital {
    fun detectCapitalUse(word: String): Boolean {
        val regex = Regex("([A-z][a-z]*)|[A-Z]*")
        return word.matches(regex)
    }
}

fun main() {

    val inst = DetectCapital()
    assert(inst.detectCapitalUse("detect"))
    assert(inst.detectCapitalUse("DETECT"))
    assert(inst.detectCapitalUse("Detect"))
    assert(!inst.detectCapitalUse("DetecT"))
}