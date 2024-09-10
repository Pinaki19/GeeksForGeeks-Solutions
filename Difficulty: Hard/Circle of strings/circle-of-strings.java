//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        int n = arr.length;
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        List<Integer>[] adj = new ArrayList[26];
        
        // Initialize adjacency list
        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build the graph
        for (String s : arr) {
            int u = s.charAt(0) - 'a';
            int v = s.charAt(s.length() - 1) - 'a';
            adj[u].add(v);
            outDegree[u]++;
            inDegree[v]++;
        }

        // Check if in-degree equals out-degree for every vertex
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }

        // Find a starting vertex with non-zero degree
        int startVertex = -1;
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                startVertex = i;
                break;
            }
        }

        // If there are no edges, it's trivially a circle
        if (startVertex == -1) {
            return 1;
        }

        // Check if all non-zero degree vertices are connected
        boolean[] visited = new boolean[26];
        dfs(adj, visited, startVertex);

        // Verify that all non-zero degree vertices are visited
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return 0;
            }
        }

        return 1;
    }

    private void dfs(List<Integer>[] adj, boolean[] visited, int u) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(adj, visited, v);
            }
        }
    }
}