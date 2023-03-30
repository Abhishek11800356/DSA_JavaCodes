
import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node next;
    Node(int key){
        data = key;
        next = null;
    }
}

class Main{
    static Node head;
    static Node temp;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            head = null;
            temp = null;
            addToTheLast(a1);
            
            for(int i = 1; i < n; i++){
                int data = sc.nextInt();
                addToTheLast(data);
            }
            Solution ans = new Solution();
            Node node = ans.rearrange(head);
            printList(node);
            System.out.println();
        }
    }
    
    public static void addToTheLast(int data){
        if(head == null){
			head = new Node(data);
			temp =head;
			return ;
		}
		else{
			Node new_node = new Node(data);
			temp.next = new_node;
			temp=temp.next;
			return;		
		}
    }
    
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

class Solution{

	public static Node reverse(Node head)
	{
        Node prev = null;
		while(head!=null)
			{
				Node temp = head.next;
				head.next=prev;
		         prev = head;
				head = temp;
			}
		return prev;	
			}
	 public static int size(Node node)
	{  int len=0;
		Node temp = node;
		  while(temp!=null)
			{
				temp = temp.next;
				len++;
			}
		return len;
	}
	
		
    public static Node rearrange(Node node){
         Node dummy=new Node(-1);
			Node newNode=dummy;
				Node temp=node;
			while(temp!=null){
	            newNode.next = new Node(temp.data);
				newNode  = newNode.next;
				temp = temp.next;
				}
			newNode=dummy.next;
		Node revhead = reverse(newNode);
		 Node mergetemp = new Node(-1);
		Node mtemp = node;
		Node revtemp = revhead;
		int length = size(node);
		for(int i=0;i<length/2;i++)
			{
				Node linker = mtemp.next;
				mtemp.next = revtemp;
				Node revlink = revtemp.next;
				if(length%2==0 && i<length/2 -1)
				{revtemp.next = linker;
			     mtemp = revtemp.next;
				revtemp = revlink;	
				}
				if(length%2==1)
				{
					revtemp.next = linker;
			     mtemp = revtemp.next;
				revtemp = revlink;
				}
					
			}
		if(length%2==0)
		revtemp.next = null;
		else 
			mtemp.next = null;
		
        return node;
		
	}
}
