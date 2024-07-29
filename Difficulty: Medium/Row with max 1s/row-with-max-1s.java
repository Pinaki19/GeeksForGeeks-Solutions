//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int m=arr.length;
        int n=arr[0].length;
        int cur=n;
        int ans=-1;
        
        for(int i=0;i<m;i++){
            int l=0,r=n-1;
            int ptr=n;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(arr[i][mid]==1){
                    ptr=mid;
                    r=mid-1;
                }else
                    l=mid+1;
            }
            
            if(ptr<cur){
                cur=ptr;
                ans=i;
            }
        }
        return ans;
    }
}