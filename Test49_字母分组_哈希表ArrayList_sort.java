package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test49_×ÖÄ¸·Ö×é_¹şÏ£±íArrayList_sort {
	  public List<List<String>> groupAnagrams(String[] strs) {
		  int len = strs.length;
		  HashMap<String,List> hash = new HashMap<String,List>();
		  
		  for(int i = 0; i< len; i++) {
			  char[] temp = strs[i].toCharArray();
			  Arrays.sort(temp);
			  String tempstring = String.valueOf(temp);
		  if(hash.containsKey(tempstring)) {
			  hash.get(tempstring).add(strs[i]);
		  }else {
			  hash.put(tempstring,new ArrayList());
			  hash.get(tempstring).add(strs[i]);
		  }
		  }
		  
		  return new ArrayList(hash.values());
	    }
}
