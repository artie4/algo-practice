package leetcode

import java.util.Stack

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (ch in s) {
            when(ch) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                else -> {
                    if (stack.empty() || stack.pop() != ch) return false
                }
            }
        }
        if (!stack.empty()) return false
        return true
    }
}

fun main() {
    val inst = ValidParentheses()

    assert(inst.isValid("{}()[]"))
    assert(inst.isValid("{()}[{}]"))
    assert(!inst.isValid("(()}[{}]"))

}
