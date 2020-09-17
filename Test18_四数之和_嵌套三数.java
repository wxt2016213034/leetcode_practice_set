package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test18_四数之和_嵌套三数 {
	 public static int[] arraySub(int[] data,int start,int end){
	        int[] C=new int[end-start];//新建数组C长度为start-end
	        int j=0;
	        for(int i=start;i<end;i++){
	            C[j]=data[i];
	            j++;
	        }
	        return C;//返回截取数组的地址
	    }

	public static List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> re = new ArrayList<>();
		Arrays.sort(nums);
		for(int i =0; i< nums.length-3;i++) {
			if(i>0 && nums[i]==nums[i-1])continue;
			List<List<Integer>> curre1 = new ArrayList<>();
			curre1 = threeSum(arraySub(nums,i+1,nums.length),target-nums[i]);
			if(curre1.size() != 0) {
			for(int j = 0; j < curre1.size();j++) {
				re.add(Arrays.asList(nums[i],curre1.get(j).get(0),curre1.get(j).get(1),curre1.get(j).get(2)));
			}
			}
		}
		
		return re;
	}
	 public static List<List<Integer>> threeSum(int[] nums,int target) {
	    	List<List<Integer>> re = new ArrayList<>();
	    	for(int i =0; i <nums.length-2;i++) {
	    		int begin =i+1;
	    		int end = nums.length-1;
	    		if(i>0 && nums[i]==nums[i-1])continue;
	    		for(;begin <end;) {
	    			
	    			
	    			if(nums[begin] + nums[i] + nums[end] >target) {
	    				end--;
	    				continue;
	    			}
	    			if(nums[begin] + nums[i] + nums[end] <target) {
	    				begin++;
	    				continue;
	    			}
	    			if(nums[begin] + nums[i] + nums[end] == target) {
	    				
	    				
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
	    	int[] nums = {1, 0, -1, 0, -2, 2};
	    	System.out.println(fourSum(nums,0));
	    	
	    	
	    }
}
