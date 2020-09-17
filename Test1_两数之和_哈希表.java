package Leetcode;
import java.util.HashMap;
import java.util.Map;
public class Test1_两数之和_哈希表 {

	@SuppressWarnings("null")
	public static int[] twoSum(int[] nums, int target ) {
		int[] returnValue = new int[2];
		for(int i = 0; i < nums.length-1;i++){
			for(int j = 0; j < nums.length-i-1; j++) {
				if(nums[i] + nums[j+i+1] == target) {
				returnValue[0] =i;
				returnValue[1] =j+i+1;
				break;
				}
			}
		}
		return returnValue;
		
	}
	
	public static int[] OncehashtwoSum(int[] nums, int target) {
		int[] returnValue = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                returnValue[0] = i;
                returnValue[1] = hash.get(nums[i]);
                return returnValue;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
		return returnValue;
	}
	
	public int[] twicehashtwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

	public static void main(String args[]) {
		int nums[] = {3123,123132,31233312,7,2,8,9};
		int value[] = new int[2];
		value = twoSum(nums,9);
		System.out.print(value[0]+""+value[1]);
	}
	
}
