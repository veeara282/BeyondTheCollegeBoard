public class Recursion implements hw1 {

    public String name() {
	return "Fitzgerald,Aidan";
    }

    public int fact(int n) {
	if (n < 0)
	    throw new IllegalArgumentException("Invalid input: " + n);
	else if (n == 0)
	    return 1;
	else
	    return n * fact(n-1);
    }

    public int fib(int n) {
	if (n < 0)
	    throw new IllegalArgumentException("Invalid input: " + n);
	else if (n == 0 || n == 1)
	    return n;
	else
	    return fib(n-1) + fib(n-2);
    }

    public double sqrt(double n) {
	if (n == 0)
	    return 0;
	else if (n < 0)
	    throw new IllegalArgumentException("Invalid input: " + n);
	else
	    return qrooty(n, n);
    }

    private double qrooty(double n, double guess) {
	System.out.println(guess+", "+Math.sqrt(n));
        double error = guess * guess - n, tolerance = 1e-8 * n;
	if (error < tolerance || error > -tolerance)
		    //	if (guess * guess == n)
	    return guess;
	else
	    return qrooty(n, (guess + n/guess) / 2);
    }
}
