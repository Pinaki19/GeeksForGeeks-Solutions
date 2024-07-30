//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    ArrayList<String> ans;
    
    char Id(int dx,int dy){
        if(dx==0 && dy==1) return 'R';
        if(dx==0 && dy==-1) return 'L';
        if(dx==1 && dy==0) return 'D';
        return 'U';
    }
    
    boolean isValid(int x,int y,int[][] mat){
        return x>=0 && x<mat.length && y>=0 && y<mat[0].length;
    }
    
    void solve(int x,int y,int[][] mat,String temp,boolean [][] vis){
        if(mat[x][y]==0)
            return;
        if(x==mat.length-1 && y==mat[0].length-1){
            ans.add(temp);
            return;
        }
        vis[x][y]=true;
        
        for(int[] d:dir){
            int dx=d[0],dy=d[1];
            int nx=x+dx,ny=y+dy;
            if(isValid(nx,ny,mat)  && vis[nx][ny]==false)
                solve(nx,ny,mat,temp+Id(dx,dy),vis);
        }
        
        vis[x][y]=false;
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ans=new ArrayList<>();
        
        int m=mat.length;
        int n=mat[0].length;
        boolean[][] vis=new boolean[m][n];
        for(boolean[] t:vis)
            Arrays.fill(t,false);
        
        solve(0,0,mat,"",vis);
        
        return ans;
    }
}