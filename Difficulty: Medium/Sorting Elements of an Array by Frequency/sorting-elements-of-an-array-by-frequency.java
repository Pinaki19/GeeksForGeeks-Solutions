//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Mycomp implements Comparator<Integer>{
  private int[] freq;
  Mycomp(int[] freq){
      this.freq=freq;
  }
  
  @Override
  public int compare(Integer i,Integer j){
      if(freq[i]==freq[j])
        return i-j;
      return freq[j]-freq[i];
  }
    
};

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        final int lim=(int)1e5+1;
        int[] freq=new int[lim];
        
        ArrayList<Integer> al=new ArrayList<>();
        Arrays.fill(freq,0);
        
        for(int i:arr){
             freq[i]++;
             al.add(i);
        }
        
        al.sort(new Mycomp(freq));
      
        return al;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends