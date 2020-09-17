package Leetcode;

public class Test11_װˮ_˫ָ�� {
    public static int maxArea(int[] height) {
    	int maxarea =0;
    	int len = height.length;
    	for(int i =0,j=len-1; i<j;) {
    		int area = Math.min(height[i], height[j]) * (j-i);
    		
    		if(area > maxarea) {
    			maxarea = area;
    		}
    		
    		if(height[i]>height[j]) {
    			j--;
    			
    		}else {
    			i++;
    		}
    		
    	}
    	return maxarea;
    }
    
    public static void main(String args[]){
	int[] height =  {1,8,6,2,5,4,8,3,7};
    	
    	System.out.print(maxArea(height));
}
    
    
}
