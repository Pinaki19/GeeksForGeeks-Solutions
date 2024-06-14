//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        // code here
        Integer N=n;
        String s=N.toString();
        long tot=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int t=(int) c-'0';
            tot+=t*t*t;
        }
        return (tot==n)? "true":"false";
    }
}