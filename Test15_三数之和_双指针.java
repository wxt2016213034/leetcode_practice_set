package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test15_三数之和_双指针 {
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> re = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i <nums.length;i++) {
	  	System.out.println(nums[i]);
		}
    	for(int i =0; i <nums.length-2;i++) {
    		int begin =i+1;
    		int end = nums.length-1;
    		if(i>0 && nums[i]==nums[i-1])continue;
    		for(;begin <end;) {
    			
    			
    			if(nums[begin] + nums[i] + nums[end] >0) {
    				end--;
    				continue;
    			}
    			if(nums[begin] + nums[i] + nums[end] <0) {
    				begin++;
    				continue;
    			}
    			if(nums[begin] + nums[i] + nums[end] ==0) {
    				
    				
    				re.add(Arrays.asList(nums[begin] , nums[i] , nums[end]));
    				while(begin <end && nums[begin] == nums[begin+1]) {
    					begin++;
    				}
    				while(end >begin && nums[end] == nums[end-1]) {
    					end--;
    				}
    				begin++;
    				end--;
    			}
    			System.out.println(""+i+begin+end);
    			
    		}
    	}
    	
    	return re;
    	
    }
    
    public static void main(String args[]) {
    	int[] nums = {-1,-1,-1,-1,0,1,2,-1,-4};
    	System.out.println(threeSum(nums));
    	
    	
    }
}
