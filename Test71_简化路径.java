package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test71_¼ò»¯Â·¾¶ {
	  public static String simplifyPath(String path) {
	        Stack<String> p = new Stack<String>();
	        for(int i = 0; i < path.length();) {
	        	if(i!= path.length()-1&& path.charAt(i)=='/'&& path.charAt(i+1) != '/') {
	        	i++;
	        	int begin = i;
	        	int end = i;
	        	while(i != path.length() && path.charAt(i)!='/') {
	        		i++;
	        		end = i;
	        	}
	        	String tempstring = path.substring(begin, end);
	        	if(!tempstring.equals(".") && !tempstring.equals("..")) {
	        		p.push(tempstring);
	        	}else if(tempstring.equals("..")) {
	        		if(p.size()!=0) {
	        			p.pop();
	        		}
	        	}
	        	}else {
	        		i++;
	        	}
	        }
	        int len = p.size();
	        String[] l = new String[len];
	        for(int i = len-1; i >= 0 ; i--) {
	        	l[i] = p.pop();
	        }
	        StringBuilder tt = new StringBuilder();
	        if(len == 0) {
	        	tt.append("/");
	        }else {
	        	for(int i = 0; i < len; i++) {
	        	tt.append("/"+l[i]);
	        	}
	        }
	   return tt.toString();
	    }
	  public static void main(String args[]) {
		  System.out.print(simplifyPath("/home//foo/"));
	  }
	  
}
