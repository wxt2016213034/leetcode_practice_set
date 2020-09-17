package Leetcode;

public class Test42_字符串相乘_类型转换 {
	   public static String multiply(String num1, String num2) {
		   int len1 = num1.length();
		   int len2 = num2.length();
		   String k = "0";
		   for(int i =len2-1 ; i >= 0 ;i--) {
			   String temp;
			   temp = singlemutiply(num2.charAt(i),num1);
			   for(int j = 1 ; j < len2-i;j++) {
				   temp = temp+"0";
			   }
			   k = twoadd(k,temp);
		   }
		   return k ;
	    }

	private static String twoadd(String k, String temp) {
		// TODO Auto-generated method stub
		int lenk = k.length();
		int lentemp = temp.length();
		int minlen = Math.min(lenk, lentemp);
		int carrier = 0; 
		String str;
		if(lenk > lentemp) {
			str = k;
		}else {
			str = temp;
		}
		StringBuilder strBuilder = new StringBuilder(str);
		
		for(int i = 1 ; i <= minlen;i++ ) {
			int temp1 = carrier + (int)(k.charAt(lenk-i))- (int)('0')+(int)(temp.charAt(lentemp-i))- (int)('0');
			char sum = (char) (temp1%10+'0');
			strBuilder.setCharAt(strBuilder.length()-i, sum);
			carrier = temp1/10;
		}
		String returnstring;
		if(carrier ==1) {
			for(int i = str.length()-minlen-1; i >=0; i++) {
				char sum =0;
				int temp1 = (int)strBuilder.charAt(i)- (int)('0')+carrier;
				sum = (char)(temp1%10+'0');
				strBuilder.setCharAt(i, sum);
				if(temp1 >= 10) {
					carrier =1;
				}else {
					carrier =0;
					break;
				}
			}
			if(carrier ==1) {
				returnstring = "1" +strBuilder.toString();
			}else {
				returnstring = strBuilder.toString();
			}
		}else {
			returnstring = strBuilder.toString();
		}
		
		
		return returnstring;
	}

	private static String singlemutiply(char charAt, String num1) {
		// TODO Auto-generated method stub
		if(charAt == '0') {
			return "0";
		}
		int len = num1.length();
		int mul1 = (int)charAt- (int)('0');
		int carrier =0;
		StringBuilder strBuilder = new StringBuilder(num1);
		for(int i = len-1 ; i >= 0 ; i--) {
			char sum ;
			int temp = ((int)strBuilder.charAt(i)- (int)('0'))*mul1;
			sum = (char)((carrier + temp)%10+'0');
			strBuilder.setCharAt(i, sum);
			carrier = (carrier + temp)/10;
		}
		String total;
		if(carrier >=1) {
		 total ="" + carrier + strBuilder.toString();
		}else {
		total = strBuilder.toString();
		}
		return total;
	}
	
	public static void main(String args[]) {
		String num1 = "123456789";
		String num2 = "987654321";
		System.out.println(multiply(num1,num2));
	}
}
