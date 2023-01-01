package leetcode

import leetcode.algo_1_path.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LinkedListCycleTest {

    private lateinit var linkedListCycle: LinkedListCycle

    @BeforeEach
    fun setUp() {
        linkedListCycle = LinkedListCycle()
    }

    @ParameterizedTest
    @ArgumentsSource(TreeProvider::class)
    fun hasCycle(listNode: ListNode, expected: Boolean) {
        Assertions.assertEquals(expected, linkedListCycle.hasCycle(listNode))
    }

    internal class TreeProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            val repeatedNode = ListNode(1)
            val head1 = repeatedNode.apply { next = ListNode(2).apply { next = repeatedNode } }
            val head2 = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } }

            return Stream.of(
                    Arguments.of(head1, true),
                    Arguments.of(head2, false),
            )
        }
    }
}