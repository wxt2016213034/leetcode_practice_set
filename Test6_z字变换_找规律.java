package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test6_z×Ö±ä»»_ÕÒ¹æÂÉ {
    public static String convert(String s, int numRows) {
    	if (numRows < 2)
    		return s;
    	int len = s.length();
    	int lines= 0;
    	char[] word = s.toCharArray();
    	
    	if(len%(2*numRows-2) <= numRows && len%(2*numRows-2) > 0) {
    		lines = (len/(2*numRows-2))*(1+numRows-2)+1;
    		 System.out.println("1");
    	}else if (len%(2*numRows-2) ==0){
    		lines = (len/(2*numRows-2))*(1+numRows-2);
    		 System.out.println("2");
    	}else {
    		lines = (len/(2*numRows-2))*(1+numRows-2) + 1+len%(2*numRows-2)-numRows;
    		 System.out.println("3");
    		 System.out.println(lines);
    	}
    	
    	char[][] k = new char[numRows][lines];
    	int l =0;
    	for(int i=0;i<lines;i++) {
    		
    		if(i%(numRows-1) == 0) {
    			
    		for(int j = 0; j<numRows;j++) {
    			if(l>=len) {
    				break;
    			}
    			k[j][i] = word[l];
    			l++;
    		}
    		
    		}else {
    			
    			k[numRows-(i%(numRows-1))-1][i]=word[l];
    			
    			l++;
    		}
    		
    	}
    	

    	String returnstring ="";
    	for(int i=0;i<numRows;i++) {
    		for(int j=0;j<lines;j++) {
    		  if(k[i][j] != '\0') {
    				returnstring = returnstring + k[i][j];
    			}
    		  System.out.print(k[i][j]);
    		}
    		  System.out.println("");
    	}
    	
    	return returnstring;
    }
    
    
    public static String getzconvert(String s,int n) {
    	if (n < 2)
    		return s;
    	List<StringBuilder> k = new ArrayList<>();
    	char[] word = s.toCharArray();
    	int len = s.length();
    	
    	for(int i=0;i<n;i++) {
    		k.add(new StringBuilder());
    	}
    	
    	for(int i = 0; i<len;i++) {
    		if((i+1)%(n*2-2) > 0 && (i+1)%(n*2-2)<=n) {
    			k.get((i+1)%(n*2-2)-1).append(word[i]);
    		}else {
    			k.get(n-(i%(n-1))-1).append(word[i]);
    			
    		}
    		
    	}
    	
    	String returnString ="";
    	
    	for(int i =0;i<k.size();i++) {
    		returnString = returnString + k.get(i);
    		System.out.println(k.get(i));
    	}
    	
    	
    	return returnString;
    }
    
    public static void main(String args[]) {
    	String s ="LEETCODEISHIRING";
    	int numRows =4 ;
    	System.out.print(getzconvert(s, numRows));
    }
    
}
