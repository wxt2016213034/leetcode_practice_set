package Leetcode;

import java.util.Stack;

public class Test25_K一组链表反转_栈_pre_cur_next {
		public ListNode reverseKGroup(ListNode head, int k) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			ListNode pre = dummy;
			for(;;) {
			int count =0;
			int flag =0;
			ListNode temp = head;
			while(temp != null) {
				count++;
				if(count == k ) {
					flag =1;
					temp = temp.next;
					break;
				}
				temp = temp.next;
			}
			
			if(flag ==1 ) {
				pre = reverse(pre,head,k);
				head = temp;
			}else {
				pre.next=head;
				break;
			}
			
			
			}
			
			return dummy.next;
		}
		
		public static ListNode reverse(ListNode pre, ListNode head, int k) {
			Stack<ListNode> stack = new Stack<ListNode>();
			for(int i = 0; i < k;i++) {
				stack.push(head);
				head = head.next;
			}
			for(int i = 0; i < k; i++) {
				pre.next = stack.pop();
				pre = pre.next;
			}
			return pre;
		}
}
