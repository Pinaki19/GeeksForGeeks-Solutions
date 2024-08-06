//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        String[] octets=str.split("\\.");
        if(octets.length!=4) return false;
        try{
            for(String octet:octets){
                int n=Integer.parseInt(octet);
                if(n<0||n>255) return false;
                if(octet.length()>1 && octet.charAt(0)=='0') return false;
            }    
        }catch(NumberFormatException e){
            return false;
        }
        
        return true;
    }
}