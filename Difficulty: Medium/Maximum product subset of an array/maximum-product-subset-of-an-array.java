//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    final int MOD=(int)1e9+7;
    long maxProduct(List<Integer> arr){
        long prod=1;
        int c1=0,c2=0;
        int mn=Integer.MIN_VALUE;
        int mx=Integer.MIN_VALUE;;
        for(int i:arr){
            mx=Math.max(i,mx);
            if(i!=0){
                if(i<0){
                     mn=Math.max(mn,i);
                     c2++;
                }else
                    c1++;
                prod*=i;
                prod%=MOD;
            }
        }
        if(c2<=1 && mx==0) return 0; 
        if(prod<0 && (c1>=1 ||c2>=2))
            prod/=mn;
        //System.out.println(prod);
        return prod%MOD;
    }
    public long findMaxProduct(List<Integer> arr) {
        // code here
        return maxProduct(arr);
    }
}