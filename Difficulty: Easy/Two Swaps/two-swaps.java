//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    void swap(List<Integer> arr,int i,int j){
        int t=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,t);
    }
    public boolean checkSorted(List<Integer> arr) {
        // code here
        int count=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=arr.size();
        for(int i=0;i<n;i++)
            mp.put(arr.get(i),i);
        
        for(int i=0;i<n;i++){
            if(arr.get(i)!=i+1){
                if(count==2)
                    return false;
                count++;
                int t=mp.get(i+1);
                swap(arr,i,t);
            }
        }
        return count==2||count==0;
    }
}