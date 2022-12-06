package grp1;
import java.util.*;
public class Tree {
	
	
	//class for nodes
	static class Node {
		Node left;
		Node right;
		int data;
		public Node(int data) {
			this.data = data;
		}
	
	//insert node into tree in order
	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			}
			else {
				left.insert(value);
			}
		}
		else {
			if (right == null) {
				right = new Node(value);
			}
			else {
				right.insert(value);
			}
		}
	}
	
	//print the values from smallest to greatest 
	public void printInOrder(int value) {
		
		if (left != null) {
			left.printInOrder(value);
		}
//		if (data == value) {
//			System.out.println("FOUND!");
//		}
		System.out.println(data);
		if (right != null) {
			right.printInOrder(value);
		}
	}
	
	
	
		// I had to look up how to print a binary tree in a somewhat legible way. 
		// the printInOrder() method was not very useful given the purpose of the assignment.
		public static void printBinaryTree(Node root)
		{
			LinkedList<Node> treeLevel = new LinkedList<Node>();
			treeLevel.add(root);
			LinkedList<Node> temp = new LinkedList<Node>();
			int counter = 0;
			int height = heightOfTree(root) - 1;
			// System.out.println(height);
			double numberOfElements = (Math.pow(2, (height + 1)) - 1);
			// System.out.println(numberOfElements);
			while (counter <= height) {
				Node removed = treeLevel.removeFirst();
				if (temp.isEmpty()) {
					printSpace(numberOfElements / Math.pow(2, counter + 1), removed);
				}
				else {
					printSpace(numberOfElements / Math.pow(2, counter), removed);
				}
				if (removed == null) {
					temp.add(null);
					temp.add(null);
				}
				else {
					temp.add(removed.left);
					temp.add(removed.right);
				}

				if (treeLevel.isEmpty()) {
					System.out.println("");
					System.out.println("");
					treeLevel = temp;
					temp = new LinkedList<>();
					counter++;
				}
			}
		}

		public static void printSpace(double n, Node removed)
		{
			for (; n > 0; n--) {
				System.out.print("\t");
			}
			if (removed == null) {
				System.out.print(" ");
			}
			else {
				System.out.print(removed.data);
			}
		}

		public static int heightOfTree(Node root)
		{
			if (root == null) {
				return 0;
			}
			return 1
				+ Math.max(heightOfTree(root.left),
						heightOfTree(root.right));
		}
		
		
		//search to find if a value exists in the tree. Uses recursion to go down the tree.
		public boolean containsOPT(int value) {
			
			if (value == data) {
				return true;
			}
			else if(value < data) {
				if (left == null) {
					return false;
				}
				else {
					return left.containsOPT(value);
				}
			}
			else {
				if (right == null) {
					return false;
				}
				else {
					return right.containsOPT(value);
				}
			}
			
		}
		

		

	}



	// Not exactly sure what you mean by "solve binary tree" So i am assuming you mean search for a value in the tree.
	public static void main(String[] args) {
		

		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		int upperbound = 100;
		
		
		
		System.out.println("How many values would you like?");
		int nodes = in.nextInt();
		
		System.out.println("What value would you like to search for?");
		int var = in.nextInt();
		
		
		Tree.Node node = new Node(50);
		
	//	Node node = new Node(nodes);
	//	Tree.Node root = new Tree.Node();
		
		
		for (int i = 0; i < nodes; i++) {
			int random = rand.nextInt(upperbound);
			node.insert(random);
		}
	//	node.printInOrder();
		Node.printBinaryTree(node);
		System.out.println(node.containsOPT(var));
	//	System.out.println(node.contains(node, 50));
	//	node.printInOrder(75);
	}

}

