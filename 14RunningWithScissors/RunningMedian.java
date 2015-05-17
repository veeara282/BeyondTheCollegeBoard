public class RunningMedian {

    private MyHeap less, more;

    public RunningMedian() {
	less = new MyHeap(true); // max heap
	more = new MyHeap(false); // min heap
    }

    public double getMedian() {
	if (isEmpty())
	    throw new IllegalStateException("Median of an empty list is undefined");
	if (less.size() > more.size())
	    return less.peek();
	if (less.size() == more.size())
	    return (less.peek() + more.peek()) / 2.0;
	return more.peek();
    }

    public void add(int v) {
	if (isEmpty() || v < getMedian())
	    less.add(v);
	else
	    more.add(v);
	rebalance();
    }

    /* Restores balance to the Force */
    private void rebalance() {
	int e = less.size() - more.size();
	if (e > 1)
	    more.add(less.remove());
	else if (e < -1)
	    less.add(more.remove());
    }

    public boolean isEmpty() {
	return less.size() == 0 && more.size() == 0;
    }

}
