import java.util.ArrayList;

/** MorseCodeTree builds a binary tree representation of Morse code, allowing conversion from Morse to letters.
 * @author Okeoghene Excel Omorobe
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    
    // Root of the Morse code binary tree
    private TreeNode<String> root;

    // Constructor initializes the tree by building it with Morse code mappings
    public MorseCodeTree() {
        buildTree();
    }

    // Returns the root node of the tree
    public TreeNode<String> getRoot() {
        return root;
    }

    // Sets a new root node
    public void setRoot(TreeNode<String> newNode) {
        this.root = newNode;
    }

    // Public method to insert a letter into the tree using its Morse code
    public void insert(String code, String letter) {
        addNode(root, code, letter);
    }

    // Recursively adds a new node (letter) to the tree at the position defined by the Morse code
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            // Base case: if only one character remains in the code, insert the node directly
            if (code.equals(".")) {
                root.setLeft(new TreeNode<>(letter));
            } else {
                root.setRight(new TreeNode<>(letter));
            }
        } else {
            // Recursive case: process the next character and recurse into left or right subtree
            char first = code.charAt(0);         // First character (either '.' or '-')
            String rest = code.substring(1);     // Remaining Morse code

            if (first == '.') {
                if (root.getLeft() == null)
                    root.setLeft(new TreeNode<>("")); // Create placeholder if needed
                addNode(root.getLeft(), rest, letter);
            } else {
                if (root.getRight() == null)
                    root.setRight(new TreeNode<>("")); // Create placeholder if needed
                addNode(root.getRight(), rest, letter);
            }
        }
    }

    // Fetches the letter associated with a Morse code string
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    // Recursively traverses the tree based on Morse code and returns the corresponding letter
    public String fetchNode(TreeNode<String> root, String code) {
        if (code.length() == 0) {
            return root.getData(); // Base case: code fully processed
        }
        char first = code.charAt(0);
        String rest = code.substring(1);

        if (first == '.') {
            return fetchNode(root.getLeft(), rest);
        } else {
            return fetchNode(root.getRight(), rest);
        }
    }

    // Delete operation is not supported in this implementation
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    // Update operation is not supported in this implementation
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    // Builds the Morse code tree by inserting all standard Morse code mappings
    public void buildTree() {
        root = new TreeNode<>("");
        insert(".", "e"); insert("-", "t");
        insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m");
        insert("...", "s"); insert("..-", "u"); insert(".-.", "r"); insert(".--", "w");
        insert("-..", "d"); insert("-.-", "k"); insert("--.", "g"); insert("---", "o");
        insert("....", "h"); insert("...-", "v"); insert("..-.", "f"); insert(".-..", "l");
        insert(".--.", "p"); insert(".---", "j"); insert("-...", "b"); insert("-..-", "x");
        insert("-.-.", "c"); insert("-.--", "y"); insert("--..", "z"); insert("--.-", "q");
    }

    // Converts the tree into an ArrayList using in-order traversal (LNR: Left, Node, Right)
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    // Recursive in-order traversal: adds each letter to the list in sorted order
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.getLeft(), list);
            if (!root.getData().isEmpty()) // Skip empty placeholders
                list.add(root.getData());
            LNRoutputTraversal(root.getRight(), list);
        }
    }
}
