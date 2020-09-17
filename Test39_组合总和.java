package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test39_组合总和 {
	List<List<Integer>> List;
	int[] candidate;
	int target;
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List = new ArrayList<>();
		 if (candidates == null || candidates.length == 0 || target < 0) {
	            return List;
	        }
		this.candidate = candidates;
		this.target = target;
		
		for(int i = 0 ; i < candidate.length;i++) {
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
				 for(int i = index ;i < candidate.length;i++) {
				 temp.add(candidate[i]);
				 iteration(temp,i,currentsum+candidate[i]);
				 temp.remove(temp.size() - 1);
				 }
			 
		 }
	 }
	 
	 public static void main(String args[]) {
		 int[] nums = {2,3,5};
		 Test39_组合总和 p = new Test39_组合总和();
	   	 List<List<Integer>> List1 = p.combinationSum(nums,8);
		 System.out.print(List1.size());
		 for(int i = 0 ; i < List1.size(); i++) {
			 System.out.print(List1.get(i));
		 }
	 }
}
