//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class MyComp implements Comparator<Integer[]>{
    @Override
    public int compare(Integer[] a,Integer[] b){
        return a[0]-b[0];
    }
};

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        final int INF=Integer.MAX_VALUE;
        int[] dist=new int[n];
        Arrays.fill(dist,INF);
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int[] edg:edges){
            int u=edg[0],v=edg[1];
            adj.putIfAbsent(u,new ArrayList<Integer>());
            adj.putIfAbsent(v,new ArrayList<Integer>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        dist[src]=0;
        PriorityQueue<Integer[]>pq =new PriorityQueue<>(new MyComp());
        pq.add(new Integer[] {0,src});
        
        while(!pq.isEmpty()){
            Integer[] t=pq.poll();
            int d=t[0],x=t[1];
            for(int i:adj.getOrDefault(x,new ArrayList<Integer>())){
                if(dist[i]>d+1){
                    dist[i]=d+1;
                    pq.add(new Integer[] {d+1,i});
                }
            }
        }
        for(int i=0;i<n;i++){
            dist[i]= dist[i]==INF? -1:dist[i];
        }
        return dist;
    }
}