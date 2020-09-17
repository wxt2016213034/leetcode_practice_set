package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class asdas {
	public static int[] nums;
	public static String check(String k) {
		k="4";
		checks(k);
		return k;
	}
	public static void checks(String k) {
		k =k+ "3";
		
	}
	
	  public void nextPermutation(int[] nums) {
		  int temp = nums[1];
	  		nums[1] = nums[0];
	  		nums[0] = temp;
	    }
	  
	  public void swap(int a, int b) {
		  int temp = a;
			a = b;
			b = temp;
		  }
	  
  
public static void main(String args[]) {
	List p = new ArrayList<>();
	ArrayList<Integer> h = new ArrayList<Integer>();
	h.add(1);
	h.add(2);
	h.add(3);
	System.out.println(h);
	p.add(h);
	p.add(new ArrayList<>(h));
	h.remove(2);
	System.out.println(p);
}
}
