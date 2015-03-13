class LNode {

    private int data;
    private LNode next;

    LNode(int data, LNode next) {
	this.data = data;
	this.next = next;
    }

    int get(int index) {
	if (index == 0)
	    return get();
	else
	    return next.get(index - 1);
    }
    int get() {
	return data;
    }

    void set(int thing) {
	data = thing;
    }

    LNode getNext() {
	return next;
    }
    void setNext(LNode node) {
	next = node;
    }

}