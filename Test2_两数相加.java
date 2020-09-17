package Leetcode;


public class Test2_两数相加 {
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode ReturnNode;
		ListNode tem = new ListNode(0);
		ReturnNode= tem;
    	int flag = 0;
    	for(;;) {
    		tem.val = l1.val + l2.val + flag;
    		
    		if(tem.val >= 10) {
    			flag = 1;
    			tem.val = tem.val - 10;
    		}else {
    			flag = 0;
    		}

    		if(l1.next == null && l2.next != null ) {
    			l1.next = new ListNode(0);
    		}
    		
    		if(l2.next == null && l1.next != null) {
    			l2.next = new ListNode(0);
    		}
    		
    		if(l1.next ==null && l2.next ==null && flag == 1) {
    			tem.next = new ListNode(1);
    			break;
    		}else if(l1.next ==null && l2.next ==null && flag == 0){
    			break;
    		}
    			l1 = l1.next;
    			l2 = l2.next;
    			tem.next= new ListNode(0);
        		tem = tem.next;
    		

    	}
		return ReturnNode;

    }
    
    public static void main(String args[]) {
    	ListNode l11 = new ListNode(6);
    	ListNode l12 = new ListNode(1);
    	ListNode l13 = new ListNode(2);
    	ListNode l14 = new ListNode(3);
    	ListNode l21 = new ListNode(9);
    	ListNode l22 = new ListNode(4);
    	ListNode l23 = new ListNode(5);
    	ListNode l24 = new ListNode(7);
    	ListNode l25 = new ListNode(1);
    	
    	l11.next =l12;
    	l12.next =l13;
    	l13.next =l14;
    	l21.next =l22;
    	l22.next =l23;
    	l23.next =l24;
    	l24.next =l25;
    	
    	ListNode check = addTwoNumbers(l11,l21);

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
