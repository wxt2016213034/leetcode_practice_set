package Leetcode;

import java.util.ArrayList;

public class Test460_双哈希表双向链表明天写 {
	
	
		public int capacity;
		public int[][] queue;
		public int[] timequeue;
		int curnum;
	   public Test460_双哈希表双向链表明天写(int capacity) {
		   	this.capacity = capacity;
		   	queue = new int[capacity][3];
		   	timequeue = new int[capacity];
		   	curnum = 0;
	    }
	    
	    public int get(int key) {
	    	int k = 0;
	    	int flag = 0;
	    	int index = 0;
	    	for(int i =0;i < queue.length; i++) {
	    		if(key == queue[i][0]) {
	    			k = queue[i][1];
	    			queue[i][2]++;
	    			flag =1;
	    			index = i;
	    			break;
	    		}
	    	}
	    	if(flag ==0)return -1;
	    	int cur = queue[index][0];
	    	for(int i =0; i <capacity;i++) {
	    		if(timequeue[i]==cur) {
	    			for(int j =i; j>0;j--) {
	    			timequeue[j] = timequeue[j-1];
	    			}
	    			timequeue[0]=cur;
	    		}
	    	}
	    	return k;
	    }
	    
	    public void put(int key, int value) {
	 
	    	for(int i =0;i < queue.length; i++) {
	    		if(key == queue[i][0]) {
	    			return;
	    	}
	    	}
	    	if(curnum < queue.length) {
	    		queue[curnum][0] = key;
	    		queue[curnum][1] = value;
	    		queue[curnum][2] = 0;
	    		timequeue[curnum] = key;
	    		curnum++;
	    		return;
	    	}
	    	int cur = 0;
	    	int min=999;
	    	ArrayList<Integer> k = new ArrayList<Integer>();
	    	for(int i =0;i<queue.length;i++) {
	    		if(queue[i][2] <min) {
	    			min = queue[i][2];
	    		}
	    	}
	    	int index =0;
	    	for(int i = 0 ; i<queue.length;i++) {
	    		if(queue[i][2] == min) {
	    		k.add(queue[i][0]);
	    		index = i;
	    		}
	    	}
	    	
	    	if(k.size()==1) {
	    		queue[index][0] = key;
	    		queue[index][1] = value;
	    		queue[index][2] = 0;
	    		for(int i =0; i <capacity;i++) {
		    		if(timequeue[i]==queue[index][0]) {
		    			for(int j =i; j<timequeue.length-1;j++) {
		    			timequeue[j] = timequeue[j+1];
		    			}
		    			timequeue[timequeue.length-1]=key;
		    		}
		    	}
	    		return;
	    	}else {
	    		for(int i = timequeue.length-1; i >-1; i--) {
	    			int flag = 0;
	    			for(int j = 0; j <k.size();j++) {
	    			if(timequeue[i] == k.get(j)) {
	    				index = k.get(j);
	    				flag =1;
	    				break;
	    			}
	    			}
	    			if(flag ==1) {
	    				break;
	    			}
	    		}
	    		for(int i = 0; i < queue.length;i++) {
	    			if(queue[i][0]==index) {
	    				index = i;
	    				break;
	    			}
	    		}
	    		queue[index][0] = key;
	    		queue[index][1] = value;
	    		queue[index][2] = 0;
	    		for(int i =0; i <capacity;i++) {
		    		if(timequeue[i]==queue[index][0]) {
		    			for(int j =i; j<timequeue.length-1;j++) {
		    			timequeue[j] = timequeue[j+1];
		    			}
		    			timequeue[timequeue.length-1]=key;
		    		}
		    	}
	    	}
	    	
	    	
	    }
	    
	    public static void main(String args[]) {
	    	int capacity = 2;
	    	int key = 1;
	    	/*Test460 cache = new Test460(capacity);
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
*/
	    	System.out.println();
	    	
	    }
}
