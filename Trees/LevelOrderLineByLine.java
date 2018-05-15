
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {

	Node root;
	public LevelOrderLineByLine()
	{
		root = null;
	}
	
	public void levelordertraversal(Node roott)
	{
		int height = height(roott);
		for (int i = 1; i <= height; i ++)
		{
			printNodesAtGivenLevel(roott, i);
			System.out.println();
		}
	}
	
	public void printNodesAtGivenLevel(Node node, int level)
	{
		if (node == null)
			return;
		if(level == 1)
			System.out.print(node.key + "  ");
		else
			printNodesAtGivenLevel(node.left, level - 1);
			printNodesAtGivenLevel(node.right, level - 1);
	}
	public int height(Node node)
	{
		if (node == null )
			return 0;
		else
			return ((Math.max(height(node.left), height(node.right))) + 1);
	}
	
	void levelOrderUsingQueues(Node node)
	{
		if(node == null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(true)
		{
			int number_of_nodes_at_current_level = q.size();
			
			if(number_of_nodes_at_current_level == 0)
				break;
			for(int i = 0 ; i < number_of_nodes_at_current_level; i ++)
			{
				Node temp = q.peek();
				System.out.print(temp.key + " ");
				q.remove();
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);		
			}
			System.out.println("");
		}
	}
	public static void main(String args [])
	{
		LevelOrderLineByLine obj = new LevelOrderLineByLine();
		obj.root = new Node(5);
		obj.root.left = new Node(4);
		obj.root.left.left = new Node(3);
		obj.root.left.right = new Node(1);
		obj.root.right = new Node(2);
		obj.root.right.left = new Node(9);
		obj.root.right.right = new Node(7);
		
		obj.levelordertraversal(obj.root);
		
		System.out.println("-----------");
		obj.levelOrderUsingQueues(obj.root);
	}
}
