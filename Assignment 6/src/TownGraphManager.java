import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Manages the graph of towns and roads.
 * Acts as a bridge between the user interface and the graph data structure.
 * Provides high-level operations such as adding towns/roads and computing paths.
 * 
 * @author Okeoghene Excel Omorobe
 */
public class TownGraphManager implements TownGraphManagerInterface {

    private Graph graph;  // The internal graph object holding towns and roads

    // Constructor initializes an empty graph
    public TownGraphManager() {
        graph = new Graph();
    }

    /**
     * Adds a road between two towns.
     * Returns true if the road was successfully added, false otherwise.
     */
    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        Town t1 = getTown(town1);
        Town t2 = getTown(town2);
        if (t1 == null || t2 == null) return false;
        graph.addEdge(t1, t2, weight, roadName);
        return true;
    }

    /**
     * Returns the name of the road between two towns, or null if none exists.
     */
    @Override
    public String getRoad(String town1, String town2) {
        Town t1 = getTown(town1);
        Town t2 = getTown(town2);
        Road road = graph.getEdge(t1, t2);
        return road != null ? road.getName() : null;
    }

    /**
     * Adds a new town to the graph.
     * Returns true if the town was added, false if it already exists.
     */
    @Override
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    /**
     * Retrieves a Town object by name.
     * Returns the Town if found, or null if not.
     */
    @Override
    public Town getTown(String name) {
        for (Town town : graph.vertexSet()) {
            if (town.getName().equals(name))
                return town;
        }
        return null;
    }

    /**
     * Checks if a town exists in the graph.
     */
    @Override
    public boolean containsTown(String v) {
        return getTown(v) != null;
    }

    /**
     * Checks if a road connection exists between two towns.
     */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        Town t1 = getTown(town1);
        Town t2 = getTown(town2);
        return graph.containsEdge(t1, t2);
    }

    /**
     * Returns a list of all road names in alphabetical order.
     */
    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> list = new ArrayList<>();
        for (Road road : graph.edgeSet()) {
            list.add(road.getName());
        }
        Collections.sort(list);
        return list;
    }

    /**
     * Deletes a road connection between two towns.
     * Returns true if the road was successfully removed.
     */
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String roadName) {
        Town t1 = getTown(town1);
        Town t2 = getTown(town2);
        Road road = graph.getEdge(t1, t2);
        if (road != null && road.getName().equals(roadName)) {
        	return graph.removeEdge(t1, t2, road.getWeight(), road.getName()) != null;
           // return graph.removeEdge(t1, t2, road.getWeight(), roadName) != null;
        }
        return false;
    }

    /**
     * Deletes a town and all of its road connections.
     * Returns true if the town was removed.
     */
    @Override
    public boolean deleteTown(String v) {
        Town town = getTown(v);
        return town != null && graph.removeVertex(town);
    }

    /**
     * Returns a list of all town names in alphabetical order.
     */
    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> list = new ArrayList<>();
        for (Town town : graph.vertexSet()) {
            list.add(town.getName());
        }
        Collections.sort(list);
        return list;
    }

    /**
     * Returns the shortest path between two towns as a list of descriptive strings.
     */
    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        Town t1 = getTown(town1);
        Town t2 = getTown(town2);
        if (t1 == null || t2 == null) return new ArrayList<>();
        return graph.shortestPath(t1, t2);
    }

    /**
     * Reads and populates the graph from a file.
     * File format: road-name,miles;town-name;town-name
     * Example: Maple Road,3;Springfield;Shelbyville
     */
    public void populateTownGraph(File file) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            if (line.isEmpty()) continue;

            // Split into road description and towns
            String[] parts = line.split(";");
            String[] roadParts = parts[0].split(",");
            String roadName = roadParts[0].trim();
            int weight = Integer.parseInt(roadParts[1].trim());
            String town1 = parts[1].trim();
            String town2 = parts[2].trim();

            // Ensure towns are added before adding road
            addTown(town1);
            addTown(town2);
            addRoad(town1, town2, weight, roadName);
        }
        scan.close();
    }
}
