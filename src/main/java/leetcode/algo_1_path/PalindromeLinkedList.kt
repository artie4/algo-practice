package leetcode.algo_1_path

import utils.Utils


class PalindromeLinkedList {
}

fun main() {
    val listOf3 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3) } }
    val listOf3Palindrome = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(1) } }
    val listOf4 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4) } } }
    val listOf4Palindrome = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(2).apply { next = ListNode(1) } } }
    val listOf6 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3)
            .apply { next = ListNode(4).apply { next = ListNode(5).apply { next = ListNode(6) } } } } }
    val listOf6Palindrome = ListNode(6).apply { next = ListNode(5).apply { next = ListNode(4)
            .apply { next = ListNode(4).apply { next = ListNode(5).apply { next = ListNode(6) } } } } }

    assert(!isPalindrome(listOf3))
    assert(isPalindrome(listOf3Palindrome))
    assert(!isPalindrome(listOf4))
    assert(isPalindrome(listOf4Palindrome))
    assert(!isPalindrome(listOf6))
    assert(isPalindrome(listOf6Palindrome))
}

fun isPalindrome(head: ListNode?): Boolean {

    var middle = 0
    var pointer = head
    var fastPointer = head

    while (fastPointer?.next?.next != null) {
        fastPointer = fastPointer.next?.next
        pointer = pointer!!.next
        middle++
    }

    val isEven = fastPointer?.next != null

    // reverse till middle
    var i = if (isEven) middle else middle - 1
    var middlePointer = pointer?.next

    var prev = head
    var current = head?.next
    var next = head?.next?.next
    prev?.next = null

    while (i > 0) {
        current?.next = prev
        prev = current
        current = next
        next = next?.next
        i--
    }

    // compare by node values
    var start = prev
    while (middlePointer != null && start != null) {
        if (middlePointer.`val` != start.`val`) return false
        middlePointer = middlePointer.next
        start = start.next
    }

    return true
}