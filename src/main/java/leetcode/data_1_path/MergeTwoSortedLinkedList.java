package leetcode.data_1_path;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(6)));
        var list2 = new ListNode(0, new ListNode(4, new ListNode(5)));
        var result = mergeTwoLists(list1, list2);
        printListNode(result);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 != null && list2 == null) {
            return list1;
        }

        if (list1 == null && list2 != null) {
            return list2;
        }

        ListNode start;
        ListNode head1;
        ListNode head2;
        if (list1.val > list2.val) {
            start = list2;
            head2 = list2.next;
            head1 = list1;
        } else {
            start = list1;
            head1 = list1.next;
            head2 = list2;
        }
        ListNode current = start;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }
        return start;
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
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
