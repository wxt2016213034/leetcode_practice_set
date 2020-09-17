package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test16_带目标的三数之和_双指针 {
    public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closestNum = 9999;
    	for(int i =0; i <nums.length-2;i++) {
    		int begin =i+1;
    		int end = nums.length-1;
    		for(;begin <end;) {
    			int threeSum = nums[begin] + nums[i] + nums[end];
    		     if (Math.abs(threeSum- target) < Math.abs(closestNum - target)) {
                     closestNum = threeSum;
                 }
    		     
    			if(threeSum >target) {
    				end--;
    				continue;
    			}
    			
    			if(threeSum<target) {
    				begin++;
    				continue;
    			}
    			
    			if(threeSum==target) {
    				
    	            return target;
    			}
    			
    			
    		}
    	}
    	
    	return closestNum;
    	
    }
    
    public static void main(String args[]) {
    	int[] nums = {0,2,1,-3};
    	System.out.print(threeSumClosest(nums,1));
    	
    }
}
