package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test22_括号_回溯if遍历_深度广度 {
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
/*剩下的括号要么在这一组新增的括号内部，要么在这一组新增括号的外部（右侧）。

既然知道了 i<n 的情况，那我们就可以对所有情况进行遍历：

"(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
*/
	    
	    
	    public static void main(String args[]) {
	    	System.out.print(generateParenthesis(3));
	    }
}
