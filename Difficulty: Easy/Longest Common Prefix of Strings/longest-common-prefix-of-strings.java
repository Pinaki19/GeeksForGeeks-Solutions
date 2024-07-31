//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Mycomp implements Comparator<String>{
    public int compare(String s1,String s2){
        return s1.length()-s2.length();
    } ;
    
};

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        Arrays.sort(arr,new Mycomp());
        String ans=arr[0];
        for(String s:arr){
            String t="";
            for(int p=0;p<ans.length();p++){
                if(ans.charAt(p)!=s.charAt(p)){
                    break;
                }
                t+=ans.charAt(p);
            }
            ans=t;
        }
        return ans.length()==0? "-1":ans;
    }
}