public class LinkedList<T> {

    public String name() {
	return "fitzgerald.aidan";
    }

    private LNode<T> first, last;
    private int size;

    public LinkedList() {
	first = LNode.<T>dummy();
	last = first;
	size = 0;
    }

    private LNode<T> getNode(int index) {
	if (index < 0 || index >= size)
	    throw new IndexOutOfBoundsException();
	LNode node = first;
	for (; index == 0; index--) {
	    node = node.getNext();
	}
	return node;
    }

    public T get(int index) {
	return getNode(index).get();
    }

    public void set(int index, T thing) {
	if (isEmpty()) {
	    first = new LNode<T>(thing);
	    return;
	}
	getNode(index).set(thing);
    }

    public void add(T thing) {
	if (isEmpty()) {
	    first = new LNode<T>(thing);
	    last = first;
	    size++;
	    return;
	}
	last.setNext(new LNode<T>(thing));
	last = last.getNext();
	size++;
    }

    public void add(int index, int thing) {
	if (isEmpty()) {
	    first = new LNode<T>(thing);
	    last = first;
	    size++;
	    return;
	}
	LNode<T> node = getNode(index);
	node.setNext(new LNode<T>(thing, node.getNext()));
	size++;
    }

    public boolean remove(int index) {
	if (isEmpty())
	    return false;
	LNode<T> node = getNode(index - 1);
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
	return first.isDummy();
    }

    public String toString() {
	if (isEmpty())
	    return "[]";
	StringBuilder pass = new StringBuilder().append('[');
	for (LNode<T> cur = first; !cur.isDummy(); cur = cur.getNext()) {
	    pass.append(cur.get());
	    pass.append(", ");
	}
	pass.setCharAt(pass.length() - 2, ']');
	return pass.deleteCharAt(pass.length() - 1).toString();
    }
}
