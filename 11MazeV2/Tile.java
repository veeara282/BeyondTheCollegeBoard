/**
 * Represents a {@link Maze} tile.
 * Each Tile is linked to the tile it was reached from.
 * When you don't need the Tile anymore, it gets garbage collected,
 * so that only the Tiles in the right solution are saved.
 */
public class Tile {

    public Tile prev;

    public int row, col;

    public Tile(int row, int col) {
	this(row, col, null);
    }

    public Tile(int row, int col, Tile prev) {
	this.row = row;
	this.col = col;
	this.prev = prev;
    }

}