package org.psk.playground;

/**
 * Bastille Agency coding test Part 3.
 * Node class that holds references to 3 neighbours. Implements Comparable but this isn't currently used. 
 */
public class Node implements Comparable<Node> {
	
	@Override
	public String toString() {
		return String.join(" | ", "Hash " + hashCode(), "Has a link? " + HasLink(), Url);
	}
	
	/**
	 * Unused except in toString
	 * @return whether this node has a non-null link to another node
	 */
	public Boolean HasLink() {
		return A != null || B != null || C != null;
	}
	
	public Node(Node a, Node b, Node c, String url) {
		super();
		A = a;
		B = b;
		C = c;
		Url = url;
	}

	// Make the Nodes public & final. Java's best effort at read-only getters IMO.
	public final Node A;
	public final Node B;
	public final Node C;
	public final String Url;
	
	// Not currently used
	@Override
	public int compareTo(Node arg0) {
		if (this == arg0)
			return 0;
		
		return 1;
	}
	
}
