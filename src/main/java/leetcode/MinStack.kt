package leetcode

import java.util.Stack

class MinStack {

    private val main: Stack<Int> = Stack()
    private val minFirst: Stack<Int>  = Stack()

    fun push(`val`: Int) {
        if (main.empty() || `val` <= minFirst.peek()) {
            minFirst.push(`val`)
        }
        main.push(`val`)
    }

    fun pop() {
        if (top() == minFirst.peek()) {
            minFirst.pop()
        }
        main.pop()
    }

    fun top(): Int = main.peek()

    fun getMin(): Int = minFirst.peek()

}

fun main() {
    val minStack = MinStack()

    for (i in 2 downTo -2) {
        minStack.push(i)
    }
    assert(minStack.top() == -2)
    assert(minStack.getMin() == -2)
    minStack.pop()
    assert(minStack.top() == -1)
    assert(minStack.getMin() == -1)
    minStack.pop()
    minStack.pop()
    assert(minStack.getMin() == 1)
    minStack.push(1)
    minStack.pop()
    assert(minStack.getMin() == 1)
}