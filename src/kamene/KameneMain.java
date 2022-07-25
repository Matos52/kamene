package kamene;

import console.ConsoleUI;

public class KameneMain {

    public static ConsoleUI consoleUI;

    private long timeMeasure = System.currentTimeMillis();

    private static KameneMain instance;

    private Options option;

    public static KameneMain getInstance() {
        if(instance == null) {
            new KameneMain();
        }
        return instance;
    }

    private KameneMain() {
        instance = this; //singleton
        option = Options.load();

        Field field = new Field(option.getRowCount(), option.getColumnCount());

        consoleUI = new ConsoleUI();
        consoleUI.startOfNewGame(field);
    }

    public static void main(String[] args) {
        KameneMain.getInstance();
    }

    public void setOption(Options option) {
        this.option = option;
        this.option.save();
    }

    public int getPlayingSeconds() {
        return (int) ((System.currentTimeMillis() - timeMeasure)/1000);
    }




}
