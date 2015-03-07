import java.util.Random;
import java.util.Arrays;

public class QuickSelect {

    static Random r = new Random();

    /**
     * @return kth smallest element of a
     */
    public static int quickSelect(int[] a, int k) {
    	return partition(a, k, 0, a.length);
    }

    public static int partition(int[] a, int k, int start, int end) {
	print(a);
	int range = end - start,
	    pivot = a[start + r.nextInt(range)];
	System.out.println("start: " + start + " end: " + end + " pivot: " + pivot);
        // nothing to partition
	// if (range <= 1)
	//     return;
	// otherwise continue
	int[] tmp = new int[range];
	int left = 0, right = range;
	for (int i = start; i < end; i++) {
	    //System.out.println("left: " + left + " right: " + right);
	    print(tmp);
	    if (a[i] < pivot)
		tmp[left++] = a[i];
	    else if (a[i] > pivot)
		tmp[--right] = a[i];
	}
	for (int i = left; i < right; i++)
	    tmp[i] = pivot;
	System.arraycopy(tmp, 0, a, start, range);
	// Finished partition

	if (left <= k && k < right)
	    return pivot;
	else if (k < left)
	    return partition(a, k, start, left);
	else	
	    return partition(a, k, right, end);
    }

    public static void main(String[] args) {
    	int[] a = new int[10];
    	for (int i = 0; i < a.length; i++)
    	    a[i] = r.nextInt(50);
    	// quicksort(a);
    	print(a);
	int k = r.nextInt(a.length);
	System.out.println("k: " + k);
	System.out.println(quickSelect(a, k));
    }

    public static void print(int[] a) {
	System.out.println(Arrays.toString(a));
    }

}
