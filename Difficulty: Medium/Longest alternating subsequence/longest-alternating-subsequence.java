//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int alternatingMaxLength(int[] arr) {
        // code here
        int n=arr.length;
        boolean findMax=true;
        int ans=0;
        int len=1;

        int prev=arr[0];
        for(int i=1;i<n;i++){
            if(findMax){
                if(arr[i]>prev){
                    prev=arr[i];
                    len++;
                    findMax=false;
                }else
                    prev=Math.min(prev,arr[i]);
            }else{
                if(arr[i]<prev){
                    prev=arr[i];
                    len++;
                    findMax=true;
                }else
                    prev=Math.max(prev,arr[i]);
            }
        }
        ans=Math.max(ans,len);
        
        len=1;
        prev=arr[0];
        findMax=false;
         for(int i=1;i<n;i++){
            if(findMax){
                if(arr[i]>prev){
                    prev=arr[i];
                    len++;
                    findMax=false;
                }else
                    prev=Math.min(prev,arr[i]);
            }else{
                if(arr[i]<prev){
                    prev=arr[i];
                    len++;
                    findMax=true;
                }else
                    prev=Math.max(prev,arr[i]);
            }
        }
        ans=Math.max(ans,len);
        return ans;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends