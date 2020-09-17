package Leetcode;

public class Test81_搜索旋转数组 {
	public boolean search(int[] nums, int target) {
		int len = nums.length;
		int begin = 0; 
		int end = len-1;
		int mid;
		while(begin <= end) {
            while(begin<end&&nums[begin]==nums[begin+1]) ++begin;
            while(begin<end&&nums[end]==nums[end-1]) --end;
			mid = (begin + end)/2;
			if(nums[mid] == target)return true;
			if(nums[mid] < nums[begin] && target <=nums[end] && target > nums[mid]) {
				return normalbicut(nums,mid,end,target);
			}else if(nums[mid] > nums[begin] && target<nums[mid] && target>=nums[begin]) {
				return normalbicut(nums,begin,mid,target);
			}else if(nums[mid] < nums[begin] && (target <nums[mid] || target >= nums[begin])) {
				end = mid-1;
			}else {
				begin = mid+1;
			}
		}
		
		return false;
    }

	private boolean normalbicut(int[] nums, int begin, int end, int target) {
		int mid;
		while(begin <= end) {
			mid = (begin + end)/2;
			if(nums[mid] == target)return true;
			if(nums[mid]<target) {
				begin = mid+1;
			}else {
				end = mid-1;
			}
		}
		return false;
	}
	public static void main(String args[]) {
		Test81_搜索旋转数组 p = new Test81_搜索旋转数组();
		int[] nums= {2,5,6,0,0,1,2};
		System.out.print(p.search(nums,0));
	}
}
