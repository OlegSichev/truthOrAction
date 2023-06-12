import java.io.*;
import java.util.List;

public class WorkingWithLists implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static void clearAllLists() { //можно потом доработать метод так, что б он принимал параметр с цифрой
        // и по ней чистил все правды и действиятолько для определенного режима игры, либо чистил только
        // листы с правдой, или чистил только листы для девушек или только для парней
        gameLists.easyTruthMan.clear();
        gameLists.easyTruthWoman.clear();
        gameLists.easyActionMan.clear();
        gameLists.easyActionWoman.clear();
        gameLists.normalTruthMan.clear();
        gameLists.normalTruthWoman.clear();
        gameLists.normalActionMan.clear();
        gameLists.normalActionWoman.clear();
        gameLists.hardTruthMan.clear();
        gameLists.hardTruthWoman.clear();
        gameLists.hardActionMan.clear();
        gameLists.hardActionWoman.clear();
    }

    public static void serializeLists() {
        try {
            FileOutputStream fileOut = new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameLists.easyTruthMan);
            out.writeObject(gameLists.easyTruthWoman);
            out.writeObject(gameLists.normalTruthMan);
            out.writeObject(gameLists.normalTruthWoman);
            out.writeObject(gameLists.hardTruthMan);
            out.writeObject(gameLists.hardTruthWoman);
            out.writeObject(gameLists.easyActionMan);
            out.writeObject(gameLists.easyActionWoman);
            out.writeObject(gameLists.normalActionMan);
            out.writeObject(gameLists.normalActionWoman);
            out.writeObject(gameLists.hardActionMan);
            out.writeObject(gameLists.hardActionWoman);
            out.writeObject(gameLists.iNever);
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
            gameLists.easyTruthMan = (List<String>) in.readObject();
            gameLists.easyTruthWoman = (List<String>) in.readObject();
            gameLists.normalTruthMan = (List<String>) in.readObject();
            gameLists.normalTruthWoman = (List<String>) in.readObject();
            gameLists.hardTruthMan = (List<String>) in.readObject();
            gameLists.hardTruthWoman = (List<String>) in.readObject();
            gameLists.easyActionMan = (List<String>) in.readObject();
            gameLists.easyActionWoman = (List<String>) in.readObject();
            gameLists.normalActionMan = (List<String>) in.readObject();
            gameLists.normalActionWoman = (List<String>) in.readObject();
            gameLists.hardActionMan = (List<String>) in.readObject();
            gameLists.hardActionWoman = (List<String>) in.readObject();
            gameLists.iNever = (List<String>) in.readObject();
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
