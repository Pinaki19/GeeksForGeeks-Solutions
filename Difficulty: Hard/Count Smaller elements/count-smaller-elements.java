//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int getInsertionPoint(List<Integer> elem,int target){
        if(elem.isEmpty()) return 0;
        int l=0,r=elem.size()-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(elem.get(mid)>=target)
                r=mid-1;
            else{
                ans=mid;
                l=mid+1;
            }
        }
        return ans+1;
    }
    int[] constructLowerArray(int[] arr) {
        // code here
        int n=arr.length;
        int[] ans=new int[n];
        
        List<Integer> elem=new ArrayList<>(10000);
        
        for(int i=n-1;i>=0;i--){
            int ind=getInsertionPoint(elem,arr[i]);
            elem.add(ind,arr[i]);
            
            ans[i]=ind;
        }
        return ans;
    }
}