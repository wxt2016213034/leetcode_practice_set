package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test17_电话号码_无法确定循环次数_回溯{
	static Map<Integer, String> phone;
	static List<String> re;
    public static List<String> letterCombinations(String digits) {
    phone = new HashMap<Integer, String>() {{
		    put(2, "abc");
		    put(3, "def");
		    put(4, "ghi");
		    put(5, "jkl");
		    put(6, "mno");
		    put(7, "pqrs");
		    put(8, "tuv");
		    put(9, "wxyz");
		  }};
      re = new ArrayList<String>();
	
    	 if (digits.length() != 0) {
    	  for(int i =0;i < phone.get(Integer.parseInt(digits.charAt(0)+"")).length();i++)
    		 backtrack("",0,i,digits);
    	 }
    	return re;
    }
    
    public static void backtrack(String curString,int layer,int index, String digits) {
		if(layer == digits.length()-1) {
			curString = curString + phone.get(Integer.parseInt(digits.charAt(layer)+"")).charAt(index);
			re.add(curString);
			return;
		}
		
		curString = curString + phone.get(Integer.parseInt(digits.charAt(layer)+"")).charAt(index);
		
    	for(int i = 0; i < phone.get(Integer.parseInt(digits.charAt(layer+1)+"")).length();i++) {
    		backtrack(curString,layer+1,i,digits);
    		
    	}
		
	
    }
    public static void main(String args[]) {
    	System.out.print(letterCombinations("2345"));
    	
    }
}
