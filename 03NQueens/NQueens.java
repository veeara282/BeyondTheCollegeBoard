public class NQueens {

    public String name() {
	return "fitzgerald.aidan";
    }

    private char[][] board;

    public NQueens(int size) {
	board = new char[size][size];
        clear();
    }

    public boolean solve() {
	return solve(0, 0);
    }

    private boolean solve(int x, int y) {
	// print
	//	System.out.println(this);
	//	System.out.println(x + ", " + y);
	//	wait(200);
	// begin

	// Base case: run past bottom of board - done
	if (x >= board.length) {
	    return true;
	}
	// Base case: end of row (or middle of first row) - backtrack
	if (y >= board.length || x == 0 && y >= board.length/2) {
	    clearRow(x - 1);
	    return false;
	}
	// run past end of row - next row
	if (safe(x, y)) {
	    // Only queen in this row
	    board[x][y] = 'Q';
	    // Move to next row
	    if (solve(x + 1, 0)) {
		return true;
	    }
	    // Backtrack
	    else {
		return solve(x, y + 1);
	    }
	}
	else {
	    // Don't put a queen, move to next row
	    return solve(x, y + 1);
	}
    }

    // Iterative safety check (via Eric Lin)
    private boolean safe(int x, int y) {
	for (int tx = 0; tx < board.length; tx++) {
	    for (int ty = 0; ty < board.length; ty++) {
		if ((x == tx ^ y == ty // horizontal or vertical
		     || Math.abs(x - tx) == Math.abs(y - ty)) // diagonal
		    && board[tx][ty] == 'Q') {
		    return false;
		}
	    }
	}
	return true;
    }

    private boolean inBounds(int x, int y) {
	return x >= 0 && x < board.length && y >= 0 && y < board.length;
    }

    private void clear() {
	for (int x = 0; x < board.length; x++) {
	    clearRow(x);
	}
    }

    private void clearRow(int x) {
	for (int y = 0; y < board.length; y++) {
	    board[x][y] = ' ';
	}
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
