import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BasicGraphSearchTest {

	public static void main(String[] args) {

//		BasicGraph<String> graph = new BasicGraph<>();
//		graph.addVertex("f");
//		graph.addVertex("g");
//		graph.addVertex("h");
//		graph.addVertex("i");
//		graph.addVertex("j");
//		graph.addVertex("k");
//
//		graph.addEdge("f","g");
//		graph.addEdge("f","i");
//		graph.addEdge("g","h");
//		graph.addEdge("i","g");
//		graph.addEdge("i","k");
//
//		graph.addEdge("j","i");
//
//		System.out.println(graph.toString());
//		System.out.println(graph.searchPathBFS("f", "h"));
//		System.out.println(graph.searchPathDFS("f", "h"));
//		System.out.println(graph.countConnectedNodes());
//		System.out.println(graph.countLargestConnectedNodes());


//		BasicGraph<Integer> graph = new BasicGraph<>();
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 1);
//		graph.addEdge(6, 4,5,7,8);
//		graph.addEdge(4, 6);
//		graph.addEdge(5, 6);
//		graph.addEdge(8, 6);
//		graph.addEdge(7, 6);
//		graph.addVertex(3);
//				
//		System.out.println(graph.toString());
//		System.out.println(graph.countConnectedNodes());
//		System.out.println(graph.countLargestConnectedNodes());

		
		BasicGraph<Integer> graph = new BasicGraph<>();
		graph.addEdge(0, 1,8,5);
		graph.addEdge(1, 0);
		graph.addEdge(8, 0,5);
		graph.addEdge(5, 0,8);
		
		graph.addEdge(4, 2,3);
		graph.addEdge(2, 4,3);
		graph.addEdge(3, 4,2);
				
		System.out.println(graph.toString());
		System.out.println(graph.countConnectedNodes());
		System.out.println(graph.countLargestConnectedNodes());
	}

}


class BasicGraph<T>{
	private HashMap<T,ArrayList<T>> edges;
	private HashSet<T>  vertexs;
	
	BasicGraph(){
		this.vertexs = new HashSet<>();
		this.edges = new HashMap<>();
	}
	
