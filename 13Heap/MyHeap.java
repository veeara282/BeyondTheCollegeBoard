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
	Node n = nextAvailableSpace();
	n.setValue(v);
	// node is in the wrong place
	while (isMaxHeap && v > n.getParent().getValue() || v < n.getParent().getValue()) {
	    n.swap(n.getParent());
	}
    }

    public int get() {
	return values[1];
    }

    public int remove() {
	Node n = lastNode(), yolo = getRoot();
	n.swap(yolo);

	// Finally get to remove the number
	values[0]--;
	return yolo.getValue();
    }

    // max values.length - 1
    public int size() {
	return values[0];
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
    private class Node {

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
	    return values[index];
	}

	public void setValue(int v) {
	    if (exists()) {
		values[index] = v;		
	    }
	    else {
		// Will usually increment the size by 1
		setSize(index);
	    }
	}

	public Node getParent() {
	    return new Node(index >> 1);
	}

	public Node getLeft() {
	    return new Node(index << 1);
	}

	public Node getRight() {
	    return new Node((index << 1) + 1);
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

    }

}
