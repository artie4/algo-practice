package leetcode;


import model.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int sum = l1.val + l2.val;
        int toNext = sum / 10;
        int value = sum % 10;
        ListNode current = l1;
        ListNode last = current;
        ListNode head = current;

        current.val = value;
        ListNode p2 = l2.next;

        if (current.next == null && l2.next != null) {
            current.next = l2.next;
            p2 = null;
        }
        current = current.next;

        while (current != null) {

            sum = 0;

            sum += current.val;

            if (p2 != null) {
                sum += p2.val;
            }

            sum += toNext;
            toNext = sum / 10;
            value = sum % 10;

            current.val = value;
            last = current;

            if (current.next == null && p2 != null && p2.next != null) {
                current.next = p2.next;
                p2 = null;
            }
            current = current.next;
            p2 = p2 != null ? p2.next : null;
        }

        if (toNext > 0) {
            last.next = new ListNode(toNext);
        }

        return head;
    }

    static void printListNode(ListNode listNode) {
        var currentHead = listNode;
        while (currentHead != null) {
            System.out.print(currentHead.val);
            currentHead = currentHead.next;
            if (currentHead != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        var first = new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(9))));
        var second = new ListNode(1, new ListNode(2, new ListNode(9)));

        var list3 = new ListNode(0);
        var list4 = new ListNode(7, new ListNode(3));

        var inst = new AddTwoNumbers();
        var sum12 = inst.addTwoNumbers(second, first);
        printListNode(sum12);
        var sum34 = inst.addTwoNumbers(list3, list4);
        printListNode(sum34);
    }
}
