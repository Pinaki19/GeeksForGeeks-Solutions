//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int len1=arr1.length;
        int len2=arr2.length;
        
        int total=len1+len2;
        int mid=total/2;
        int ans=0;
        boolean takePrev= (total&1)==0;
        
        int i=0,j=0;
        int k=0;
        
        for(;i<len1 && j<len2 && k<=mid;k++){
            int t= arr1[i]<arr2[j]? arr1[i++]:arr2[j++];
            if(k==mid||(k==mid-1 && takePrev)){
                ans+=t;
            }
        }
        
        for(;k<=mid && i<len1;i++,k++){
            int t= arr1[i];
            if(k==mid||(k==mid-1 && takePrev))
                ans+=t;
        }
        
        for(;k<=mid && j<len2;j++,k++){
            int t= arr2[j];
            if(k==mid||(k==mid-1 && takePrev))
                ans+=t;
        }
        
        return ans;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends