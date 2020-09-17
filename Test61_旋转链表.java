package Leetcode;

public class Test61_Ðý×ªÁ´±í {
	 public ListNode rotateRight(ListNode head, int k) {
		 ListNode dummy = head;
		 ListNode dummy2 = head;
		 for(int i = 0 ; i < k ; i ++) {
			 dummy = dummy.next;
		 }
		 while(dummy.next!= null) {
			 dummy = dummy.next;
			 dummy2 = dummy2.next;
		 }
		 ListNode returnnode = dummy2.next;
		 dummy.next = head;
		 dummy2.next = null;
		 
		 return returnnode;
	    }
	 
	 
}
