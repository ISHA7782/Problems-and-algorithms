
public class LevelOrderTraversal {

	Node root;
	LevelOrderTraversal()
	{
		root = null;
	}
	int get_length(Node root)
	{
		if(root == null)
			return 0;
		else
		{
			return(Math.max(get_length(root.left), get_length(root.right)) + 1);
		}
	}
	void printNodesAtLevel(Node root, int level)
	{
		if(root == null)
			return;
		else
		{
			if(level == 0)
				System.out.println(root.data + "  ");
			else
			{
				printNodesAtLevel(root.left, level -1);
				printNodesAtLevel(root.right, level - 1);
			}
		}
	}
	void printLevelOrderTraversal()
	{
		int length = get_length(root);
		for(int i = 0; i < length ; i++)
			printNodesAtLevel(root, i);
	}
	
	public static void main(String args [])
	{
		LevelOrderTraversal obj = new LevelOrderTraversal();
		obj.root =  new Node(0);
		obj.root.left = new Node(1);
		obj.root.right = new Node(2);
		obj.root.left.left = new Node(3);
		obj.root.right.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.left.right = new Node(7);

		
		obj.printLevelOrderTraversal();
	}
}
