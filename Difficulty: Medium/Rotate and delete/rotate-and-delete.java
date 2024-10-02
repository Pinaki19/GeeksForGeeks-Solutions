//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here
        Collections.reverse(arr);
        LinkedList<Integer> l=new LinkedList<>(arr);
        int r=0;
        int sz=l.size();
        for(int i=0;i<sz/2;i++){
            l.offerLast(l.getFirst());
            l.pollFirst();
            if(l.size()>r){
                l.remove(r);
                r++;
            }else
                l.pollFirst();
        }
        
        return l.getLast();
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends