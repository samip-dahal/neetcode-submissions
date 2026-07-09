/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int sz = getListSize(head);
        int positionToDelete = sz - n; 
        ListNode prev = null;
        ListNode tempHead = head;

        if (positionToDelete == 0) {
            return head.next;
        }

        while (positionToDelete-- > 0) {
            prev = tempHead;
            tempHead = tempHead.next;
        }

        prev.next = tempHead.next;
        tempHead.next = null;

        return head;

    }

    private int getListSize(ListNode head) {
        
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }

        return cnt;
    }
}
