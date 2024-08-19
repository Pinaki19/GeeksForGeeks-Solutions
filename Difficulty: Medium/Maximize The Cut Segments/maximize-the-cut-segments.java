//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{

    boolean solve(int i,int[] dp,List<Integer> al,int n){
        if(i>n) return false;
        if(i==n){
            dp[i]=0;
            return true;
        }
        if(dp[i]>=0) return true;
        boolean next=false;
        for(int p:al){
            boolean res=solve(i+p,dp,al,n);
            if(res)
                dp[i]=Math.max(dp[i],1+dp[i+p]);
            next|=res;
        }
        return next;
    }
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       ArrayList<Integer> al=new ArrayList<>();
       if(x<=n) al.add(x);
       if(y<=n) al.add(y);
       if(z<=n) al.add(z);
        solve(0,dp,al,n);
        return Math.max(0,dp[0]);
    }
}