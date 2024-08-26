//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    int m,n;
    int solve(String patt,String str,int i,int j,int[][] dp){
        if(i==m) return j>=n? 1:0;
        if(j==n){
            while(i<m && patt.charAt(i)=='*')
                i++;
             return i>=m? 1:0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        char c1=patt.charAt(i);
        char c2=str.charAt(j);
        if(c1==c2||c1=='?')
            return dp[i][j]=solve(patt,str,i+1,j+1,dp);
        else if(c1=='*'){
            int ans=0;
            for(int k=j;k<=str.length();k++){
                ans=solve(patt,str,i+1,k,dp);
                if(ans==1) break;
            }
            return dp[i][j]=ans;
        }else
            return dp[i][j]=0;
    }
    public int wildCard(String pattern, String str) {
        // Your code goes here
        m=pattern.length();
        n=str.length();
        int[][] dp=new int[m][n];
        for(int[] t:dp)
            Arrays.fill(t,-1);
        return solve(pattern,str,0,0,dp);
    }
}
