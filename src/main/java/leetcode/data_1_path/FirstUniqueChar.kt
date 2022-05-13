package leetcode.data_1_path

class FirstUniqueChar {
    fun firstUniqChar(s: String): Int {
        val array = Array<Int>(26) { 0 }

        for(i in 0..s.lastIndex) {
            array[s[i] - 'a']++
        }

        for(i in 0..s.lastIndex) {
            if (array[s[i] - 'a'] == 1) return i
        }
        return -1
    }
}

fun main() {
    val inst = FirstUniqueChar()
    assert(inst.firstUniqChar("a") == 0)
    assert(inst.firstUniqChar("abcdeabc") == 3)
    assert(inst.firstUniqChar("aabba") == -1)
}