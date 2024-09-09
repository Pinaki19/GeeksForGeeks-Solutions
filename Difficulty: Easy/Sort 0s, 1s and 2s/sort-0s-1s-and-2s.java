//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    void swap(ArrayList<Integer> al,int i,int j){
        int t=al.get(j);
        al.set(j,al.get(i));
        al.set(i,t);
    }
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int l=0,r=arr.size()-1;
        int i=0;
        while(i<=r){
            int t=arr.get(i);
            if(t==0){
                swap(arr,l++,i);
                i++;
            }else if(t==2){
                swap(arr,r--,i);
            }else{
                i++;
            }
        }
    }
}