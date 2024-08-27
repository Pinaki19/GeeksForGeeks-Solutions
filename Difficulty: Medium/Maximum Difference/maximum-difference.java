//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n=arr.length;
        int ans=0;
        Stack<Integer> min=new Stack<>();
        int[] rmin=new int[n];
       
        for(int i=0;i<n;i++){
            int val=arr[i];
            while(min.size()>0 && val<arr[min.peek()]){
                rmin[min.pop()]=val;
            }
            min.push(i);
        }
        
        while(min.size()>0){
           min.pop();
        }
        
        for(int i=n-1;i>=0;i--){
            int val=arr[i];
            while(min.size()>0 && val<arr[min.peek()]){
                int ind=min.pop();
                ans=Math.max(ans,Math.abs(val-rmin[ind]));
            }
            min.push(i);
        }
        
        while(min.size()>0){
            int ind=min.pop();
            ans=Math.max(ans,rmin[ind]);
        }
        
        return ans;
    }
}
