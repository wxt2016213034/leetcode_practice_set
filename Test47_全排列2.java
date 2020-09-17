package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test47_全排列2 {
	List<List<Integer>> list;
	  public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
		  list = new ArrayList<>();
		  int[] check = new int[nums.length];
		  ArrayList<Integer> templist = new ArrayList<Integer>();
		  iteration(check,templist,nums);
	  return list;
	  }
	private void iteration(int[] check, ArrayList<Integer> templist, int[] nums) {
		// TODO Auto-generated method stub
		if(templist.size() == nums.length) {
			list.add(new ArrayList<>(templist));
			System.out.println(templist);
			return;
		}
		for(int i = 0; i < check.length; i++) {
			
			   if(i>0 && nums[i] == nums[i-1] && check[i-1] == 1) continue;
			 //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了
				if(check[i] == 0 ) {
			  templist.add(nums[i]);
			  check[i] = 1;
			  iteration(check,templist,nums);
			  check[i] = 0;
			  templist.remove(templist.size()-1);
				}
			
		}
		
	}
	public static void main(String args[]) {
		Test47_全排列2 p = new Test47_全排列2();
		int[] nums = {1,1,2};
		List temp2 = p.permuteUnique(nums);
		System.out.print(temp2);

	}
}
