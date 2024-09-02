//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    static class Mycomp implements Comparator<int[]>{
        int[][] dp;
        Mycomp(int[][] dp){
            this.dp=dp;
        }
        
        @Override
        public int compare(int[] a,int[] b){
            int x1=a[0],y1=a[1];
            int x2=b[0],y2=b[1];
            int v1=dp[x1][y1];
            int v2=dp[x2][y2];
            
            if(v1==v2)
                return x1-x2;
            return v1-v2;
        }
    };
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int m=grid.length;
        int n=grid[0].length;
        
        int[][] dp=new int[m][n];
        for(int[] t:dp)
            Arrays.fill(t,Integer.MAX_VALUE);
 
        dp[m-1][n-1]=grid[m-1][n-1];
        
        int[][] dir=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Mycomp(dp));
        pq.add(new int[]{m-1,n-1});
        
        while(!pq.isEmpty()){
            int[] t=pq.poll();
            int x=t[0],y=t[1];
            for(int[] d:dir){
                int dx=d[0],dy=d[1];
                int nx=x+dx,ny=y+dy;
                if(nx>=0 && nx<m && ny>=0 && ny<n && dp[nx][ny]>dp[x][y]+grid[nx][ny]){
                    dp[nx][ny]=dp[x][y]+grid[nx][ny];
                    pq.offer(new int[] {nx,ny});
                }
            }
        }
        
        return dp[0][0];
    }
}