package Leetcode;

public class Test53_最大子序和_分治法 {
	 public int maxSubArray(int[] nums) {
		 int len = nums.length;
		 int premax = nums[0];
		 int Max = nums[0];
		 for(int i = 1 ; i < len ; i++) {
			 premax = Math.max(premax+nums[i], nums[i]);
			 Max = Math.max(Max, premax);
		 }
		 return Max;
	    }
	 
	 
}
