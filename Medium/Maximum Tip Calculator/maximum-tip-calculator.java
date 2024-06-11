//{ Driver Code Starts
import java.io.*;
import java.util.*;

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

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        ArrayList<Integer[]> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new Integer[]{arr[i],brr[i]});
        }   
        long total=0;
        al.sort(new Comparator<Integer[]>(){
            public int compare(Integer[] a,Integer[] b){
                return Math.abs(b[0]-b[1])- Math.abs(a[0]-a[1]);
            }
        });
        
        for(int i=0;i<n;i++){
            Integer[] t=al.get(i);
            if(t[0]>t[1]){
                if(x>0){
                    x--;
                    total+=t[0];
                }else{
                    y--;
                    total+=t[1];
                }
            }else{
                if(y>0){
                    y--;
                    total+=t[1];
                }else{
                    x--;
                    total+=t[0];
                }
            }
        }
        return total;
        
    }
}
