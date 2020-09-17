package Leetcode;

import java.util.ArrayList;

public class Test57_²åÈëÇø¼ä {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
    	int len = intervals.length;
    	int index = 0;
    	int[][] returnint;
    	if(intervals[0][0] > newInterval[1]) {
    		returnint = new int[len+1][2];
    		returnint[0] = newInterval;
    		for(int i = 0 ; i < len; i++) {
    			returnint[i+1] = intervals[i];
    		}
    		return returnint;
    	}else if(intervals[len-1][1] < newInterval[0]) {
    		returnint = new int[len+1][2];
    		returnint[len] = newInterval;
    		for(int i = 0 ; i < len; i++) {
    			returnint[i] = intervals[i];
    		}
    		return returnint;
    	}else if(newInterval[0] < intervals[0][0] && newInterval[1] > intervals[0][0]) {
    		int count = 0;
    		while(intervals[count][1] < newInterval[1] ) {
    			count++;
    		}
    		if(intervals[count][0] <= newInterval[1]) {
    			int[] newgap = {newInterval[0],intervals[count][1]};
    			returnint = new int[len - count][2];
    			returnint[0] = newgap;
    			for(int i = 1; i < len-count; i++) {
    				returnint[i] = intervals[i+count];
    			}
    			return returnint;
    		}else {
    			returnint = new int[len - count+1][2];
    			returnint[0] = newInterval;
    			for(int i = 1; i < len-count+1; i++) {
    				returnint[i] = intervals[i+count-1];
    			}
    			return returnint;
    		}
    		
    	}
    	
    	
    	for(int i = 0 ; i < len; i++) {
    		if(i == len-1) {
    			if(intervals[len-1][1] > newInterval[0]) {
    				int[] newgap = {intervals[len-1][0],newInterval[1]};
    				intervals[len-1] = newgap;
    				return intervals;
    			}else {
    				returnint = new int[len+1][2];
    				for(int j = 0 ; j < len ; j++) {
    					returnint[j] = intervals[j];
    				}
    				returnint[len] = newInterval;
    			}
    		}
    		if(intervals[i][0] < newInterval[0] && intervals[i+1][0] > newInterval[0]) {
    			index = i;
    			break;
    		}
    	}
    	
    	if(intervals[index][1] < newInterval[0] ) {
    		int count = 0;
    		while(intervals[count+index+1][1] < newInterval[1] ) {
    			count++;
    		}
    		if(intervals[count+index+1][0] <= newInterval[1]) {
    			int[] newgap = {newInterval[0],intervals[count][1]};
    			returnint = new int[len - count][2];
    			returnint[index+1] = newgap;
    			for(int i = 0; i < index+1; i++) {
    				returnint[i] = intervals[i];
    			}
    			for(int i = index+2 ; i < len-count; i++) {
    				returnint[i] = intervals[i+count];
    			}
    			return returnint;
    		}else {
    			returnint = new int[len - count+1][2];
    			returnint[index+1] = newInterval;
    			for(int i = 0; i < index+1; i++) {
    				returnint[i] = intervals[i];
    			}
    			for(int i = index+2; i < len-count+1;i++) {
    				returnint[i] = intervals[i + count-1];
    			}
    			return returnint;
    		}
    	}else {
    		int count = 0;
    		while(intervals[count+index+1][1] < newInterval[1] ) {
    			count++;
    		}
    		if(intervals[count+index+1][0] <= newInterval[1]) {
    			int[] newgap = {intervals[index][0],intervals[count+index+1][1]};
    			returnint = new int[len - count-1][2];
    			returnint[index] = newgap;
    			for(int i = 0; i < index; i++) {
    				returnint[i] = intervals[i];
    			}
    			for(int i = index+1 ; i < len-count-1; i++) {
    				returnint[i] = intervals[i+count+1];
    			}
    			return returnint;
    		}else {
    			returnint = new int[len - count][2];
    			int[] newgap = {intervals[index][0],newInterval[1]};
    			returnint[index] = newInterval;
    			for(int i = 0; i < index; i++) {
    				returnint[i] = intervals[i];
    			}
    			for(int i = index+1; i < len-count;i++) {
    				returnint[i] = intervals[i + count];
    			}
    			return returnint;
    		}
    	}
    
    }
    
    
    public static int[][] insert2(int[][] nums, int[] newinterval) {
    	ArrayList newarray = new ArrayList<>();
    	int begin = newinterval[0];
    	int end = newinterval[1];
    	if(newinterval[1] < nums[0][0]) {
    		newarray.add(newinterval);
    	}
    	for(int i = 0 ; i < nums.length; i++) {
    		if(nums[i][1] < begin) {
    			newarray.add(nums[i]);
    		}else if(nums[i][0] > end) {
    			newarray.add(nums[i]);
    		}else if(i!=0 && nums[i-1][1]<begin&&nums[i][0] > end ){
    		newarray.add(newinterval);
    		}else{
    			int newbegin = Math.min(nums[i][0],begin);
    			while(i < nums.length && nums[i][0] <= end) {
    				i++;
    			}
    			i--;
    			int newend = Math.max(nums[i][1],end);
    			newarray.add(new int[] {newbegin,newend});
    		
    			String s;
    			
    			
    		}
    		
    	}
    	if(newinterval[0] > nums[nums.length-1][1]) {
    		newarray.add(newinterval);
    	}
    	int[][] returnarray = new int[newarray.size()][2];
    	for(int i = 0 ; i < newarray.size(); i++) {
    		returnarray[i] = (int[]) newarray.get(i);
    	}
    	
    	
    	
    	return returnarray;
    }
    public static void main(String args[]) {
    	int[][] nums = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    	int[] interval = {4,8};
    	int [][] newnums = insert2(nums,interval);
    	for(int i = 0 ; i < newnums.length; i++) {
    		System.out.println(newnums[i][0]+""+newnums[i][1]);
    	}
    }
}
