package Leetcode;

public class Test27_É¾³ıÔªËØ {
	public int removeElement(int[] nums, int val) {
	    if(nums.length ==0){
	            return 0;
	        }
	int point1 = 0;
		
		for(int i = 0 ; i < nums.length;i++) {
			if(nums[i] == val) {
				
			}else {
				nums[point1] = nums[i];
				point1++;
			}
			
		}

		return point1++;
	    }
}
