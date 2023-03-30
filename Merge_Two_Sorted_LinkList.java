import java.io.*;
import java.util.*;
 
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
 static Node merge(Node x, Node y){
       Node dummy = new Node(-1); // to have a starting point for new ll.
	 Node temp = dummy; // this will be the head of the new ll
         while(x!=null && y!=null)
			 {
				 if(x.data<y.data)
				 {
					 
					 temp.next = x; // The first node got linked and so on
					 temp = temp.next;
					 x = x.next;
				 }
				 else
				 {
					 temp.next = y; // The  node got linked and so on
					 temp = temp.next;
					 y = y.next; 
				 }
			 }
          if(x!=null)
		  {
			  temp.next = x;
		  }
	 else
		  {
			  temp.next=y;
		  }
				 // while(x!=null)
					//  {
					// temp.next = x;  // Rest of the node is getting linked
					//  temp = temp.next;
					//  x = x.next; 
					//  }

				 // while(y!=null)
					//  {
					// temp.next = y; // Rest of the node is getting linked
					//  temp = temp.next;
					//  y = y.next;
					//  }
	 
	        return dummy.next;
			 }

	 
    }

public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        LinkedList l2 = new LinkedList();
        for(int i=0;i<m;i++){
            l2.add(sc.nextInt());
        }

        Solution Ob = new Solution();
        Node head = Ob.merge(l1.head, l2.head);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
