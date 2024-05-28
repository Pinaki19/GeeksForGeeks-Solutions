//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    static int P=Integer.MAX_VALUE;
    public static int solve(int i,int w,int[] cost,int[][] dp,int n){
        if(i>=n||w<=0) return (w==0)? 0:P;
        if(cost[i]==-1) return dp[i][w]=solve(i+1,w,cost,dp,n);
        if(dp[i][w]!=-1) return dp[i][w];
        int canTake=w/(i+1);
        int cur=P,take;
        for(int k=0;k<=canTake;k++){
            take=solve(i+1,w-k*(i+1),cost,dp,n);
            int v= (take==P)? P-k*cost[i]:take;
            cur=Math.min(cur,k*cost[i]+v);
        }
        return dp[i][w]=cur;
    }
    public static int minimumCost(int n, int w, int[] cost) {
        int[][] dp=new int[n][w+1];
        
        for(int[] t:dp)
            Arrays.fill(t,-1);
        int ans=solve(0,w,cost,dp,n);
        return (ans==P)? -1:ans;
    }
}
