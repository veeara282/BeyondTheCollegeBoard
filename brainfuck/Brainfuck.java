import java.io.*;
import java.util.Scanner;

/**
 * Brainfuck interpreter
 */
public class Brainfuck implements Runnable {

    public static void main(String[] args) {
	if (args.length == 0) {
	    System.out.println("Brainfuck 1.0-alpha");
	    System.out.println(">\t increment pointer");
	    System.out.println("<\t decrement pointer");
	    System.out.println("+\t increment current byte");
	    System.out.println("-\t decrement current byte");
	    System.out.println(",\t read byte");
	    System.out.println(".\t write byte");
	    System.out.println("[\t jump forward");
	    System.out.println("]\t jump backward");
	    System.exit(0);
	}
	Brainfuck fuck = new Brainfuck(args[0]);
	fuck.run();
    }

    private int[] store;
    private String program;

    public Brainfuck(String filename) {
	// Create empty array (default 32 KB)
	store = new int[1 << 15];
	// Load program (immutable)
	program = load(filename);
    }

    /**
     * via http://stackoverflow.com/a/7449797
     */
    public String load(String filename) {
	try {
	    return new Scanner(new File(filename), "UTF-8").useDelimiter("\\A").next();
	}
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public void run() {
	for (int instr = 0, ptr = 0; instr < program.length(); instr++) {
	    switch(program.charAt(instr)) {
	    case '>': ptr++; break;
	    case '<': ptr--; break;
	    case '+': store[ptr]++; break;
	    case '-': store[ptr]--; break;
	    case ',': read(ptr); break;
	    case '.': System.out.write(store[ptr]); break;
	    case '[': instr = jumpRight(instr); break;
	    case ']': instr = jumpLeft(instr); break;
	    }
	}
    }

    private void read(int ptr) {
	try {
	    store[ptr] = System.in.read();
	}
	catch (IOException e) {
	    // ignore the error...
	}
    }

    private int jumpRight(int ptr) {
	int depth = 0;
	do {
	//	while (depth > 0) {
	    if (program.charAt(ptr) == '[')
		depth++;
	    if (program.charAt(ptr) == ']')
		depth--;
	    ptr++;
	}
	while (depth > 0);
	return ptr;
    }

    private int jumpLeft(int ptr) {
	int depth = 1;
	do {
	    //	while (depth > 0) {
	    if (program.charAt(ptr) == '[')
		depth--;
	    if (program.charAt(ptr) == ']')
		depth++;
	    ptr--;
	}
	while (depth > 0);
	return ptr;
    }

}