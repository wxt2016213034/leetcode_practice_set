package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test51_n»Êºó {
	
	private int[][] chess;
	private int n;
	List returnlist;
	 public List<List<String>> solveNQueens(int n) {
		 this.n = n;
		 chess = new int[n][n];
		 returnlist = new ArrayList<>();
		 iteration(0);
		 return returnlist;
	    }
	 
	private void recoverstate(int number, int layer) {
		// TODO Auto-generated method stub
		chess[layer][number]++;
		for(int i = layer+1 ; i < n ; i++) {
			chess[i][number]--;
		}
		int j = number+1;
		for(int i = layer+1; i<n;i++,j++) {
			if(j < n ) chess[i][j]--;
		}
		j = number -1;
		for(int i = layer+1; i<n;i++,j--) {
			if(j > -1 ) chess[i][j]--;
		}
	}
	private void iteration(int layer) {
		// TODO Auto-generated method stub
		if(layer==n-1 && checkvaliable(layer)) {
			for(int i = 0; i < n ; i ++) {
				if(chess[layer][i] == 0) {
					chess[layer][i] = -1;
					addtolist();
					chess[layer][i] = 0;
					break;
				}
			}
		}else if(!checkvaliable(layer)){
			return;
		}else{
			for(int i = 0 ; i < n; i++) {
			if(chess[layer][i]==0) {
				 changestate(i,layer);
				 iteration(layer+1);
				 recoverstate(i,layer);
			}
			}
		}
	}
	private void addtolist() {
		// TODO Auto-generated method stub
		ArrayList<String> templist = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
		StringBuilder temp = new StringBuilder();
			for(int j = 0 ; j < n ; j ++) {
				if(chess[i][j] == -1) {
					temp.append('Q');
				}else {
					temp.append('.');
				}
			}
		templist.add(temp.toString());
		}
		returnlist.add(new ArrayList(templist));
	}

	private boolean checkvaliable(int layer) {
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			if(chess[layer][i]==0) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}

	private void changestate(int number, int layer) {
		// TODO Auto-generated method stub
		chess[layer][number]--;
		for(int i = layer+1 ; i < n ; i++) {
			chess[i][number]++;
		}
		int j = number+1;
		for(int i = layer+1; i<n;i++,j++) {
			if(j < n ) chess[i][j]++;
		}
		j = number -1;
		for(int i = layer+1; i<n;i++,j--) {
			if(j > -1 ) chess[i][j]++;
		}
	}
	 
	 public static void main(String args[]) {
		 Test51_n»Êºó k = new Test51_n»Êºó();
		 System.out.print(k.solveNQueens(5));
	 }
	 
	 
	 
}
