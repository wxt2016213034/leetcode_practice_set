package Leetcode;

public class Test86_·Ö¸ôÁ´±í {
	  public static ListNode partition(ListNode head, int x) {
		  	ListNode returnnode = new ListNode(-1);
		  	ListNode small = new ListNode(-1);
		  	ListNode truereturn = small;
		  	ListNode key = new ListNode(-1);
		  	returnnode.next = head;
		  	small.next =head;
		  	key.next=head;
		  	while(key.next != null) {
		  		key = key.next;
		  		if(key.val > x) {
		  			break;
		  		}
		  	}
		  	while(returnnode.next != null) {
		  		ListNode temp = returnnode;
		  		returnnode = returnnode.next;
		  		if(returnnode.val < x) {
		  			small.next = returnnode;
		  			small = small.next;
		  			temp.next = returnnode.next;
		  			returnnode = temp;
		  		}
		  	}
		  	
		  	small.next = key;
		  	
		  	return truereturn.next;
	    }
	  public ListNode partition1(ListNode head, int x) {

	        // before and after are the two pointers used to create the two list
	        // before_head and after_head are used to save the heads of the two lists.
	        // All of these are initialized with the dummy nodes created.
	        ListNode before_head = new ListNode(0);
	        ListNode before = before_head;
	        ListNode after_head = new ListNode(0);
	        ListNode after = after_head;

	        while (head != null) {

	            // If the original list node is lesser than the given x,
	            // assign it to the before list.
	            if (head.val < x) {
	                before.next = head;
	                before = before.next;
	            } else {
	                // If the original list node is greater or equal to the given x,
	                // assign it to the after list.
	                after.next = head;
	                after = after.next;
	            }

	            // move ahead in the original list
	            head = head.next;
	        }

	        // Last node of "after" list would also be ending node of the reformed list
	        after.next = null;

	        // Once all the nodes are correctly assigned to the two lists,
	        // combine them to form a single list which would be returned.
	        before.next = after_head.next;

	        return before_head.next;
	    }
	  
	  public static void main(String args[]) {
	    	ListNode l11 = new ListNode(1);
	    	ListNode l12 = new ListNode(4);
	    	ListNode l13 = new ListNode(3);
	    	ListNode l14 = new ListNode(2);
	    	ListNode l15 = new ListNode(3);
	    	ListNode l16 = new ListNode(2);
	    	ListNode l17 = new ListNode(3);
	    	ListNode l18 = new ListNode(2);
	    	ListNode l20 = new ListNode(5);
	    	ListNode l21 = new ListNode(2);
	    	
	    	l11.next =l12;
	    	l12.next =l13;
	    	l13.next =l14;
	    	l14.next =l15;
	    	l15.next =l16;
	    	l16.next =l17;
	    	l17.next =l18;
	    	l18.next =l20;
	    	l20.next =l21;
	    	
	    	ListNode check = partition(l11,3);
	    	
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
