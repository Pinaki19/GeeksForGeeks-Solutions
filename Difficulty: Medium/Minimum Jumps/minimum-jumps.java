//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // your code here
        int n=arr.length;
        int ans=0;
        int cur=0;
        boolean changed=true;
        while(cur<n-1 && changed){
            changed=false;
            int d=arr[cur];
            int last=cur;
            int li=cur;
            for(int j=cur+1;j<=cur+d && j<n;j++){
                changed=true;
                int jmp=arr[j];
                if(j+jmp>last){
                    last=Math.min(n-1,j+jmp);
                    li=j;
                }
            }
            cur=li;
            ans++;
        }
        return cur==n-1? ans:-1;
    }
}