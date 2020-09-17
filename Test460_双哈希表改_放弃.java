package Leetcode;

import java.util.HashMap;

public class Test460_双哈希表改_放弃 {
	HashMap<Integer,ListNode> hash;
	HashMap<Integer,ListNode> freqhash;
	int count =0;
	int capacity;
		public Test460_双哈希表改_放弃(int capacity) {
			hash = new HashMap<Integer,ListNode>();
			freqhash = new HashMap<Integer,ListNode>();
			this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	    	if(hash.containsKey(key)) {
	    		int freq = ++hash.get(key).freq;
	    		System.out.println(freq+"mm,");
	    		if(!freqhash.containsKey(freq)) {
	    			freqhash.put(freq, hash.get(key));
	    			freqhash.get(freq).next = null;
	    			freqhash.get(freq).pre = null;
	    		}else {
	    			 hash.get(key).pre.next = hash.get(key).next;
	    			 hash.get(key).next.pre = hash.get(key).pre;
	    			ListNode cur = freqhash.get(freq);
	    			freqhash.remove(freq);
	    			freqhash.put(freq, hash.get(key));
	    			freqhash.get(freq).next = cur;
	    			freqhash.get(freq).pre = null;
	    			cur.pre = freqhash.get(freq);
	    		}
	    		return hash.get(key).val;
	    	}else {
	    		return -1;
	    	}
	    }
	    
	    public void put(int key, int value) {
	    	ListNode input = new ListNode(value);
	    	input.freq =1;
	    	input.key = key;
	    	input.pre = null;
	    	input.next = null;
	    	if(hash.containsKey(key)) {
	    	 hash.get(key).pre.next = hash.get(key).next;
			 hash.get(key).next.pre = hash.get(key).pre;
	    	hash.remove(key);	
	    	hash.put(key, input);
	    	if(freqhash.containsKey(1)) {
	    		ListNode cur = freqhash.get(1);
    			freqhash.remove(1);
    			freqhash.put(1, hash.get(key));
    			freqhash.get(1).next = cur;
    			cur.pre = freqhash.get(1);
    			freqhash.get(1).pre = null;
	    	}else {
	    		freqhash.put(1, input);
	    		freqhash.get(1).next = null;
    			freqhash.get(1).pre = null;
	    	}
	    	}else if(count == capacity){
	    			if(freqhash.containsKey(1)) {
	    				ListNode cur = freqhash.get(1);
	    				while(cur.next != null) {
	    					System.out.println(cur.val+"l");
	    				 cur = cur.next;
	    					System.out.println(cur.pre.val+"l");
	    				}
	    				System.out.println(cur.pre.val+"l");
	    				//System.out.println(cur.pre);
	    				cur.pre.next = null;
	    				hash.remove(cur.key);
	    			 	hash.put(key, input);
	    		    	if(freqhash.containsKey(1)) {
	    		    		ListNode cur1 = freqhash.get(1);
	    	    			freqhash.remove(1);
	    	    			freqhash.put(1, hash.get(key));
	    	    			freqhash.get(1).next = cur1;
	    	    			cur.pre = freqhash.get(1);
	    	    			freqhash.get(1).pre = null;
	    		    	}else {
	    		    		freqhash.put(1, input);
	    		    		freqhash.get(1).next = null;
	    	    			freqhash.get(1).pre = null;
	    		    	}
	    		 
	    			
	    		}else {
	    			freqhash.put(1, input);
		    		freqhash.get(1).next = null;
	    			freqhash.get(1).pre = null;
	    		}
	    	}else if (count < capacity) {
	    		
	    		hash.put(key, input);
		    	if(freqhash.containsKey(1)) {
		    		ListNode cur = freqhash.get(1);
	    			freqhash.remove(1);
	    			freqhash.put(1, input);
	    			input.next = cur;
	    			cur.pre = input;
	    			input.pre = null;
	    			
		    	}else {
		    		freqhash.put(1, input);
		    		input.next = null;
	    			input.pre = null;
	    			
		    	}
	    		count++;
	    	System.out.println(count+"oo");
	    	}
	    }
	    
	    public static void main(String args[]) {
	    	int capacity = 2;
	    	int key = 1;
	    	Test460_双哈希表改_放弃 cache = new Test460_双哈希表改_放弃(capacity);
	    	cache.put(1, 1);
	    	cache.put(2, 2);
	    	System.out.println(cache.get(1));       // 返回 1
	    	cache.put(3, 3);    // 去除 key 2
	    	System.out.println(cache.get(2));      // 返回 -1 (未找到key 2)
	    	System.out.println(cache.get(3));      // 返回 3
	    	cache.put(4, 4);    // 去除 key 1
	    	System.out.println(cache.get(1));         // 返回 -1 (未找到 key 1)
	    	System.out.println(cache.get(3));        // 返回 3
	    	System.out.println(cache.get(4));       // 返回 4

	    	System.out.println();
	    	
	    }
	    
	    
	    
}
