//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int m=mat.length;
        int n=mat[0].length;
        int i=0;
        
        for(;i<m;i++){
            boolean found=true;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    found=false;
                    break;
                }
            }
            if(found)
                break;
        }
        if(i==m) return -1;
        
        for(int j=0;j<m;j++){
            if(i==j) continue;
            if(mat[j][i]==0) return -1;
        }
        return i;
    }
}