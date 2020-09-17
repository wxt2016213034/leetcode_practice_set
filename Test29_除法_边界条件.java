package Leetcode;

public class Test29_除法_边界条件 {
	  public static int divide(int dividend, int divisor) {
		  if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
		  int sign =1;
		  if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			  sign =-1;
		  }
		  int dend = Math.abs(dividend);
		  int dsor = Math.abs(divisor);
		  dend = -dend;
		  dsor = -dsor;
		  if(dend>dsor) return 0;
		  int a = divid(dend,dsor);
		  return sign * a;
	    }
	  
	  
	  public static int divid(int a, int b) {
		  if(a>b)return 0;
		  
		  int count =1;
		  int cur = b;
		  while((a < cur+cur || a == cur + cur) && (cur + cur<0)) {
			  cur = cur + cur;
			  count = count + count;
		  }
			  
		  if(a - cur < b) {
			  
			  count = count +divid(a-cur,b);
		  }
			  
		  return count;
		  
		 
	  }
	  
	  public static void main(String args[]) {
		  System.out.print(divide(8,3));
		  
	  }
}
