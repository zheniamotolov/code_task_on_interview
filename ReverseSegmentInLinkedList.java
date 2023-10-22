//https://leetcode.com/problems/reverse-linked-list-ii/
//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]


public class ReverseSegmentInLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode xxx(ListNode head, int r, int l) {
        if(head==null && r==l){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode prev =dummy;
        for(int i=0;i<l-1;i++){
            prev=prev.next;
        }

        ListNode current= prev.next;

        for(int i=0;i<r-l;i++){
            ListNode next = current.next;
            current.next = next.next;
            next.next=prev.next;
            prev.next = next;
        }

        return dummy.next;

    }
}
