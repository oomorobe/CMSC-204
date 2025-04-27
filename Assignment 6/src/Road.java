/** The Road class represents a road connecting two towns, with a name and a distance (weight)
 * 
 * @author Okeoghene Excel Omorobe
 */
public class Road implements Comparable<Road> {
    
    private Town source;         // One end of the road (starting town)
    private Town destination;    // The other end of the road (ending town)
    private String name;         // Name of the road
    private int weight;          // Distance or cost associated with traveling the road

    // Constructor to create a road with specified source, destination, weight, and name
    public Road(Town source, Town destination, int weight, String name) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.name = name;
    }

    // Overloaded constructor that sets default weight to 1
    public Road(Town source, Town destination, String name) {
        this(source, destination, 1, name);  // default weight = 1
    }

    // Getter for the source town
    public Town getSource() {
        return source;
    }

    // Getter for the destination town
    public Town getDestination() {
        return destination;
    }

    // Getter for the road's name
    public String getName() {
        return name;
    }

    // Getter for the road's weight
    public int getWeight() {
        return weight;
    }

    // Checks if the road connects to a specific town
    public boolean contains(Town town) {
        return source.equals(town) || destination.equals(town);
    }

    // Compares this road with another road based on name (lexicographical order)
    @Override
    public int compareTo(Road o) {
        return this.name.compareTo(o.name);
    }

    // Returns a string representation of the road
    @Override
    public String toString() {
        return name + ": " + source + " to " + destination + " (" + weight + " mi)";
    }

    // Checks if two roads are equal: they must connect the same towns (in either direction) and have the same name
    @Override
    public boolean equals(Object r) {
        if (r instanceof Road) {
            Road other = (Road) r;
            return (this.source.equals(other.source) && this.destination.equals(other.destination) ||
                    this.source.equals(other.destination) && this.destination.equals(other.source))
                   && this.name.equals(other.name);
        }
        return false;
    }
}
