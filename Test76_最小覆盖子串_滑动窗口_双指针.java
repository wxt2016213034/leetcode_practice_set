package Leetcode;

import java.util.HashMap;

public class Test76_最小覆盖子串_滑动窗口_双指针 {
	   public static String minWindow(String s, String t) {
		   int len_raw = s.length();
		   int len_target = t.length();
		   char[] word_raw = s.toCharArray();
		   char[] word_target = t.toCharArray();
		   int begin=0,end = 0;
		   int beginmin = 0, endmin = 0;
		   int len_min = 100000;
		   int count = 0;
		   boolean flag = false;
		   HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		   for(int i = 0 ; i < t.length(); i++) {
			   if(!hash.containsKey(word_target[i])){
			   hash.put(word_target[i], 1);
			   }else {
			   int tempint = hash.get(word_target[i])+1;
			   hash.put(word_target[i], tempint);
			   }
		   }
		   
		   for(int i = 0 ; i < s.length(); i++) {
			   if(hash.containsKey(word_raw[i])) {
				   int times = hash.get(word_raw[i]);
				   if(times>0) {
				   hash.put(word_raw[i], times-1);
				   count++;
				   if(count==len_target) {
					 end = i;  
					 while(count == len_target) {
						 if(end-begin < len_min) {
							 flag = true;
							 beginmin = begin;
							 endmin = end;
							 len_min = end - begin;
						 }
						 if(hash.containsKey(word_raw[begin])) {
							 int temp_times = hash.get(word_raw[begin]);
							 if(temp_times < 0) {
								 hash.put(word_raw[begin],temp_times+1);
							 }else {
								 hash.put(word_raw[begin], temp_times+1);
								 count--;
							 }
						 }
						 begin++;
					 }
				   }
				   }else {
				   hash.put(word_raw[i], times-1);
				   }
			   }
			   
		   }
		 if(flag) {
		   return s.substring(beginmin, endmin+1);
		 }else {
			 return "";
		 }
	   }
	   
	   public static void main(String args[]) {
		   System.out.print(minWindow("ADOBECODEBANC","ABC"));
	   }
	   
}
