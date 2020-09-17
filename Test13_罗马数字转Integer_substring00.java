package Leetcode;

public class Test13_ÂÞÂíÊý×Ö×ªInteger_substring00 {
    public static int romanToInt(String s) {
   	 int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
     String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
     int i=0;
     int point = 0;
     int number =0;
     int len = s.length();
     s += "00";
     while(i<13) {
    	 if(s.substring(point, point+1).equals(romans[i])) {
    		 for(;;) {
    			 
    			 if(s.substring(point, point+1).equals(romans[i])) {
    				 number += nums[i];	
    				 point++;
    				 
    			 }else {
    				 break;
    			 }
    			 
    		 }
    		 continue;
    	 }
     	 if(s.substring(point, point+2).equals(romans[i])) {
     		 number += nums[i];	
			 point++;
			 point++;
     		 
     		 
     	 }
    	 i++;
    	 
    	 if(point>=s.length()) {
    		 break;
    	 }
     }

     return number;
    }
    
    
    public static void main(String args[]) {
    	System.out.print(romanToInt("III"));
    	
    }
}
