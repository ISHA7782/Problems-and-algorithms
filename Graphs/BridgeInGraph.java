import java.util.Iterator;
import java.util.LinkedList;

public class BridgeInGraph {
	// Vertices - Total number of Vertices , time - total time to reach vertex. for level 0, time - 0  
	int Vertices;
	int time;
	
	// Adjacency Vertex for each Vertex 
	LinkedList<Integer> adjacency_vertices[]; 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	//Constructor
	BridgeInGraph( int number_of_vertices)
	{
		//Initialization of Vertices along with there adjacency list 
		Vertices = number_of_vertices;
		adjacency_vertices = new LinkedList[number_of_vertices];
		for( int i = 0 ;i < number_of_vertices; i++)
			adjacency_vertices[i]= new LinkedList();
	}
	
	// Adding vertex to adjacency list 
	void add_edges_to_vertex(int Vertex1, int Vertex2)
	{
		adjacency_vertices[Vertex1].add(Vertex2);
		adjacency_vertices[Vertex2].add(Vertex1);
	}
	
	//function to find if vertex is articulation point of Graph or not
	void bridge(int current, boolean [] visited, int [] disc, int [] low, int [] parent)
	{
		//Initialization of lowest time, disc time, and visited array 
		visited[current] = true;
		disc[current] = low[current] = ++time;
		
		//Iterating all the child vertices of current Vertex
		Iterator<Integer> i = adjacency_vertices[current].iterator();
		while(i.hasNext())
		{
			int vertex  = i.next();
			
			//If vertex is not yet visited, we are adding it as children for current and calling the function for its child 
			if(!visited[vertex])
			{
				parent[vertex] = current;
				
				bridge(vertex, visited, disc, low, parent);
				
				//This is required to check the case if current vertex `s child has some back connection to one of the ancestor of current
				low[current] = Math.min(low[current], low[vertex]);		

				// A edge will be bridge if it is only connect point from ancestors and current to Vertex and childs.
				if(low[vertex] >  disc[current])
					System.out.println(current + " , " + vertex);
			}
			else if(vertex != parent[current])
				low[current]  = Math.min(low[current], disc[vertex]);
			//Setting the value of low with lowest value which can be set from its current value of if any of the child have back connection updating the low value
		}
	}
	void getCutVertices()
	{
		//Initialization the arrays for storing is_visited , parents, low time etc
		boolean visited [] = new boolean[Vertices];
		int disc[] = new int[Vertices];
		int low[] = new int[Vertices];
		int parent[] = new int[Vertices];
		
		for(int i = 0 ;i<Vertices; i++)
		{
			visited[i] = false;
			parent[i] = -1;
		}
		
		//Recursive call for all vertices to check Bridges
		for(int i = 0 ; i < Vertices; i++)
		{
			if(visited[i] == false )
				bridge(i, visited, disc, low, parent);
		}

	}
	
	
	public static void main(String args[])
	{
		// Main function to initialize the graph along with edges.Calling function to check bridges.
		BridgeInGraph graph_obj = new BridgeInGraph(6);
		graph_obj.add_edges_to_vertex(0, 5);
		graph_obj.add_edges_to_vertex(0, 1);
		graph_obj.add_edges_to_vertex(1, 3);
		graph_obj.add_edges_to_vertex(1, 2);
		graph_obj.add_edges_to_vertex(2, 3);
		graph_obj.add_edges_to_vertex(5, 4);

		System.out.println("Bridges in  Graphs ");
		graph_obj.getCutVertices();	
		
	}
}
