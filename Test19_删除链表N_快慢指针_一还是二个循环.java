package Leetcode;

public class Test19_ɾ������N_����ָ��_һ���Ƕ���ѭ�� {
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
