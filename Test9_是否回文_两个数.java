package Leetcode;

public class Test9_是否回文_两个数 {
    public static boolean isPalindrome(int x) {
    	if(x<0) {
    		return false;
    	}
    	int k=0;
    	int p=x;
    	for(;p>=1;) {
    		k=k*10+p%10;
    		p=p/10;
    		
    	}
    	if(k==x) {
    		return true;
    	}else {
		return false;
    	}
    	
    	
    }
    
    
    public static void main(String args[]) {
    	System.out.print(isPalindrome(113455411));
    	
    	
    }
}
