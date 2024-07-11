//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    boolean checkParent(int[][][] parents,int i,int j){
        int[] t=parents[i][j];
        return i==t[0] && j==t[1];
    }
    
    boolean isValid(int i,int j,int[][] grid){
        return i>=0 && i<grid.length && j>=0 && j<grid.length && grid[i][j]==1;
    }
    
    boolean isValid2(int i,int j,int[][] grid){
        return i>=0 && i<grid.length && j>=0 && j<grid.length;
    }
    int[] getArr(int i,int j){
        int[] t=new int[2];
        t[0]=i;
        t[1]=j;
        return t;
    }
    
    int[] getParent(int[][][] parents,int i,int j){
        if(checkParent(parents,i,j)) return getArr(i,j);
        return getParent(parents,parents[i][j][0],parents[i][j][1]);
    }
    void DSU(int[][][] parents,int i,int j,int x,int y,int[][] sizes){
        int[] p1=getParent(parents,i,j);
        int[] p2=getParent(parents,x,y);
        if(p1[0]==p2[0] && p1[1]==p2[1]) return;
        i=p1[0];j=p1[1];
        x=p2[0];y=p2[1];
        if(sizes[i][j]>sizes[x][y]){
            sizes[i][j]+=sizes[x][y];
            parents[x][y]=getArr(i,j);
        }else{
            sizes[x][y]+=sizes[i][j];
            parents[i][j]=getArr(x,y);
        }
    }
    
    boolean match(int[][] pars,int i,int j,int l){
        for(int k=0;k<l;k++){
            int[] t=pars[k];
            if(t[0]==i && t[1]==j) return true;
        }
        return false;
    }
    
    public int MaxConnection(int grid[][]) {
        // Your code here
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int n=grid.length;
        int[][][] parents=new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                parents[i][j]=getArr(i,j);
        }
        int[][] sizes=new int[n][n];
        for(int[] t:sizes)
            Arrays.fill(t,1);
            
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                   for(int[] d:dir){
                       int dx=d[0],dy=d[1];
                        int nx=i+dx,ny=j+dy;
                        if(isValid(nx,ny,grid))
                            DSU(parents,i,j,nx,ny,sizes);
                   }
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int[] par=getParent(parents,i,j);
                    ans=Math.max(ans,sizes[par[0]][par[1]]);
                }
                else{
                    int cur=0;
                    int[][] pars=new int[4][2];
                    int l=0;
                     for(int[] d:dir){
                       int dx=d[0],dy=d[1];
                       int nx=i+dx,ny=j+dy;
                       if(isValid(nx,ny,grid)){
                           int[] par=getParent(parents,nx,ny);
                           //System.out.printf("%d %d\n",par[0],par[1]);
                           if(!match(pars,par[0],par[1],l)){
                              cur+=sizes[par[0]][par[1]]; 
                              pars[l++]=par;
                           }
                       }
                      }  
                      
                      ans=Math.max(ans,cur+1);
                }
            }
        }
        return ans;
    }
}