//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        int size=str.length();
        char[] digs=str.toCharArray();
        char lastDigit=digs[size-1];
        int lastVal=(int)lastDigit-(int)'0';
        digs[size-1]='0';
        boolean overflow=false;
        int t=size-2;
        if(lastVal>5){
            overflow=true;
            while(t>=0 && overflow){
                if(digs[t]=='9'){
                    digs[t]='0';
                    overflow=true;
                }else{
                    overflow=false;
                    digs[t]+=1;
                }
                t--;
            }  
        }
        
        if(overflow)
            return '1'+new String(digs);
        return new String(digs);
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends