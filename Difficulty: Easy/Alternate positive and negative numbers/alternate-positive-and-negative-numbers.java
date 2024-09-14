//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> nonNegetive=new ArrayList<>();
        ArrayList<Integer> negetive=new ArrayList<>();
        
        for(int i:arr){
            if(i>=0)
                nonNegetive.add(i);
            else
                negetive.add(i);
        }
        int l1=0,l2=0;
        int i=0;
        while(l1<nonNegetive.size() && l2<negetive.size()){
            int val= ((i&1)==1)? negetive.get(l2++):nonNegetive.get(l1++);
            arr.set(i,val);
            i++;
        }
        while(l1<nonNegetive.size()){
            arr.set(i,nonNegetive.get(l1));
            i++;
            l1++;
        }
        while(l2<negetive.size()){
            arr.set(i,negetive.get(l2));
            i++;
            l2++;
        }
    }
}