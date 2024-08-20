//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java
   /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    
/*

At: 4 ld: 0 rd: 0
At: 10 ld: 0 rd: 0
At: 13 ld: 0 rd: 0
At: 11 ld: 0 rd: 1
At: 7 ld: 1 rd: 2
At: 5 ld: 3 rd: 1
At: 2 ld: 1 rd: 4
At: 12 ld: 0 rd: 0
At: 9 ld: 0 rd: 1
At: 6 ld: 0 rd: 2
At: 3 ld: 0 rd: 3
At: 1 ld: 5 rd: 4

                    1
                2       3
              4    5      6
                7   8       9
             10  11           12
                   13


*/
    
class Solution
{
    static int ans;
    static int depth(Node root){
        if(root==null)
            return 0;
        return 1+Math.max(depth(root.left),depth(root.right));
    }
    static int[] solve(Node root,int target){
        if(root==null)
            return new int[]{0,0};
        if(root.data==target){
            ans=Math.max(ans,depth(root.left));
            ans=Math.max(ans,depth(root.right));
            return new int[]{1,1};
        }
        int[] ld=solve(root.left,target);
        int[] rd=solve(root.right,target);
        if(ld[1]==rd[1]){
            ans=Math.max(Math.max(ld[0],rd[0]),ans);
            return new int[] {1+Math.max(ld[0],rd[0]),0};
        }else if(ld[1]==1){
            ans=Math.max(ld[0]+rd[0],ans);
            return new int[] {1+ld[0],1};
        }else{
            ans=Math.max(ld[0]+rd[0],ans);
            return new int[] {1+rd[0],1};
        }
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        ans=0;
        solve(root,target);
        return ans;
    }
}