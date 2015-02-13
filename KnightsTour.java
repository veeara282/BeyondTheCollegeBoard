import java.util.*;
import java.io.*;

public class KnightsTour {
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][] board;

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

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	for (int[] row: board) {
	    for (int cell: row) {
		ans += cell + "\t";
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size) {
	if (size > 0) {
	    board = new int[size][size];
	    reset();
	}
	else {
	    throw new IllegalArgumentException("Invalid board size: "+size);
	}
    }

    public void reset() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		board[i][j] = 0;
	    }
	}
    }
    
    public void solve() {
	/*	BitSet solutions = new BitSet(board.length * board.length);
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board.length; y++) {
		solutions.set(x * board.length + y, solve(x, y));
	    }
	}
	System.out.println(solutions.cardinality() + " solutions");
	*/
	if (solve(0,0)) System.out.println("solution (0, 0)");
    }

    public boolean solve(int startx, int starty) {
	return solve(startx, starty, 1);
    }
		
    public boolean solve(int x, int y, int move) {
       	System.out.println(this);
       	wait(20);
	if (x >= 0 && x < board.length && y >= 0 && y < board.length) {
	    if (board[x][y] == 0) {
		board[x][y] = move;
		if(move == board.length * board.length
		   || solve(x-1,y-2,move+1) || solve(x+1,y-2,move+1)
		   || solve(x-2,y-1,move+1) || solve(x+2,y-1,move+1)
		   || solve(x-2,y+1,move+1) || solve(x+2,y+1,move+1)
		   || solve(x-1,y+2,move+1) || solve(x+1,y+2,move+1)) {
		    return true;
		}
		else {
		    board[x][y] = 0;
		}
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	int n;
	try {
	    n = Integer.parseInt(args[0]);
	} catch(Exception e) {
	    n = 6;
	}
	KnightsTour b = new KnightsTour(n);
	b.solve();
    }

}