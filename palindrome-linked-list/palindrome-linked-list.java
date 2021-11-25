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
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode firstEnd = findHalf(head);
        ListNode reverseStart = reverse(firstEnd.next);
        
        ListNode p1 = head;
        ListNode p2 = reverseStart;
        boolean result = true;
        while(result&&p2!=null){
            if(p1.val!=p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstEnd.next = reverse(reverseStart);
        return result;
    }
    
    private ListNode findHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}