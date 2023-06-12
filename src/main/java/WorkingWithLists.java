import java.io.*;
import java.util.List;

public class WorkingWithLists implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static void clearAllLists() { //можно потом доработать метод так, что б он принимал параметр с цифрой
        // и по ней чистил все правды и действиятолько для определенного режима игры, либо чистил только
        // листы с правдой, или чистил только листы для девушек или только для парней
        GameLists.easyTruthMan.clear();
        GameLists.easyTruthWoman.clear();
        GameLists.easyActionMan.clear();
        GameLists.easyActionWoman.clear();
        GameLists.normalTruthMan.clear();
        GameLists.normalTruthWoman.clear();
        GameLists.normalActionMan.clear();
        GameLists.normalActionWoman.clear();
        GameLists.hardTruthMan.clear();
        GameLists.hardTruthWoman.clear();
        GameLists.hardActionMan.clear();
        GameLists.hardActionWoman.clear();
        GameLists.iNever.clear();
        GameLists.crocodile.clear();
    }

    public static void serializeLists() {
        try {
            FileOutputStream fileOut = new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GameLists.easyTruthMan);
            out.writeObject(GameLists.easyTruthWoman);
            out.writeObject(GameLists.normalTruthMan);
            out.writeObject(GameLists.normalTruthWoman);
            out.writeObject(GameLists.hardTruthMan);
            out.writeObject(GameLists.hardTruthWoman);
            out.writeObject(GameLists.easyActionMan);
            out.writeObject(GameLists.easyActionWoman);
            out.writeObject(GameLists.normalActionMan);
            out.writeObject(GameLists.normalActionWoman);
            out.writeObject(GameLists.hardActionMan);
            out.writeObject(GameLists.hardActionWoman);
            out.writeObject(GameLists.iNever);
            out.writeObject(GameLists.crocodile);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void deserializeLists() {
        try {
            FileInputStream fileIn = new FileInputStream("data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            GameLists.easyTruthMan = (List<String>) in.readObject();
            GameLists.easyTruthWoman = (List<String>) in.readObject();
            GameLists.normalTruthMan = (List<String>) in.readObject();
            GameLists.normalTruthWoman = (List<String>) in.readObject();
            GameLists.hardTruthMan = (List<String>) in.readObject();
            GameLists.hardTruthWoman = (List<String>) in.readObject();
            GameLists.easyActionMan = (List<String>) in.readObject();
            GameLists.easyActionWoman = (List<String>) in.readObject();
            GameLists.normalActionMan = (List<String>) in.readObject();
            GameLists.normalActionWoman = (List<String>) in.readObject();
            GameLists.hardActionMan = (List<String>) in.readObject();
            GameLists.hardActionWoman = (List<String>) in.readObject();
            GameLists.iNever = (List<String>) in.readObject();
            GameLists.crocodile = (List<String>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("List class not found");
            c.printStackTrace();
            return;
        }
    }

}
