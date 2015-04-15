/**
 * Iterates backwards through the maze.
 */
public class TileCrawler implements Iterator<Tile> {

    private Tile cur;

    public boolean hasNext() {
	return cur != null;
    }

    /**
     * Returns the current tile and overwrites it with the next one
     */
    public Tile next() {
	Tile yolo = cur;
	cur = cur.prev;
	return yolo;
    }

}