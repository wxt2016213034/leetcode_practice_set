package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test3_最长子串_哈希表_滑动窗口 {
	
	 public static int lengthOfLongestSubstring(String s) {
		 int length = 0;
	     HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		 for(int i =0; i<s.length();i++) {
			if(s.length() - i <= length)break;
			int tem =0;
			for(int j =i; j<s.length(); j++) {
				int key = (int)s.charAt(j);
				if(hash.containsKey(key)){
					hash.clear();
					break;
				}
				hash.put(key, j);
				tem++;
			}
			if(tem > length) {
				length =tem;
			}
			 
		 }
		 return length;
	   
	 }
	 
	 public static int getlong(String s) {
		 int length = 0;
		 int l = s.length();
		 HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		 for(int i=0, j=0; j<l;j++) {
			 char tem = s.charAt(j);
			 if(!hash.containsKey(tem)) {
			 hash.put(tem, j);
			 length = Math.max(length, j-i+1);
			 }else {			 
				 i = Math.max(hash.get(s.charAt(j))+1, i);
				 hash.put(s.charAt(j), j);
				 length = Math.max(length, j-i+1);
			 }
			 
		 }
		 return length;
	 }
	 
	    public static int BestlengthOfLongestSubstring(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }

	 
	 public static void main(String args[]) {
		 int b =getlong("abcabcbb");
		 System.out.print(b);
	 }
	 
}
