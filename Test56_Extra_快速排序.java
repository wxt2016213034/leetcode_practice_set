package Leetcode;

public class Test56_Extra_¿ìËÙÅÅĞò {

	
	public static void quicksort(int[] nums, int ll, int rr) {
		if(rr-ll <= 1) {
			return;
		}
		int len = rr-ll+1;
		int flag = nums[rr];
		int leftpoint = ll;
		int rightpoint = rr-1;
		while(true) {
			while(nums[leftpoint] < flag && leftpoint < rightpoint) {
				leftpoint++;
			}
			if(leftpoint == rightpoint)break;
			while(nums[rightpoint] > flag && leftpoint < rightpoint) {
				rightpoint--;
			}
			if(leftpoint == rightpoint)break;
			int cur = nums[leftpoint];
			nums[leftpoint] = nums[rightpoint];
			nums[rightpoint] = cur;
		}
		
		if(nums[leftpoint] < flag) {
			for(int i = rr; i > leftpoint+1; i --) {
				nums[i] = nums[i-1];
			}
			nums[leftpoint+1] = flag;
			quicksort(nums,ll,leftpoint);
			quicksort(nums,leftpoint+2,rr);
		}else {
			for(int i = rr; i > leftpoint; i --) {
				nums[i] = nums[i-1];
			}
			nums[leftpoint] = flag;
			quicksort(nums,ll,leftpoint-1);
			quicksort(nums,leftpoint+1,rr);
		}
		
	}
	
	public static void main(String args[]) {
		int[] nums = {9,5,4,8,6,3,2,1,7};
		quicksort(nums,0,nums.length-1);
		for(int i = 0; i < nums.length; i++) {
		System.out.print(nums[i]);
		}
	}
	
}
