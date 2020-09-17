package Leetcode;

public class Test69_Æ½·½¸ù {
	   public static int mySqrt(int x) {
		   int l = 0, r = x;
		   int mid = 0;
	        while (l < r) {
	             mid = (l+r+1)/2;
	            if ((long)mid * mid <= x) {
	                l = mid;
	            }
	            else {
	                r = mid - 1;
	            }
	        }
	        return mid;

	    }
	   public static void main(String args[]) {
		   System.out.print(mySqrt(8));
		   
	   }

}
