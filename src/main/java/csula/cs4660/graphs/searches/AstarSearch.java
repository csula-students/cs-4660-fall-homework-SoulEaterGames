package csula.cs4660.graphs.searches;


import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Perform A* search
 */

class Vertex implements Comparable<Vertex> {
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String argName)
    {
        name = argName;
    }

    public String toString()
    {
        return name;
    }

    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}

public class AstarSearch implements SearchStrategy {

    @Override
    public List<Edge> search(Graph graph, Node source, Node dist) {
        return null;
    }

    public static void computePaths(Vertex source, Vertex goal) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);
        boolean found = false;
        while (!vertexQueue.isEmpty()&&(!found)) {
            Vertex u = vertexQueue.poll();
            vertexQueue.add(u);
            if(source.minDistance==goal.minDistance)
            {
                found=true;
            }
            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                double distanceThroughV  = distanceThroughU + v.minDistance;
                if((vertexQueue.contains(v)) &&
                        (distanceThroughV >= v.minDistance)){
                    continue;
                }
				/*else if v node is not in vertexQueue or
                 newer f_score is lower*/
                else if((!vertexQueue.contains(v)) ||
                        (distanceThroughV  < v.minDistance)){
                    // v.minDistance = u;
                    v.minDistance = distanceThroughU;
                    v.minDistance = distanceThroughV ;
                    if(vertexQueue.contains(v)){
                        vertexQueue.remove(v);
                    }
                    vertexQueue.add(v);
                }
                else {
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    // Update vertex v's position in the vertexQueue based on its new minDistance.
                    // First, remove it if it's in the vertexQueue. (Do nothing if not.)
                    // Then add it (or add it back) to the vertexQueue.
                    vertexQueue.remove(v);
                    //vertexQueue.add(v);
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


}
