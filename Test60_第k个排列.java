package Leetcode;

import java.util.ArrayList;

public class Test60_µÚk¸öÅÅÁĞ {
	 public static String getPermutation(int n, int k) {
		 ArrayList<String> list = new ArrayList<String>();
		 for(int i = 1; i <= n; i++) {
			 list.add(""+i);
		 }
		 StringBuilder tempstring = new StringBuilder();
		 
		 while(true) {
			 int calnum = cal(n-1);
			 int divided = k/calnum;
			 int leave = k%calnum;
			 if(leave != 0) {
				 divided++;
				 tempstring.append(list.get(divided-1));
				 list.remove(list.get(divided-1));
			 }else {
				 tempstring.append(list.get(divided-1));
				 list.remove(list.get(divided-1));
				 for(int i = list.size()-1 ; i >=0 ;i--) {
					 tempstring.append(list.get(i));
				 }
				 break;
			 }
			 n--;
			 k = leave;
			 
		 }
		 return tempstring.toString();
	    }
	 
	 private static int cal(int num) {
		 int sum =1;
		 for(int i = 1; i <=num; i++) {
			 sum = sum*i;
		 }
		 return sum;
	 }
	 
	 public static void main(String args[]) {
		 System.out.println(getPermutation(3,3));
	 }
}
