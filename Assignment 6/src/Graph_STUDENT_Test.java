import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

/**
 * JUnit test class for the Graph class.
 * Tests core graph operations including adding/removing vertices and edges,
 * checking existence, and computing shortest paths.
 * @author Okeoghene Excel Omorobe
 */
public class Graph_STUDENT_Test {
    private Graph graph;
    private Town t1, t2, t3, t4;

    /**
     * Sets up the test graph with four towns and three connecting roads.
     * The graph structure is:
     * Gaithersburg --3--> Rockville --4--> Bethesda --2--> Olney
     */
    @Before
    public void setUp() throws Exception {
        graph = new Graph();

        t1 = new Town("Gaithersburg");
        t2 = new Town("Rockville");
        t3 = new Town("Bethesda");
        t4 = new Town("Olney");

        // Add towns (vertices)
        graph.addVertex(t1);
        graph.addVertex(t2);
        graph.addVertex(t3);
        graph.addVertex(t4);

        // Add roads (edges)
        graph.addEdge(t1, t2, 3, "MD355");
        graph.addEdge(t2, t3, 4, "MD586");
        graph.addEdge(t3, t4, 2, "MD97");
    }

    /**
     * Test if graph correctly identifies whether a vertex exists.
     */
    @Test
    public void testContainsVertex() {
        assertTrue(graph.containsVertex(t1));
        assertFalse(graph.containsVertex(new Town("NotInGraph")));
    }

    /**
     * Test if graph correctly identifies the existence of a specific edge.
     */
    @Test
    public void testContainsEdge() {
        assertTrue(graph.containsEdge(t1, t2)); // MD355 exists
        assertFalse(graph.containsEdge(t1, t4)); // No direct road between these towns
    }

    /**
     * Test retrieving a specific edge between two towns.
     */
    @Test
    public void testGetEdge() {
        Road r = graph.getEdge(t1, t2);
        assertNotNull(r);
        assertEquals("MD355", r.getName());
    }

    /**
     * Test removing a vertex and ensuring it no longer exists in the graph.
     */
    @Test
    public void testRemoveVertex() {
        assertTrue(graph.removeVertex(t4)); // remove Olney
        assertFalse(graph.containsVertex(t4)); // should no longer exist
    }

    /**
     * Test removing an edge and verifying it's been removed.
     */
    @Test
    public void testRemoveEdge() {
        assertNotNull(graph.removeEdge(t2, t3, 4, "MD586")); // remove Rockville <-> Bethesda
        assertFalse(graph.containsEdge(t2, t3)); // confirm it's gone
    }

    /**
     * Test Dijkstra’s algorithm for shortest path between Gaithersburg and Olney.
     */
    @Test
    public void testShortestPath() {
        ArrayList<String> path = graph.shortestPath(t1, t4);
        assertEquals(3, path.size());
        assertEquals("Gaithersburg via MD355 to Rockville 3 mi", path.get(0));
        assertEquals("Rockville via MD586 to Bethesda 4 mi", path.get(1));
        assertEquals("Bethesda via MD97 to Olney 2 mi", path.get(2));
    }

    /**
     * Test the total number of vertices and edges in the graph.
     */
    @Test
    public void testEdgeSetAndVertexSet() {
        Set<Town> towns = graph.vertexSet();
        Set<Road> roads = graph.edgeSet();
        assertEquals(4, towns.size());
        assertEquals(3, roads.size());
    }
}
