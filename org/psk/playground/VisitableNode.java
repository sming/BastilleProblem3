package org.psk.playground;

public class VisitableNode extends Node {
	@Override
	public String toString() {
		return String.join(" | ", super.toString(), visited ? "visited" : "not visited");
	}

	public VisitableNode(Node a, Node b, Node c, String url) {
		super(a, b, c, url);
	}
	
	public boolean visited = false;
	public int distance = 0;
}
/* public class VisitableNode  implements Comparable<Node> {
	
	public VisitableNode(Node node) {
		super();
		this.node = node;
		this.visited = false;
	}
	
	@Override
	public int compareTo(Node o) {
		return node.compareTo(o);
	}

	public final Node node;
	public final boolean visited;
}
*/