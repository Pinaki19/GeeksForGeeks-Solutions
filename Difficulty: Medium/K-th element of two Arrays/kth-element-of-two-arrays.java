//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int l1=0,l2=0;
        while(k>0){
           if(l1<arr1.length && l2<arr2.length){
               if(arr1[l1]<arr2[l2]){
                   if(k==1)
                    return arr1[l1];
                    l1++;
               }else{
                   if(k==1)
                    return arr2[l2];
                    l2++;
               }
               
           }else if(l1<arr1.length){
               if(k==1)
                    return arr1[l1];
               l1++;
               
           }else{
               if(k==1)
                    return arr2[l2];
                    l2++;
           }
            k--;
        }
        return -1;
    }
}