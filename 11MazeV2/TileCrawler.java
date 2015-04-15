import java.util.Iterator;

/**
 * Iterates backwards through the maze.
 */
public class TileCrawler implements Iterator<Tile> {

    private Tile cur;

    public TileCrawler(Tile start) {
	cur = start;
    }

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

    public void remove() {
	throw new UnsupportedOperationException("You can't remove a tile from the solution to a maze. It just doesn't make sense.");
    }

}