	public void addVertex(T vertex) {
		
		if(!this.hasVertex(vertex)) {
			this.vertexs.add(vertex);
			this.edges.put(vertex, new ArrayList<T>());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void addEdge(T vertex, T ... nodes) {
		for(T node : nodes) {
			this.addEdge(vertex, node);
		}
	}
	public void addEdge(T vertex, T node) {
		
		if(!this.hasVertex(vertex)) {
			this.addVertex(vertex);
			if(!this.hasVertex(node)) this.addVertex(node);
			
			ArrayList<T> arr = new ArrayList<T>();
			arr.add(node);
			
			this.edges.put(vertex, arr);
		}else {
			this.edges.get(vertex).add(node);
		}
	}
	public boolean hasVertex(T vertex) {
		return this.vertexs.contains(vertex);
	}
	
	public boolean hasNeighbor(T node, T neighbor){
		if( this.hasVertex(node) && this.hasVertex(neighbor)) {
			
		}
		return false;
	}

	public ArrayList<T> searchPathBFS(T start, T end){
		Queue<ArrayList<T>> queue = new LinkedList<>();
		HashSet<T> visited = new HashSet<>();
		
		if(this.hasVertex(start) && this.hasVertex(end)) {
			ArrayList<T> Tpaths = new ArrayList<>();
			Tpaths.add(start);
			
			//add start Vertex
			queue.add(Tpaths);
			
			//find the path to end
			while(!queue.isEmpty()) {
				
				//Poll path and add path to paths
				ArrayList<T> paths = (ArrayList<T>) queue.poll();
				
				System.out.println("Path " +paths.toString());

				T path = paths.get(paths.size()-1);
				if(path.equals(end)) return paths;
				
				
				if(!visited.contains(path)) {
					//get the paths
					ArrayList<T> pathsFrom = this.edges.get(path);
					
					for(T pathTo : pathsFrom) {
						ArrayList<T> newPaths = (ArrayList<T>) paths.clone();
						newPaths.add(pathTo);
						queue.add(newPaths);
					}
				}
				
			}
		}
		
		//If there are no paths return empty array
		
		
		return new ArrayList<>();
	}
	

	
	
	public ArrayList<T> searchPathDFS(T start, T end){
		Stack<ArrayList<T>> stack = new Stack<>();
		HashSet<T> visited = new HashSet<>();
		
		if(this.hasVertex(start) && this.hasVertex(end)) {
			ArrayList<T> Tpaths = new ArrayList<>();
			Tpaths.add(start);
			
			//add start Vertex
			stack.add(Tpaths);
			
			//find the path to end
			while(!stack.isEmpty()) {
				
				//Poll path and add path to paths
				ArrayList<T> paths = (ArrayList<T>) stack.pop();
				
				System.out.println("Path " +paths.toString());
				
				T path = paths.get(paths.size()-1);
				if(path.equals(end)) return paths;
				
				
				if(!visited.contains(path)) {
					//get the paths
					ArrayList<T> pathsFrom = this.edges.get(path);
					
					for(T pathTo : pathsFrom) {
						ArrayList<T> newPaths = (ArrayList<T>) paths.clone();
						newPaths.add(pathTo);
						stack.add(newPaths);
					}
				}
				
			}
		}
		
		//If there are no paths return empty array
		
		
		return new ArrayList<>();
	}
	
	
	public int countConnectedNodes() {
		int count =0;
		
		HashSet<T> seen = new HashSet<>();
		Queue<T> queue = new LinkedList<>();
		
		
		for(T path : this.vertexs) {
			//pick and explore path
//			System.out.println("PAth >> " +path );
			
			if(!seen.contains(path)) {
				//increase the disconected component by 1
				count++;
				//explore the paths to it by adding the path to the queue
				queue.add(path);
				seen.add(path);
				
				//explore the paths in the queue
				while(!queue.isEmpty()) {
					T temp = queue.poll();
					for(T pt : this.edges.get(temp)) {
						if(!seen.contains(pt)) {
							seen.add(pt);
							queue.add(pt);
						}
					}
				}

			}
			
		}
		
		return count;
	}
	

	public int countLargestConnectedNodes() {
		//counts number of disconnected nodes
		int count =0;
		
		HashSet<T> seen = new HashSet<>();
		Queue<ArrayList<T>> queue = new LinkedList<>();
		
		//A priority queue to hold list of paths returned from the search and the longest
		PriorityQueue<ArrayList<T>> traversedPaths = new PriorityQueue<>(
				new Comparator<ArrayList<T>>() {

					@Override
					public int compare(ArrayList<T> a, ArrayList<T> b) {
						return b.size() - a.size();
					}
				}
		);
		
		
		
		for(T path : this.vertexs) {
			//pick and explore path
//			System.out.println("PAth >> " +path );
			
			if(!seen.contains(path)) {
				//increase the disconected component by 1
				count++;
				//explore the paths to it by adding the path to the queue
				ArrayList<T> paths = new ArrayList<>();
				paths.add(path);
				
				queue.add(paths);
				seen.add(path);
				
				//explore the paths in the queue
				while(!queue.isEmpty()) {
					ArrayList<T> tempList = queue.poll();
					T temp = tempList.get(tempList.size()-1);
					
					for(T pt : this.edges.get(temp)) {
						if(!seen.contains(pt)) {
							seen.add(pt);
							ArrayList<T> newTempList = (ArrayList<T>) tempList.clone();
							newTempList.add(pt);
							queue.add(newTempList);
							paths.add(pt);
						}
					}
				}
				
				//save paths in traversed list
				traversedPaths.add(paths);
			}
			
		}
		
		
		for(ArrayList<T> temp : traversedPaths) {
			System.out.println(temp.toString());
		}
		
		return traversedPaths.size() > 0 ? traversedPaths.poll().size() : 0;
	}
	
	public String toString() {
		String builder = "";
		
		for(T edge : edges.keySet()) {
			ArrayList<T> paths = this.edges.get(edge);
			builder = builder + ""+edge + " -> [";
			for(T path : paths) {		
				builder = builder + ""+path+",";
			}
			builder = builder + "]\n";
 
		}
		return builder;
	}
}
