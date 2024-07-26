//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // code here
        Set<Character> s=new HashSet<>();
        int chars=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(Character.isSpace(c)) continue;
            s.add(c);
            chars++;
        }
            
        int left=26-s.size();
        return k>=left && chars>=26;
    }
}