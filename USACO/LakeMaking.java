import java.util.Scanner;

/**
 * March '08 Bronze, Problem #12: http://tjsct.wikidot.com/usaco-mar08-bronze
 */
public class LakeMaking {

    public static void main(String[] args) {
	String filename = "makelake.in";
	if (args.length > 0)
	    filename = args[0];
	Scanner in = new Scanner(filename);

	// Line 1: Four space-separated integers: R, C, E, N
	int[][] pasture = new int[in.nextInt()][in.nextInt()]; // R, C
	int waterLevel = in.nextInt(); // E
	int N = in.nextInt(); // N: # stomp digging instructions
	
	// Lines 2..R+1: Line i+1 describes row of squares i with C
        // space-separated integers
    }
}