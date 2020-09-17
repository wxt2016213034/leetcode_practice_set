package Leetcode;

public class Test75_ÑÕÉ«·ÖÀà {
	 public static void sortColors(int[] nums) {
		 int len = nums.length;
		 int begin = 0;
		 int end = len-1;
		 for(int i = 0 ; i <= end;) {
			 if(nums[i] == 0 && i != 0) {
				 for(int j = i-1; j>=begin; j--) {
					 nums[j+1] =nums[j]; 
				 }
				 nums[begin] = 0;
				 begin++;
				 i++;
			 }else if(nums[i] == 2 && i != len-1) {
				 for(int j = i+1; j <=end; j++) {
					 nums[j-1] = nums[j];
				 }
				 nums[end] = 2;
				 end--;
			 }else {
				 i++;
			 }
		 }
	    }
	 
	 public static void main(String args[]) {
		 int[] nums = {0,0};
		 sortColors(nums);
		 for(int i = 0; i < nums.length; i++) {
		 System.out.print(nums[i]);
		 }
	 }
}
