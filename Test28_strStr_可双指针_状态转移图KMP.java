package Leetcode;

public class Test28_strStr_可双指针_状态转移图KMP {
	
	
	/*
	 
dp[j][c] = next
0 <= j < M，代表当前的状态
0 <= c < 256，代表遇到的字符（ASCII 码）
0 <= next <= M，代表下一个状态

dp[4]['A'] = 3 表示：
当前是状态 4，如果遇到字符 A，
pat 应该转移到状态 3

dp[1]['B'] = 2 表示：
当前是状态 1，如果遇到字符 B，
pat 应该转移到状态 2

	 */
    public int strStr(String haystack, String needle) {
    	int len = needle.length();
    	if(len == 0) {
    		return 0;
    	}
    	char key = needle.charAt(0);
    	int flag = 0;
    	int index = 0;
    	for(int i = 0; i < haystack.length();i++) {
    		if(haystack.charAt(i)==key&&haystack.length()-i>=len) {
    			if(haystack.substring(i, i+len).equals(needle)) {
    				flag =1;
    				index = i;
    				break;
    			}
    		}
    		
    	}
    	
    	if(flag ==1) {
    		return index;
    	}else {
    		return -1;
    	}
    }
}
