//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int solve(int i,int j,String s1,String s2,int[][] dp){
        if(i>=s1.length())
            return s2.length()-j;
        if(j>=s2.length())
            return s1.length()-i;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        int t=0;
        if(s1.charAt(i)!=s2.charAt(j))
            t=1;
        ans=t+solve(i+1,j+1,s1,s2,dp);
        ans=Math.min(ans,1+solve(i+1,j,s1,s2,dp));
        ans=Math.min(ans,1+solve(i,j+1,s1,s2,dp));
        
        dp[i][j]=ans;
        return ans;
    }
    public int editDistance(String str1, String str2) {
        // Code here
        int m=str1.length();
        int n=str2.length();
        
        if(m>n){
            String temp=str1;
            str1=str2;
            str2=temp;
        }

        int[][] dp=new int[str1.length()][str2.length()];
        
        for(int[] t:dp)
            Arrays.fill(t,-1);
            
        return solve(0,0,str1,str2,dp);
    }
}