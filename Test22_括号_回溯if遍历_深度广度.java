package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test22_����_����if����_��ȹ�� {
	  public static List<String> generateParenthesis(int n) {
	        List<String> ans = new ArrayList();
	        backtrack(ans, "", 0, 0, n);
	        return ans;
	    }

	    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
	        if (cur.length() == max * 2) {
	            ans.add(cur);
	            return;
	        }

	        if (open < max)
	            backtrack(ans, cur+"(", open+1, close, max);
	        if (close < open)
	            backtrack(ans, cur+")", open, close+1, max);
	    }
	    public List<String> NB_generateParenthesis(int n) {
	        List<String> ans = new ArrayList();
	        if (n == 0) {
	            ans.add("");
	        } else {
	            for (int c = 0; c < n; ++c)
	                for (String left: generateParenthesis(c))
	                    for (String right: generateParenthesis(n-1-c))
	                        ans.add("(" + left + ")" + right);
	        }
	        return ans;
	    }
/*ʣ�µ�����Ҫô����һ�������������ڲ���Ҫô����һ���������ŵ��ⲿ���Ҳࣩ��

��Ȼ֪���� i<n ������������ǾͿ��Զ�����������б�����

"(" + ��i=pʱ�������ŵ�������ϡ� + ")" + ��i=qʱ�������ŵ�������ϡ�
*/
	    
	    
	    public static void main(String args[]) {
	    	System.out.print(generateParenthesis(3));
	    }
}
