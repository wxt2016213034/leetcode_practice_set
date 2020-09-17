package Leetcode;

public class Test50_pow {
    public double myPow(double x, int n) {
    	int N = n;
    	if (N < 0) {
            x = 1 / x;
            N = -N;
        }
    	return iteration(x,n);
    }
    
    
    public double iteration(double x, int n) {
    	if(n == 0) {
    		return 1;
    	}
    	
    	double half = iteration(x,n/2);
    	if(n%2 == 0) {
    		return half*half;
    	}else {
    		return half*half*x;
    	}
    }
    public static void main(String args[]) {
    	Test50_pow ad = new Test50_pow();
    	System.out.print(ad.myPow(2, -10));
    }
    
}
