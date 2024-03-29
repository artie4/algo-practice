package model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this(val, null);
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}