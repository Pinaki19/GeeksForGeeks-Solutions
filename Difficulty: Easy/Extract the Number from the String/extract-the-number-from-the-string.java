//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        String[] parts=sentence.split(" ");
        long ans=-1l;
        for(String part:parts){
            if(Character.isLetter(part.charAt(0))||part.indexOf('9')>=0) continue;
            try{
                long num=Long.parseLong(part);
                ans=Math.max(ans,num);
            }catch(NumberFormatException e){
                
            }
        }
        
        return ans;
    }
}