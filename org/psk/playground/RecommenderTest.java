package org.psk.playground;

import java.util.Collection;

public class RecommenderTest {

	public static void main(String[] args) {
		Recommender r = new Recommender();
		
		RecommenderTest t = new RecommenderTest();
		Node g = t.testBuildGraph();
		
		Collection<String> urls = r.getRecs(g);
		
		for (String u : urls) {
			System.out.println("Recommended URL: " + u);
		}
	}

	private Node testBuildGraph() {
		Node n1 = new Node(null, null, null, "www.google.com/1");
		Node n2 = new Node(n1, null, null, "www.google.com/2");
		Node n3 = new Node(n1, n2, null, "www.google.com/3");

		Node n4 = new Node(n3, null,null, "www.google.com/4");
		Node n5 = new Node(n3, n4, null, "www.google.com/5");
		Node n6 = new Node(n3, n4, n5, "www.google.com/6");

		Node n7 = new Node(n6, null, null, "www.google.com/7");
		Node n8 = new Node(n6, n7, null, "www.google.com/8");
		Node n9 = new Node(n6, n7, n8, "www.google.com/9");
		
//		Node root = new Node(n1, n4, n6, "www.google.com/root");
		Node root = new Node(n9, n8, n7, "www.google.com/root");
		return root;
	}
}
