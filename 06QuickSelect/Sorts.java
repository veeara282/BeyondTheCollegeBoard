import java.util.Random;
import java.util.Arrays;

public class Sorts {

    static Random r = new Random();

    /**
     * Sorts the array "in-place"
     */
    public static void quicksort(int[] a) {
    	partition(a, 0, a.length, 0);
    }

    public static void partition(int[] a, int start, int end, int depth) {
	///print(a);
	int range = end - start;
	    
	// indent depth spaces
	for (int i = 0; i < depth; i++)
	    System.out.print(' ');
	System.out.print("start: " + start + " end: " + end);

        // nothing to partition
	if (range <= 1) {
	    System.out.println();
	    return;
	}

	int pivot = a[start + r.nextInt(range)];
	System.out.println(" pivot: " + pivot);
	// Do the dirty work in temp array
	int[] tmp = new int[range];
	int left = 0, right = range;
	for (int i = start; i < end; i++) {
	    //System.out.println("left: " + left + " right: " + right);
	    //print(tmp);
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

	partition(a, start, left, depth+1);
	partition(a, right, end, depth+1);
	
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
