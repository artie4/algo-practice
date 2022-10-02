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

    public static void main(String[] args) {
        var nocycle = new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(9))));
        var cycle = new ListNode(1);
        cycle.next = new ListNode(2, cycle);

        assert(detectCycle(nocycle) == null);
        assert (detectCycle(cycle) == cycle);
    }
}