/** Generic TreeNode class representing a node in a binary tree
 * 
 * @author Okeoghene Excel Omorobe
 */
public class TreeNode<T> {

    // Data stored in the node
    private T data;

    // Left and right child nodes
    private TreeNode<T> left, right;

    // Constructor to create a node with data, left and right children are null
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Constructor to create a node with data and specified left and right children
    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // Getter for the data field
    public T getData() {
        return data;
    }

    // Setter for the data field
    public void setData(T data) {
        this.data = data;
    }

    // Getter for the left child
    public TreeNode<T> getLeft() {
        return left;
    }

    // Setter for the left child
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    // Getter for the right child
    public TreeNode<T> getRight() {
        return right;
    }

    // Setter for the right child
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
