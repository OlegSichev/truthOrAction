import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int countTrueMan = 0;
    static int countTrueWoman = 0;
    static List<String> truthMan;
    static List<String> truthWoman;
    static List<String> actionMan;
    static List<String> actionWoman;

    static int countPlayers = Players.players.size(); //todo
    static int cycleCount = 0;

    public static void gameLevel() {
        System.out.println("Выберите сложность игры:\n1.Разминка\n2.Вечеринка 18+\n3.Хардкор");
        int level = scanner.nextInt();
        switch (level) {
            case 1 -> start(Main.Level.easy);
            case 2 -> start(Main.Level.normal);
            case 3 -> start(Main.Level.hard);
        }
    }

    public static void start(Main.Level level) {
        if (level.equals(Main.Level.easy)) {
            truthMan = defaultLists.easyTruthMan;
            truthWoman = defaultLists.easyTruthWoman;
            actionMan = defaultLists.easyActionMan;
            actionWoman = defaultLists.easyActionWoman;
        } else if (level.equals(Main.Level.normal)) {
            truthMan = defaultLists.normalTruthMan;
            truthWoman = defaultLists.normalTruthWoman;
            actionMan = defaultLists.normalActionMan;
            actionWoman = defaultLists.normalActionWoman;
        } else if (level.equals(Main.Level.hard)) {
            truthMan = defaultLists.hardTruthMan;
            truthWoman = defaultLists.hardTruthWoman;
            actionMan = defaultLists.hardActionMan;
            actionWoman = defaultLists.hardActionWoman;
        }

        while (true) {
            System.out.println("Вопрос для " + Players.players.get(cycleCount).getNAME() + "\nВыбери:\n1.Правда\n" +
                    "2.Действие\n-1.Выход из программы\n-2.Сменить уровень сложности");
            if (Players.players.get(cycleCount).getSEX().equals(Players.Sex.Man)) {
                int inputMan = scanner.nextInt();
                if (inputMan == 1) {
                    if (countTrueMan >= 3) {
                        System.out.println("Вы использовали уже 3 правды, придется исполнить действие!"); //TODO некорректно считает использованные правды
                        countTrueMan = 0;
                        System.out.println("Действие для " + Players.players.get(cycleCount).getNAME() + ": " +
                                actionMan.get(random.nextInt(actionMan.size())));
                    } else {
                        System.out.println("Вопрос для " + Players.players.get(cycleCount).getNAME() + ": "
                                + truthMan.get(random.nextInt(truthMan.size()))); //вызывается лист с рандомным вопросом
                        // правды
                    }
                    countTrueMan++;
                } else if (inputMan == 2) {
                    System.out.println("Действие для " + Players.players.get(cycleCount).getNAME() + ": " +
                            actionMan.get(random.nextInt(actionMan.size()))); //вызывается лист с рандомным действием
                } else if (inputMan == -1) {
                    System.exit(0);
                } else if (inputMan == -2) {
                    System.out.println("Выберите уровень (введите нужную цифру):\n1. Разминка\n2. Вечеринка\n3. Хардкор 18+");
                    switch (inputMan = scanner.nextInt()) {
                        case 1 -> Game.start(Main.Level.easy);
                        case 2 -> Game.start(Main.Level.normal);
                        case 3 -> Game.start(Main.Level.hard);
                    }
                } else if (inputMan == 900) {
                    Main.developerMode();
                } else {
                    System.out.println("Вы ввели некорректное число"); // start();
                }
            } else if (Players.players.get(cycleCount).getSEX().equals(Players.Sex.Woman)) {
                    int inputWoman = scanner.nextInt();
                    if (inputWoman == 1) {
                        if (countTrueWoman >= 3) {
                            System.out.println("Вы использовали уже 3 правды, придется исполнить действие!"); //TODO некорректно считает использованные правды
                            countTrueWoman = 0;
                            System.out.println("Действие для " + Players.players.get(cycleCount).getNAME() + ": " +
                                    actionWoman.get(random.nextInt(actionWoman.size())));
                        } else {
                            System.out.println("Вопрос для " + Players.players.get(cycleCount).getNAME() + ": "
                                    + truthWoman.get(random.nextInt(truthWoman.size()))); //вызывается лист с рандомным вопросом
                            // правды
                        }
                        countTrueWoman++;
                    } else if (inputWoman == 2) {
                        System.out.println("Действие для " + Players.players.get(cycleCount).getNAME() + ": " +
                                actionWoman.get(random.nextInt(actionWoman.size()))); //вызывается лист с рандомным действием
                    } else if (inputWoman == -1) {
                        System.exit(0);
                    } else if (inputWoman == -2) {
                        System.out.println("Выберите уровень (введите нужную цифру):\n1. Разминка\n2. Вечеринка\n3. Хардкор 18+");
                        switch (inputWoman = scanner.nextInt()) {
                            case 1 -> Game.start(Main.Level.easy);
                            case 2 -> Game.start(Main.Level.normal);
                            case 3 -> Game.start(Main.Level.hard);
                        }
                    } else if (inputWoman == 900) {
                        Main.developerMode();
                    } else {
                        System.out.println("Вы ввели некорректное число"); // start();
                    }
                    }
            cycleCount++;
            if (cycleCount == (Players.players.size())) {
                cycleCount = 0;
                }
            }
        }

    public static void clearAllLists() { //можно потом доработать метод так, что б он принимал параметр с цифрой
        // и по ней чистил все правды и действиятолько для определенного режима игры, либо чистил только
        // листы с правдой, или чистил только листы для девушек или только для парней
        defaultLists.easyTruthMan.clear();
        defaultLists.easyTruthWoman.clear();
        defaultLists.easyActionMan.clear();
        defaultLists.easyActionWoman.clear();
        defaultLists.normalTruthMan.clear();
        defaultLists.normalTruthWoman.clear();
        defaultLists.normalActionMan.clear();
        defaultLists.normalActionWoman.clear();
        defaultLists.hardTruthMan.clear();
        defaultLists.hardTruthWoman.clear();
        defaultLists.hardActionMan.clear();
        defaultLists.hardActionWoman.clear();
    }

    public static void serializeLists() {
        try {
            FileOutputStream fileOut = new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(defaultLists.easyTruthMan);
            out.writeObject(defaultLists.easyTruthWoman);
            out.writeObject(defaultLists.normalTruthMan);
            out.writeObject(defaultLists.normalTruthWoman);
            out.writeObject(defaultLists.hardTruthMan);
            out.writeObject(defaultLists.hardTruthWoman);
            out.writeObject(defaultLists.easyActionMan);
            out.writeObject(defaultLists.easyActionWoman);
            out.writeObject(defaultLists.normalActionMan);
            out.writeObject(defaultLists.normalActionWoman);
            out.writeObject(defaultLists.hardActionMan);
            out.writeObject(defaultLists.hardActionWoman);
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
            defaultLists.easyTruthMan = (List<String>) in.readObject();
            defaultLists.easyTruthWoman = (List<String>) in.readObject();
            defaultLists.normalTruthMan = (List<String>) in.readObject();
            defaultLists.normalTruthWoman = (List<String>) in.readObject();
            defaultLists.hardTruthMan = (List<String>) in.readObject();
            defaultLists.hardTruthWoman = (List<String>) in.readObject();
            defaultLists.easyActionMan = (List<String>) in.readObject();
            defaultLists.easyActionWoman = (List<String>) in.readObject();
            defaultLists.normalActionMan = (List<String>) in.readObject();
            defaultLists.normalActionWoman = (List<String>) in.readObject();
            defaultLists.hardActionMan = (List<String>) in.readObject();
            defaultLists.hardActionWoman = (List<String>) in.readObject();
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