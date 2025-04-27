/**The Town class represents a town in a graph, typically used in a road map or network
 * 
 * @author Okeoghene Excel Omorobe
 */
public class Town implements Comparable<Town> {
    
    private String name;  // Name of the town

    // Constructor to create a town with a given name
    public Town(String name) {
        this.name = name;
    }

    // Copy constructor: creates a new Town object as a copy of another
    public Town(Town templateTown) {
        this.name = templateTown.name;
    }

    // Getter for the town's name
    public String getName() {
        return name;
    }

    // Returns a string representation of the town (just its name)
    @Override
    public String toString() {
        return name;
    }

    // Compares two towns based on their names (lexicographical comparison)
    @Override
    public int compareTo(Town o) {
        return this.name.compareTo(o.name);
    }

    // Checks if two Town objects are equal based on their names
    @Override
    public boolean equals(Object o) {
        if (o instanceof Town) {
            Town other = (Town) o;
            return this.name.equals(other.name);
        }
        return false;
    }

    // It's good practice to override hashCode when equals is overridden
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
