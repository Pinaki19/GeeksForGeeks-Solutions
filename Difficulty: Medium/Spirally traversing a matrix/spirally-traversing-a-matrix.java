//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    void solve(int left,int right,int up,int down,List<Integer> ans,int[][] matrix){
        if(up>=down || left>=right) return;
        for(int i=left;i<right;i++){
            ans.add(matrix[up][i]);
        }
        for(int i=up+1;i<down;i++){
            ans.add(matrix[i][right-1]);
        }
        if(up!=down-1)
            for(int i=right-2;i>=left;i--){
                ans.add(matrix[down-1][i]);
            }
        if(left!=right-1)
            for(int i=down-2;i>up;i--){
                ans.add(matrix[i][left]);
            }
    }
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int rb=n;
        int lb=m;
        for(int i=0;i<=m/2;i++){
            solve(i,rb--,i,lb--,ans,matrix);
        }
        
        return ans;
    }
}
