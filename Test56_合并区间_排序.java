package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Test56_合并区间_排序 {
	   public static int[][] merge(int[][] intervals) {
		   int len = intervals.length;
		   if(len == 1) {
			   return intervals;
		   }
		   for(int i = 0 ; i < len-1 ; i++) {
			   for(int j = 0 ; j < len-1-i; j++) {
				if(intervals[j][0] > intervals[j+1][0]) {
					int[] p = intervals[j+1];
					intervals[j+1] = intervals[j];
					intervals[j] = p;
				}
			   }
		   }
		   ArrayList<int[]> p = new ArrayList<int[]>();
		   for(int i = 0 ; i < len-1; i ++) {
			   int min = intervals[i][0];
			   int max = intervals[i][1];
			   if(intervals[i+1][0] == intervals[i][0]) {

				   while(i < len-1 && intervals[i+1][0] == intervals[i][0]) {
					   max = Math.max(intervals[i+1][1], max);
					   i++;
				   }

			   }
			   
			   if(p.size()>0 && min > p.get(p.size()-1)[1]) {
				   p.add(new int[] {min,max});
			   }else if(p.size() == 0 ) {
				   p.add(new int[] {min,max});
			   }else {
				   int premin = p.get(p.size()-1)[0];
				   int premax = p.get(p.size()-1)[1];
				   p.remove(p.size()-1);
				   p.add(new int[] {premin,Math.max(premax, max)});
				   
			   }
			   
		   }
		   if(intervals[len-1][0] > p.get(p.size()-1)[1]) {
			   p.add(new int[] {intervals[len-1][0],intervals[len-1][1]});
		   }else {
			   int premin = p.get(p.size()-1)[0];
			   int premax = p.get(p.size()-1)[1];
			   p.remove(p.size()-1);
			   p.add(new int[] {premin,Math.max(premax, intervals[len-1][1])});
		   }
		   
		   
		   int[][] returnlist = new int[p.size()][2];
		   for(int i = 0; i < p.size();i++) {
			   returnlist[i] = p.get(i);
		   }
		   return returnlist;
	    }
	   
	   
	   public static void main(String args[]) {
		   int[][] nums = {{4,5},{1,4},{0,1}};
		   int[][] nums1 = merge(nums);
		   for( int i=0;i<nums1.length;i++)
		        System.out.println(Arrays.toString(nums1[i]));
	   }
}
