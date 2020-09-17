package Leetcode;

public class Test5_最长回文_动态规划_中心扩散 {
    public static String longestPalindrome(String s) {

    int len = s.length();
    char[] word = s.toCharArray();
    boolean[][] ToF = new boolean[len][len];
    for(int i =0;i<len;i++) {
    	ToF[i][i] = true;
    }//initialize
    
    for(int i=len-2; i>=0; i--) {
    	for(int j=len-1; j>i;j-- ) {
    		
    	if(j-i<=3 && word[i] == word[j]) {
    		ToF[i][j]=true;
    		System.out.println(i+""+j);
    		continue;
    	}
    	
    	
    	if(ToF[i+1][j-1] == true && word[i] == word[j]) {
    		ToF[i][j]=true;
    		System.out.println(i+""+j);
    	}
    	}
    	
    }
    	
    
    
    	return "a";
    }
    public String midexpend(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String args[]) {
    	String k = "1234554321444";
    	longestPalindrome(k);
    }
}
