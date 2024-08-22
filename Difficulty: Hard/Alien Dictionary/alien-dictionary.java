//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
//baa abcd abca cab cada


class Solution {
    void traverse(int t,Queue<Integer> q,int[] indeg,Map<Integer,Set<Integer>> adj){
        if(!adj.containsKey(t)) return;
        
        for(int j:adj.get(t)){
            indeg[j]--;
            if(indeg[j]==0)
                q.offer(j);
        }
            
    }
    
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        int[] indeg=new int[k];
        Map<Integer,Set<Integer>> adj=new HashMap<>();
        
        int len=dict.length;
        for(int i=0;i<len-1;i++){
            String cur=dict[i];
            String next=dict[i+1];
            
            int l1=cur.length();
            int l2=next.length();
            for(int j=0;j<Math.min(l1,l2);j++){
                if(cur.charAt(j)==next.charAt(j)) continue;
                int t=(int)next.charAt(j)-(int)'a';
                int p=(int)cur.charAt(j)-(int)'a';
                if(!adj.containsKey(p)|| !adj.get(p).contains(t)){
                    adj.putIfAbsent(p,new HashSet<Integer>());
                    adj.get(p).add(t);
                    indeg[t]++;
                }
                break;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<k;i++)
            if(indeg[i]==0)
                q.offer(i);
        
        String ans="";
        
        while(!q.isEmpty()){
            int t=q.poll();
            char c=(char)((int)'a'+t);
            ans+=c;
            
            traverse(t,q,indeg,adj);
        }
        // System.out.println(ans);
        return ans.length()==k? ans:"";
    }
}