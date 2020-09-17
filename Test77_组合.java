package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test77_×éºÏ {
	static List returnlist;
	static int totalnum;
	  public static List<List<Integer>> combine(int n, int k) {
		  returnlist = new ArrayList<>();
		  totalnum = n;
		  ArrayList<Integer> temp = new ArrayList<Integer>();
          if(k>1){
		  for(int i = 1; i <= n-k+1; i++) {
		  temp.add(i);
		  iteration(2,k,temp,i+1);
		  temp.remove(temp.size()-1);
		  }
          }else{
          for(int i = 1; i <= n; i++) {
		  temp.add(i);
          returnlist.add(new ArrayList(temp));
		  temp.remove(temp.size()-1);
		  }
          }
		  return returnlist;
	    }
	  
	private static void iteration(int current, int total, ArrayList temp, int num) {
		if(current==total) {
			for(int i = num; i <= totalnum; i++) {
			temp.add(i);
			returnlist.add(new ArrayList(temp));
			temp.remove(temp.size()-1);
			}
		}else {
			for(int i = num ; i <= totalnum-(total-current)+1 ;i++) {
			temp.add(i);
			iteration(current+1,total,temp,i+1);
			temp.remove(temp.size()-1);
			}
			
		}
	}
	
	public static void main(String args[]) {
		System.out.print(combine(5,3));
	}
}