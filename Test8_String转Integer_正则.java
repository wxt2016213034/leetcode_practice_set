package Leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test8_StringתInteger_���� {
    public static int myAtoi(String str) {
    	char[] word = str.toCharArray();
    	int start =0;
    	int end = 0;
    	int flag1 =0;
    	int flag =0;
    	int flagint =0;
    	for(int i =0;i<word.length;i++) {

    		 if(word[i]=='-' && i == word.length-1){
                break;
            }
    		if(word[i]=='-' && flag1==0 && Character.isDigit(word[i+1])) {
    			flag1=1;
    			continue;
    		}
            
            if(word[i]=='+' && i == word.length-1){
                break;
            }
            
            if(word[i]=='+' && Character.isDigit(word[i+1])){
    			continue;
    		}
    		
    		if(!Character.isDigit(word[i]) && word[i] !=' ') {
    			flag =1;
    			break;
    			
    		}
    		
    		if(Character.isDigit(word[i]) ) {
    			int count =0;
    			int count2 =0;
    			flagint =1;
    			start =i;
    			int flag7 =0;
    			for(int j =i;j<word.length;j++) {
    				
    				/*if(word[j] == '0' && flag7 ==0) {
    					count2++;
    					continue;
    				}*/
    				
    				if(word[j] !='0' ) {
    					flag7=1;
    				}
    				
    				if(Character.isDigit(word[j])) {
    					count++;
                        if(count > 10 && flag1==1){
                        return -2147483648;
                        }else if(count > 10 && flag1==0){
                        return 2147483647;
                        }
                        
    				}else {
    					break;
    				}
    			}
    			start = start + count2;
    			end = start+count;
    			if(count ==0) {
    				return 0;
    			}
    			break;
    		}
    	}
    	if(flag ==1) {
    		return 0;
    	}
    	long returnword =0;
    	
    	if(flagint ==1) {
    		String k = str.substring(start, end);
    		returnword = Long.parseLong(k);
    		if(flag1 ==1)
    			returnword = returnword*(-1);
    		
    		
    	}
    	
       if(returnword <-2147483648) { 
    	   returnword = -2147483648;
       }else if( returnword > 2147483647) {
    	   returnword = 2147483647;
       }
       
    	
    	return (int) returnword;
    }
    
    public int zhengzemyAtoi(String str) {
        //����ַ�����ͷ��ĩβ�ո�����trim�������ܣ���ʵ������ֻ����տ�ͷ�ո�
        str = str.trim();
        //java������ʽ
        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(str);
        int value = 0;
        //�ж��Ƿ���ƥ��
        if (m.find()){
            //�ַ���ת���������
            try {
                value = Integer.parseInt(str.substring(m.start(), m.end()));
            } catch (Exception e){
                //�����е��ַ���"42"û�����ţ����������ж�'-'
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
        }
        return value;
    }
    
    public static void main(String args[]) {
    	System.out.print(myAtoi(" 0001"));
    	
    }
}
