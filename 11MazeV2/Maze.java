import java.util.*;
import java.awt.Point;

public class Maze extends MazeBase {

    private Tile solution = null;

    public Maze(String filename) {
	super(filename);
    }

    public boolean solveBFS() {
	return solveBFS(false);
    }

    public boolean solveDFS() {
	return solveDFS(false);
    }

    public boolean solveBest() {
	return solveBest(false);
    }

    public boolean solveAStar() {
	return solveAStar(false);
    }

    private static final int BFS = 0, DFS = 1, best = 2, AStar = 3;

    public boolean solveBFS(boolean animate) {
	return solve(BFS, animate);
    }

    public boolean solveDFS(boolean animate) {
	return solve(DFS, animate);
    }

    public boolean solveBest(boolean animate) {
	return solvePQ(best, animate);
    }

    public boolean solveAStar(boolean animate) {
	return solvePQ(AStar, animate);
    }

    public boolean solve(int mode, boolean animate) {
	if (mode == best || mode == AStar) {
	    return solvePQ(mode, animate);
	}
	Deque<Tile> moves = new LinkedList<Tile>();
	Tile p = new Tile(startx, starty);
	moves.addFirst(p);
	while (moves.size() != 0) {
	    p = moves.removeFirst();
	    animate(animate);
	    // proceed
	    int x = p.row;
	    int y = p.col;
	    if (maze[x][y] == 'E') {
		// save the last tile removed
		solution = p;
		// backtrack thru the maze
		for (Tile bk: solution) {
		    if (maze[bk.row][bk.col] == '.') {
			maze[bk.row][bk.col] = '@';
			animate(animate);
		    }
		}
		return true;
	    }
	    if (maze[x][y] == ' ' || maze[x][y] == 'S') {
		// mark the floor
		if (maze[x][y] == ' ')
		    maze[x][y] = '.';
		// add all 4 directions (von Neumann neighborhood)
		// when we reach them, they'll be ignored and garbage collected
		// if you can't go on them
		if (mode == BFS) {
		    moves.addLast(new Tile(x+1, y, p));
		    moves.addLast(new Tile(x-1, y, p));
		    moves.addLast(new Tile(x, y+1, p));
		    moves.addLast(new Tile(x, y-1, p));
		}
		else if (mode == DFS) {
		    moves.addFirst(new Tile(x+1, y, p));
		    moves.addFirst(new Tile(x-1, y, p));
		    moves.addFirst(new Tile(x, y+1, p));
		    moves.addFirst(new Tile(x, y-1, p));
		}
	    }
	}
	return false;
    }

    /**
     * Solve using either best-first or A*
     */
    private boolean solvePQ(int mode, boolean animate) {
	PriorityQueue<Tile> moves = new PriorityQueue<Tile>();
	Tile p = new Tile(startx, starty);
	moves.add(p, 0);
	
	// find E: needed for distance heuristic
	Tile goal = this.findGoal();

	while (!moves.isEmpty()) {
	    p = moves.remove();
	    animate(animate);
	    // proceed
	    int x = p.row;
	    int y = p.col;
	    if (maze[x][y] == 'E') {
		// save the last tile removed
		solution = p;
		// backtrack thru the maze
		for (Tile bk: solution) {
		    if (maze[bk.row][bk.col] == '.') {
			maze[bk.row][bk.col] = '@';
			animate(animate);
		    }
		}
		return true;
	    }
	    if (maze[x][y] == ' ' || maze[x][y] == 'S') {
		// mark the floor
		if (maze[x][y] == ' ')
		    maze[x][y] = '.';
		// add all 4 directions (von Neumann neighborhood)
		// when we reach them, they'll be ignored and garbage collected
		// if you can't go on them
		moves.add(new Tile(x+1, y, p), p.distFrom(goal) + (mode == AStar?p.dist:0));
		moves.add(new Tile(x-1, y, p), p.distFrom(goal) + (mode == AStar?p.dist:0));
		moves.add(new Tile(x, y+1, p), p.distFrom(goal) + (mode == AStar?p.dist:0));
		moves.add(new Tile(x, y-1, p), p.distFrom(goal) + (mode == AStar?p.dist:0));
	    }
	}
	return false;
    }

    private Tile findGoal() {
	for (int row = 0; row < maze.length; row++) {
	    for (int col = 0; col < maze[0].length; col++) {
		if (maze[row][col] == 'E')
		    return new Tile(row, col);
	    }
	}
	return null;
    }

    private void animate(boolean animate) {
	if (animate) {
	    System.out.println(toString(true));
	    wait(20);
	}
    }

    public int[] solutionCoordinates() {
	LinkedList<Integer> L = new LinkedList<Integer>();
	for (Tile backtrack = solution; backtrack != null; backtrack = backtrack.prev) {
	    L.addFirst(backtrack.col);
	    L.addFirst(backtrack.row);
	}
	int[] yolo = new int[L.size()];
	int i = 0;
	for (Integer n: L) {
	    yolo[i++] = n;
	}
	return yolo;
    }

}
