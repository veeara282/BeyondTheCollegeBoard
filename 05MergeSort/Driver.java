public class Driver {

    public static void main(String[] arr) {
	int[] unsorted = {6, 5, 3, 1, 8, 7, 2, 4};
	int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8};
	print(unsorted);
	MergeSort.sort(unsorted);
	System.out.println("Finished sorting");
	print(unsorted);
	print(sorted);
	if (match(unsorted, sorted)) {
	    System.out.println("Sort successful");
	}
	else {
	    System.out.println("Sort unsuccessful");
	}
    }

    public static void print(int[] A) {
	for (int n: A) {
	    System.out.print(n + " ");
	}
	System.out.println();
    }

    private static boolean match(int[] A, int[] B) {
	if (A.length != B.length) {
	    return false;
	}
	for (int i = 0; i < A.length; i++) {
	    if (A[i] != B[i]) {
		return false;
	    }
	}
	return true;
    }
}
