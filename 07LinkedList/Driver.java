import java.util.Random;

public class Driver {

    public static void main(String[] arr) {
	Random r = new Random();

	LinkedList l = new LinkedList();
	System.out.println(l);
	System.out.println(l.size());
	System.out.println();

	for (int i = 0; i < 40; i++) {
	    l.add(r.nextInt(100));
	}
	System.out.println(l);
	System.out.println(l.size());
	System.out.println();

	for (int i = 0; i < 20; i++) {
	    l.add(l.size(), r.nextInt(100));
	}
	System.out.println(l);
	System.out.println(l.size());
	System.out.println();
    }
}