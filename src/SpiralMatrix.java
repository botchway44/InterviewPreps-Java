import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class SpiralMatrix {

	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		System.out.println(matrix.length);
		findSpiralMatrix(matrix);
		
//		for(int i=0; i<matrix[0].length; i++) {
//			for(int j=0; j<matrix.length; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//		}
	}
	

	private static void findSpiralMatrix(int[][] matrix) {
		HashSet<Integer> seen = new HashSet<>();
		Stack<Node> paths = new Stack<>();
		ArrayList<Integer> path = new ArrayList<>();
		Node node = new Node(0,0, matrix[0][0],"RIGHT");
		paths.add(node);
		findSpiralMatrixHelper(matrix,seen,paths,path);
		
		
	}
	
	private static void findSpiralMatrixHelper(
						int[][] matrix,
						HashSet<Integer> seen,
						Stack<Node> paths,
						ArrayList<Integer> path
						) {
		
		if(paths.isEmpty()) {
			//stop exploring
		}
		
		//pick the current path on the stack
		Node node = paths.pop();
		//add value of the node to seen
		seen.add(node.value);
		path.add(node.value);
		System.out.println(" Value >> "+node.value);
		//explore the next paths
		String direction = node.direction;
		int width = matrix[0].length;
		int height = matrix.length;
		int x_pos = node.x;
		int y_pos = node.y;
		System.out.println("IN >> "+node.value+" x="+x_pos+" y="+y_pos);

		//Right direction
		if(direction.compareTo("RIGHT") == 0 && node.x < width-1 && !seen.contains(matrix[y_pos][x_pos+1])) {
			//increase the x position 
			x_pos = x_pos+1;
			System.out.println("Right >> "+node.value+" x="+x_pos+" y="+y_pos);
			
		}else {
			//change direction to DOWN
			direction = "DOWN";
			
			//increase the y position
			y_pos = y_pos+1;
			System.out.println("DOWN >> "+node.value+" x="+x_pos+" y="+y_pos);

		}
		
		
		//Down direction
		if(direction.compareTo("DOWN") == 0 && node.y < height && !seen.contains(matrix[y_pos+1][x_pos+1])) {
			y_pos = y_pos+1;
		}else {
			//change direction to DOWN
			direction = "LEFT";
			
			//increase the y position
			x_pos = x_pos-1;
		}
//		
//		//Left direction
//		if(direction.compareTo("LEFT") == 0 && node.x > 0) {
//			x_pos = x_pos-1;
//		}else {
//			//change direction to DOWN
//			direction = "UP";
//			
//			//increase the y position
//			y_pos = y_pos-1;
//		}
//		
//		
//		//Up Direction
//		if(direction.compareTo("UP") == 0 && (node.y > 0 && seen.contains())) {
//			Node nd = new  Node(x_pos,y_pos, node.value,"UP");
//			
//			y_pos = y_pos-1;
//
//		}else {
//			//change direction to DOWN
//			direction = "RIGHT";
//			
//			//increase the y position
//			x_pos = x_pos+1;
//		}
		
		int val = matrix[y_pos][x_pos];
		if(!seen.contains(val)) {
			Node temp = new Node(x_pos,y_pos, val, direction);			
			paths.add(temp);
			System.out.println("SEEN >> "+node.direction);

		}
		findSpiralMatrixHelper(matrix,seen,paths,path);

	}

	

}

 class Node{
	public int x;
	public int y;
	public int value;
	public String direction;
	
	Node(int x, int y, int value,String direction){
		this.x = x;
		this.y = y;
		this.value = value;
		this.direction = direction;
	}
}
