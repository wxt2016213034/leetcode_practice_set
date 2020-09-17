package Leetcode;

public class Test74_ËÑË÷¶şÎ¬¾ØÕó {
	public boolean searchMatrix(int[][] matrix, int target) {
		boolean result = false;
		int row = matrix.length;
		int column = matrix[0].length;
		int mid = 0;
		int selectrow = 0;
		if(row != 1) {
		int begin = 0;
		int end = row-1;
		if(matrix[row-1][0] <= target) {
			selectrow = row-1;
		}else {
		while(begin < end) {
			mid = (begin+end)/2;
			if(matrix[mid][0] <= target && matrix[mid+1][0] > target) {
				break;
			}else if(matrix[mid][0] > target) {
				end = mid;
			}else {
				begin = mid;
			}
		}	
		}
		}
		if(selectrow == 0)
		selectrow = row == 0 ? 0 : mid;
		int begin = 0;
		int end = column-1;
		int mid2 = 0;
		while(begin <= end) {
			mid2 = (begin+end)/2;
			if(matrix[selectrow][mid2] == target)return true;
			if(matrix[selectrow][mid2]>target) {
				end = mid2-1;
			}else {
				begin = mid2 +1;
			}
			
		}
		
		return result;
    }
}
