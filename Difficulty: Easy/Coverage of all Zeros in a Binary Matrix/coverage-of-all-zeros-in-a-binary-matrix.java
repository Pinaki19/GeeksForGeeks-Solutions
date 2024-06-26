//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isValid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int findCoverage(int[][] matrix) {
        // code here
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1) continue;
                for(int[] d:dir){
                    int dx=d[0],dy=d[1];
                    int nx=i+dx,ny=j+dy;
                    if(isValid(nx,ny,m,n) && matrix[nx][ny]==1){
                       ans++;
                    }
                }
            }
        }
        return ans;
    }
}