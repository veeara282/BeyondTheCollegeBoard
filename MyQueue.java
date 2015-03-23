public class MyQueue<E> {

    private MyLinkedList<E> quoi;

    public MyQueue<E>() {
	quoi = new MyLinkedList<E>();
    }

    public void enqueue(E thing) {
	quoi.add(thing);
    }

    public E dequeue() {
	return quoi.remove(0);
    }

    public E peek() {
	return quoi.get(0);
    }

}