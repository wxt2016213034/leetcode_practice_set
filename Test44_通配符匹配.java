package Leetcode;

public class Test44_Í¨Åä·ûÆ¥Åä {
    public boolean isMatch(String s, String p) {
    	if(p.equals("*")) {
    		return true;
    	}else if((s.length()==0 && p.length()!=0) ||(p.length()==0 && s.length()!=0)) {
    		return false;
    	}else if(s.length() ==0 && p.length() == 0) {
    		return true;
    	}else if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '*' && p.charAt(0) != '?') {
    		return false;
    	}else if(p.charAt(0)=='*'){
    		return isMatch(s.substring(0),p.substring(1)) || isMatch(s.substring(1),p.substring(0));
    	}else {
    		return isMatch(s.substring(1),p.substring(1));
    	}
    }
    
    public static void main(String args[]) {
    	Test44_Í¨Åä·ûÆ¥Åä p = new Test44_Í¨Åä·ûÆ¥Åä();
    	System.out.print(p.isMatch("adceb", "*a*b"));
    }
}
