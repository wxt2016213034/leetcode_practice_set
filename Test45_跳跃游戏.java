package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Test45_ÌøÔ¾ÓÎÏ· {
	
	ArrayList<Integer> jumplist;
	   public int jump(int[] nums) {
		   jumplist = new ArrayList<Integer>();
		   for(int i = 1 ; i <= nums[0];i++) {
			   iterationjump(nums,i,1);
		   }
		   int[] p = new int[jumplist.size()];
		   for(int i = 0; i < p.length;i++) {
			   p[i] = jumplist.get(i);
		   }
		   Arrays.sort(p);
		   return p[0];
	    }
	private void iterationjump(int[] nums, int i,int times) {
		// TODO Auto-generated method stub
		if(i == nums.length-1) {
			jumplist.add(times);
			return;
		}else if(i >= nums.length) {
			return;
		}else {
			int iterationtimes = nums[i];
			for(int j = 1; j <= iterationtimes; j++) {
			iterationjump(nums,i+j,times+1);	
			}
		}
	}
	
	
	public int jump2(int[] nums) {
		if(nums.length ==1) {
			return 0;
		}
		int start = 1;
		int times = 1;
		int max = nums[0];
		while(max < nums.length-1) {
			int temp = max;
			for(int j = start; j <= temp;j++) {
				max = max > nums[j]+j ? max:nums[j]+j;
			}
			start = temp+1;
			times++;
		}
		return times;
	}
	
	
	
	public static void main(String args[]) {
		Test45_ÌøÔ¾ÓÎÏ· ac = new Test45_ÌøÔ¾ÓÎÏ·();
		int[] nums = {2,3,1,1,4,1,1,1,1,1,1,1,1,1,1};
		System.out.print(ac.jump2(nums));
		
		
	}
}
