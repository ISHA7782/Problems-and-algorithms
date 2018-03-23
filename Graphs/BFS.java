import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	
	public static void main(String args[])
	{
		Graph graph_obj = new Graph(6);
		graph_obj.add_edges_to_vertex(0, 5);
		graph_obj.add_edges_to_vertex(0, 4);
		graph_obj.add_edges_to_vertex(1, 5);
		graph_obj.add_edges_to_vertex(2, 4);
		graph_obj.add_edges_to_vertex(2, 0);
		graph_obj.add_edges_to_vertex(3, 2);
		graph_obj.add_edges_to_vertex(4, 3);
		graph_obj.add_edges_to_vertex(4, 0);
		graph_obj.add_edges_to_vertex(5, 2);

		BFS obj = new BFS();
		obj.BFS_traverse(graph_obj, 1);
		
	}
	
	void BFS_traverse(Graph graphobj, int source)
	{
		boolean is_traversed[] = new boolean[graphobj.Vertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		System.out.println("BFS of Given graph is - ");
		
		queue.add(source);
		int current;
		while(!queue.isEmpty())
		{
			current = queue.poll();
			if(is_traversed[current] == false )
			{
				System.out.print(current + "  ");
				is_traversed[current]=true;
				
				Iterator<Integer> i = graphobj.adjacency_vertices[current].listIterator();
				while(i.hasNext())
				{
					int vertex = i.next();
					queue.add(vertex);
				}
			}
		}
	}

}
