//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
    static void rotate(int mat[][]) {
        // Code Here
        int m=mat.length;
        int n=mat[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                int t=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=t;
            }
        }
        
        for(int i=0;i<m;i++){
            int l=0;int r=n-1;
            while(l<r){
                int t=mat[i][l];
                mat[i][l]=mat[i][r];
                mat[i][r]=t;
                l++;
                r--;
            }
        }
    }
}