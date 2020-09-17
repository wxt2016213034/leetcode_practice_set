package Leetcode;

public class Test33_旋转搜索_不用找到断点_二分法 {
	 public static int search(int[] nums, int target) {
	        int len = nums.length;
	        int left = 0, right = len-1;
	        while(left <= right){
	            int mid = (left + right) / 2;
	            if(nums[mid] == target)
	                return mid;
	            else if(nums[mid] < nums[right]){
	                if(nums[mid] < target && target <= nums[right])
	                    left = mid+1;
	                else
	                    right = mid-1;
	            }
	            else{
	                if(nums[left] <= target && target < nums[mid])
	                    right = mid-1;
	                else
	                    left = mid+1;
	            }
	        }
	        return -1;
	    }
	
	public static void main(String args[]) {
		int[] nums = {1,3,5};
		System.out.print(search(nums,0));
		
	}
}
