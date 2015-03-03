class Driver {

    public static void main(String[] args) {
	int n;
	try {
	    n = Integer.parseInt(args[0]);
	} catch(Exception e) {
	    n = 5;
	}
        NQueens b = new NQueens(n);
	if (b.solve())
	    System.out.print(b);
	else
	    System.out.println("no solution");
    }

}
