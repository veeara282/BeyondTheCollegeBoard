class Prime {

    static boolean isPrime(int n) {
	return prm(n, 2);
    }

    private static boolean prm(int n, int p) {
	if (n <= 1)
	    return false;
	else if (n < p*p)
	    return true;
	else
	    return n % p != 0 && prm(n, p+1);
    }
}