package leetcode.algo_1_path

class FindTheDifference {
}

fun findTheDifference(s: String, t: String): Char {
    if (s.isEmpty()) return t[0]
    var diff = t[0].toInt()
    for (i in 1..t.lastIndex) {
        diff = diff xor t[i].toInt()
    }
    for (i in 0..s.lastIndex) {
        diff = diff xor s[i].toInt()
    }
    return diff.toChar()
}

fun main() {
    assert(findTheDifference("abd", "abcd") == 'c')
    assert(findTheDifference("", "a") == 'a')
    assert(findTheDifference("sbcd", "asbcd") == 'a')
}