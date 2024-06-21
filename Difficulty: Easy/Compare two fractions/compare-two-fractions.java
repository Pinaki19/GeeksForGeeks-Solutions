//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        String[] nums=str.split(", ");
        String[] n1=nums[0].split("/");
        String[] n2=nums[1].split("/");
        int a=Integer.parseInt(n1[0]);
        int b=Integer.parseInt(n1[1]);
        int c=Integer.parseInt(n2[0]);
        int d=Integer.parseInt(n2[1]);
        double f1=(double)a/b;
        double f2=(double)c/d;
        if(f1==f2)
            return "equal";
        if(f1>f2)
            return nums[0];
        return nums[1];
    }
}
