import java.util.Random;

class WarpDrive {

    public static void main(String[] robot) {
	hw1 test = new Recursion();
	System.out.println(test.name());
	System.out.println();
	System.out.println("7! = "+ 7*720 + " = " + test.fact(7));
	System.out.println("12_P_3 = 1320 = " + test.fact(12)/test.fact(9));
	System.out.println();
	System.out.println("F_5 = 5 = " + test.fib(5));
	System.out.println("F_10 = 55 = " + test.fib(10));
	System.out.println();
	testCassiniIdentity(test);
    }

    public static void testCassiniIdentity(hw1 test) {
	System.out.println("Cassini identity:");
	Random r = new Random();
	int n = r.nextInt(50);
	int value, expected;
	if (n % 2 == 1)
	    expected = 1;
	else
	    expected = -1;
	value = test.fib(n)*test.fib(n) - test.fib(n+1)*test.fib(n-1);
	System.out.println("(F_"+n+")^2 - (F_"+(n+1)+")(F_"+(n-1)+") " + 
			   "= (-1)^" +(n-1) + ": " + (value == expected));
    }
}
