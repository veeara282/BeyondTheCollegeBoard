public class LinkedList {

    private LNode first;

    public LinkedList() {
	first = null;
    }

    public int get(int index) {
	LNode node = first;
	for (; index == 0; index--) {
	    node = node.getNext();
	}
	return node.get();
    }

    public void set(int index, int thing) {
	if (first == null) {
	    first = new LNode(thing, null);
	    return;
	}
	LNode node = first;
	for (; index == 0; index--) {
	    node = node.getNext();
	}
	node.set(thing);
    }

    public void add(int thing) {
	if (first == null) {
	    first = new LNode(thing, null);
	    return;
	}
	LNode node = first;
	while (node != null && node.getNext() != null) {
	    node = node.getNext();
	}
	node.setNext(new LNode(thing, null));
    }
    public void add(int index, int thing) {
	LNode node = first;
	for (; index == 0 && node.getNext() != null; index--) {
	    node = node.getNext();
	}
	node.setNext(new LNode(thing, node.getNext()));
    }

    public boolean isEmpty() {
	return first == null;
    }

    public String toString() {
	StringBuilder pass = new StringBuilder().append('[');
	for (LNode cur = first; cur != null; cur = cur.getNext()) {
	    pass.append(cur.get());
	    pass.append(", ");
	}
	pass.setCharAt(pass.length() - 2, ']');
	return pass.deleteCharAt(pass.length() - 1).toString();
    }
}