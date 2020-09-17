package Leetcode;

public class Test41_第一个缺失正数_符号 {
	 public static int firstMissingPositive(int[] nums) {
		 if(nums.length == 0) {
			 return 1;
		 }
		 boolean flag = false;
		 for(int i = 0 ; i < nums.length ; i++) {
			 if(nums[i] ==1) {
				 flag = true;
				 break;
			 }
		 }
		 if(!flag) {
			 return 1;
		 }
		 for(int i = 0; i < nums.length; i++) {
			 if(nums[i] <= 0) {
				 nums[i] = 1;
			 }
		 }
		 boolean flag1 = false;
		 for(int i =0; i < nums.length; i++) {
			 int abs = Math.abs(nums[i]);
			 if(abs < nums.length && nums[abs] >0) {
				 nums[abs] = - nums[abs];
			 }else if(abs == nums.length){
				 flag1 = true;
			 }
		 }
		 for(int i = 1 ; i < nums.length;i++) {
			 if(nums[i] > 0) {
				 return i;
			 }
		 }
		 if(flag1) {
			 return nums.length+1;
		 }else {
			 return nums.length;
		 }
		 
	  }
	 public static void main(String args[]) {
		 int[] nums = {1,2};
		 System.out.print(firstMissingPositive(nums));
	 }
}
