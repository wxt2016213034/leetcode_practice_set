package Leetcode;

public class Test73_æÿ’Û÷√¡„ {
    public void setZeroes(int[][] matrix) {
    	int row = matrix.length;
    	int column = matrix[0].length;
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < column; j++) {
    			if(matrix[i][j] == 0) {
    				for(int t = 0 ; t <row; t++) {
    					matrix[t][j] = -100000;
    				}
    				for(int t = 0 ; t <column; t++) {
    					matrix[i][t] = -100000;
    				}
    				
    			}
    			
    		}
    	}
    	
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < column ; j++) {
    			if(matrix[i][j] == -100000) {
    				matrix[i][j] =0;
    			}
    		}
    	}
    	
    }
}
