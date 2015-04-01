import java.util.*;
import java.awt.Point;

public class Maze extends MazeBase {

    public Maze(String filename) {
	super(filename);
    }

    public boolean solveBFS() {
	return solveBFS(false);
    }

    public boolean solveDFS() {
	return solveDFS(false);
    }

    public boolean solveBFS(boolean animate) {
	Queue<Point> moves = new LinkedList<Point>();
	for (Point p = new Point(startx, starty); moves.size() != 0; p = moves.remove()) {
	    // print
	    if (animate) {
		System.out.println(this);
	    }
	    // proceed
	    int x = p.x;
	    int y = p.y;
	    if (maze[x][y] == 'E') {
		return true;
	    }
	    if (maze[x][y] == ' ' || maze[x][y] == 'S') {
		// mark the floor
		if (maze[x][y] == ' ')
		    maze[x][y] = 'x';
		// add all 4 directions (von Neumann neighborhood)
		// they'll be removed and ignored if you can't go on them
		moves.add(new Point(x+1, y));
		moves.add(new Point(x-1, y));
		moves.add(new Point(x, y+1));
		moves.add(new Point(x, y-1));
	    }
	}
	return false;
    }

    public boolean solveDFS(boolean animate) {
	Deque<Point> moves = new LinkedList<Point>();
	for (Point p = new Point(startx, starty); moves.size() != 0; p = moves.removeFirst()) {
	    // print
	    if (animate) {
		System.out.println(this);
	    }
	    // proceed
	    int x = p.x;
	    int y = p.y;
	    if (maze[x][y] == 'E') {
		return true;
	    }
	    if (maze[x][y] == ' ' || maze[x][y] == 'S') {
		// mark the floor
		if (maze[x][y] == ' ')
		    maze[x][y] = 'x';
		// add all 4 directions (von Neumann neighborhood)
		moves.addFirst(new Point(x+1, y));
		moves.addFirst(new Point(x-1, y));
		moves.addFirst(new Point(x, y+1));
		moves.addFirst(new Point(x, y-1));
	    }
	}
	return false;
    }

    // public int[] solutionCoordinates() {
    // 	return {0};
    // }

}