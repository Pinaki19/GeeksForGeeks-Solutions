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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod=(int)1e9+7;
    public int padovanSequence(int n){
      int[] dp=new int[n+1];
      for(int i=0;i<=n;i++){
          if(i<3)
              dp[i]=1;
          else
            dp[i]=(dp[i-2]%mod+dp[i-3]%mod)%mod;
      }
      return dp[n]%mod;
    }
}
