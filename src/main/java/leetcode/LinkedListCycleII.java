package leetcode;


import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            set.add(current);
            current = current.next;
        }
        return null;
    }

    public static ListNode detectCycleTwoPointers(ListNode head) {
        if (head == null) {
            return null;
        }

        var pointer = head;
        var fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            pointer = pointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer == pointer) {
                var pointerFromHead = head;
                while (pointerFromHead != pointer) {
                    pointerFromHead = pointerFromHead.next;
                    pointer = pointer.next;
                }
                return pointer;
            }
        }
        return null;
    }

        public static void main (String[]args){
            var nocycle = new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(9))));
            var cycle = new ListNode(1);
            cycle.next = new ListNode(2, cycle);

            var cycleStart = new ListNode(2);
            cycleStart.next = new ListNode(3, new ListNode(4, cycleStart));
            var secondNodeCycle = new ListNode(1, cycleStart);

            assert (detectCycle(nocycle) == null);
            assert (detectCycle(cycle) == cycle);
            assert (detectCycle(secondNodeCycle) == cycleStart);
            assert (detectCycleTwoPointers(secondNodeCycle) == cycleStart);
        }
    }