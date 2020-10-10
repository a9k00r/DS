/*
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

       List<Integer> list = new ArrayList<Integer>();
        
        while (l1 != null ) {
            list.add(l1.val);
            l1= l1.next;
        }
        
        while (l2 != null ) {
            list.add(l2.val);
            l2= l2.next;
        
         }

        if (list.isEmpty()) return l1;
        
        Collections.sort(list);
        
        ListNode head = new ListNode(list.get(0), null);
        
        ListNode temp = head;
        
        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i), null);
            temp = temp.next;
            
            
        }

        return head;
    }

}                
                     
