package kamene;

import java.lang.reflect.Array;
import java.util.Random;

public class Field {

    private Tile[][] tiles;

    private final int rowCount;

    private final int columnCount;

    private final int emptytileCount;

    public Field(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.emptytileCount = 1;

        tiles = new Tile[rowCount][columnCount];

        //generate the field content
        generateFieldBoard();
    }

    public Tile getTiles(int row, int col) {
        return tiles[row][col];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getEmptytile() {
        return emptytileCount;
    }

    public void setTiles(Tile oldTile, Tile newTile) {
        Tile temp = oldTile;
        oldTile = newTile;
        newTile = temp;
    }

    private void generateFieldBoard() {
        Random rand = new Random();
        int counter = 0, r, c;

        while(counter < emptytileCount) {
            r = rand.nextInt(rowCount);
            c = rand.nextInt(columnCount);
            if(tiles[r][c] == null) {
                tiles[r][c] = new EmptyTile();
                counter++;
                //assert counter > 0;
            }
        }

        int[][] filled = new int[rowCount][columnCount];
        int count = 1;

        for (r = 0; r < rowCount; r++) {
            for (c = 0; c < columnCount; c++) {
                if(tiles[r][c] == null) {
                    filled[r][c] = r + c;
                    tiles[r][c] = new FilledTile(count++);
                }
            }
        }
    }
}
