package Leetcode;

public class Test44_ÕÒÔªËØ {
    public int[] searchRange(int[] nums, int target) {
    	int begin = 0;
    	int end = nums.length-1;
    	int index = 0;
    	int[] p = new int[2];
    	if(nums.length ==0) {
    		p[0] = -1;
    		p[1] = -1;
    		return p;
    	}else if(nums.length ==1 ) {
    		if(nums[0] == target) {
    			p[0] = 0;
        		p[1] = 0;
        		return p;
    		}else {
    			p[0] = -1;
        		p[1] = -1;
        		return p;
    		}
    	}else if(nums.length ==2) {
    		if(nums[0] == target && nums[1] == target) {
    			p[0] = 0;
        		p[1] = 1;
        		return p;
    		}else if(nums[0] == target) {
    			p[0] = 0;
        		p[1] = 0;
        		return p;
    		}else if(nums[1]== target){
    			p[0] = 1;
        		p[1] = 1;
        		return p;
    		}else {
    			p[0] = -1;
        		p[1] = -1;
        		return p;
    		}
    	}
    	boolean flag = false;
    	while(begin < end) {
    		int mid = (begin + end)/2;
    		if(nums[mid] == target) {
    			index = mid;
    			flag =true;
    			break;
    			
    		}
    		if(nums[mid] > target) {
    		    end = mid; 
    		}else {
    			begin = mid +1;
    		}
    	}
    	if(flag) {
    		int indexbegin = index;
    		int indexend = index;
    		for(;indexend - indexbegin < nums.length-1;) {
    			boolean flag1 = false;
    			boolean flag2 = false;
    			if(indexbegin-1 >=0 && nums[indexbegin-1] == target) {
    				indexbegin--;
    				flag1 =true;
    			}
    			if(indexend +1 <= nums.length -1 && nums[indexend +1] == target) {
    				indexend++;
    				flag2 = true;
    			}
    			if(flag1 || flag2) {
    			}else {
    				break;
    			}
    		}
    		p[0] = indexbegin;
    		p[1] = indexend;
    		return p;
    	}else {
    		p[0] = -1;
    		p[1] = -1;
    		return p;
    	}
    	
    	
    }
}
