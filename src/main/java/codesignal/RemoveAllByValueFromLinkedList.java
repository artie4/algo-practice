package codesignal;

public class RemoveAllByValueFromLinkedList {

    public static void main(String[] args) {
        ListNode<Integer> headNode = removeKFromList(
                new ListNode<>(2,
                        new ListNode<Integer>(2,
                                new ListNode<Integer>(2,
                                        new ListNode<Integer>(4,
                                                new ListNode<>(5,
                                                        new ListNode<>(2))
                                        )
                                ))), 2);
        System.out.println(headNode);
    }

    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if (l == null) return null;
        if (l.next == null) return l.value == k ? null : l;
        ListNode<Integer> fakeHead = new ListNode<>(k);
        fakeHead.next = l;
        ListNode<Integer> curNode = fakeHead;
        while (curNode != null && curNode.next != null) {
            if (curNode.next.value == k) {
                ListNode<Integer> innerTraverse = curNode.next.next;
                while (innerTraverse != null && innerTraverse.value == k) {
                    innerTraverse = innerTraverse.next;
                }
                curNode.next = innerTraverse;
            }
            curNode = curNode.next;
        }
        return fakeHead.next;
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
