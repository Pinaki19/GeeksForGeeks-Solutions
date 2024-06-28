//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int m=arr.length;
        int n=arr[0].length;
        for(int i=0;i<m;i++){
            int l=0,r=n-1;
            while(l<r && arr[i][l]==arr[i][r]){
                l++;r--;
            }
            if(l>=r) return String.valueOf(i)+" R";
        }
            
        for(int i=0;i<n;i++){
            int l=0,r=m-1;
            while(l<r && arr[l][i]==arr[r][i]){
                l++;r--;
            }
            if(l>=r) return String.valueOf(i)+" C";
        }
            
        return "-1";
    }
}
