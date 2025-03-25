import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * CourseDBManager manages the interaction with the CourseDBStructure.
 * It implements CourseDBManagerInterface to provide course-related operations
 * such as adding courses, retrieving by CRN, reading from a file, and displaying all.
 * 
 * @author Okeoghene Excel Omorobe
 */
public class CourseDBManager implements CourseDBManagerInterface {

    // Underlying database structure that stores CourseDBElements
    private CourseDBStructure db;

    /**
     * Default constructor that initializes the database with default size.
     */
    public CourseDBManager() {
        db = new CourseDBStructure(100); // Initial table size
    }

    /**
     * Adds a new course to the database.
     *
     * @param id         Course ID (e.g., "CMSC204")
     * @param crn        Course Registration Number
     * @param credits    Number of credits
     * @param roomNum    Room number
     * @param instructor Instructor's name
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        db.add(element); // Delegate to CourseDBStructure
    }

    /**
     * Retrieves a course by its CRN.
     *
     * @param crn Course Registration Number
     * @return The CourseDBElement if found, otherwise null
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return db.get(crn);
        } catch (Exception e) {
            System.out.println("Error: Course with CRN " + crn + " not found.");
            return null;
        }
    }

    /**
     * Reads a file of course data and adds each course to the database.
     * Each line in the file should follow the format:
     * courseID crn credits roomNum instructor name (could be multiple words)
     *
     * @param input The input file
     * @throws FileNotFoundException If the file cannot be found
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);

        // Process each line of the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            // Skip empty lines
            if (!line.isEmpty()) {
                Scanner lineScanner = new Scanner(line);

                // Parse the fixed parts of the line
                String id = lineScanner.next();
                int crn = lineScanner.nextInt();
                int credits = lineScanner.nextInt();
                String roomNum = lineScanner.next();

                // The rest of the line is the instructor's name (could be multiple words)
                String instructor = "";
                while (lineScanner.hasNext()) {
                    instructor += lineScanner.next() + " ";
                }

                instructor = instructor.trim(); // Remove trailing space

                // Add the parsed course to the database
                add(id, crn, credits, roomNum, instructor);

                lineScanner.close();
            }
        }

        scanner.close();
    }

    /**
     * Returns a list of all courses in the database as strings.
     *
     * @return ArrayList of string representations of each course
     */
    @Override
    public ArrayList<String> showAll() {
        return db.showAll(); // Delegate to CourseDBStructure
    }
}
