import java.util.Arrays;
import java.util.Random;

public class Driver {

    public static void main(String[] arr) {
	int size;
	if (arr.length > 0)
	    size = Integer.parseInt(arr[0]);
	else
	    size = 100000;
	int[] unsorted = random(size);
	// int[] sorted = 
	// print(unsorted);
	MergeSort.sort(unsorted);
	System.out.println("Finished sorting");
	// print(unsorted);
	// print(sorted);
	// if (match(unsorted, sorted)) {
	//     System.out.println("Sort successful");
	// }
	// else {
	//     System.out.println("Sort unsuccessful");
	// }
    }

    private static int[] random(int size) {
	int[] A = new int[size];
	Random r = new Random();
	for (int i = 0; i < size; i++) {
	    A[i] = r.nextInt();
	}
	return A;
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
