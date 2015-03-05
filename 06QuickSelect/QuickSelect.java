import java.util.Random;

public class QuickSelect {

    Random r = new Random();

    public static void partition(int[] a, int start, int end) {
	int range = end - start,
	    pivotVal = a[start + r.nextInt(range)];
	int[] tmp = new int[range];
	for (int i = 0; i < range; i++) {
	    if (a[start + i] < pivotVal) {

	    }
	}
    }

}