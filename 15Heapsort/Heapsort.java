public class Heapsort {

    public static void heapsort(int[] a, boolean reverse) {
	TempHeap h = new Heap(a, reverse);
	h.sort();
    }

    private static class TempHeap {

	private final int[] values;

	// Heap from 0 to (size - 1)
	private int size;

	private final boolean isMaxHeap;

	/**
	 * Creates a heap from the given array and automatically heapifies it in place.
	 * @param reverse - if true, make a min heap; if false, make a max heap
	 */
	public TempHeap(int[] a, boolean reverse) {
	    values = a;
	    size = a.length;
	    isMaxHeap = !reverse;
	    heapify();
	}

	private void heapify() {
	    for (int i = size - 1; i > 0; i--) {
		// Swap with parent ONCE per iteration. A node may be swapped more than once per method call.
		Node n = new Node(i), p = n.getParent();
		if (n.compareTo(p) > 0)
		    n.swap(p);
	    }
	}

	public void sort() {
	    while (size > 0)
		pop();
	}

	private void pop() {
	    Node n = lastNode(), swag = getRoot();
	    n.swap(swag);
	    size--;
	    
	    while (n.hasLeft() && n.compareTo(n.getChild()) < 0) {
		n.swap(n.getChild());
	    }
	}

	private Node getRoot() {
	    return new Node(0);
	}

	private Node lastNode() {
	    return new Node(size - 1);
	}

	/**
	 * A reference to a node.
	 */
	private class Node implements Comparable<Node> {

	    private int index;

	    public Node(int index) {
		if (index > size)
		    throw new NullPointerException("Reference to nonexistent heap node " + index);
		this.index = index;
	    }

	    public int getIndex() {
		return index;
	    }

	    public int getValue() {
		return values[index];
	    }

	    public void setValue(int v) {
		values[index] = v;
	    }

	    public Node getParent() {
		return new Node(index >> 1);
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
		return new Node(index * 2 + 1);
	    }

	    public Node getRight() {
		return new Node(index * 2 + 2);
	    }

	    public boolean hasLeft() {
		return index * 2 + 1 <= size();
	    }

	    public boolean hasRight() {
		// hasRight() only if hasLeft()
		return index * 2 + 2 <= size();
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



    }
}
