package Leetcode;

public class Test28_strStr_��˫ָ��_״̬ת��ͼKMP {
	
	
	/*
	 
dp[j][c] = next
0 <= j < M������ǰ��״̬
0 <= c < 256�������������ַ���ASCII �룩
0 <= next <= M��������һ��״̬

dp[4]['A'] = 3 ��ʾ��
��ǰ��״̬ 4����������ַ� A��
pat Ӧ��ת�Ƶ�״̬ 3

dp[1]['B'] = 2 ��ʾ��
��ǰ��״̬ 1����������ַ� B��
pat Ӧ��ת�Ƶ�״̬ 2

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
