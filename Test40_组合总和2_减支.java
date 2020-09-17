package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test40_组合总和2_减支 {
	List<List<Integer>> List;
	int[] candidate;
	int target;
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List = new ArrayList<>();
		 if (candidates == null || candidates.length == 0 || target < 0) {
	            return List;
	        }
		this.candidate = candidates;
		this.target = target;
		
		for(int i = 0 ; i < candidate.length;i++) {
			if(i !=0 && candidates[i] == candidates[i-1])continue;
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(candidate[i]);
		iteration(temp,i,candidate[i]);
		}
		
		return List;
	    }
	 
	 public void iteration(List<Integer> temp, int index, int currentsum) {
		 if(currentsum == target) {
			 List.add(new ArrayList<>(temp));
			 return;
		 }else if(currentsum> target) {
			 return;
		 }else{
				 for(int i = index+1 ;i < candidate.length;i++) {
				 if(i > index +1 && candidate[i] == candidate[i-1])continue;
				 temp.add(candidate[i]);
				 iteration(temp,i,currentsum+candidate[i]);
				 temp.remove(temp.size() - 1);
				 }
			 
		 }
	 }
	 public static void main(String args[]) {
		 int[] nums = {10,1,2,7,6,1,5};
		 Test40_组合总和2_减支 p = new Test40_组合总和2_减支();
	   	 List<List<Integer>> List1 = p.combinationSum2(nums,8);
		 System.out.print(List1.size());
		 for(int i = 0 ; i < List1.size(); i++) {
			 System.out.print(List1.get(i));
		 }
	 }
}
