import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
	BTree<Integer> tree = new BTree<Integer>();

	Scanner sc = new Scanner(System.in);
	while (true) {
	    if (sc.hasNextInt()) {
		Integer i = sc.nextInt();
		tree.add(i);
		print(tree);
	    }
	    else {
		String cmd = sc.next();
		//switch (cmd) {
		    //case "r": case "rm": case "remove": case "delete":
		    // remove;
		    //break;
		//case "q": case "quit":
		if (cmd.equals("q")) {
		    System.exit(0);
		}
		else if (cmd.equals("p")) {
		    print(tree);
		}
	    }
	}
    }

    private static void print(BTree tree) {
	System.out.println();
	System.out.println();
	System.out.println(tree);
	System.out.println();
    }
}