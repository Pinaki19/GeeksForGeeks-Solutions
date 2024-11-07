//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        ArrayList<Integer> al=new ArrayList<>();
        long sum=0;
        for(int i:arr)
            sum+=i;
        if(sum%3!=0){
            al.add(-1);
            al.add(-1);
        }else{
            long target1=(long)sum/3;
            long target2=target1*2;
            boolean possible1=false,possible2=false;
            
            long cur=0;
            for(int i=0;i<arr.length;i++){
                cur+=arr[i];
                if(cur==target1 && !possible1){
                    possible1=true;
                    al.add(i);
                }
                else if(cur==target2 && !possible2){
                    possible2=true;
                    al.add(i);
                }
            }
            if(possible1 && possible2){
                
            }else{
                al.clear();
                al.add(-1);
                al.add(-1);
            }
        }
        
        return al;
    }
}