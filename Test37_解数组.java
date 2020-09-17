package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Test37_½âÊý×é {
	  static char[] tempp = {'1','2','3','4','5','6','7','8','9'};
	public static void solveSudoku(char[][] board) {
		System.out.print(solve(0,0,board));
    }
	
	public static boolean solve(int i, int j, char[][] board) {
		char[] candidate;
		if(i == 8 && j ==8) {
			candidate = findcandidate(i,j,board);
			if(candidate ==null) {
				return false;
			}
			if(candidate.length == 1) {
				board[i][j] = candidate[0];
				return true;
			}else {
				return false;
			}
		}
		
		while(board[i][j] != '.') {
		if(j !=8) {
			j++;
			if(i ==8 && j==8) {
				return true;
			}
		}else{
			j=0;
			i++;
		}
		}
		
		candidate = findcandidate(i,j,board);
		if(candidate ==null) {
			return false;
		}
		int tempi = i;
		int tempj = j;
		if(tempj !=8) {
			tempj++;
		}else{
			tempj=0;
			tempi++;
		}
		for(int p = 0; p < candidate.length;p++) {
			board[i][j] = candidate[p];
			if(solve(tempi,tempj,board)) {
			return true;
			}
		}
		board[i][j] ='.';
		return false;
		
	}
	
	
	
	
	  public static char[] findcandidate(int i, int j, char[][] board) {
		  HashMap<Character,Character> hash = new HashMap<Character,Character>();
		  for(int q = 0; q < 9; q++) {
			  hash.put(tempp[q], tempp[q]);
		  }
		  for(int q = 0; q < 9;q++) {
			  if(hash.containsKey(board[i][q])) {
				  hash.remove(board[i][q]);
			  }
		  }
		  for(int q = 0; q < 9;q++) {
			  if(hash.containsKey(board[q][j])) {
				  hash.remove(board[q][j]);
			  }
		  }
		  
		  int box_index = (i / 3 ) * 3 + j / 3;
		  
		  for(int r = (box_index / 3) * 3; r < (box_index /3) *3 + 3; r++) {
			  for(int t = (box_index % 3) * 3; t <(box_index % 3) * 3+3;t++) {
				  if(hash.containsKey(board[r][t])) {
					  hash.remove(board[r][t]);
				  }
			  }
		  }
		  
		  char[] returnchar = null;
		  if(hash.size()==0) {
			  return returnchar;
		  }else {
			  returnchar = new char[hash.size()];
			  int h =0;
			  for(int b = 0 ; b < 9;b++) {
				  if(hash.containsKey(tempp[b])) {
					  returnchar[h] = tempp[b];
					  h++;
				  }
			  }
		  }
		return returnchar;
	}

	
	
	public static void main(String args[]) {
		char[][] board = {
{'5','3','.','.','7','.','.','.','.'},
{'6','.','.','1','9','5','.','.','.'},
{'.','9','8','.','.','.','.','6','.'},
{'8','.','.','.','6','.','.','.','3'},
{'4','.','.','8','.','3','.','.','1'},
{'7','.','.','.','2','.','.','.','6'},
{'.','6','.','.','.','.','2','8','.'},
{'.','.','.','4','1','9','.','.','5'},
{'.','.','.','.','8','.','.','7','9'}
		};

		solveSudoku(board);
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ;j < 9 ; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}
}
