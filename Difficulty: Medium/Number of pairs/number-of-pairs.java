//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
        long ans=0;
        double[] a=new double[M];
        double[] b=new double[N];
        for(int i=0;i<M;i++){
            int v=x[i];
            a[i]=Math.log(v)/(double)v;
        }
        for(int i=0;i<N;i++){
            int v=y[i];
            b[i]=Math.log(v)/(double)v;
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        for(double val:a){
           long c=-1;
           int l=0,r=N-1;
           while(l<=r){
               int mid=l+(r-l)/2;
               if(b[mid]<val){
                   c=mid;
                   l=mid+1;
               }else
                r=mid-1;
           }
           ans+=c+1;
        }
        
        return ans;
    }
}