package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Test43_½ÓÓêË®_Õ»_Ë«Ö¸Õë {
	   public static int trap(int[] height) {
		   int volum = 0;
		   ArrayList<Integer[]> recordv = new ArrayList<Integer[]>();
		   for(int i = 1 ; i < height.length-1; i++) {
			   int volumcur =0;
			   if(height[i] == height[i-1])continue;
			   if(height[i-1] > height[i] && height[i+1] >= height[i] ) {
				   int recordleft = 0;
				   int recordlpoint = i-1;
				   int recordright = 0;
				   int recordrpoint = i+1;
				   int flag1 =0;
				   for(int j = i-1;j>-1;j--) {
					   if(flag1 ==1)break;
					   if(height[j]> recordleft) { 
						   recordleft = height[j];
						   recordlpoint = j;
						   for(int k = i+1;k < height.length;k++) {
							   if(height[k]>=height[j]) {
								   recordright = height[k];
								   recordrpoint = k;
								   break;
							   }
							   if(height[k]>recordright) {
								   recordright = height[k];
								   recordrpoint = k;
							   }
							   if(k==height.length-1) {
								   flag1=1;
							   }
						   }
						   
					   }else if(height[j]<=recordleft)break;
				   }
				   
				   System.out.println(""+i+recordlpoint+recordrpoint);
				   
				   if(recordright == height[i])continue;
				   
				   int flag =0;
				   for(int k = 0 ; k < recordv.size();k++) {
					   if(recordlpoint >= recordv.get(k)[0] && recordrpoint <= recordv.get(k)[1]) {
						   flag =1;
					   }
				   }
				   
				   if(flag ==1) {
					  continue;
				   }else {
					   Integer[] cur = new Integer[2];
					   cur[0] = recordlpoint;
					   cur[1] = recordrpoint;
					   recordv.add(cur);
				   }
				   
				   int volumraw =(recordrpoint - recordlpoint-1)*Math.min(height[recordlpoint], height[recordrpoint]);
				   for(int k = recordlpoint+1; k < recordrpoint;k++) {
					
					   volumraw -= height[k];
				   }
				   volum += volumraw;
				   
				   
			   }
			   
		   }
		   return volum;
	    }
	   
	   
	   public static int stacktrap(int[] nums) {
		   int volumn = 0;
		   Stack<Integer> p = new Stack<Integer>();
		   
		   for(int i = 0 ; i < nums.length;i++)
		   {
			 if(!p.isEmpty() && nums[p.peek()] < nums[i]) {
				   while(!p.isEmpty() && nums[p.peek()] < nums[i])   
				   {
					   int top = p.peek();
					   p.pop();
					   if(p.isEmpty())break;
					   int distance = i-p.peek()-1;
					   int volumncur = distance * (Math.min(nums[i], nums[p.peek()])-nums[top]);
					   volumn += volumncur;
					   
				   }
			   }
			   p.push(i);
			   
		   }
		   return volumn;
	   }
	   
	   public static void main(String args[]) {
		   int[] k = {0,1,0,2,1,0,1,3,2,1,2,1};
		   System.out.print(stacktrap(k));
		   
		   
	   }
	   
	   
	   
}
