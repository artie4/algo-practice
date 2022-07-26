package leetcode.algo_1_path

class Palindrome2 {
    fun validPalindrome(s: String): Boolean {
        var start = 0
        var end = s.lastIndex
        while (start < end) {
            if (s[start] != s[end]) {
                return helper(start + 1, end, s) || helper(start, end - 1, s)
            }
            start++
            end--
        }
        return true
    }

    private fun helper(left: Int, right: Int, str: String): Boolean {
        var start = left
        var end = right
        while (start < end) {
            if (str[start] != str[end]) {
                 return false
            }
            start++
            end--
        }
        return true
    }
}

fun main() {
    val palindrome2 = Palindrome2()
    assert(!palindrome2.validPalindrome("abdca"))
    assert(!palindrome2.validPalindrome("abc"))
    assert(palindrome2.validPalindrome("abcca"))
    assert(palindrome2.validPalindrome("app"))
    assert(palindrome2.validPalindrome("appp"))
    assert(!palindrome2.validPalindrome("aabbddbbcc"))
    assert(!palindrome2.validPalindrome("eeccccbebaeeabebccceea"))
}


