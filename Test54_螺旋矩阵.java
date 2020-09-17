package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test54_ÂÝÐý¾ØÕó {
	public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> returnlist = new ArrayList<Integer>();
    	int row = matrix.length;
    	if(row == 0) {
    		return returnlist;
    	}
    	int column = matrix[0].length;
    	boolean flag = true;
    	int layer = 0;
    	int caseN = 1;
    	while(flag) {
    		switch(caseN) {
    			case 1:
    				if(layer < (row+1)/2) {
    					for(int i = layer; i < column-layer;i++) {
    						returnlist.add(matrix[layer][i]);
    					}
    				}else {
    					flag = false;
    				}
    			caseN++;
    			break;
    			
    			case 2:
    				if((layer+1)*2 <= row ) {
    	    			for(int i = layer+1; i < row-layer-1;i++) {
    	    				returnlist.add(matrix[i][column-1-layer]);
    	    			}
    	    			}else {
    	    				flag = false;
    	    		}
    			caseN++;
    			break;
    			case 3:
    				if(column-layer-1 == layer) {
    					flag = false;
    					returnlist.add(matrix[row-layer-1][column-layer-1 ]);
    					break;
    				}
    	    			for(int i = column-layer-1; i >= layer ;i--) {
    	    				returnlist.add(matrix[row-1-layer][i]);
    	    			}
    	    		
    			caseN++;
    			break;
    			case 4:
    				
    	    			for(int i = row-layer-2; i > layer ;i--) {
    	    				returnlist.add(matrix[i][layer]);
    	    			}
    	    	if((layer+1)*2 == column) {
    	    		flag = false;
    	    	}
    	    	layer++;
    			caseN=1;
    			break;
    		}
    	}
    	
    	return returnlist;
    }
	
	public static void main(String args[]) {
		int[][] matrix = {{1,2},{3,4},{5,6},{7,8},{9,10}};
		System.out.print(spiralOrder(matrix));
	}
}
