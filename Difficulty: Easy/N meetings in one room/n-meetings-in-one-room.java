//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Mycomp implements Comparator<int[]>{
  @Override
  public int compare(int[] a,int[] b){
      if(a[0]==b[0]) return a[1]-b[1];
      return a[0]-b[0];
  }
    
};


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        int[][] es=new int[n][2];
        for(int i=0;i<n;i++){
            es[i]=new int[]{end[i],start[i]};
        }
        
        Arrays.sort(es,new Mycomp());
        int ans=0;
        int prev=-1;
        for(int[] t:es){
           if(t[1]>prev){
               prev=t[0];
               ans++;
           }
        }
        
        return ans;
    }
}
