package Leetcode;

public class Test23_合并k个链表 {
	 public ListNode mergeKLists(ListNode[] lists) {
		 ListNode returnlist = new ListNode(0);
		 ListNode pointer = returnlist;
		 
		 for(;;) {
			 
		 int maxvalue = 0;
		 int count = 0;
		 for(int i =0;i<lists.length;i++) {
			 if(lists[i] != null) {
			 maxvalue = lists[i].val>maxvalue?lists[i].val:maxvalue;
			 }else {
				 count++;
			 }
		 }
		 
		 if(count == lists.length)break;
		 
		 for(int i =0;i<lists.length;i++) {
			if(lists[i].val==maxvalue) {
				returnlist=lists[i];
				lists[i]=lists[i].next;
				returnlist = returnlist.next;
				break;
			}
		 }
		 
		 }
		 
		 return pointer;
	    }
	 
}
