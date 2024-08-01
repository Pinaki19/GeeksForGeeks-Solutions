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
class Trie{
  int numChild;
  int set;
  Trie child;
  
  Trie(){
      numChild=0;
      child=null;
      set=-1;
  }
};
class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String ans="";
        Trie head=new Trie();
        
        for(String s:arr){
            Trie temp=head;
            for(int i=0;i<s.length();i++){
                int t=(int)s.charAt(i)-'a';
                if(temp.set==t){
                    temp=temp.child;
                    continue;
                }
                if(temp.numChild==0){
                    temp.child=new Trie();
                    temp.numChild=1;
                    temp.set=t;
                }else{
                    temp.numChild+=1;
                    break;
                }
                temp=temp.child;
            }
        }
        
        while(true){
            if(head.numChild!=1) break;
            ans+=(char)((int)'a'+head.set);
            head=head.child;
        }
        
        return ans.length()==0? "-1":ans;
    }
}