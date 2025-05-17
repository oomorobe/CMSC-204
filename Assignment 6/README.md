# CMSC 204 - Assignment #6: Town Graph and Shortest Path Finder

## 🗺️ Overview

This project focuses on simulating a geographic network of towns connected by roads. The application allows users to manage towns and roads, and find the **shortest path** between any two towns using **Dijkstra’s Shortest Path Algorithm**. This project emphasizes graph data structures, pathfinding algorithms, and the modeling of real-world relationships through software.

---

## 🧠 Concepts Practiced

- Graphs (Vertices and Edges)
- Adjacency Lists
- Dijkstra's Algorithm
- File Parsing and I/O
- Exception Handling
- GUI Integration
- Comparable and Comparator Interfaces
- Custom Testing with JUnit

---

## 📦 Class Structure

### 🔹 `Town` (Vertex)
- Implements `Comparable<Town>`
- Attributes:
  - Name of the town
  - List of adjacent towns (for pathfinding)
- Two towns are equal if their names match

### 🔹 `Road` (Edge)
- Implements `Comparable<Road>`
- Attributes:
  - Name of the road
  - Distance (in miles)
  - Two connected `Town` objects (undirected)
- Compares based on distance

### 🔹 `Graph` (Data Structure)
- Implements `GraphInterface<Town, Road>`
- Uses adjacency list or set of towns/roads
- Core functionalities:
  - `addVertex`, `addEdge`
  - `containsVertex`, `getEdge`
  - `shortestPath`, `dijkstraShortestPath`

### 🔹 `TownGraphManager`
- Implements `TownGraphManagerInterface`
- Wraps a `Graph` instance
- Handles:
  - Adding towns and roads
  - Listing roads and towns
  - Finding shortest paths
  - Populating graph from input file

---

## ⚙️ Exception Handling

- `FileNotFoundException`: When input file is not found
- `IOException`: For unreadable or invalid file input

---

## 🖥️ GUI Features (Provided)

- **Add Town**: Input and register a new town
- **Add Road**: Create a new connection between towns with a given distance and name
- **Find Connection**: Compute and display the shortest path between two towns
- **Read File**: Load town/road data from a file (e.g., `MD Towns.txt`)
- **Exit**: Closes the application

---

## 📚 Input File Format

