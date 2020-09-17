package Leetcode;

public class Test4_找中位数_trick {
    public static double findMedian(int[] nums1, int[] nums2) {
    	double k = 0;
    	int m = nums1.length-1;
    	int n = nums2.length-1;
    	int i =0;
    	int j =(m+n)/2-i;
    	for(;;) {
    		if(nums1[i+1]>nums2[j-1] && nums2[j]>nums1[i]) {
    			k = (double)(Math.max(nums1[i], nums2[j-1])+Math.min(nums1[i+1], nums2[j]))/2;
    			break;
    		}else if(nums1[i+1]<nums2[j-1]) {
    			i++;
    			j--;
    		}else if(nums2[j]<nums1[i]) {
    			i--;
    			j++;
    		}
    	}
    	return k;
    }
    
    
    public static double findmedian(int[] nums1, int[] nums2) {
    	int len_1 = nums1.length;
    	int len_2 = nums2.length;
    	int[] n1;
    	int[] n2;
    	int i;
    	int j;
    	int m;
    	int n;
    	
    	if(len_1 >= len_2) {
    		n1 = nums1;// n1 = larger one
    		n2 = nums2;// n2 = short one
    		m= len_1;// n1 --m
    		n= len_2;// n2 --n
    	}else {
    		n1 = nums2; // n1 = larger one
    		n2 = nums1; // n2 = short one
    		m= len_2; // n1 --m
    		n= len_1; // n2 --n
    	}
    	
    	if(n==1&& m==1&n1[0]==n2[0]) {
    		return n1[0];
    		
    	}
    	if(n==0 && m ==1) {
    		return  n1[m-1];
    	}
    	
    	if(n==0 && m%2 ==0) {
    		return (double)(n1[(m-1)/2]+n1[(m+1)/2])/2;
    	}else if(n==0 && m%2 ==1) {
    		return n1[(m+1)/2-1];
    	}
    	
    	
    	if(m==n && n1[0] > n2[n-1]) {
    		return (double)(n1[0]+n2[n-1])/2; 
    	}else if(m==n & n1[n-1] < n2[0])
    	{
    		return (double)(n1[n-1]+n2[0])/2;
    	}else if(n==1 && n2[0]<(double)(n1[m/2]+n1[m/2-1])/2 && m%2 ==0) {
    		return Math.max(n1[m/2-1],n2[0]);
    	}else if(n==1 && n2[0]<n1[(m+1)/2-1] && m%2 ==1) {
    		return (double)(Math.max(n1[(m-1)/2-1],n2[0])+n1[(m-1)/2])/2;
    	}else if(n==1 && n2[0]>(double)(n1[m/2]+n1[m/2-1])/2 && m%2 ==0){
    		return Math.min(n1[m/2],n2[0]);
    	}else if(n==1 && n2[0]>n1[(m+1)/2-1] && m%2 ==1){
    		return (double)(n1[(m-1)/2]+Math.min(n1[(m-1)/2+1],n2[0]))/2;
    	}
    	
    	
    	if((m + n) %2 ==1 && n%2 == 0) {
    		i=n/2;
    		j=(m+n -1)/2 -i;
    	}else if((m + n) %2 ==1 && n%2 ==1){
    		i=(n-1)/2;
    		j=(m+n)/2-i;
    	}else {
    		i=n/2;
    		j=(m+n)/2-i;
    	}
    	
    	for(;;) {
    		System.out.println(i);
    		System.out.println(j);	
    		if(i == 0 ) {
       			if((m+n)%2==1) {
    				return Math.min(n1[j], n2[i]);
    			}else {
    				return (double)(n1[j-1]+Math.min(n2[i], n1[j]))/2;
    			}
    		}
    		
    		if(i == n ) {
       			if((m+n)%2==1) {
    				return  n1[j];
    			}else {
    				return (double)(Math.max(n2[i-1], n1[j-1])+n1[j])/2;
    			}
    		}
    		
    		if(n2[i]>=n1[j-1] && n1[j]>=n2[i-1]) {
    			if((m+n)%2==1) {
    				return Math.min(n1[j], n2[i]);
    			}else {
    	    		System.out.println("return from here");
    				return (double)(Math.max(n1[j-1], n2[i-1])+Math.min(n1[j], n2[i]))/2;
    			}
    		}
    		
    		if(n2[i]<n1[j-1]) {
    			i++;
    			j--;
    		}
    		
    		if(n1[j]<n2[i-1]) {
    			i--;
    			j++;
    		}
    		
    	}
    }
    
    
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            System.out.print(i);
            System.out.print(j);
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft;
                if (i == 0) {//A分成的leftA(空集) 和 rightA(A的全部)  所以leftPart = leftA(空集) + leftB,故maxLeft = B[j-1]。
                    maxLeft = B[j - 1];
                } else if (j == 0) { //B分成的leftB(空集) 和 rightB(B的全部)  所以leftPart = leftA + leftB(空集),故maxLeft = A[i-1]。
                    maxLeft = A[i - 1];
                } else { //排除上述两种特殊情况，正常比较
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) { //奇数，中位数正好是maxLeft
                    return maxLeft;
                }
                //偶数
                int minRight;
                if (i == m) {//A分成的leftA(A的全部) 和 rightA(空集)  所以rightPart = rightA(空集) + rightB,故minRight = B[j]。
                    minRight = B[j];
                } else if (j == n) {//B分成的leftB(B的全部) 和 rightB(空集)  所以rightPart = rightA + rightB(空集),故minRight = A[i]。
                    minRight = A[i];
                } else {//排除上述两种特殊情况，正常比较
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    public static void main(String args[]) {
    	int[] n1 = {1};
    	int[] n2 =  {2,3,4};
    	//double k = findMedian(n1,n2);
    	double p = findMedianSortedArrays(n1,n2);
    	//System.out.println(k);
    	System.out.print(p);
    }
}
