//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int[] freq=new int[26];
        int m=p.length();
        for(int i=0;i<m;i++){
            char c=p.charAt(i);
            int t=(int)c-(int)'a';
            freq[t]++;
        }
        
        int Len=Integer.MAX_VALUE;
        String ans="-1";
        int L=-1;
        int n=s.length();
        int l=0,r=0;
        int[] cur=new int[26];
        
        while(r<n){
            char c=s.charAt(r);
            int t=(int)c-(int)'a';
            cur[t]++;
            boolean allFound=true;
            while(allFound){
                for(int i=0;i<26;i++){
                    if(freq[i]>0 && cur[i]<freq[i]){
                        allFound=false;
                        break;
                    }
                }
                if(allFound){
                    int t2=(int)s.charAt(l)-(int)'a';
                    cur[t2]--;
                    int curLen=r-l+1;
                    if(curLen<Len){
                        Len=curLen;
                        ans=s.substring(l,r+1);
                    }
                    l++;
                }
            }
            r++;
        }
        
        return ans;
    }
}