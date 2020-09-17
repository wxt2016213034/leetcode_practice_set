package Leetcode;

public class Test12_罗马数字_贪心算法 {
    public static String intToRoman(int num) {
    	 int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
         String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

         StringBuilder stringBuilder = new StringBuilder();
         int index = 0;
         while (index < 13) {
             // 特别注意：这里是等号
             while (num >= nums[index]) {
                 // 注意：这里是等于号，表示尽量使用大的"面值"
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
