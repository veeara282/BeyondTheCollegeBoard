import java.io.Console;

public class Driver {

    public static void main(String[] args) {
	Console console = System.console();
	MyHeap heap;
	{
	    String minOrMax = console.readLine("Min heap or max heap? (m/M) ");
	    heap = new MyHeap(minOrMax.equals("M"));
	}
	for (String cmd = console.readLine("Type a number to add, 'r' to remove, or 'x' to exit: ");
	     !cmd.equals("x");
	     cmd = console.readLine("> ")) {
	    if (cmd.equals("r")) {
		if (heap.size() > 0) {
		    console.printf("Removed %d\n", heap.remove());
		    console.printf(heap.toString() + '\n');
		}
		else {
		    console.printf("Cannot remove from empty heap\n");
		}
	    }
	    else {
		try {
		    int addMe = Integer.parseInt(cmd);
		    heap.add(addMe);
		    console.printf("Added %d\n", addMe);
		    console.printf(heap.toString() + '\n');
		}
		catch (NumberFormatException e) {
		    console.printf("Invalid command: %s\n", cmd);
		}
	    }
	}
    }

}
