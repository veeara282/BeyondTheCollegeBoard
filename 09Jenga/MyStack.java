public class MyStack<E> {

    private LNode<E> top;

    public MyStack() {
	top = null;
    }

    public void push(E item) {
	if (top == null) {
	    top = new LNode<>(item);
	    return;
	}
	LNode<E> augend = new LNode<>(item);
	augend.setNext(top);
	top = augend;
    }

    public E peek() {
	return top.get();
    }

    public E pop() {
	// pop the top
	LNode<E> poop = top;
	top = top.getNext();
	return poop.get();
    }

}
