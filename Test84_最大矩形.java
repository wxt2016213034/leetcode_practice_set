package Leetcode;

import java.util.Stack;

public class Test84_×î´ó¾ØÐÎ {
	 public int largestRectangleArea(int[] heights) {
		 int len = heights.length;
		 int leftpoint;
		 int rightpoint;
		 int maxvalue = 0;
		 for(int i=0 ;i < len ; i++) {
			 leftpoint = i;
			 rightpoint = i;
			 while(leftpoint >= 0) {
				 if(heights[leftpoint] < heights[i]) {
					break; 
				 }else {
						 leftpoint--;
				 }
			 }
			 leftpoint++;
			 while(rightpoint <= len-1) {
				 if(heights[rightpoint] < heights[i]) {
					break; 
				 }else {
						 rightpoint++;
				 }
			 }
			 rightpoint--;
			 int sum = (rightpoint-leftpoint+1)*heights[i];
			 maxvalue = maxvalue > sum ? maxvalue : sum;
		 }
		 return maxvalue;
	  }
	 
	 public int largestRectangle(int nums[]) {
		 int len = nums.length;
		 int maxvalue = 0;
		 int[] left = new int[len];
		 int[] right = new int[len];
		 
		 Stack<Integer> index = new Stack<Integer>();
		 for(int i = 0; i < len ; i++) {
			 while(!index.isEmpty() && nums[index.peek()] > nums[i]) {
				 index.pop();
			 }
			 if(index.isEmpty()) {
			 left[i] = 0;
			 }else {
			 left[i] = index.peek()+1;
			 }
			 index.push(i);
		 }
		 index.clear();
		 
		 for(int i = len-1 ; i >=0; i--) {
			 while(!index.isEmpty() && nums[index.peek()] > nums[i]) {
				 index.pop();
			 }
			 if(index.isEmpty()) {
			 right[i] = len-1;
			 }else {
			 right[i] = index.peek()-1;
			 }
			 index.push(i);
			 
		 }
		 for(int i = 0 ; i < len ; i++) {
			 maxvalue = maxvalue > (right[i] - left[i]+1)*nums[i]? maxvalue:(right[i] - left[i]+1)*nums[i];
		 }
		 
		 return maxvalue;
	 }
}
