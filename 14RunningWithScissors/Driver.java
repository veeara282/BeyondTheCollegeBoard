import java.util.Random;

public class Driver {

    public static void main(String[] pffft) {
	RunningMedian set = new RunningMedian();

	int n;
	if (pffft.length > 0)
	    n = Integer.parseInt(pffft[0]);
	else
	    n = 1000;

	long seed;
	if (pffft.length > 1)
	    seed = Long.parseLong(pffft[1]);
	else
	    seed = 0x201505141210L;
	Random r = new Random(seed);

	for (int i = 0; i < n; i++)
	    set.add(r.nextInt(50000));
	System.out.println(set.getMedian());
    }

}