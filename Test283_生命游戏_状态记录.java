package Leetcode;

public class Test283_生命游戏_状态记录 {
	
	/*2->活到死
	 *3->死到活
	 */  
	static int row;
	static int column;
	   public static void gameOfLife(int[][] board) {
		   row = board.length;
		   column = board[0].length;
		  
		  for(int i =0; i < row; i++) {
			  for(int j =0; j < column;j++) {
					  board[i][j] = check(i,j,board);
			  }
		  }
		  
		  for(int i =0; i < row; i++) {
			  for(int j =0; j < column;j++) {
					  board[i][j] = board[i][j] == 2 ?0:board[i][j];
					  board[i][j] = board[i][j] == 3 ?1:board[i][j];
					  System.out.print(board[i][j]);
			  }
			  System.out.println();
		  }
	    }

	private static int check(int i, int j, int[][] board) {
		int livecell =0;
		int state = board[i][j];
		
		int startrow,endrow,startcolumn,endcolumn;
		
		startrow = i==0? 0 : i-1;
		endrow = i== row-1? row: i+2;
		startcolumn = j ==0? 0:j-1;
		endcolumn = j ==column-1? column:j+2;
		for(int i1 = startrow;i1<endrow;i1++) {
			for(int j1 = startcolumn; j1<endcolumn;j1++) {
			if(board[i1][j1]==1){	
			livecell++;
			}else if(board[i1][j1] == 2) {
			livecell++;	
			}
			
		}
		}
		
		if(board[i][j] == 1)livecell--;
			
		if(board[i][j] == 0 && livecell ==3) {
			state = 3;
		}else if(board[i][j] == 1 && livecell <2) {
			state = 2;
		}else if(board[i][j] == 1 && livecell >3) {
			state = 2;
		}
		return state;
	}
	
	
	public static void main(String args[]) {
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}} ;
        gameOfLife(board);
		
	}
}
