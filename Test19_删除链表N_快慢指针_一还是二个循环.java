package Leetcode;

public class Test19_删除链表N_快慢指针_一还是二个循环 {
	   public ListNode removeNthFromEnd(ListNode head, int n) {
		   ListNode dummy = new ListNode(0);
		   dummy.next = head;
		   ListNode f = dummy;
		   ListNode s = dummy;
		   
		   for(int i = 0; i<n;i++) {
			   f = f.next;
		   }
		   while(f.next != null) {
			   f = f.next;
			   s = s.next;
		   }
		   
		   s.next = s.next.next;
		   
		   return dummy.next;
	    }
	   
	   
	   //recursion, stark
}
