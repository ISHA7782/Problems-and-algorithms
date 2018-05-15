import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

public class BinaryTree {

	Node root;
	BinaryTree()
	{
		root = null;
	}

	void inorder(Node node)
	{
		//Recursive In-order
		if (node == null)
		{
			return;
		}
		inorder(node.left);
		System.out.print(node.key + "  ");
		inorder(node.right);
	}
	
	void preorder(Node node)
	{
		//Recursive Pre order
		if(node == null)
			return; 
		System.out.print(node.key + "  ");
		preorder(node.left);
		preorder(node.right);
	}
	
	void postorder(Node node)
	{
		//Recursive Post order
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.key + "  ");
	}
	void inorderWithStack(Node node)
	{
		//Creating Stack with type as Node object.
		Stack<Node> s = new Stack<Node>();
		//If root is null, exit
		if( node == null)
			return;
		//Loop until current node is null
		while(node != null)
		{
			//Push the current node and and move node as node -> left 
			s.push(node);
			node = node.left;
		}
		//Now, pop and push elements until stack is empty 
		while( !s.isEmpty())
		{
			//Pop element. and print. 
			node = s.pop();
			System.out.print(node.key + "  ");
			//If node has right, push Right node
			if(node.right != null)
			{
				node = node.right;
				//If node has any left child child, push the left child. 
				while(node != null )
				{
					s.push(node);
					node = node.left;
				}
			}
			 	
		}
	}
	void preorderwithstack(Node node)
	{
		//Declaring stack with data type as node 
		Stack<Node> s = new Stack<Node>();
		//If root is null, return
		if (node == null)
			return;
		//Push root node to stack
		s.push(node);
		Node current;
		//Loop runs until stack is empty. First print the  current data, then insert root right child and then roots left child.
		while(!s.isEmpty()) 
		{
			current = s.pop();
			System.out.print(current.key + "  ");
			if(current.right != null)
				s.push(current.right);
			if(current.left != null)
				s.push(current.left);
		}
	}
	void inorderWithMorris(Node node)
	{
		//Without stack and without Recursion. Using the concept of adding current node to the right child of left tree.
		if(node == null)
			//Checking if node is null.. If root is null, exit
			return;
		Node pre;
		//pre pointer is for storing node`s procedessor and current to store current node
		Node current = node;
		//Loop until current is null
		while(current != null)
		{
			//If left is null, that means current node is printed. And then starts traversing right part of the current.
			if(current.left == null)
			{
				System.out.print(current.key + "  ");
				current = current.right;
			}
			else
			{	//Setting pre as left node of current.
				pre = current.left;
				//Finding pre so that root can be added to rightmost child of left subtree
				while(pre.right != null && pre.right != current)
				{
					pre = pre.right;
				}
				//If pre of right is null, means we need to add the current to rightmost child which is pre. 
				if(pre.right == null)
				{
					pre.right = current;
					current = current.left;
				}
				else
				{
					//If right of pre is same as current, meaning all left is traversed, now print the current and move to right part of current for traversing. 
					pre.right = null;
					System.out.print(current.key + "  ");
					current = current.right;
				}
			}
		}
	}
	//Preorder Traversal using Morrris Theorem
	void preorderWithMorris(Node node)
	{
		//Creating current object to traverse and node which will be processed.
		Node current;
		//If node is null, Return as no object to traverse.
		if(node ==  null)
			return;
		//Loop until node which is processed is null
		while(node != null)
		{
			// If node left is null, then print the node and set the nose to right for traversing right part of tree.
			if(node.left  == null)
			{
				System.out.print(node.key + "  ");
				node =  node.right;
			}
			else
			{
				//If left is not null, Initialize the left to current so that we can point the root to the right most child of left sub-tree.
				current = node.left;
				//Find the right most child and check if root is already being pointed by right child
				while(current.right != null && current.right != node)
				{
					current = current.right;
				}
				//If root is not being pointed by right child, print the root and add link to right child and change node points to left child for further traversing.
				if(current.right == null)
				{
					System.out.print(node.key + "  ");
					current.right = node;
					node = node.left;
				}
				else
				{
					//If right child of left tree already points to node, remove the link and add the node as node right child
					current.right = null;
					node = node.right ;
				}		
			}
		}
	}
	//Post Order traversal using two stacks
	void postorderTraversalWithTwoStacks(Node node)
	{
		//Return if node is null. No need to traverse
		if(node == null)
			return;
		//Two stacks . First to add unprocessed and second to add processed 
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node current;
		//Pushing the Root node to Stack 1
		s1.push(node);
		//Loop until first stack is empty. 
		while(!s1.empty())
		{
			//Pop from s1 and push first left and right. Here order is reverse as we are pushing it to another stack. Then it will form correct. 
			current = s1.pop();
			if(current.left != null)
				s1.push(current.left);
			if(current.right != null)
				s1.push(current.right);
			s2.push(current);
		}
		//Pop all elements from stack 2 and print the node data
		while(!s2.isEmpty())
		{
			System.out.print(s2.pop().key + "  ");
		}
	}
	//Post order traversal using one stack
	void postorderUsingOneStack(Node node)
	{
		//If node is null, return as no traversal
		if(node == null)
			return;
		//Creation of stack and pushing the root to stack.
		Stack<Node> s = new Stack<Node>();
		s.push(node);
		Node prev = null;
		Node current;
		//Loop until stack is not empty
		while( ! s.isEmpty())
		{
			//Check the current element. Compare it with prev
			current = s.peek();
			//If prev is null, means, this is root. We can push left elements or right if left are not present. If both are not there, then pop and print. 
			if(prev == null || prev.left == current || prev.right == current)
			{
				if(current.left != null)
					s.push(current.left);
				else if(current.right != null)
					s.push(current.right);
				else
				{
					System.out.print(current.key + "  ");
					s.pop();
				}
				
			}
			//If previous element points to left, that means left is processed, now we can process right part
			//If right is not there, then we can traverse root.
			else if(current.left == prev)
			{
				if(current.right != null)
				{
					s.push(current.right);
				}
				else
				{
					System.out.print(current.key + "  ");
					s.pop();
				}
			}
			//If right is prev, that means child is processed already. Now pop and traverse.
			else if(current.right == prev)
			{
				System.out.print(current.key + "  ");
				s.pop();
			}
			prev = current;
		}
	}
	void printReverseLevelOrderTraversal(Node node)
	{
		//This method calls the another method for each level to print the nodes at current Level
		//Since this method needs to print nodes in reverse level order, so having decremental loop
		if(node == null)
			return;
		int height = this.heightOfTree(node);
		for(int i=height-1; i >=0; i--)
		{
			printNodesAtGivenLevel(node, i);
		}
	}
	void printNodesAtGivenLevel(Node node, int level)
	{
		//This method print the nodes at any given level by moving to child and decreementing the level.
		if(level == 0)
			System.out.print(node.key + "  ");
		else
		{
			if(node.left != null)
				this.printNodesAtGivenLevel(node.left, level- 1);
			if(node.right != null)
				this.printNodesAtGivenLevel(node.right, level - 1);
		}
	}
	int heightOfTree(Node node)
	{
		//Recursive method to find height of tree
		if(node == null)
			return 0;
		return(Math.max(this.heightOfTree(node.left),this.heightOfTree(node.right)) + 1);	
	}
	// Reverse Level Order Traversal using Queues and Stack. 
	void printReverseLevelOrderTraversalUsingQueues(Node node)
	{
		//Idea here is do level order using queues and then insert all into Stack to reverse. And print all stack elements
		if(node == null)
			return;
		//Stack and Queue creation of Node type. 
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();
		
		//Adding current node to queue.
		q.add(node);
		Node current;
		
		//Loop until queue is not empty
		while( ! q.isEmpty())
		{
			//For every iteration,remove one element from queue and push its right and then left child in queue. 
			current = q.remove();
			s.push(current);
			
			if(current.right != null)
				q.add(current.right);
			if(current.left != null)
				q.add(current.left);
		}
		
		//Print all the elements from stack. 
		while( ! s.isEmpty())
		{
			System.out.print(s.pop().key + "  ");
		}
	}
	int findIndexInArray(int arr[], int element , int n)
	{
		for(int i = 0; i <n ; i++)
		{
			if(arr[i] == element)
				return i;
		}
		return -1;
	}
	//Constructing post order traversal from in order and Pre order traversals
	void findPostOrderTraversalFromInorderAndPreOrderTraversal(int inorder[], int preorder[] , int total)
	{
		// Element which is at 0 position in pre order will be root. 
		int root = preorder[0];
		//finding the same element in order. All elements left in inorder will be left tree and for right, will be right tree
		int index = this.findIndexInArray(inorder, root, total);
		int temp_arr[] = new int[total] ;
		//If index is 0, that means no elements in left tree
		if(index != 0)
		{
			//If left tree exists, then extracting the left tree inorder and preorder
			System.arraycopy(preorder, 1, temp_arr, 0, total -1);
			this.findPostOrderTraversalFromInorderAndPreOrderTraversal(inorder, temp_arr, index);
		}         
		int temp_inorder [] = new int[total];
		int temp_preorder [] = new int[total];

		//If root is last element in array, then no sub - right tree exists
		if(index != total - 1)
		{
			//Extracting the right inorder and pre order tree and calling the function recurssively. 
			System.arraycopy(inorder, index +1 , temp_inorder, 0 , total - index - 1  );
			System.arraycopy(preorder, index+1 , temp_preorder, 0 , total - index -1 );
			this.findPostOrderTraversalFromInorderAndPreOrderTraversal(temp_inorder, temp_preorder, total - index -1);
		}
		System.out.print(preorder[0] + "  ");
	}
	void printLevelOrderTraversalUsingTwoQueues(Node node)
	{
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		
		if(node == null)
			return;
		q1.add(node);
		Node current;
		
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			while(!q1.isEmpty())
			{
				current = q1.remove();
				if(current.left != null)
					q2.add(current.left);
				if(current.right != null)
					q2.add(current.right);
				
				System.out.print(current.key);
			}	
			System.out.println("");
			while(!q2.isEmpty())
			{
				current = q2.remove();
				if(current.left != null)
					q1.add(current.left);
				if(current.right != null)
					q1.add(current.right);
				
				System.out.print(current.key);
			}		
			System.out.println("");
		}
		
	}
	void formHashmap(Node node, HashMap<Integer,Vector<Integer>> val, int distance)
	{
		if(node == null)
			return;
		if(!val.containsKey(distance))
		{
			val.put(distance,new Vector<Integer>());
		}
		Vector<Integer> temp = val.get(distance);
		temp.addElement(node.key);
		
		val.put(distance, temp);
		
		formHashmap(node.left, val , distance-1);
		formHashmap(node.right, val, distance);
	}
	void printHashmap(HashMap<Integer,Vector<Integer>> map)
	{
		for (Entry<Integer, Vector<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }
	}
	// This Method will print the Tree Diagnolly using hashmap.
	void printTreeDiagnolUsingHashMap(Node node)
	{
		
		HashMap<Integer,Vector<Integer>> map = new HashMap<>();
		
		formHashmap(node,map,0);
		printHashmap(map);
		
	}
	//Printing the Diagonal Traversal using Queues and Iteration
	void printTreeDiagnolUsingIterationAndQueues(Node node)
	{
		if(node == null)
			return;
		//If node is null, no traversal required.
		//queue creation and adding root to qurue. Adding null to queue after root.
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		queue.add(null);
		Node temp;
		//Temp node.
		while(! queue.isEmpty())
		{
			//Loop will execute if there is any element in the queue. 
			int is_new_line=0;
            temp = queue.poll();

            //If element is null in queue, that means new line as it is new diagnol.
			while(temp == null)
			{
				is_new_line=1;
				if(queue.isEmpty())
					return;
				temp = queue.poll();
	
			}
			if(is_new_line == 1)
			System.out.println();
			
			//Printing all right elements as all are in same diagonal and pushing all left elements in the queue.
			while(temp != null)
			{
				System.out.print(temp.key);
				if(temp.left != null)
					queue.add(temp.left);
				temp = temp.right;
			}
			queue.add(null);
		}
		
	}
	//Inorder Traversal without Recurssion and queue
	void inorderTraversalWithoutRecurssionIteration(Node node)
	{
		//If node is null, no need to traverse.
		if(node == null)
		{
			return;
		}
		//Lefttraverse flag to track if left sub tree is already traversed.
		boolean leftTraverse = false;
		//Loop until current node is not null
		while(node!=null)
		{
			//Move to left most node if left traverse flag is false.
			while(leftTraverse==false && node.left!=null)
				node=node.left;
		
		//As we reached to left node, enable flag and print value.
		leftTraverse=true;
		System.out.print(node.key + " ");
		//If right sub tree is there, set left traverse as false. As right sub tree might again have left sub tree.
		if(node.right != null)
		{
			leftTraverse=false;
			node=node.right;
		}
		//If right tree is empty, then moving to parent, here we are moving to until parent is not null or current node is not the right child.
		else if(node.parent!=null)
		{
			while(node.parent!=null && node.parent.right==node)
				node=node.parent;
			if(node.parent==null)
				return;
			//Moving to parent. Back tracking
			node=node.parent;
		}
		else
			return;
		}
	}
	void formHashmapForVerticalTraversal(Node node, TreeMap<Integer,Vector<Integer>> val, int distance)
	{
		if(node==null)
		{
			return;
		}
		if(!val.containsKey(distance))
		{
			val.put(distance, new Vector<Integer>());
		}
		Vector<Integer> temp = val.get(distance);
		temp.add(node.key);
		val.put(distance, temp);
		
		formHashmapForVerticalTraversal(node.left, val, distance-1);
		formHashmapForVerticalTraversal(node.right,val,distance+1);	
		
	}
	void printTreemap(TreeMap<Integer,Vector<Integer>> map)
	{
		for (Entry<Integer, Vector<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }
	}
	void printVerticalTraversal(Node node)
	{
		TreeMap<Integer,Vector<Integer>> map = new TreeMap<>();
		
		formHashmapForVerticalTraversal(node, map, 0);
		printTreemap(map);

	}
	//Printing Left most part of binary tree
	void printleftmostBinaryPart(Node node)
	{
		//If left is present then move to left part otherwise move to right if avaialble. 
		while(node.left!=null || node.right!=null)
		{
			System.out.print(node.key + "  ");
			if(node.left!=null )
				node =node.left;
			else
				node=node.right;				
		}
	}
	//Print leaf nodes of sub tree
	void printLeafNodes(Node node)
	{
		if(node==null)
			return;
		//Recursion for printing left most tree`s leaf nodes and then right part leaf nodes.
		printLeafNodes(node.left);
		if(node.left==null && node.right==null)
			System.out.print(node.key + "  ");
		printLeafNodes(node.right);
			
		
	}
	//Printing Right most part of tree in top bottom order
	void printRightMostPartBottomTop(Node node)
	{
		if(node==null)
			return;
		//check if node right is not null, If null, then nodes left part of right most of the tree
		if(node.right!=null)
		{
			printRightMostPartBottomTop(node.right);
			System.out.print(node.key + " ");
		}
		else if(node.left!=null)
		{
			printRightMostPartBottomTop(node.left);
			System.out.print(node.key + " ");
		}
	}
	//Printing Boundary for binary tree
	void printBoundaryBinaryTree(Node node)
	{
		if(node==null)
			return;
		//Boundary is formed using three types of node, Left most part with top to bottom traversing, Leaf nodes with left to right traversing
		//And Right most part with bottom to up order.
		this.printleftmostBinaryPart(node);
		
		this.printLeafNodes(node.left);
		this.printLeafNodes(node.right);
		
		this.printRightMostPartBottomTop(node);
	}
	public static void main(String args [])
	{
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(4);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(1);
		bt.root.right = new Node(2);
		bt.root.right.left = new Node(9);
		bt.root.right.right = new Node(7);
		
		System.out.println("Inorder Traversal of Binary Tree ");
		bt.inorder(bt.root);
		
		System.out.println(" \n Preorder Traversal of Binary Tree ");
		bt.preorder(bt.root);
		
		System.out.println("\n PostOrder Traversal of Binary Tree ");
		bt.postorder(bt.root);
		
		System.out.println("\n Using Stack Inorder Traversal");
		bt.inorderWithStack(bt.root);
		
		System.out.println("\n Using morrris therorm Inorder Traversal");
		bt.inorderWithMorris(bt.root);

		System.out.println("\n Using Stack Preorder Traversal");
		bt.preorderwithstack(bt.root);
		
		System.out.println("\n Using morris theorem  Preorder Traversal");
		bt.preorderWithMorris(bt.root);
		
		System.out.println("\n Postorder traversal using two stacks");
		bt.postorderTraversalWithTwoStacks(bt.root);
		
		System.out.println("\n Postorder traversal using one stack");
		bt.postorderUsingOneStack(bt.root);
		
		System.out.println("\n Reverse Level order Traversal");
		bt.printReverseLevelOrderTraversal(bt.root);
		
		System.out.println("\n Reverse Level order Traversal Using stack and queue");
		bt.printReverseLevelOrderTraversalUsingQueues(bt.root);
		
	    System.out.println("\n PostOrder From PreOrder and InOrder");
		int inorder[] ={3,4,1,5,9,2,7};
		int preorder[] = {5,4,3,1,2,9,7};
		bt.findPostOrderTraversalFromInorderAndPreOrderTraversal(inorder , preorder, 7);
		
		System.out.println("\n Print Level Order Traversal using Two Queues");
		bt.printLevelOrderTraversalUsingTwoQueues(bt.root);
		
		System.out.println("\n Printing Diagnol Traversal of tree");
		bt.printTreeDiagnolUsingHashMap(bt.root);
		
		System.out.println("\nPrinting Diagnol Traversal using iteration");
		bt.printTreeDiagnolUsingIterationAndQueues(bt.root);

		//Extra field parent for inorder traversing without recurssion and Iteration
		bt.root.left.parent=bt.root;
		bt.root.left.left.parent=bt.root.left;
		bt.root.left.right.parent=bt.root.left;
		bt.root.right.parent=bt.root;
		bt.root.right.left.parent=bt.root.right;
		bt.root.right.right.parent=bt.root.right;
		
		System.out.println("\n Inorder Traversal Without using stacks and recurssions.");
		bt.inorderTraversalWithoutRecurssionIteration(bt.root);
		
		System.out.println("\n \n Vertical traversal of binary tree");
		bt.printVerticalTraversal(bt.root);
		
		System.out.println("\n Boundary traversal for binary tree");
		bt.printBoundaryBinaryTree(bt.root);
	}
}
