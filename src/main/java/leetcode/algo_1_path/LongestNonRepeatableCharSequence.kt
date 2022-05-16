package leetcode.algo_1_path;

import java.util.LinkedList
import java.util.Queue

class LongestNonRepeatableCharSequence {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        var max = 0
        val chars = mutableMapOf<Char, Int>()
        val queue = LinkedList<Char>()

        for (ch in s) {
            if (chars[ch] == 1) {
                if (max < queue.size) {
                    max = queue.size
                }
                removeAllBefore(queue, ch, chars)
            }
            queue.add(ch)
            chars[ch] = 1
        }
        if (max < queue.size) {
            max = queue.size
        }
        return max
    }

    fun removeAllBefore(queue: Queue<Char>, target: Char, chars: MutableMap<Char, Int>) {
        var removed = queue.remove()
        chars[removed] = 0
        while (queue.isNotEmpty() && removed != target) {
            removed = queue.remove()
            chars[removed] = 0
        }
    }
}

fun main() {
    val inst = LongestNonRepeatableCharSequence()
    assert(inst.lengthOfLongestSubstring("aaabbb") == 2)
    assert(inst.lengthOfLongestSubstring("aacabdebb") == 5)
    assert(inst.lengthOfLongestSubstring("tmmzuxt") == 5)
    assert(inst.lengthOfLongestSubstring("ckilbkd") == 5)
}
