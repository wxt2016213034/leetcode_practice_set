package Leetcode;

public class Test62_²»Í¬Â·¾¶ {
	  public static int uniquePaths(int m, int n) {
		  int[] temparray = new int[m];
		  for(int i = 0 ; i < m; i++) {
			  temparray[i] = 1;  
		  }
		  
		  for(int i = 0; i < n-1;i++) {
			  int tempint;
			  for(int j = 1; j < m;j++) {
				  tempint = temparray[j-1];
				  temparray[j] = temparray[j] + tempint; 
			  }
		  }
		  
		  return temparray[m-1];
	    }
	  
	  public static void main(String args[]) {
		  System.out.print(uniquePaths(7,3));
	  }
}
