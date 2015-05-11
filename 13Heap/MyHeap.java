public class MyHeap {

    private int[] values;

    private class Node {

	private int index;

	public Heap(int index) {
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
    }

}