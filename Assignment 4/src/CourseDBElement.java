/**
 * CourseDBElement class represents a single course with details like
 * course ID, CRN, number of credits, room number, and instructor name.
 * It implements Comparable to allow sorting by CRN.
 * 
 * @author Okeoghene Excel Omorobe
 */
public class CourseDBElement implements Comparable<CourseDBElement> {

    // Unique identifier for the course (e.g., "CMSC204")
    private String courseID;

    // Course Registration Number, used for uniquely identifying the course
    private int crn;

    // Number of credits the course is worth
    private int credits;

    // Room number where the course is held
    private String roomNum;

    // Instructor's name for the course
    private String instructor;

    /**
     * Default constructor for flexibility in instantiation.
     * Useful when values will be set later via setters.
     */
    public CourseDBElement() {
        // No initialization here; values can be set later.
    }

    /**
     * Parameterized constructor to create a CourseDBElement with all values.
     *
     * @param courseID   Course identifier
     * @param crn        Course Registration Number
     * @param credits    Number of credits
     * @param roomNum    Room number
     * @param instructor Instructor's name
     */
    public CourseDBElement(String courseID, int crn, int credits, String roomNum, String instructor) {
        this.courseID = courseID;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }

    // Getter for course ID
    public String getID() {
        return courseID;
    }

    // Getter for CRN
    public int getCRN() {
        return crn;
    }

    // Getter for number of credits
    public int getCredits() {
        return credits;
    }

    // Getter for room number
    public String getRoomNum() {
        return roomNum;
    }

    // Getter for instructor's name
    public String getInstructor() {
        return instructor;
    }

    // Setter to change the CRN
    public void setCRN(int crn) {
        this.crn = crn;
    }

    /**
     * Compares this CourseDBElement to another based on CRN.
     * Allows sorting of CourseDBElements in collections.
     *
     * @param other Another CourseDBElement to compare to
     * @return Negative if this CRN is less, positive if greater, zero if equal
     */
    @Override
    public int compareTo(CourseDBElement other) {
        return Integer.compare(this.crn, other.crn);
    }

    /**
     * Checks equality based on CRN.
     * Two CourseDBElements are considered equal if their CRNs match.
     *
     * @param obj Object to compare with
     * @return true if CRNs are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object
        if (!(obj instanceof CourseDBElement)) return false; // Different type
        CourseDBElement other = (CourseDBElement) obj;
        return this.crn == other.crn; // Compare CRNs
    }

    /**
     * Generates a hash code based on the CRN.
     * Ensures consistent hashing for use in hash-based collections.
     *
     * @return Hash code for this object
     */
    @Override
    public int hashCode() {
        return Integer.toString(crn).hashCode(); // Use CRN string's hash code
    }

    /**
     * Returns a formatted string containing all course details.
     *
     * @return String representation of the course
     */
    @Override
    public String toString() {
        return "Course:" + courseID + " CRN:" + crn + " Credits:" + credits +
               " Instructor:" + instructor + " Room:" + roomNum;
    }
}
