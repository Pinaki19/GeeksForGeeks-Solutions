//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        List<Integer> al=new ArrayList<>();
        HashMap<Integer,Integer> mp=new HashMap<>();
        int total=nums.size();
        for(Integer i:nums){
            mp.putIfAbsent(i,0);
            mp.put(i,mp.get(i)+1);
        }
        
        for(Integer i:mp.keySet()){
            int votes=mp.get(i);
            if(votes*3>total){
                al.add(i);
            }
        }
        if(al.size()==0)
            al.add(-1);
        return al;
    }
}
