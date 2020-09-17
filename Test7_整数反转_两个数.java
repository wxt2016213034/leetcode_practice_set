package Leetcode;

public class Test7_整数反转_两个数 {
    public static int reverse(int x) {
    	  long n = 0;
          while(x != 0) {
              n = n*10 + x%10;
              x = x/10;
          }
          return (int)n==n? (int)n:0;
    }
    
    
    
    public static void main(String args[]) {
    	
    	System.out.print(reverse(-1));
    }
}
