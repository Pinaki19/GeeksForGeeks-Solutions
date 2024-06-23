//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        Integer open=1;
        LinkedList<Integer> ls=new LinkedList<Integer>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='('){
                ls.addLast(open);
                ans.add(open++);
            }else if(c==')'){
                ans.add(ls.getLast());
                ls.removeLast();
            }
        }
        return ans;
    }
};