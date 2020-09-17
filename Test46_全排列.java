package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test46_ȫ���� {
	List<List<Integer>> list;
	  public List<List<Integer>> permute(int[] nums) {
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

				if(check[i] == 0) {
			  templist.add(nums[i]);
			  check[i] = 1;
			  iteration(check,templist,nums);
			  check[i] = 0;
			  templist.remove(templist.size()-1);
				}
			
		}
		
	}
	
	public static void main(String args[]) {
		Test46_ȫ���� p = new Test46_ȫ����();
		int[] nums = {1,2,3};
		List temp2 = p.permute(nums);
		System.out.print(temp2);

	}
	  
}
