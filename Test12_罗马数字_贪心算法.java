package Leetcode;

public class Test12_��������_̰���㷨 {
    public static String intToRoman(int num) {
    	 int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
         String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

         StringBuilder stringBuilder = new StringBuilder();
         int index = 0;
         while (index < 13) {
             // �ر�ע�⣺�����ǵȺ�
             while (num >= nums[index]) {
                 // ע�⣺�����ǵ��ںţ���ʾ����ʹ�ô��"��ֵ"
                 stringBuilder.append(romans[index]);
                 num -= nums[index];
             }
             index++;
         }
         return stringBuilder.toString();

    }
    
    
    public static void main(String args[]) {
    	System.out.print(intToRoman(1885));
    	
    	
    }
}
