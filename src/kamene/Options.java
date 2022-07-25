package kamene;

import java.io.*;

public class Options implements Serializable {

    private final int rowCount;

    private final int columnCount;

    public static final Options STUDENT = new Options(4,4);

    public static final Options MASTER = new Options(8,8);

    private static final String OPTION_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + "kamene.settings";


    public Options(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public void save() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(OPTION_FILE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Not possible to write to an object");
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static Options load() {
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream(OPTION_FILE);
            ois = new ObjectInputStream(fis);
            Options s = (Options) ois.readObject();
            return s;
        } catch (IOException e) {
            System.out.println("Not possible to open options, using default STUDENT");
        } catch (ClassNotFoundException e) {
            System.out.println("Not possible to read options, using default STUDENT");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {

                }
            }
        }
        return STUDENT;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }


}
