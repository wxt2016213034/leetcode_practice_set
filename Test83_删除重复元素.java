package Leetcode;

public class Test83_É¾³ýÖØ¸´ÔªËØ {
	   public ListNode deleteDuplicates(ListNode head) {
		   ListNode dummy = new ListNode(1);
		   ListNode returnnode = dummy;
		   dummy.next = head;
		   ListNode point = head;
		   while(point.next != null) {
			   if(point.next.val == point.val) {
				   point = point.next;
				   dummy.next = point;
			   }else {
				   dummy = dummy.next;
				   point = point.next;
			   }
		   }
		   return returnnode.next;
	   }
}
