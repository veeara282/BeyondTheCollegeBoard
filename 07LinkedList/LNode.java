class LNode<E> {

    private E data;
    private LNode<E> next;

    LNode<E>(E data) {
	this(data, LNode.<E>dummy());
    }

    LNode<E>(E data, LNode<E> next) {
	this.data = data;
	this.next = next;
    }

    // E get(int index) {
    // 	if (index == 0)
    // 	    return get();
    // 	else
    // 	    return next.get(index - 1);
    // }
    E get() {
	return data;
    }

    void set(E thing) {
	data = thing;
    }

    LNode<E> getNext() {
	return next;
    }
    void setNext(LNode<E> node) {
	next = node;
    }

    /**
     * Returns a dummy node, which marks the end of the list
     */
    static <E> LNode<E> dummy() {
	return new LNode<E>() {
	    E get() {
		return null;
	    }

	    void set(E thing) {
		throw new UnsupportedOperationException();
	    }

	    LNode<E> getNext() {
		return this;
	    }

	    void setNext(LNode<E> node) {
		throw new UnsupportedOperationException();
	    }
	};
    }

    /**
     * Checks whether this node is a dummy
     */
    boolean isDummy() {
	return get() == null && getNext() == this;
    }

    /**
     * Checks whether this node is the last one on the list, i.e. whether
     * its getNext() method returns a dummy
     */
    boolean isLast() {
	return getNext().isDummy();
    }

}
