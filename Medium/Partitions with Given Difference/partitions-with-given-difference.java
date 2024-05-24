//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int mod=(int)1e9+7;
    static int solve(int i,int sum,int d,int[] arr,int [][]dp,int total){
        if(i>=arr.length) return (sum-total+sum)==d? 1:0;
        if(dp[i][sum]!=-1) return dp[i][sum];
        long cur=solve(i+1,sum+arr[i],d,arr,dp,total)+solve(i+1,sum,d,arr,dp,total);
        return dp[i][sum]=(int)cur%mod;
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int total=0;
        for(int i:arr)
            total+=i;
        int [][] dp=new int[n][total+1];
        for(int[] t:dp)
            Arrays.fill(t,-1);
        return solve(0,0,d,arr,dp,total)%mod;
    }
}
        
