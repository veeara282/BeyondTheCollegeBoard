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
	start = 0;
	end = 1;
    }

    public void add(T value, int priority) {
	if (end + 1 != start) {
	    data[start] = value;
	    priorities[start--] = priority;
	    start %= data.length;
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

    public T getLowest() throws NoSuchElementException {
	return (T) data[mindex()];
    }

    // Remove data[indexLowest()] then shift the head right
    public T removeLowest() throws NoSuchElementException {
	int mindex = mindex();
	T min = (T) data[mindex];
	// shift everything from start to (mindex - 1) right 1
	for (int i = mindex - 1; i >= start || i < start && i >= end;) {
	    // wrap around
	    if (i == 0) {
		data[0] = data[data.length - 1];
		priorities[0] = priorities[data.length - 1];
		i = data.length - 1;
	    }
	    // shift
	    else {
		data[i+1] = data[i];
		priorities[i+1] = priorities[i];
	    }
	    i--;
	}
	start++;
	return min;
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
