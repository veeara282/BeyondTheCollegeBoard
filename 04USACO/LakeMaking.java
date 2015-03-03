import java.util.Scanner;

/**
 * March '08 Bronze, Problem #12: http://tjsct.wikidot.com/usaco-mar08-bronze
 */
public class LakeMaking {

    public static void main(String[] args) {
	String filename = "makelake.in";
	if (args.length > 0)
	    filename = args[0];
	Scanner in = new Scanner(filename).useDelimiter("\\D");

	// Line 1: Four space-separated integers: R, C, E, N
	int rows = in.nextInt();
	int cols = in.nextInt();
	int[][] pasture = new int[rows][cols]; // R, C
	int waterLevel = in.nextInt(); // E
	int N = in.nextInt(); // N: # stomp digging instructions
	
	// Lines 2..R+1: Line i+1 describes row of squares i with C
        // space-separated integers
	for (int r = 0; r < pasture.length; r++) {
	    for (int c = 0; c < pasture[0].length; c++) {
		pasture[r][c] = in.nextInt();
	    }
	}

	// Lines R+2..R+N+1: Line i+R+1 describes stomp-digging instruction i
        // with three integers: R_s, C_s, and D_s
	for (int i = 0; i < N; i++) {
	    int r = in.nextInt(), c = in.nextInt(), dz = in.nextInt();
	    depress(pasture, r, c, dz);
	}

	// Fill the lake
	System.out.println(lakeVolume(pasture, waterLevel));
    }

    public static int[][] depress(int[][] pasture, int row, int col, int dz) {
	if (row + 2 < pasture.length || col + 2 < pasture[0].length) {
	    return pasture;
	}
	// Find highest elevation
	int highest = 0;
	for (int dr = 0; dr < 3 && row + dr < pasture.length; dr++) {
	    for (int dc = 0; dc < 3 && col + dc < pasture[0].length; dc++) {
		if (pasture[row+dr][col+dc] > highest) {
		    highest = pasture[row+dr][col+dc];
		}
	    }
	}
	// Stomp digging
	for (int dr = 0; dr < 3 && row + dr < pasture.length; dr++) {
	    for (int dc = 0; dc < 3 && col + dc < pasture[0].length; dc++) {
		if (pasture[row+dr][col+dc] > highest - dz) {
		    pasture[row+dr][col+dc] = highest - dz;
		}
		if (pasture[row+dr][col+dc] < 0) {
		    pasture[row+dr][col+dc] = 0;
		}
	    }
	}
	return pasture;
    }

    public static int lakeVolume(int[][] pasture, int elevation) {
	int yolo = 0;
	for (int row = 0; row < pasture.length; row++) {
	    for (int col = 0; col < pasture[0].length; col++) {
		int swag = elevation - pasture[row][col];
		if (swag > 0)
		    yolo += swag;
	    }
	}
	return yolo * 72 * 72;
    }
}