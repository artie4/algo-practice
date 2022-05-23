package leetcode

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val regex = Regex("[^a-zA-Z0-9]+")
        val replaced = s.replace(regex, "").toLowerCase()
        val len = replaced.length - 1
        val isEven = replaced.length % 2 == 0
        var p1 = if (isEven) len / 2 else len / 2 - 1
        var p2 = len / 2 + 1
        while (p1 >= 0 && p2 <= replaced.lastIndex) {
            if (replaced[p1--] != replaced[p2++]) return false
        }
        return true
    }
}

fun main() {
    val inst = ValidPalindrome()
    assert(inst.isPalindrome("ab_a"))
    assert(inst.isPalindrome("amannama"))
    assert(!inst.isPalindrome("oaM c moa"))
    assert(inst.isPalindrome("A man, a plan, a canal: Panama"))
    assert(!inst.isPalindrome("race a car"))
}