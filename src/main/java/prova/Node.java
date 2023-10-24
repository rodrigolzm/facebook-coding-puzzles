package prova;

import java.util.ArrayList;
import java.util.List;

public class Node {

	int data;
	List<Node> children;

	public Node(int data) {
		this.data = data;
	}

	public void add(Node node) {
		if (children == null)
			children = new ArrayList<Node>();
		children.add(node);
	}

}
