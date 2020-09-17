package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test30_串联子串_可哈希表 {
	  public static List<Integer> findSubstring(String s, String[] words) {
		  List<Integer> tt = new ArrayList<Integer>();
		  if (s == null || s.length() == 0 || words == null || words.length == 0) return tt;
		  int len = words[0].length();
		  int index = 0;
		  int count =0;
		  boolean[] p = new boolean[words.length];
		  boolean flag = false;
		  for(int i =0; i < s.length()-len;) {
			  boolean check = false;
			  for(int j =0; j < words.length;j++) {
			  if(!flag && !p[j] && s.substring(i, i+len).equals(words[j])) {
				  p[j] =true;
				  flag =true;
				  index = i;
				  check =true;
				  count++;
				  continue;
			  }else if(flag && !p[j] && s.substring(i, i+len).equals(words[j]) ) {
				  p[j] = true;
				  check = true;
				  count++;
				  continue;
			  }
			  }
			  
			  if(flag) {
				  if(count == words.length) {
					  tt.add(index);
					  while(s.substring(index, index+len).equals(s.substring(i+len, i+len+len))) {
						  tt.add(index+len);
						  index = index +len;
						  i = i+len;
					  }
					  flag = false;
					  p = new boolean[words.length];
					  count =0;
				  }
				  if(!check) {
					  flag = false;
					  p = new boolean[words.length];
					  count =0;
				  }
			  }
			  
			  if(!flag) {
				  i = i++;
			  }else {
				  i = i+len;
			  }
			  
			  
		  }
		  return tt;
	    }
	  
	  public static void main(String args[]) {
		  String s = "barfoofoobarthefoobarman";
		  String[] words = {"bar","foo","the"};
		  
		System.out.print(findSubstring(s,words));  
	  
	  }
	  }
