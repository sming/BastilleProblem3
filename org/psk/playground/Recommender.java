package org.psk.playground;

import java.util.HashSet;
import java.util.Set;

/**
 * *** Bastille Agency coding test Part 3.***
 * Class that provides URL recommendations given a start node and a desired "distance" from that node.
 */
public class Recommender {
	private static int DEFAULT_DESIRED_DISTANCE = 3;
	
	/**
	 * Pass in a root node and get recommendations DEFAULT_DESIRED_DISTANCE hops away.
	 *
	 * Main public interface for the Recommender. "Go and get all recommendations 3 hops away from here".
	 * See overload below for more discussion.
	 *  
	 * @param rootNode - node from which to start searching
	 * @return - list of URLs
	 */
	public Set<String> getRecs(Node rootNode) {
		return getRecs(rootNode, DEFAULT_DESIRED_DISTANCE);
	}

	/**
	 * Uses Set for maximal implementation flexibility i.e. we can change backing impl and not affect clients, 
	 * while still informing them that the strings will be unique. 
	 * Provide nice return value rather than having client having to new-up collection before calling. This also
	 * enables "fluent" syntax calls and hides recursive nature of adopted algorithm.
	 *  
	 * @param rootNode - node from which to start searching
	 * @return - list of URLs
	 */
	public Set<String> getRecs(Node node, int desiredDistance) {
		
		// TODO determine a sensible maximum for desiredDistance to protect from blowing through the Java stack size limit.
		
		//	 * Use HashSet for O(1) insertions whilst ensuring uniqueness
		Set<String> urls = new HashSet<String>();
		getRecs(urls, node, 0, desiredDistance);
		return urls;
	}
	
	/**
	 * Recurses through the graph in a breadth-first fashion. TBH I haven't done the analysis as to whether depth-first would
	 * be better or not.
	 * Yes, recursion is a dirty word in some eyes but we're only going 3 hops down the graph by default. See above TODO about protecting
	 * against excessive number of hops.
	 * 
	 * @param urls - must be a non-null, empty collection into which the recommended URLs will be put
	 * @param node - node in the graph from which to start
	 * @param currentDistance - how far we are from root
	 * @param desiredDistance - the number of hops away from root we're looking for
	 */
	private void getRecs(Set<String> urls, Node node, int currentDistance, int desiredDistance) {
		if (node == null)	// can't go any further through the graph
			return;

		// woo-hoo we found one exactly desiredDistance away. Stop recursion since we've either seen its neighbours before
		// (< desiredDistance) or we're not interested in ones further away (> desiredDistance)
		if (currentDistance == desiredDistance) {	
			urls.add(node.Url);
			return;
		}
		
		// we know that currentDistance is < desiredDistance so keep going to explore the graph
		getRecs(urls, node.A, currentDistance + 1, desiredDistance);
		getRecs(urls, node.B, currentDistance + 1, desiredDistance);
		getRecs(urls, node.C, currentDistance + 1, desiredDistance);
	}
}
