public class Driver {

    public static void main(String[] args) {
	try {
	    boolean reverse = args[0].equals("-r");
	    int[] a;
	    if (reverse)
		a = new int[args.length - 1];
	    else
		a = new int[args.length];

	    for (int i = 0; i < a.length; i++) {
		a[i] = Integer.parseInt(args[i + (reverse?1:0)]);
	    }

	    Heapsort.heapsort(a, reverse);

	    print(a);
	} catch (Exception e) {
	    System.err.println("Usage: java Driver [-r] [ints separated by spaces]");
	}
    }

    public static void print(int[] a) {
	for (int n: a) {
	    System.out.print(n + " ");
	}
	System.out.println();
    }

}
