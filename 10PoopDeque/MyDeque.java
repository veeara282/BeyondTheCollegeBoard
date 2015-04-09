import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyDeque<T> {

    // make this using reflection
    private Object[] data;

    // internal indices wrap around
    // end is last index + 1, so it should never equal start
    private int start, end;

    public MyDeque() {
	data = new Object[16];
	start = 0;
	end = 1;
    }

    public void addFirst(T value) {
	if (end + 1 != start) {
	    data[start--] = value;
	    start %= data.length;
	    return;
	}
	// Only one level of recursion should be necessary
	resize();
	addFirst(value);
    }

    public void addLast(T value) {
	if (end + 1 != start) {
	    data[end++] = value;
	    end %= data.length;
	    return;
	}
	// Only one level of recursion should be necessary
	resize();
	addLast(value);
    }

    public T getFirst() throws NoSuchElementException {
	if (isEmpty())
	    throw new NoSuchElementException();
	return (T) data[start];
    }

    public T getLast() throws NoSuchElementException {
	if (isEmpty())
	    throw new NoSuchElementException();
	return (T) data[end - 1];
    }

    public T removeFirst() throws NoSuchElementException {
	if (isEmpty())
	    throw new NoSuchElementException();
	return (T) data[start++];
    }

    public T removeLast() throws NoSuchElementException {
	if (isEmpty())
	    throw new NoSuchElementException();
	return (T) data[end-- - 1];
    }

    public boolean isEmpty() {
	return end == start + 1;
    }

    /**
     * Can't use generic T[]
     * @throws NegativeArraySizeException when the new size is 1 << 31 or more
     */
    private void resize() {
	Object[] newSpace = new Object[data.length << 1];
	for (int i = 0; i < data.length; i++) {
	    newSpace[i] = data[(i + start) % data.length];
	}
	// Change start and end BEFORE garbage collecting the old array
	start = 0;
	end = data.length;
	// Overwrite data
	data = newSpace;
    }

}
