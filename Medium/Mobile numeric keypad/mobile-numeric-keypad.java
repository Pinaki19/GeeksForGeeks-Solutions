//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    Map<Integer,Integer[]> mp=new HashMap<>();
    boolean isValid(int i,int j,int[][] nums){
        return i>=0 && j>=0 && i<nums.length && j<nums[0].length && nums[i][j]>=0;
    }
    
    long solve(int i,int n,int[][] dir,int[][] nums,long[][] dp){
        if(n==0) return 1;
        if(dp[i][n]>=0) return dp[i][n];
        long ans=0;
        Integer[] xy=mp.get(i);
        for(int[] d:dir){
            int nx=xy[0]+d[0];
            int ny=xy[1]+d[1];
            if(isValid(nx,ny,nums))
                ans+=solve(nums[nx][ny],n-1,dir,nums,dp);
        }
        return dp[i][n]=ans;
    }
    public long getCount(int n) {
        long[][] dp = new long [10][n+1];
        for(long[] t:dp)
            Arrays.fill(t,-1l);
        
        int[][] nums={{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        long ans=0;
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++)
                mp.put(nums[i][j],new Integer[]{i,j});
        }
        
        int [][] dir={{0,0},{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<10;i++){
            ans+=solve(i,n-1,dir,nums,dp);
        }
        
        return ans;
    }
}