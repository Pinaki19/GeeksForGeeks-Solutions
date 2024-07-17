//{ Driver Code Starts
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class CreateTree {
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            Node root = ob.createTree(arr);

            printLevelOrder(root);
            System.out.println();
        }
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
        }
    }

    public static void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            result.clear();
            printGivenLevel(root, i);
            Collections.sort(result);
            for (int j = 0; j < result.size(); j++)
                System.out.print(result.get(j) + " ");
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        else {

            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public static void printGivenLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1)
            result.add(node.data);
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
}

// } Driver Code Ends


/*node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        // Your code here
        Node head=null;
        int n=parent.length;
        Node[] nodes=new Node[n];
        for(int i=0;i<n;i++){
            nodes[i]= nodes[i]==null? new Node(i):nodes[i];
            int p=parent[i];
            if(p>=0){
                nodes[p]= nodes[p]==null? new Node(p):nodes[p];
                if(nodes[p].left==null)
                    nodes[p].left=nodes[i];
                else
                    nodes[p].right=nodes[i];
            }
            else 
                head=nodes[i];
        }
        
        return head;
    }
}
