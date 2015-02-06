class SumDigits {

    int iterative(int n, int radix) {
	if (n < 0)
	    return iterative(-n, radix);
	int r = 0;
	while (n != 0) {
	    r += n % radix;
	    n /= radix;
	}
	return r;
    }

    int recursive(int n, int radix) {
	if (n == 0)
	    return 0;
	else if (n < 0)
	    return recursive(-n, radix);
	else
	    return n % radix + recursive(n/radix, radix);
    }

    int tailRecursive(int n, int radix) {
	if (n >= 0)
	    return sd(n, radix, 0);
	else
	    return sd(-n, radix, 0);
    }

    private int sd(int n, int radix, int part) {
	if (n == 0)
	    return part;
	else
	    return sd(n / radix, radix, part + n % radix);
    }

    int digitalRoot(int n, int radix) {
	if (n >= 0)
	    return dr(n, radix, 0);
	else
	    return dr(-n, radix, 0);
    }

    private int dr(int n, int radix, int part) {
	if (n == 0)
	    if (part < radix)
		return part;
	    else
		return dr(part, radix, 0);
	else
	    return dr(n / radix, radix, part + n % radix);
    }

    public static void main(String[] arr) {
	SumDigits s = new SumDigits();
	System.out.println(s.digitalRoot(255, 10));
    }
}