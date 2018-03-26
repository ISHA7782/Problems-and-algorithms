import java.util.Iterator;
import java.util.Stack;

public class TopoligicalSort {

	public static void main(String args[])
	{
		Graph graph_obj = new Graph(6);
		graph_obj.add_edges_to_vertex(5, 2);
		graph_obj.add_edges_to_vertex(5, 0);
		graph_obj.add_edges_to_vertex(4, 0);
		graph_obj.add_edges_to_vertex(4, 1);
		graph_obj.add_edges_to_vertex(2, 3);
		graph_obj.add_edges_to_vertex(3, 1);
		TopoligicalSort obj = new TopoligicalSort();
		obj.topoligicalSort(graph_obj);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void topoligicaltraversal(Graph graph_obj, Stack stk, int i , boolean is_visited[])
	{
		is_visited[i] = true;
		
		Iterator<Integer> j = graph_obj.adjacency_vertices[i].iterator();
		int vertex;
		while(j.hasNext())
		{
			vertex = j.next();
			if(is_visited[vertex] != true)
				topoligicaltraversal(graph_obj,stk, vertex,  is_visited);
		}
		
		stk.push(i);
	}
	@SuppressWarnings("rawtypes")
	void topoligicalSort(Graph graph_obj)
	{
		Stack stk = new Stack();
		 
		boolean is_visited[] = new boolean[graph_obj.Vertices];
		for( int i = 0 ; i < graph_obj.Vertices ; i++)
		{
			if(is_visited[i] != true)
				topoligicaltraversal(graph_obj, stk, i , is_visited);
		}
		while(!stk.isEmpty())
		{
			System.out.println(stk.pop());
		}
	}
}
