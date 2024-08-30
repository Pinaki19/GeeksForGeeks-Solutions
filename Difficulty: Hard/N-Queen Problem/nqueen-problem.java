//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean check(int x,int y,int n,boolean[][] board){
        for(int j=y-1;j>=0;j--){
            if(board[x][j]) 
                return false;
        }
        for(int i=x-1;i>=0;i--){
            if(board[i][y])
                return false;
        }
        int i=x-1,j=y-1;
        while(i>=0 && j>=0){
            if(board[i][j])
                return false;
            i--;
            j--;
        }
        i=x+1;
        j=y-1;
        while(i<n && j>=0){
            if(board[i][j])
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    void addAns(ArrayList<ArrayList<Integer>> ans,boolean[][] board){
        ArrayList<Integer> al=new ArrayList<>();
        int n=board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[j][i])
                    al.add(j+1);
            }
        }
        ans.add(al);
    }
    
    void solve(int col,int count,boolean[][] board,ArrayList<ArrayList<Integer>> ans){
        if(count==0){
            addAns(ans,board);
            return;
        }
        int n=board.length;
        if(col>=n) return;
        for(int i=0;i<n;i++){
            if(check(i,col,n,board)){
                board[i][col]=true;
                solve(col+1,count-1,board,ans);
                board[i][col]=false;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        boolean[][] board=new boolean[n][n];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        solve(0,n,board,ans);
        return ans;
    }
}