//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends
class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        String ans="";
        int prev=0;
        for(int i=1;i<=d;i++){
            int left=s-prev;
            for(int k= i==1? 1:0;k<=9;k++){
                if(left-k<=(d-i)*9||k==9){
                    ans+=String.valueOf(k);
                    prev+=k;
                    break;
                }
            }
        }
        return prev==s? ans:"-1";
    }
}
