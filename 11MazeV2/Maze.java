import java.util.*;
import java.awt.Point;

public class Maze extends MazeBase {

    public static final int DFS = 0, BFS = 1;

    public boolean solve(int mode) {
	Deque<Point> moves = new LinkedList<>();
	for (Point p = new Point(startx, starty); moves.size() != 0; p = moves.remove()) {
	    int x = p.x;
	    int y = p.y;
	    if (maze[x][y] == 'E') {
		return true;
	    }
	    if (maze[x][y] == ' ') {
		// mark the floor
		maze[x][y] = '@';
		// add all 4 directions (von Neumann neighborhood)
		Deque<Point> next = new LinkedList<>();
		next.add(new Point(x+1, y));
		next.add(new Point(x-1, y));
		next.add(new Point(x, y+1));
		next.add(new Point(x, y-1));
		if (mode == DFS) {
		    // stack: add to the front
		    next.addAll(moves);
		    moves = next;
		}
		else if (mode == BFS) {
		    // queue: add to the end
		    moves.addAll(next);
		}
	    }
	}
    }
}