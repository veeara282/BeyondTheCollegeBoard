import java.util.Random;

public class Driver {

    public static void main(String[] arr) {
	Random r = new Random();

	LinkedList l = new LinkedList();
	for (int i = 0; i < 40; i++) {
	    l.add(r.nextInt(100));
	}

	System.out.println(l);
    }
}