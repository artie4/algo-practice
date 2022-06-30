package leetcode

import java.util.*

class IsomorphicString {

    // two dictionaries approach
    fun isIsomorphic(s: String, t: String): Boolean {

        val smap = mutableMapOf<Char, Char>()
        val tmap = mutableMapOf<Char, Char>()

        for (i in 0..s.lastIndex) {
            val schar = s[i]
            val tchar = t[i]
            if (smap[schar] == null && tmap[tchar] == null) {
                smap[schar] = tchar
                tmap[tchar] = schar
            } else if (schar != tmap[tchar] || tchar != smap[schar]) {
                return false
            }
            if (smap[schar] == null || tmap[tchar] == null) {
                return false
            }
        }
        return true
    }

    // encode by position approach
    fun isIsomorphic2(s: String, t: String): Boolean {
        val arr1 = helper(s)
        val arr2 = helper(t)
        return arr1.contentEquals(arr2)
    }

    private fun helper(s: String): IntArray {
        val map = mutableMapOf<Char, Int>()
        val array = IntArray(s.length)
        for (i in 0..s.lastIndex) {
            map.putIfAbsent(s[i], i)
            array[i] = map[s[i]]!!
        }
        return array
    }
}

fun main() {
    val inst = IsomorphicString()
    assert(inst.isIsomorphic("abc", "cde"))
    assert(inst.isIsomorphic("leet", "cool"))
    assert(!inst.isIsomorphic("equal", "apple"))
    assert(!inst.isIsomorphic("bbaba", "aabba"))

    assert(inst.isIsomorphic2("abc", "cde"))
    assert(inst.isIsomorphic2("leet", "cool"))
    assert(!inst.isIsomorphic2("equal", "apple"))
    assert(!inst.isIsomorphic2("bbaba", "aabba"))
}