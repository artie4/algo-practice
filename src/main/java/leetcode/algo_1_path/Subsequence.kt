package leetcode.algo_1_path

class Subsequence {
}

fun main() {
    assert(isSubsequence("abc", "abcde"))
    assert(!isSubsequence("abc", "abdek"))
    assert(isSubsequence("gh", "gaklh"))
    assert(isSubsequence("gh", "gh"))
    assert(isSubsequence("", "a"))
}

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty())  return true

    var pointer1 = 0
    var pointer2 = 0

    while (pointer2 < t.length) {
        if (s[pointer1] == t[pointer2]) {
            pointer1++
            if (pointer1 > s.lastIndex) return true
        }
        pointer2++
    }
    return false
}