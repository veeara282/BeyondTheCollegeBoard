public class NQueens {

    public String name() {
	return "fitzgerald.aidan";
    }

    private char[][] board;

    public NQueens(int size) {
	board = new char[size][size];
    }

    public boolean solve() {
	// return solve(0, 0, board.length);
	for (int x = 0; x < board.length; x++) {
	    if (solve(x, 0, board.length)) {
		return true;
	    }
	}
	return false;
    }

    private boolean solve(int x, int y, int n) {
	// print
	System.out.println(this);
	wait(500);
	// begin
	if (inBounds(x, y)) {
	    if (board[x][y] == ' ') {
		board[x][y] = 'Q';
		// Base: no more pieces to put on board
		if ((n == 0 || !threatened(x, y))
		    // the knight can go anywhere the queen can't go (within the 5x5 neigh-borhood)
		    // and vice versa, so the knight's moves are a good heuristic
		    && solve(x-1,y-2,n-1) || solve(x+1,y-2,n-1)
		    || solve(x-2,y-1,n-1) || solve(x+2,y-1,n-1)
		    || solve(x-2,y+1,n-1) || solve(x+2,y+1,n-1)
		    || solve(x-1,y+2,n-1) || solve(x+1,y+2,n-1)) {
		    return true;
		}
		board[x][y] = ' ';
	    }
	}
	return false;
    }

    private boolean threatened(int x, int y) {
	return threatened(x + rowIncr(0), y + colIncr(0), 0)
	    || threatened(x + rowIncr(1), y + colIncr(1), 1)
	    || threatened(x + rowIncr(2), y + colIncr(2), 2)
	    || threatened(x + rowIncr(3), y + colIncr(3), 3)
	    || threatened(x + rowIncr(4), y + colIncr(4), 4)
	    || threatened(x + rowIncr(5), y + colIncr(5), 5)
	    || threatened(x + rowIncr(6), y + colIncr(6), 6)
	    || threatened(x + rowIncr(7), y + colIncr(7), 7);
    }

    /**
     * Directions:
     * 7 0 1
     * 6 x 2
     * 5 4 3
     */
    private boolean threatened(int x, int y, int direction) {
	return inBounds(x, y) && board[x][y] == 'Q'
	    || threatened(x + rowIncr(direction), y + colIncr(direction), direction);
    }

    /* +1 is down, -1 is up */
    private int rowIncr(int direction) {
	switch (direction) {
	case 7: case 0: case 1:  return -1; // go up
	case 6: /*mid*/ case 2:  return 0;
	case 5: case 4: case 3:  return 1; // go down
	default:
	    throw new IllegalArgumentException("direction must be in [0, 8)");
	}
    }

    /* +1 is right, -1 is left */
    private int colIncr(int direction) {
	switch (direction) {
	case 1: case 2: case 3:  return 1; // go right
	case 0: /*mid*/ case 4:  return 0;
	case 7: case 6: case 5:  return -1; // go left
	default:
	    throw new IllegalArgumentException("direction must be in [0, 8)");
	}
    }

    private boolean inBounds(int x, int y) {
	return x >= 0 && x < board.length && y >= 0 && y < board.length;
    }

    // DISPLAYING

    public String toString() {
	StringBuilder yolo = new StringBuilder();
	yolo.append(hide).append(clear).append(go(0,0));
	for (char[] row: board) {
	    yolo.append(row).append('\n');
	}
	return yolo.append(show).toString();
	//return hide + clear + go(0,0) + ans + "\n" + show;

    }

    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

}
