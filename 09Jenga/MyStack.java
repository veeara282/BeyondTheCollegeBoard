import java.util.*;

public class MyStack<E> {

    private LinkedList<E> data;

    public void push(E elem) {
	data.addFirst(elem);
    }

    public E peek() {
	return data.get(0);
    }

    public E pop() {
	return data.remove(0);
    }

}
