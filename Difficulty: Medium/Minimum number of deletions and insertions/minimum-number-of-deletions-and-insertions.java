//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int m,n;
    int solve(int i,int j,String s1,String s2,int[][] dp){
        if(i>=m)
            return n-j;
        if(j>=n)
            return m-i;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j))
            ans=solve(i+1,j+1,s1,s2,dp);
        ans=Math.min(ans,1+solve(i,j+1,s1,s2,dp));
        ans=Math.min(ans,1+solve(i+1,j,s1,s2,dp));
        return dp[i][j]=ans;
    }
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    m=str1.length();
	    n=str2.length();
	    int [][] dp=new int[m][n];
	    for(int[] t:dp)
	        Arrays.fill(t,-1);
	       
	    return solve(0,0,str1,str2,dp);
	} 
}