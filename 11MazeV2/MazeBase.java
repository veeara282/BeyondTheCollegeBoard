import java.util.*;
import java.io.*;
public abstract class MazeBase {

    // You get direct random access to these...
    protected char[][] maze;
    protected int startx, starty;

    // ...but not these
    private int maxx, maxy;

    public MazeBase(String filename) {
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

    // Terminal muck

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    // used in Driver.java line 11
    // just before solving
    public void clearTerminal() {
	System.out.println(clear);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString() {
	StringBuilder ans = new StringBuilder(maxx).append(',').append(maxy).append('\n');
	for (char[] row: maze) {
	    for (char cell: row) {
		ans.append(cell).append(' ');
	    }
	    ans.append('\n');
	}
	return ans.toString();
    }

    public String toString(boolean animate) {
	if (!animate)
	    return toString();
	return hide + go(0,0) + toString() + "\n" + show;
    }
}
