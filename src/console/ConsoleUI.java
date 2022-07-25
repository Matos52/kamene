package console;

import kamene.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI {

    private Field field;

    private EmptyTile emptyTile;

    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public void startOfNewGame(Field field) {
        System.out.println("Choose difficulty -> (1) Student,(2) Master, (Enter) Default");
        String checker = readLine();
        if(checker != null && !checker.equals("")){
            try {
                int intLevel = Integer.parseInt(checker);
                Options o;
                switch (intLevel) {
                    case 1:
                        o = Options.STUDENT;
                        break;
                    case 2:
                        o = Options.MASTER;
                        break;
                    default:
                        o = Options.MASTER;
                };
                KameneMain.getInstance().setOption(o);
                this.field = new Field(o.getRowCount(), o.getColumnCount());

            } catch (NumberFormatException e) {

            }
        }

        do {
            update();
        } while (true);

    }

    public void update() {
        System.out.printf("Hraci cas: %d%n", KameneMain.getInstance().getPlayingSeconds());
        System.out.println("Zadaj (W) pre posun prazdnej dlazdice smerom hore, (A) pre posun dolava, (S) pre posun smerom nadol, (D) pre posun doprava");

        for (int r = 0; r < field.getRowCount(); r++) {
            for (int c = 0; c < field.getColumnCount(); c++) {
                System.out.printf("%5s", field.getTiles(r, c));
            }
            System.out.println();
        }

        String choice = readLine();

        switch (choice) {
            case "New":
                break;
            case "Exit":
                System.out.printf("Cas hrania: %d%n", KameneMain.getInstance().getPlayingSeconds());
                System.out.println("Koniec hry");
                System.exit(0);
            case "W":
                goUp();
                break;
            case "A":
                goLeft();
                break;
            case "S":
                goDown();
                break;
            case "D":
                goRight();
                break;
        }
    }

    public void goRight() {
        for (int r = 0; r < field.getRowCount(); r++) {
            for (int c = 0; c < field.getColumnCount(); c++) {
                if (field.getTiles(r, c) instanceof EmptyTile) {
                    if (r + 1 < field.getRowCount()) {
                        field.setTiles(field.getTiles(r, c), field.getTiles(r + 1, c));
                    }
                }
            }
        }
    }


    public void goLeft() {
        for (int r = 0; r < field.getRowCount(); r++) {
            for (int c = 0; c < field.getColumnCount(); c++) {
                if(field.getTiles(r,c) instanceof EmptyTile) {
                    if(r + 1 < field.getRowCount()) {
                        field.setTiles(field.getTiles(r, c), field.getTiles(r - 1, c));
                    }
                }
            }
        }
    }

    public void goUp() {

    }

    public void goDown() {

    }
}

