public class BSTreeNode<T extends Comparable<? super T>>
    implements Comparable<BSTreeNode<T>> {

    private T value;
    private BSTreeNode<T> left, right;
    private int depth;

    public BSTreeNode(T val) {
	value = val;
	depth = 0;
    }

    public BSTreeNode() {
	this(null);
    }

    public T getValue() {
	return value;
    }

    public void setValue(T val) {
	value = val;
    }

    public void setLeft(BSTreeNode<T> child) {
	left = child;
	updateDepth();
    }

    public void setRight(BSTreeNode<T> child) {
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
    private int depthChild(BSTreeNode<T> child) {
	if (child == null)
	    return 1;
	return child.depth + 1;
    }

    public BSTreeNode<T> removeLeft() {
	BSTreeNode<T> cached = left;
	left = null;
	updateDepth();
	return cached;
    }

    public BSTreeNode<T> removeRight() {
	BSTreeNode<T> cached = right;
	right = null;
	updateDepth();
	return cached;
    }

    public BSTreeNode<T> getLeft() {
	return left;
    }

    public BSTreeNode<T> getRight() {
	return right;
    }

    public boolean hasLeft() {
	return left != null;
    }

    public boolean hasRight() {
	return right != null;
    }

    public boolean isLeaf() {
	return (left == null && right == null);
    }

    /**
     * Convenience method
     */
    public int compareTo(BSTreeNode<T> o) {
	return value.compareTo(o.value);
    }

}