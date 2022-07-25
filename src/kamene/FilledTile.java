package kamene;

public class FilledTile extends Tile {

    private final int value;

    public FilledTile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
