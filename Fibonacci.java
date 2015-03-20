import java.util.Iterator;

public class Fibonacci implements Iterator<Integer> {

    private int cur, prev;

    public Fibonacci() {
	cur = 1;
	prev = 0;
    }

    public boolean hasNext() {
	return true;
    }

    public Integer next() {
	int yolo = cur;
	cur += prev;
	prev = yolo;
	return yolo;
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }
}