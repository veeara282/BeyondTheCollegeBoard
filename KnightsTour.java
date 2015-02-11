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
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size) {
	board = new int[size][size];
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		board[i][j] = -1;
	    }
	}
    }

    
    public void solve() {
	Random r = new Random();
	int x = r.nextInt(board.length);
	int y = r.nextInt(board.length);
	solve(x, y);
    }

    public void solve(int startx, int starty){
	if (solve(startx, starty, 0))
	    System.out.println(this);
	else
	    System.out.println("no solution");
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	if (
	return false;
    }


}