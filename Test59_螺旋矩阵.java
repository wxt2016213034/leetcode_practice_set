package Leetcode;

public class Test59_ÂİĞı¾ØÕó {
	  public static int[][] generateMatrix(int n) {
		  int[][] matrix = new int[n][n];
		  if(n==1) {
			  return new int[][] {{1}};
		  }
		  int layer = 0;
		  boolean flag = true;
		  int count = 1;
		  int countnum = 1;
		  while(flag) {
			  switch(count) {
				  case 1:
					  System.out.println("1");
				for(int i = layer ; i < n-1-layer;i++) {
					matrix[layer][i] = countnum;
					countnum++;
				}
				count++;
				break;
				  case 2:
					  System.out.println("2");
				for(int i = layer; i < n-1-layer;i++) {
					matrix[i][n-1-layer] = countnum;
					countnum++;
				}
				
				count++;
				break;
				  case 3:
					  System.out.println("3");
				for(int i = n-1-layer; i > layer; i--) {
					matrix[n-1-layer][i] = countnum;
					countnum++;
				}
				count++;
				break;
				  case 4:
					  System.out.println("4");
				for(int i = n-1-layer; i > layer; i--) {
					matrix[i][layer] = countnum;
					countnum++;
				}
				if(layer+1 == n/2) {
					flag = false;
				}else {
				layer++;
				count=1;
				}
				break;
			  }
			  
		  }
		  if(n%2 ==1) {
			  matrix[n/2][n/2] = n*n;
			 }
		  return matrix;
	  }
	  
	  public static void main(String args[]) {
		  int[][] matrix = generateMatrix(4);
		  for(int i = 0; i < matrix.length; i++) {
			  for(int j = 0 ; j < matrix.length; j++) {
			  System.out.print(matrix[i][j]);
			  }
			  System.out.println();
		  }
	  }
}
