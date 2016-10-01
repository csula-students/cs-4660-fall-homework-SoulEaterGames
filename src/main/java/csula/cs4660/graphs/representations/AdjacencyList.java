package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;
import csula.cs4660.utils.StringUtils;

import java.io.File;
import java.util.*;

/**
 * Adjacency list is probably the most common implementation to store the unknown
 * loose graph
 *
 * TODO: please implement the method body
 */
public class AdjacencyList implements Representation {
    private Map<Node, Collection<Edge>> adjacencyList;
    List<Node> nodes;

    // add to a list of nodes

    public AdjacencyList(File file) {
        Scanner input = new Scanner(file);

        String line;
        while ((line = input.nextLine()) != null) {
            // process the line.
            if (line.equals(":")) {
                // Do something with first line
                line = input.nextLine();
                // Split up the third line by space
                String split[]= StringUtils.split(line); // split[1] = "Mozart," so you may need to do a little more work there
            }
        }
        input.close();


    }

    public AdjacencyList() {

    }

    @Override
    public boolean adjacent(Node x, Node y) {
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
        return null;
    }

    @Override
    public boolean addNode(Node x) {
        return false;
    }

    @Override
    public boolean removeNode(Node x) {
        return false;
    }

    @Override
    public boolean addEdge(Edge x) {
        return false;
    }

    @Override
    public boolean removeEdge(Edge x) {
        return false;
    }

    @Override
    public int distance(Node from, Node to) {
        return 0;
    }

    @Override
    public Optional<Node> getNode(int index) {
        return null;
    }
}
