package Leetcode;

public class Test26_É¾³ıÖØ¸´ {
		
	public static int removeDuplicates(int[] nums) {
	
	int point1 = 1;
	
	for(int i = 1 ; i < nums.length;i++) {
		if(nums[i] == nums[i-1]) {
			
		}else {
			nums[point1] = nums[i];
			point1++;
		}
		
	}

	return point1++;
	}
	
	public static void main(String args[]) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int len = removeDuplicates(nums);
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i]);
		}
	}
}
