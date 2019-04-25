import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Graph {
private Map<Vertex, List<Vertex>> adjacencylist;


	edgeList;
	adjacencyList;
	adjacencyMatrix;

	// Method field
	numVertices();
	numEdges();
	degree(Vertex v);
	getEdge(Vertex u, Vertex v);
	endVertices(Edge e);
	public void insertVertex(String label){
		adjacencylist.putIfAbsent(new Vertex(label), new ArrayList<>());
		
	}
	
	public void insertEdge(String labelf, String labels){
		Vertex v1 = new Vertex(labelf);
		Vertex v2 = new Vertex(labels);
		adjacencylist.get(v1).add(v2);
	}
	public void removeVertex(String label){
		Vertex v = new Vertex(label);
		adjacencylist.values().stream().map(e-> e.remove(v)).collect(Collectors.toList());
		adjacencylist.remove(new Vertex(label));
	}
	public void removeEdge(String labelf, String labels) {
		Vertex v1 = new Vertex(labelf);
		Vertex v2 = new Vertex(labels);
		List<Vertex> edgeV1 = adjacencylist.get(v1);
		List<Vertex> edgeV2 = adjacencylist.get(v2);
		if(edgeV1 != null)
			edgeV1.remove(v2);
		if(edgeV2!= null)
			edgeV2.remove(v1);
	}
	
	List<Vertex> getAdjacencylists(String label) {
	    return adjacencylist.get(new Vertex(label));
	}
	// Depth first traversal
	Set<String> depthFirstTraversal(Graph graph, String root) {
	    Set<String> v_visited = new LinkedHashSet<String>();
	    Stack<String> StackZ = new Stack<String>();
	    StackZ.push(root);
	    while (!StackZ.isEmpty()) {
	        String vertex = StackZ.pop();
	        if (!v_visited.contains(vertex)) {
	            v_visited.add(vertex);
	            for (Vertex v : graph.getAdjacencylists(vertex)) {              
	                StackZ.push(v.label);
	            }
	        }
	    }
	    return v_visited;
	}
	//Breath First Traversal
	Set<String> breadthFirstTraversal(Graph graph, String root) {
	    Set<String> V_Visited = new LinkedHashSet<String>();
	    Queue<String> GraphQueue = new LinkedList<String>();
	    GraphQueue.add(root);
	    V_Visited.add(root);
	    while (!GraphQueue.isEmpty()) {
	        String vertex = GraphQueue.poll();
	        for (Vertex v : graph.getAdjacencylists(vertex)) {
	            if (!V_Visited.contains(v.label)) {
	                V_Visited.add(v.label);
	                GraphQueue.add(v.label);
	            }
	        }
	    }
	    return V_Visited;
	}
	
}
