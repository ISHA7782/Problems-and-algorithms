import java.util.Iterator;

public class DFS {
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

		DFS obj = new DFS();
		boolean is_traversed[] = new boolean[graph_obj.Vertices];
		System.out.println("DFS of Given graph is - ");
		
		obj.DFS_traverse(graph_obj, 1 , is_traversed);
		
	}
	
	void DFS_traverse(Graph graphobj, int source, boolean [] is_traversed)
	{
		
		if(is_traversed[source] == false )
		{
			System.out.print(source + "  ");
			is_traversed[source]=true;
			
			Iterator<Integer> i = graphobj.adjacency_vertices[source].listIterator();
			while(i.hasNext())
			{
				int vertex = i.next();
				DFS_traverse(graphobj, vertex, is_traversed);
			}
		}
	}
}
