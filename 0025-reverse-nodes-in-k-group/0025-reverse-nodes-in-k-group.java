class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            // Find the kth node
            ListNode kth = prevGroup;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            if (kth == null)
                break;

            ListNode groupNext = kth.next;

            // Reverse the group
            ListNode prev = groupNext;
            ListNode curr = prevGroup.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the reversed group
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }

        return dummy.next;
    }
}