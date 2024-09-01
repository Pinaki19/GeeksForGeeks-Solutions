//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int m=arr1.size();
        int n=arr2.size();
        int i=0,j=0;
        int s1=0,s2=0;
        int ans=0;
        while(i<m && j<n){
            int v1=arr1.get(i);
            int v2=arr2.get(j);
            if(v1==v2){
                ans+=Math.max(s1,s2)+v1;
                i++;
                j++;
                s1=s2=0;
            }else if(v1<v2){
                s1+=v1;
                i++;
            }else{
                j++;
                s2+=v2;
            }
        }
        
        
        while(i<m){
            s1+=arr1.get(i++);
        }
        while(j<n){
            s2+=arr2.get(j++);
        }
        
        ans+=Math.max(s1,s2);
        return ans;   
    }
}