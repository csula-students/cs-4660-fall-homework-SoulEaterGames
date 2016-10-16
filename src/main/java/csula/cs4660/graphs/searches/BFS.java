package csula.cs4660.graphs.searches;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BFS implements SearchStrategy {
    @Override
    public List<Edge> search(Graph graph, Node source, Node dist) {

        List<Node> visited = new ArrayList<Node>();

        HashSet<Node> explored = new HashSet<Node>();
        explored.add(source);

        while (!visited.isEmpty()) {
            Node v = visited.get();
            visited.add(v);
            List<Node> unexploredNeighbors = new ArrayList<Node>();
            for (Edge e : v.edges) {
                Node w = e.otherNode(v);
                if (!explored.contains(w)) {
                    explored.add(w);
                    unexploredNeighbors.add(w);
                    System.out.println(explored);
                }
            }
            visited.add(unexploredNeighbors);
        }
        return visited;
    }


}
