//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        long sum=0;
        int n=arr.length;
        int unseen=0,repeat=0;
        for(int i=0;i<n;i++){
            int val=Math.abs(arr[i])-1;
            if(arr[val]<0){
                repeat=val+1;
            }else
                arr[val]*=-1;
            sum+=val+1;
        }
        long expected= (n*1l*(n+1))/2;
        sum-=repeat;
        unseen=(int)(expected-sum);
        return new int[]{repeat,unseen};
    }
}