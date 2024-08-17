//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int numZeroes=0;
        long product=1;
        for(int i:nums){
            if(i==0)
                numZeroes++;
            else
                product*=i;
        }
        
        int n=nums.length;
        long[] ans=new long[n];
        for(int i=0;i<n;i++){
            int p=nums[i];
            if(numZeroes>1)
                ans[i]=0;
            else if(p==0)
                ans[i]=product;
            else
                ans[i]= numZeroes==0? product/p:0;
        }
        
        return ans;
    }
}
