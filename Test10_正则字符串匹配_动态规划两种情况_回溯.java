package Leetcode;

public class Test10_�����ַ���ƥ��_��̬�滮�������_���� {
    public static boolean isMatch2(String s, String p) {
    	char[] sign = p.toCharArray();
    	int start=0;
    	int end =0;
    	int signindex =0;
    	for(;;) {
    		String temp ="";
    		boolean repeat = false;
    		for(int j=signindex;j<sign.length;j++) {
    			
    			
    			if(sign[j]!='*') {
    			temp = temp+sign[j];
    	    	System.out.println(temp);
    			}else {
    				
    				repeat = true;
    				break;
    			}
    			
    			if(j==sign.length) {
    				repeat = false;
    				break;
    			}
    			
    		}
    		
    		if(!repeat) {
    			String temp2 = "";
    			int len = temp.length();
    			end = end +len;
    			signindex = signindex + len+1;
    			temp2=s.substring(start, end);
    			if(!temp2.equals(temp)) {
    				return false;
    			}
    			if(end == s.length())return true;    
    			
    		}
    		
    		if(repeat) {
    			if(temp.equals(".")) {
    				return true;
    			}
    			String temp2 = "";
    			int len = temp.length();
    			end = end +len;
    			signindex = signindex + len+1;
    			temp2=s.substring(start, end);
    			if(!temp2.equals(temp)) {
    				end -= len;
    				continue;
    			}
    			if(end == s.length())return true;    
    			for(;;) {
    				end += len;
    				start += len;
    				if(end > s.length()) {
    					end -= len;
    					break; 
    				}
    				temp2 = s.substring(start, end);
    				if(!temp2.equals(temp)) {
    					end -= len;
    					break;
    				}
    				if(end == s.length())return true;    				
    				
    			}
    			
    		}    		
    		
    		if(signindex >=sign.length) {
    			break;
    		}
    	}
return false;
    }
    public static boolean check(String s, String p) {
    	if(p.isEmpty()) {
    		return s.isEmpty();
    	}
    	boolean flag = false;
    	if(!s.isEmpty()) {
    	
    		if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') 
    		flag =true;
    	}
    	
    	if(p.length()>=2 &&p.charAt(1) == '*') {
    		return  (flag && check(s.substring(1),p)) || check(s,p.substring(2));
    		
    		
    	}else if(flag) {
    		return check(s.substring(1),p.substring(1));
    		
    		
    	}else {
    		return false;
    	}
    	
    }
    
    public static boolean isMatch(String s, String p) {
        //�������pΪ���ַ���sҲΪ����ƥ��ɹ����������pΪ�յ���s���ǿ���˵��ƥ��ʧ��
        if (p.isEmpty())return s.isEmpty();
        //�ж�s��p�����ַ��Ƿ�ƥ�䣬ע��Ҫ���ж�s��Ϊ��
        boolean headMatched=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
        if (p.length()>=2&&p.charAt(1)=='*'){//���p�ĵ�һ��Ԫ�ص���һ��Ԫ����*
            //��ֱ��������������ж�
            return isMatch(s,p.substring(2))||
                (headMatched&&isMatch(s.substring(1),p));
        }else if (headMatched){//�������s��p�����ַ����
            return isMatch(s.substring(1),p.substring(1));
        }else {
            return false;
        }
    }
    public static boolean isMatch3(String s, String p) {
        //��Ҫ�ֱ�ȡ��s��pΪ�յ����������dp�����С+1
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        //��ʼ��dp[0][0]=true,dp[0][1]��dp[1][0]~dp[s.length][0]Ĭ��ֵΪfalse���Բ���Ҫ��ʽ��ʼ��
        dp[0][0]=true;
        //��д��һ��dp[0][2]~dp[0][p.length]
        for (int k=2;k<=p.length();k++){
            //p�ַ����ĵ�2���ַ��Ƿ����'*',��ʱjԪ����Ҫ0��������s����p���������ַ�
            dp[0][k]=p.charAt(k-1)=='*'&&dp[0][k-2];
        }
        //��дdp����ʣ�ಿ��
        for (int i=0;i<s.length();i++){
            for (int j=0;j<p.length();j++){
                //p��j���ַ��Ƿ�Ϊ*
                if (p.charAt(j)=='*'){
                    //�������:1.s����[i+1],p�Ƴ�����Ԫ��[j+1-2]��
                    // 2.�Ƚ�s��iԪ�غ�p��j-1(��Ϊ��ʱjԪ��Ϊ*)Ԫ��,������Ƴ���Ԫ��[i+1-1],p���䡣
                    dp[i+1][j+1]=dp[i+1][j-1]||
                        (dp[i][j+1]&&headMatched(s,p,i,j-1));
                }else {
                    //s��iԪ�غ�p��jԪ���Ƿ����,������Ƴ�s��iԪ��[i+1-1]��p��jԪ��[j+1-1]
                    dp[i+1][j+1]=dp[i][j]&&headMatched(s,p,i,j);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static boolean headMatched(String s,String p,int i,int j){

        return s.charAt(i)==p.charAt(j)||p.charAt(j)=='.';
    }
    
    public static boolean isMatch4(String s, String p) {
    	if(p.equals("*"))return false;
    	char[] word = s.toCharArray();
    	char[] checkword = p.toCharArray();
    	int len_s = s.length();
    	int len_p = p.length();
    	boolean[][] chart = new boolean[len_s+1][len_p+1];
    	chart[0][0] = true;
    	for(int i =1; i<len_s+1;i++) {
    		chart[i][0] =false;
    	}
    	for(int i = 0; i< len_p ;i++) {
    		if(checkword[i] == '*') {
    			chart[0][i+1]=chart[0][i-1];
    			
    		}else {
    			chart[0][i+1] = false;
    		}
    	}
    	
    	for(int i =0; i<len_s;i++) {
    		for(int j =0; j<len_p;j++) {
    			if(checkword[j] == '*') {
    				chart[i+1][j+1] = chart[i+1][j-1] || (chart[i][j+1] && headMatched(s,p,i,j-1));	
    			}else {
    				chart[i+1][j+1] = chart[i][j] && headMatched(s,p,i,j);
    			}
    		}
    	}
    	
    	
    	return chart[len_s][len_p];
    }
    
    
    public static void main(String args[]) {
    	System.out.println(isMatch4("aa","a*"));
    	System.out.println("");
    	
    }
    
}
