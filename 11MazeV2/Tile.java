import java.util.*;

/**
 * Represents a {@link Maze} tile.
 * Each Tile is linked to the tile it was reached from.
 * When you don't need the Tile anymore, it gets garbage collected,
 * so that only the Tiles in the right solution are saved.
 */
public class Tile implements Iterable<Tile> {

    public Tile prev;

    public final int row, col, dist;

    public Tile(int row, int col) {
	this(row, col, null);
    }

    public Tile(int row, int col, Tile prev) {
	this.row = row;
	this.col = col;
	this.prev = prev;

	if (prev == null)
	    dist = 0;
	else
	    dist = prev.dist + 1;
    }

    /**
     * Manhattan distance from another tile
     * @param t the other tile.
     */
    public int distFrom(Tile t) {
	// absolute value
	int dr = t.row - row;
	dr = (dr < 0)?-dr:dr;
	int dc = t.col - col;
	dc = (dc < 0)?-dc:dc;
	return dr + dc;
    }

    public Iterator<Tile> iterator() {
	return new TileCrawler(this);
    }

}
