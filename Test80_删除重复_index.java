package Leetcode;

public class Test80_É¾³ıÖØ¸´_index {
	public int removeDuplicates(int[] nums) {
        int len =nums.length;
        int index = 0;
        boolean flag = false;
        for(int i = 0 ; i < len; i++){
            if(i != 0 && flag && nums[i] == nums[i-1]){
            }else if(i != 0 && !flag && nums[i] == nums[i-1]){
                nums[index] = nums[i];
                index++;
                flag = true;
            }else{
                nums[index] = nums[i];
                index++;
                flag = false;
            }
        }

        return index++;
    }
}
