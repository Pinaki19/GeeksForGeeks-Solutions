//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int lcs(String s,String t){
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(s.charAt(i)==t.charAt(j)){
                    int mx=Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=Math.max(mx,1+dp[i-1][j-1]);
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[m-1][n-1];
        
    }
    static int countMin(String str)
    {
        int n=str.length();
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        return n-lcs(" "+str," "+sb.toString());
        
    }
}