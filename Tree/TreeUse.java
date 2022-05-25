package Tree;

import Queue.QueueEmptyException;
import Queue.QueueUsingLL;
import java.util.Scanner;

public class TreeUse {
	public static TreeNode<Integer> treeInput(Scanner sc){
		
		System.out.println("Enter next Node");
		int n = sc.nextInt();
		
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		
		System.out.println("Enter number of children of "+ n);
		int childCount = sc.nextInt();
		
		for(int i=0; i<childCount; i++) {
			TreeNode<Integer> child= treeInput(sc);
			root.children.add(child);
		}
		return root;
		
	}
	
	public static void treeOutput(TreeNode<Integer> root){
		String s = root.data + ":";
		for(int i=0; i<root.children.size(); i++) {
			s = s +  root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i=0; i<root.children.size(); i++) {
			treeOutput(root.children.get(i));
		}
		
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data: ");
		int rootData = sc.nextInt();
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter num of children of "+ frontNode.data);
				int numChildren = sc.nextInt();
				for(int i=0; i < numChildren; i++) {
					System.out.println("Enter " + (i +1) + "th child of" + frontNode.data);
					int child = sc.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			}catch(QueueEmptyException e) {
				//Shouldn't come here
				return null;
			}
		}
		return root;
		
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		QueueUsingLL<TreeNode<Integer>> q = new QueueUsingLL<TreeNode<Integer>>();
		TreeNode<Integer> nullNode = new TreeNode<Integer>(Integer.MIN_VALUE);
		q.enqueue(root);
		q.enqueue(nullNode);
		System.out.println(root.data + ":");
		while(q.size()!=1) {
			TreeNode<Integer> temp = null;
			try {
				temp = q.dequeue();
				
			}catch(QueueEmptyException e) {
				
			}
			if(temp == nullNode) {
				q.enqueue(nullNode);
				System.out.println();
				continue;
			}
			for(int i=0; i<temp.children.size(); i++) {
				System.out.print(temp.children.get(i).data+ " ");
				q.enqueue(temp.children.get(i));
			}
		}
	}

	public static int numberOfNodes(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int count = 1;
		for(int i=0; i<root.children.size(); i++) {
			count += numberOfNodes(root.children.get(i));
		}
		return count;
	}
	
	public static int sumOfNodes(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int sum = root.data;
		for(int i=0; i<root.children.size(); i++) {
			sum += sumOfNodes(root.children.get(i));
		}
		return sum;
	}
	
	public static int largest(TreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int node = root.data;
		for(int i=0; i<root.children.size(); i++) {
			int childNode = largest(root.children.get(i));
			if(childNode > node) {
				node = childNode;
			}	
		}
		return node;
	}
	
	public static int numNodeGreater(TreeNode<Integer> root,int x){

		if(root == null) {
			return 0;
		}
		
		int count = 0;
		if(root.data > x) {
			count++;
		}
		for(TreeNode<Integer> child : root.children) {
			count = count + numNodeGreater(child, x);
		}
		return count;
	}
	
	public static int getHeight(TreeNode<Integer> root){

		
		if(root == null) {
			return 0;
		}
		int count = 0;
		for(TreeNode<Integer> child : root.children) {
			int childHeight = getHeight(child);
			if(childHeight > count) {
				count = childHeight;
			}
		}
		return count + 1;
		
	}
	
	public static void printAtK(TreeNode<Integer> root, int k) {
		if(k < 0) {
			return;
		}
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		for(int i=0; i< root.children.size(); i++) {
			printAtK(root.children.get(i), k-1);
		}
	}
	
	public static int countLeafNodes(TreeNode<Integer> root){

		if(root == null) {
			return 0;
		}
		if(root.children.size() == 0) {
			return 1;
		}
		int count = 0;
		for(TreeNode<Integer> child : root.children) {
			count += countLeafNodes(child);
		}
		return count;

	}
	
	public static void preOrder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		for(int i=0; i<root.children.size(); i++) {
			preOrder(root.children.get(i));
		}
	}
	
	public static void printPostOrder(TreeNode<Integer> root){
		if(root == null) {
			return;
		}
		
		for(int i=0; i<root.children.size(); i++) {
			printPostOrder(root.children.get(i));
		}
		
		System.out.print(" " + root.data);
	}
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		TreeNode<Integer> root = treeInput(sc);
		
		TreeNode<Integer> root = takeInputLevelWise();
//		
//		printLevelWise(root);
 		
//		System.out.println(numberOfNodes(root));
//		System.out.println(sumOfNodes(root));
		
//		System.out.println(largest(root));
		
//		System.out.println(numNodeGreater(root, 35));
		
//		System.out.println(getHeight(root));
//		printAtK(root,2);
		System.out.println(countLeafNodes(root));
		preOrder(root);
		System.out.println();
		printPostOrder(root);
		
//		treeOutput(root);
		
		
//		TreeNode<Integer> root = new TreeNode<Integer>(4);
//		TreeNode<Integer> node1 = new TreeNode<Integer>(2);
//		TreeNode<Integer> node2 = new TreeNode<Integer>(3);
//		TreeNode<Integer> node3 = new TreeNode<Integer>(6);
//		TreeNode<Integer> node4 = new TreeNode<Integer>(5);
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);
//		
//		System.out.println(root);
	}

}







	



