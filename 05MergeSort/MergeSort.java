public class MergeSort {

    public static int[] sort(int[] A) {
	return sortSub(A, 0, A.length);
    }

    /**
     * Sorts elements [start, end - 1].
     */
    private static int[] sortSub(int[] A, int start, int end) {
	// Diagnostic
	// Driver.print(A);
	int subLen = end - start;
	if (subLen == 1) {
	    return A;
	}
	else if (subLen == 2) {
	    return swap(A, start, start + 1);
	}
	else {
	    // Cut in half and sort each half
	    int middle = start + subLen / 2;
	    sortSub(A, start, middle);
	    sortSub(A, middle, end);
	    // Merge the two halves
	    return merge(A, start, middle, end);
	}
    }

    private static int[] swap(int[] A, int first, int second) {
	if (A[first] > A[second]) {
	    int swap = A[first];
	    A[first] = A[second];
	    A[second] = swap;
	}
	return A;
    }

    /**
     * Merges the sublists [start, middle - 1] and [middle, end - 1]
     * Solution via http://stackoverflow.com/a/8949433/2276567
     */
    private static int[] merge(int[] A, int start, int middle, int end) {
	int[] tmp = new int[end - start];
	// i, j = current indices of both sublists, k = current index of tmp
	int i = 0, j = 0, k = 0;
	// Merge the heads
	while (i < middle - start && j < end - middle) {
	    if (A[start + i] <= A[middle + j])
		tmp[k++] = A[start + i++];
	    else
		tmp[k++] = A[middle + j++];
	}
	// Get the rest of the lists
	while (i < middle - start)
	    tmp[k++] = A[start + i++];
	while (j < end - middle)
	    tmp[k++] = A[middle + j++];
	// Copy tmp back into A
	System.arraycopy(tmp, 0, A, start, tmp.length);
	return A;
    }
}
