import java.util.Random;

public class QuickSelect {

    Random r = new Random();

    public static void partition(int[] a, int start, int end) {
	int range = end - start,
	    pivotVal = a[start + r.nextInt(range)];
	int[] tmp = new int[range];
	int left = start, right = end;
	for (int i = start; i < end; i++) {
	    if (a[i] < pivotVal)
		tmp[left++] = a[i++];
	    else if (a[i] > pivotVal)
		tmp[right--] = a[i++];
	}
	for (int i = left; i < right; i++)
	    tmp[i] = pivotVal;
	partition(a, start, left);
	partition(a, right, end);
    }

}
