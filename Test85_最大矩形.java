package Leetcode;

public class Test85_最大矩形 {
	//1,Test84延申，依次算行和列
	//2,动态规划,算左右高
	
	public int maximalRectangle(char[][] matrix) {
		int maxarea = 0;
		int row = matrix.length;
		int column = matrix[0].length;
		
		int[] left = new int[column];
		int[] right = new int[column];
		int[] height = new int[column];
		
		for(int i = 0 ; i < row; i++) {
			for(int j = 0 ; j < column; j++) {
				if(matrix[i][j]=='1') {
				int templeft = j;
				while(templeft > -1 && matrix[i][templeft] != '0') {
					templeft--;
				}
				left[j] = Math.max( templeft+1, left[j]);
				
				int tempright = j;
				while(tempright < column && matrix[i][tempright] != '0') {
					tempright++;
				}
				right[j] = Math.min(tempright-1, right[j]);
				
				height[j] = height[j]+1;
				}else {
					left[j] = -1;
					right[j] = column;
					height[j] = 0;
				}
				
				
				maxarea= maxarea > (right[j]-left[j] +1)*height[j]? maxarea: (right[j]-left[j] +1)*height[j];
				System.out.println(maxarea);
				
			}
		}
		
		return maxarea;
    }
}
