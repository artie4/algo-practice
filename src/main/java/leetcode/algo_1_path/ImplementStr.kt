package leetcode.algo_1_path

fun main() {
    println(strStr(haystack = "hello", needle = "ll"))
    println(strStr("mississippi","issip"))
    println(strStr("aaa","aaaa"))
}

fun strStr(haystack: String, needle: String): Int {

    if (needle.isEmpty()) return 0
    var haystackPointer: Int
    var needlePointer = 0

    for (i in haystack.indices) {
        haystackPointer = i
        var j = i
        while (true) {
            if (j > haystack.lastIndex) return -1
            if (haystack[j] == needle[needlePointer]) {
                if (needlePointer == needle.lastIndex) {
                    return haystackPointer
                }
                j++
                needlePointer++
            } else {
                break
            }
        }
        needlePointer = 0
    }
    return -1
}