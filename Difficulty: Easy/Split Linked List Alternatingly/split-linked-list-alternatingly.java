//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        Node head1=null;
        Node head2=null;
        head1=head;
        head2=head.next;
        Node tail1=head1;
        Node tail2=head2;
        Node temp=head.next;
        if(temp!=null)
            temp=temp.next;
        tail1.next=null;
        tail2.next=null;
        Node tempNext=null;

        while(temp!=null){
            tail1.next=temp;
            tempNext=temp.next;
            tail1.next.next=null;
            if(tempNext!=null){
                tail2.next=tempNext;
                tempNext=tempNext.next;
                tail2.next.next=null;
            }
            tail1=tail1.next;
            tail2=tail2.next;
            temp=tempNext;
        }
        
        return new Node[] {head1,head2};
    }
}
