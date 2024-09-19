//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        String[] splitStr=str.split("\\.");
        int n=splitStr.length;
        int l=0,r=n-1;
        while(l<r){
            String temp=splitStr[l];
            splitStr[l]=splitStr[r];
            splitStr[r]=temp;
            l++;
            r--;
        }
        
        String ans=splitStr[0];
        for(int i=1;i<n;i++){
            ans+='.';
            ans+=splitStr[i];
        }
        return ans;
    }
}