import java.util.*;

/** The Graph class implements a graph data structure using Towns as vertices and Roads as edges.
 * @author Okeoghene Excel Omorobe
 */
public class Graph implements GraphInterface<Town, Road> {

    private Set<Town> vertices;                          // Set of all towns (vertices) in the graph
    private Set<Road> edges;                             // Set of all roads (edges) in the graph
    private Map<Town, Set<Road>> adjacencyMap;           // Maps each town to a set of roads it's connected to
    private Map<Town, Integer> distances;                // Stores shortest distance from source in Dijkstra's algorithm
    private Map<Town, Town> previous;                    // Tracks the previous town in the shortest path

    // Constructor initializes the graph's internal data structures
    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjacencyMap = new HashMap<>();
    }

    // Returns the road connecting two towns, or null if no such road exists
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        if (sourceVertex == null || destinationVertex == null || 
            !vertices.contains(sourceVertex) || !vertices.contains(destinationVertex))
            return null;

        for (Road road : adjacencyMap.get(sourceVertex)) {
            if (road.contains(destinationVertex)) return road;
        }
        return null;
    }

    // Adds a new road between two towns and updates the adjacency map
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        if (!vertices.contains(sourceVertex) || !vertices.contains(destinationVertex))
            throw new IllegalArgumentException();

        Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
        edges.add(newRoad);
        adjacencyMap.get(sourceVertex).add(newRoad);
        adjacencyMap.get(destinationVertex).add(newRoad);
        return newRoad;
    }

    // Adds a new town (vertex) to the graph
    public boolean addVertex(Town v) {
        if (v == null || vertices.contains(v)) return false;

        vertices.add(v);
        adjacencyMap.put(v, new HashSet<>());
        return true;
    }

    // Checks if a road (edge) exists between two towns
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        return getEdge(sourceVertex, destinationVertex) != null;
    }

    // Checks if a town (vertex) exists in the graph
    public boolean containsVertex(Town v) {
        return vertices.contains(v);
    }

    // Returns a set of all roads in the graph
    public Set<Road> edgeSet() {
        return edges;
    }

    // Returns all roads connected to a given town
    public Set<Road> edgesOf(Town vertex) {
        if (!vertices.contains(vertex)) throw new IllegalArgumentException();
        return adjacencyMap.get(vertex);
    }

    // Removes a road between two towns from the graph
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        Road toRemove = new Road(sourceVertex, destinationVertex, weight, description);
        if (edges.remove(toRemove)) {
            adjacencyMap.get(sourceVertex).remove(toRemove);
            adjacencyMap.get(destinationVertex).remove(toRemove);
            return toRemove;
        }
        return null;
    }

    // Removes a town and all its connected roads from the graph
    public boolean removeVertex(Town v) {
        if (!vertices.contains(v)) return false;
        
        // Remove all roads connected to this town
        for (Road road : new HashSet<>(adjacencyMap.get(v))) {
            removeEdge(road.getSource(), road.getDestination(), road.getWeight(), road.getName());
        }
        adjacencyMap.remove(v);
        vertices.remove(v);
        return true;
    }

    // Returns a set of all towns (vertices) in the graph
    public Set<Town> vertexSet() {
        return vertices;
    }

    // Uses Dijkstra's algorithm to find the shortest paths from a source town
    public void dijkstraShortestPath(Town sourceVertex) {
        distances = new HashMap<>();
        previous = new HashMap<>();
        Set<Town> visited = new HashSet<>();
        PriorityQueue<Town> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Initialize distances to all towns as infinity
        for (Town town : vertices) {
            distances.put(town, Integer.MAX_VALUE);
            previous.put(town, null);
        }
        distances.put(sourceVertex, 0);
        queue.add(sourceVertex);

        // Main loop of Dijkstra's algorithm
        while (!queue.isEmpty()) {
            Town current = queue.poll();
            visited.add(current);

            for (Road road : edgesOf(current)) {
                Town neighbor = road.getDestination().equals(current) ? road.getSource() : road.getDestination();
                if (visited.contains(neighbor)) continue;

                int newDist = distances.get(current) + road.getWeight();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Builds and returns the shortest path from source to destination as a list of steps
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        dijkstraShortestPath(sourceVertex);  // Compute shortest paths from the source
        ArrayList<String> path = new ArrayList<>();

        // If the destination was not reached, return an empty path
        if (!previous.containsKey(destinationVertex) || distances.get(destinationVertex) == Integer.MAX_VALUE) {
            return path;
        }

        // Reconstruct the path from destination back to source
        LinkedList<Town> pathTowns = new LinkedList<>();
        for (Town at = destinationVertex; at != null; at = previous.get(at)) {
            pathTowns.addFirst(at);
        }

        // Convert the path to readable strings
        for (int i = 0; i < pathTowns.size() - 1; i++) {
            Town from = pathTowns.get(i);
            Town to = pathTowns.get(i + 1);
            Road road = getEdge(from, to);
            if (road != null) {
                path.add(from + " via " + road.getName() + " to " + to + " " + road.getWeight() + " mi");
            }
        }

        return path;
    }
}
