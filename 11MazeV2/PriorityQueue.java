import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class PriorityQueue<T> {

    private Object[] data;
    private int[] priorities;

    // internal indices wrap around
    // end is last index + 1, so it should never equal start
    private int start, end;

    public PriorityQueue() {
	data = new Object[16];
	priorities = new int[16];
	start = 0;
	end = 0;
    }

    public void add(T value, int priority) {
	if ((end + 1) % data.length != start) {
	    data[end] = value;
	    priorities[end++] = priority;
	    end %= data.length;
	    return;
	}
	// Only one level of recursion should be necessary
	resize();
	add(value, priority);
    }

    private int mindex() throws NoSuchElementException {
	if (isEmpty())
	    throw new NoSuchElementException();
	int min = Integer.MAX_VALUE, mindex = start;
	// reigning champion
	for (int i = start; i < end; i = i % data.length + 1) {
	    if (priorities[i] < min) {
		min = priorities[i];
		mindex = i;
	    }
	}
	return mindex;
    }

    public T get() throws NoSuchElementException {
	return (T) data[mindex()];
    }

    // Remove data[mindex()] then fill with the tail
    public T remove() throws NoSuchElementException {
	int mindex = mindex();
	T min = (T) data[mindex];

	// move tail here O(1) rather than shifting O(n)
	data[mindex] = data[end-1];
	priorities[mindex] = priorities[end-1];
	// wipe from old location so it can be garbage collected once removed
	data[end-1] = null;
	priorities[end-1] = 0;
	end--;

	return min;
    }

    public boolean isEmpty() {
	return end == start;
    }

    /**
     * Can't use generic T[]
     * @throws NegativeArraySizeException when the new size is 1 << 31 or more
     */
    private void resize() {
	Object[] newSpace = new Object[data.length << 1];
	int[] newSpWts = new int[data.length << 1];

	for (int i = 0; i < end - start; i++) {
	    newSpace[i] = data[(i + start) % data.length];
	    newSpWts[i] = priorities[(i + start) % data.length];
	}
	// Change start and end BEFORE garbage collecting the old array
	start = 0;
	end = end - start;
	// Overwrite data
	data = newSpace;
	priorities = newSpWts;
    }

    public static void main(String[] args) {
	PriorityQueue<String> yolo = new PriorityQueue<>();

	int weight = 53;
	for (String s: args) {
	    yolo.add(s, weight--);
	}

	while (!yolo.isEmpty()) {
	    String swag = yolo.remove();
	    System.out.println(swag);
	}
    }

}
