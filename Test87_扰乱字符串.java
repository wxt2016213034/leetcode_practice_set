package Leetcode;

public class Test87_ÈÅÂÒ×Ö·û´® {
	  public static boolean isScramble(String s1, String s2) {
		  int length1 = s1.length();
		  int length2 = s2.length();
		  if(length1 != length2) {
			  return false;
		  }else if(length1 == 1) {
			  return s1.equals(s2);
		  }
		  
		  boolean[][][] matrix = new boolean[length1][length1][length1+1];
		  for(int i = 0 ; i < length1;i++) {
			  for(int j = 0; j < length1 ; j ++) {
				  if(s1.charAt(i)==s2.charAt(j)) {
					  matrix[i][j][1] = true;
				  }else {
					  matrix[i][j][1] = false;
				  }
			  }
		  }
		  
		  for(int k = 2; k <= length1 ;k++) {
		  for(int i = 0; i <= length1 - k; i++) {
			  for(int j= 0 ; j <= length1 - k; j++) {
				  
					  boolean flag = false;
					  for(int p = 1 ; p <= k-1 ; p++) {
						  if(matrix[i][j][p] && matrix[i+p][j+p][k-p]) {
							flag = true;
							break;
						  }
						  if( matrix[i][j+k-p][p] && matrix[i+p][j][k-p]) {
							flag = true;
							break;  
						  }
					  }
					  matrix[i][j][k] = flag;
					  }
				  
		  }
		  }
		  
		  
		  return matrix[0][0][length1];
	    }
	  
	  public static void main(String args[]) {
		  System.out.print(isScramble("great","rgate"));
	  }
	  
}
