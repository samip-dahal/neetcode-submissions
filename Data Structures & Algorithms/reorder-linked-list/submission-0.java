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
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightPtr = reverseLinkedListFromMid(slow.next);
        ListNode leftPtr = head;
        slow.next = null;
        
        while (rightPtr != null) {
            ListNode lNext = leftPtr.next;
            ListNode rNext = rightPtr.next;
            leftPtr.next = rightPtr;
            rightPtr.next = lNext;
            leftPtr = lNext;
            rightPtr = rNext;
        }    
    }

    private ListNode reverseLinkedListFromMid(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = null;

        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}

