public class TreeNode<T> {

    private T value;
    private TreeNode<T> left, right;
    private int depth;

    public TreeNode(T val) {
	value = val;
	depth = 0;
    }

    public TreeNode() {
	this(null);
    }

    public T getValue() {
	return value;
    }

    public void setValue(T val) {
	value = val;
    }

    public void setLeft(TreeNode<T> child) {
	left = child;
	updateDepth();
    }

    public void setRight(TreeNode<T> child) {
	right = child;
	updateDepth();
    }

    public int getDepth() {
	return depth;
    }

    // Helper for add, remove
    private void updateDepth() {
	depth = Math.max(depthChild(left), depthChild(right));
    }
    // Helper for updateDepth
    private int depthChild(TreeNode<T> child) {
	if (child == null)
	    return 1;
	return child.depth + 1;
    }

    public TreeNode<T> removeLeft() {
	TreeNode<T> cached = left;
	left = null;
	updateDepth();
	return cached;
    }

    public TreeNode<T> removeRight() {
	TreeNode<T> cached = right;
	right = null;
	updateDepth();
	return cached;
    }

    public TreeNode<T> getLeft() {
	return left;
    }

    public TreeNode<T> getRight() {
	return right;
    }

    public boolean hasLeft() {
	return left != null;
    }

    public boolean hasRight() {
	return right != null;
    }

}