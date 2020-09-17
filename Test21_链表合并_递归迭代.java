package Leetcode;

public class Test21_链表合并_递归迭代 {
	
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1==null && l2 ==null) {
    		return null;
    	}else if(l1 == null) {
    		return l2;
    	}else if(l2 == null) {
    		return l1;
    	}
    	
    	
    	ListNode returnList = new ListNode(0);
    	ListNode dummy = returnList;
    	for(;;) {
    		int l1num = l1.val;
    		int l2num = l2.val;
    		
    		if(l1num < l2num) {
    			returnList.next =l1;
    			l1=l1.next;
    		}else {
    			returnList.next = l2;
    			l2=l2.next;
    		}
    		returnList = returnList.next;
    		if(l1 == null) {
    			returnList.next=l2;
    			break;
    		}
    		if(l2 == null) {
    			returnList.next=l1;
    			break;
    		}
    		
    	}
    	
    	
    	return dummy.next;
    }
    
    public static ListNode digui(ListNode l1, ListNode l2) {
    	
    	if(l1 ==null) {
    		return l2;
    	}
    	else if(l2 ==null) {
    		return l1;
    	}
    	
    	else if(l1.val<=l2.val) {
    		l1.next = digui(l1.next,l2);
    	    return l1;
    	}else {
    		l2.next = digui(l1,l2.next);
    		return l2;
    	}
    	
    	
    }
    public static void main(String args[]) {
    	ListNode l11 = new ListNode(1);
    	ListNode l12 = new ListNode(2);
    	ListNode l13 = new ListNode(3);
    	ListNode l14 = new ListNode(6);
    	ListNode l21 = new ListNode(1);
    	ListNode l22 = new ListNode(3);
    	ListNode l23 = new ListNode(4);
    	ListNode l24 = new ListNode(5);
    	ListNode l25 = new ListNode(6);
    	
    	l11.next =l12;
    	l12.next =l13;
    	l13.next =l14;
    	l21.next =l22;
    	l22.next =l23;
    	l23.next =l24;
    	l24.next =l25;
    	
    	ListNode check = digui(l11,l21);

    	for(;;) {
    		if(check.next != null) {
    			System.out.print(check.val);
    			check = check.next;
    		}else {
    			System.out.print(check.val);
    			break;
    		}
    	}
    	
    }
}
