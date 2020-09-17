package Leetcode;

import java.util.HashMap;
import java.util.Stack;



public class Test20_ÓÐÐ§À¨ºÅ_Õ»hash {
	
	
	public static HashMap<Character, Character> mappings;

    public static boolean isValid(String s) {
    	mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    	
    	Stack<Character> p = new Stack<Character>();
    	char[] word = s.toCharArray();
    	
    	for(int i = 0; i <word.length;i++) {
    		if(word[i] == '(' || word[i] == '[' ||word[i] == '{' )
    		{
    			p.push(word[i]);
    		}else {
    			if(p.isEmpty() || p.pop() != mappings.get(word[i])) return false;
    			
    		}
    	}
    	if(p.isEmpty())
    	return true;
    	
    	return false;
    	
    }
    
    public static void main(String args[]) {
    	System.out.println(isValid("}"));
    	
    	
    }
}
