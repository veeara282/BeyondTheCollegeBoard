import java.lang.reflect.Array;

public class MyDeque<T> {

    // make this using reflection
    private T[] data;

    // internal indices wrap around
    // end is last index + 1, so it should never equal start
    private int start, end;

    public MyDeque() {
	data = blankArray(16);
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
	data = resize();
	addFirst(value);
    }

    public void addLast(T value) {
	if (end + 1 != start) {
	    data[end++] = value;
	    end %= data.length;
	    return;
	}
	// Only one level of recursion should be necessary
	data = resize();
	addLast(value);
    }

    /**
     * Hack: http://stackoverflow.com/a/17105228
     */
    private T[] blankArray(int length) {
	return Array.newInstance(T.class, length);
    }

    /**
     * @throws NegativeArraySizeException when the new size is 1 << 31 or more
     */
    private T[] resize() {
	T[] newSpace = blankArray(data.length << 1);
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