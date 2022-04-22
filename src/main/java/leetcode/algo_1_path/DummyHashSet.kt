package leetcode.algo_1_path


class DummyHashSet {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private var currentSize = 16
    private var loadFactor = 0.8
    private var count = 0
    private var buckets = arrayOfNulls<ListNode?>(currentSize)

    fun add(key: Int) {
        if (count.toDouble() / buckets.size > loadFactor) {
            buckets = buckets.copyOf(currentSize * 2)
        }
        val index = key % currentSize
        val bucket = buckets[index]
        if (bucket != null) {
            if (bucket.`val` == key) return
            var head = bucket
            while (head!!.next != null) {
                head = head.next
                if (head?.`val` == key) return
            }
            head.next = ListNode(key)
        } else {
            buckets[index] = ListNode(key)
        }
        count++
    }

    fun remove(key: Int) {
        val index = key % currentSize
        val bucket = buckets[index]
        if (bucket?.`val` == key) {
            buckets[index] = bucket.next
        }
        var prev = bucket
        var head = bucket?.next
        while (head != null) {
            if (head.`val` == key) {
                prev!!.next = head.next
                return
            }
            prev = head
            head = head.next
        }
    }

    fun contains(key: Int): Boolean {
        val index = key % currentSize
        val bucket = buckets[index]
        if (bucket != null) {
            if (bucket.`val` == key) return true
            var head = bucket
            while (head != null) {
                if (head.`val` == key) return true
                head = head.next
            }
        }
        return false
    }
}

fun main() {
    val hashSet = DummyHashSet()
    hashSet.add(0)
    hashSet.add(10)
    hashSet.add(26)
    assert(hashSet.contains(10))
    assert(!hashSet.contains(8))
    assert(hashSet.contains(26))
    hashSet.remove(26)
    assert(!hashSet.contains(26))
    hashSet.remove(26)
}

