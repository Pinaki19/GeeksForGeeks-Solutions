//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int nthStair(int n) {
        // Code here
        // 2 2 2 2 1 --> 9
        // 1 1 2 2 2 1
        // 1 1 1 1 2 2 1
        // 1 1 1 1 1 1 2 1
        // 1 1 1 1 1 1 1 1 1
        return n/2+1;
    }
}