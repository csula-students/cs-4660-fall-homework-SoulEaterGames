package csula.cs4660.quizes;

import csula.cs4660.graphs.Node;
import csula.cs4660.graphs.searches.Edge;
import csula.cs4660.graphs.searches.Vertex;
import csula.cs4660.quizes.models.State;

import java.util.*;

/**
 * Here is your quiz entry point and your app
 */
public class App {

    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    public static bfs(){
        List<Node> visited = new ArrayList<Node>();

        HashSet<Node> explored = new HashSet<Node>();
        explored.add(source);

        while (!visited.isEmpty()) {
            Node v = visited.get();
            visited.add(v);
            List<Node> unexploredNeighbors = new ArrayList<Node>();
            for (csula.cs4660.graphs.Edge e : v.edges) {
                Node w = e.otherNode(v);
                if (!explored.contains(w)) {
                    explored.add(w);
                    unexploredNeighbors.add(w);
                    System.out.println(explored);
                }
            }
            visited.add(unexploredNeighbors);
    }

    public static void main(String[] args) {
        // to get a state, you can simply call `Client.getState with the id`
        State initialState = Client.getState("10a5461773e8fd60940a56d2e9ef7bf4").get();
        System.out.println(initialState);
        // to get an edge between state to its neighbor, you can call stateTransition
        System.out.println(Client.stateTransition(initialState.getId(), initialState.getNeighbors()[0].getId()));
    }
}
