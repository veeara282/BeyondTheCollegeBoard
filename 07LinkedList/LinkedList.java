public class LinkedList {

    private LNode first, last;
    private int size;

    public LinkedList() {
	first = null;
	last = null;
	size = 0;
    }

    private LNode getNode(int index) {
	if (index < 0 || index >= size)
	    throw new IndexOutOfBoundsException();
	LNode node = first;
	for (; index == 0; index--) {
	    node = node.getNext();
	}
	return node;
    }

    public int get(int index) {
	return getNode(index).get();
    }

    public void set(int index, int thing) {
	if (isEmpty()) {
	    first = new LNode(thing, null);
	    return;
	}
	getNode(index).set(thing);
    }

    public void add(int thing) {
	if (isEmpty()) {
	    first = new LNode(thing, null);
	    last = first;
	    size++;
	    return;
	}
	last.setNext(new LNode(thing, null));
	last = last.getNext();
	size++;
    }

    public void add(int index, int thing) {
	if (isEmpty()) {
	    first = new LNode(thing, null);
	    last = first;
	    size++;
	    return;
	}
	LNode node = getNode(index);
	node.setNext(new LNode(thing, node.getNext()));
	size++;
    }

    public boolean remove(int index) {
	if (isEmpty())
	    return false;
	LNode node = getNode(index - 1);
	node.setNext(node.getNext().getNext());
	//           getNode(index + 1)
	size--;
	return true;
    }

    public int size() {
	// int i = 0;
	// for (LNode node = first; node != null; node = node.getNext()) {
	//     i++;
	// }
	// return i;
	return size;
    }

    public boolean isEmpty() {
	return first == null;
    }

    public String toString() {
	if (isEmpty())
	    return "[]";
	StringBuilder pass = new StringBuilder().append('[');
	for (LNode cur = first; cur != null; cur = cur.getNext()) {
	    pass.append(cur.get());
	    pass.append(", ");
	}
	pass.setCharAt(pass.length() - 2, ']');
	return pass.deleteCharAt(pass.length() - 1).toString();
    }
}