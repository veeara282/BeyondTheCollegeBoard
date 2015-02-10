import java.awt.Point;

public class Maze {

    /**
     * Characters:
     * 'X' - wall
     * ' ' - space
     * 'S' - start
     * 'E' - end
     * '.' - incorrect path
     * '@' - correct path
     */
    public char[][] solve(char[][] maze) {
	int x = 0, y = 0;
	return solver(maze, x, y);
    }

}