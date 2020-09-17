package Leetcode;

public class Test53_��������_���η� {
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
