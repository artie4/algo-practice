package codesignal;

import java.util.ArrayList;
import java.util.List;

public class LinkedPalindrome {

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2,
                new ListNode<>(2, new ListNode<>(1))));

        System.out.println(isListPalindrome(head));

        ListNode<Integer> head2 = new ListNode<>(1, new ListNode<>(2,
                new ListNode<>(3, new ListNode<>(2, new ListNode<>(1)))));

        System.out.println(isListPalindrome(head2));

        ListNode<Integer> head3 = new ListNode<>(2, new ListNode<>(2,
                new ListNode<>(3, new ListNode<>(2, new ListNode<>(1)))));

        System.out.println(isListPalindrome(head3));
    }

    // 1*1 -> 1*2 -> 2*3 -> 1*3 -> 2*2 -> 1*1
    // 1 -> 1 -> 2 -> 1 -> 2 -> 1
    static boolean isListPalindrome(ListNode<Integer> l) {
        int nodeCount = 0;
        long sum = 0;
        ListNode<Integer> start1 = l;
        ListNode<Integer> start2 = l;

        while (start1 != null) {
            nodeCount++;
            start1 = start1.next;
        }

        int curNode = 1;
        while (start2 != null) {
            if (nodeCount % 2 == 0) {
                if (curNode <= nodeCount/2) {
                    sum += (long) curNode * start2.value;
                } else {
                    sum -= (long) (nodeCount - curNode + 1) * start2.value;
                }
            } else {
                if (curNode < nodeCount/2 + 1) {
                    sum += (long) curNode * start2.value;
                } else if (curNode > nodeCount/2 + 1) {
                    sum -= (long) (nodeCount - curNode + 1) * start2.value;
                }
            }
            start2 = start2.next;
            curNode++;
        }
        System.out.println("Sum = " + sum);
        System.out.println("Node count = " + nodeCount);
        return sum == 0;
    }

    static class ListNode<T> {

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

}
