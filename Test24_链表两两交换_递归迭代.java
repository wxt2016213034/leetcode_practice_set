package Leetcode;

public class Test24_������������_�ݹ����{
	public ListNode swapPairs(ListNode head) {
		ListNode dummy =new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		while(head != null && head.next != null) {
			
			ListNode temp = head.next.next;
			pre.next = head.next;
			head.next.next=head;
			head.next = temp;
			
			pre = head;
			head = head.next;
			
		}
		return dummy;
    }
}
