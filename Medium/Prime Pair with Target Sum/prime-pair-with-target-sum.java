//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    static BitSet bs=new BitSet((int)1e6+1);
    static void Sieve(BitSet bs,int lim){
        bs.set(0,lim+1);
        bs.clear(0);
        bs.clear(1);
        for(int i=4;i<lim;i+=2)
            bs.clear(i);
        for(int i=3;i<lim;i+=2){
            if(bs.get(i)){
                for(long j=i*1l*i;j<lim;j+=i)
                    bs.clear((int)j);
            }
        }
        
    }
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        Sieve(bs,n+1);
        int a=-1,b=-1;
        if(bs.get(n-2)){
            a=2;
            b=n-2;
        }else{
            for(int i=3;i<n;i+=2){
                if(bs.get(i)&& bs.get(n-i)){
                    a=i;b=n-i;
                    break;
                }
            }  
        }
        
        return new ArrayList<Integer> (Arrays.asList(a,b));
    }
}
