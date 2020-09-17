package Leetcode;

public class Test31_È«ÅÅÁĞÂß¼­ {
	

	  public static void nextPermutation(int[] nums) {
		  int len = nums.length;
		  if(len <= 1){
	            return;
	        }
		  	int temp;
		  	
		  	if(len ==2 && nums[0] > nums[1]) {
		  		temp = nums[len-1];
		  		nums[len-1] = nums[len-2];
		  		nums[len-2] = temp;
		  	}else if(len ==2 && nums[0] == nums[1]) {
		  		return;
		  	}
		  	
		  	
		  	
		  	if(nums[len-1]>nums[len-2]) {
		  		temp = nums[len-1];
		  		nums[len-1] = nums[len-2];
		  		nums[len-2] = temp;
		  	}else if(nums[len-3]<nums[len-1] ) {
		  			temp = nums[len-1];
			  		nums[len-1] = nums[len-3];
			  		nums[len-3] = temp;
			  		temp = nums[len-1];
			  		nums[len-1] = nums[len-2];
			  		nums[len-2] = temp;
		  	}else if(nums[len-3]<nums[len-2] ) {
	  			temp = nums[len-1];
		  		nums[len-1] = nums[len-3];
		  		nums[len-3] = temp;
		  		temp = nums[len-3];
		  		nums[len-3] = nums[len-2];
		  		nums[len-2] = temp;
	  	    }else {
		  		if(len ==3) {
		  			temp = nums[0];
			  		nums[0] = nums[2];
			  		nums[2] = temp;
		  		}else {
		  			boolean flag = false;
		  			int index1 = 0;
		  			
		  			for(int i= len-4; i >= 0;i--) {
		  				for(int j = i+1 ; j < len; j++) {
		  					if( (nums[i] < nums[j] && j == len-1) || (nums[i] < nums[j] && nums[i] >= nums[j+1])) {
		  						index1 = i;
		  						temp = nums[i];
						  		nums[i] = nums[j];
						  		nums[j] = temp;
		  						flag =true;
		  						break;
		  					}
		  				}
		  				if(flag) {
		  					break;
		  				}
		  			}
		  			
		  			if(flag) {
		  				for(int i = 1; i <= (len-index1-1)/2; i++) {
		  					temp = nums[len-i];
					  		nums[len-i] = nums[index1+i];
					  		nums[index1+i] = temp;
		  				}
		  			}else {
		  				for(int i = 1; i <= len/2; i++) {
		  					temp = nums[len-i];
					  		nums[len-i] = nums[i-1];
					  		nums[i-1] = temp;
		  				}
		  			}
		  			
		  		}
		  	}
	    }
	  
	  public static void main(String args[]) {
		  int[] nums = {5,4,7,5,3,2};
		  nextPermutation(nums);
		  for(int i =0; i < nums.length;i++) {
			  System.out.print(nums[i]);
			  
		  }
	  }
	
	  
}
