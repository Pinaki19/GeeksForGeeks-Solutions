//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        int n=arr.length;
        int[] pref=new int[n];
        int[] suff=new int[n];
        pref[0]=arr[0];
        suff[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            pref[i]=Math.min(pref[i-1],arr[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.max(suff[i+1],arr[i+1]);
        }
        
        for(int i=0;i<n;i++){
            if(pref[i]<arr[i] && suff[i]>arr[i]){
                ArrayList<Integer> al=new ArrayList<>();
                al.add(pref[i]);
                al.add(arr[i]);
                al.add(suff[i]);
                
                return al;
            }
        }
        
        return new ArrayList<Integer> ();
    }
}