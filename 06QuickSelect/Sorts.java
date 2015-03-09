import java.util.Random;
import java.util.Arrays;

public class Sorts {

    static Random r = new Random();

    /**
     * Sorts the array "in-place"
     */
    public static void quicksort(int[] a) {
    	partition(a, 0, a.length);
    }

    public static void partition(int[] a, int start, int end) {
	print(a);
	int range = end - start;
        // nothing to partition
	if (range > 1) {
	    int pivot = a[start + r.nextInt(range)];
	    System.out.println("start: " + start + " end: " + end + " pivot: " + pivot);
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
	    // A[left:right] is all the duplicates
	    for (int i = left; i < right; i++)
		tmp[i] = pivot;
	    System.arraycopy(tmp, 0, a, start, range);
	    // Finished partition

	    partition(a, start, left);
	    partition(a, right, end);
	}
    }

    public static void main(String[] args) {
    	int[] a = new int[10];
    	for (int i = 0; i < a.length; i++)
    	    a[i] = r.nextInt(50);
	print(a);
    	quicksort(a);
    	print(a);
    }

    public static void print(int[] a) {
	System.out.println(Arrays.toString(a));
    }

}