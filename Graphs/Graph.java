import java.util.*;


public class Graph {
	int Vertices;
	LinkedList<Integer> adjacency_vertices[]; 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Graph( int number_of_vertices)
	{
		Vertices = number_of_vertices;
		adjacency_vertices = new LinkedList[number_of_vertices];
		for( int i = 0 ;i < number_of_vertices; i++)
			adjacency_vertices[i]= new LinkedList();
	}
	void add_edges_to_vertex(int Vertex1, int Vertex2)
	{
		adjacency_vertices[Vertex1].add(Vertex2);
	}
}
