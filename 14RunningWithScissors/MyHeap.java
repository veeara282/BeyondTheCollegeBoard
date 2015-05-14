public class MyHeap {

    private int[] values;

    public final boolean isMaxHeap;

    public MyHeap() {
	this(true);
    }

    public MyHeap(boolean isMaxHeap) {
	values = new int[16];
	this.isMaxHeap = isMaxHeap;
    }

    public void add(int v) {
	if (size() == 0) {
	    getRoot().setValue(v);
	}
	else {
	    Node n = nextAvailableSpace();
	    n.setValue(v);
	    // node is in the wrong place
	    while (n.hasParent() && n.compareTo(n.getParent()) > 0) {
		n.swap(n.getParent());
	    }
	}
    }

    public int get() {
	return values[1];
    }

    public int remove() {
	Node n = lastNode();
	int yolo;

	theActualRemoval: {
	    Node swag = getRoot();
	    n.swap(swag);
	    yolo = swag.getValue();
	    values[0]--;
	}

	while (n.hasLeft() && n.compareTo(n.getChild()) < 0) {
	    n.swap(n.getChild());
	}

	return yolo;
    }

    // max values.length - 1
    public int size() {
	return values[0];
    }

    // bit shift algorithm to get the log_2 of the size
    public int depth() {
	int power = size(), log2 = 0;
	while (power != 0) {
	    power /= 2;
	    log2++;
	}
	return log2;
    }

    private void setSize(int size) {
	if (size >= values.length) {
	    int[] copy = new int[values.length << 1];
	    copy[0] = size;
	    System.arraycopy(values, 1, copy, 1, size());
	    values = copy;
	}
	else {
	    values[0] = size;
	}
    }

    private Node getRoot() {
	return new Node(1);
    }

    private Node lastNode() {
	return new Node(size());
    }

    private Node nextAvailableSpace() {
	return new Node(size() + 1);
    }

    /**
     * A reference to a node.
     */
    private class Node implements Comparable<Node> {

	private int index;

	public Node(int index) {
	    this.index = index;
	}

	public boolean exists() {
	    return index > 0 && index <= size();
	}

	public int getIndex() {
	    return index;
	}

	public int getValue() {
	    if (exists()) {
		return values[index];
	    }
	    else {
		throw new NullPointerException("Reference to nonexistent heap node " + index);
	    }
	}

	public void setValue(int v) {
	    if (!exists()) {
		// Will usually increment the size by 1
		setSize(index);
	    }
	    values[index] = v;		
	}

	public boolean hasParent() {
	    return index > 1;
	}

	public Node getParent() {
	    if (hasParent())
		return new Node(index >> 1);
	    else
		return null; // root has no parent
	}

	/**
	 * Returns the greater child if this is a max heap or the smaller child
	 * if this is a min heap.
	 */
	public Node getChild() {
	    if (hasRight() && getLeft().compareTo(getRight()) <= 0)
		return getRight();
	    else
		return getLeft();
	}

	public Node getLeft() {
	    return new Node(index * 2);
	}

	public Node getRight() {
	    return new Node(index * 2 + 1);
	}

	public boolean hasLeft() {
	    return index * 2 <= size();
	}

	public boolean hasRight() {
	    // hasRight() only if hasLeft()
	    return index * 2 + 1 <= size();
	}

	public Node getSista() {
	    // toggle bit: http://stackoverflow.com/a/47990
	    return new Node(index ^ 1);
	}

	public void swap(Node n) {
	    // swap values
	    int nv = n.getValue();
	    n.setValue(this.getValue());
	    this.setValue(nv);
	    // swap indices
	    int ni = n.index;
	    n.index = this.index;
	    this.index = ni;
	}

	/**
	 * Reversible comparison.
	 * @return positive if this node is supposed to be above {@code other}
	 * in the heap, negative if it's supposed to be below {@code other}.
	 */
	public int compareTo(Node other) {
	    return isMaxHeap?(getValue() - other.getValue()):(other.getValue() - getValue());
	}

    }

    public String toString() {
	StringBuilder yolo = new StringBuilder();
	for (int i = 1; i <= size(); i++) {
	    yolo.append(values[i]).append(' ');
	}
	return yolo.toString();
    }

}
