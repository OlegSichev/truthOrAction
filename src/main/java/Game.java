import java.io.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);
    static Random random = new Random();
    static List<String> truthMan;
    static List<String> truthWoman;
    static List<String> actionMan;
    static List<String> actionWoman;
    static int cycleCount = 0;

    public static void gameLevel() {
        System.out.println("Выберите сложность игры:\n1.Разминка\n2.Вечеринка 18+\n3.Хардкор");
        int level = scanInt.nextInt();
        switch (level) {
            case 1 -> startTruthOrAction(Main.Level.easy);
            case 2 -> startTruthOrAction(Main.Level.normal);
            case 3 -> startTruthOrAction(Main.Level.hard);
        }
    }

    public static void startTruthOrAction(Main.Level level) {
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
            try {
                System.out.println("Вопрос для " + Players.players.get(cycleCount).getNAME() + "\nВыбери:\n1.Правда\n" +
                        "2.Действие\n-1.Выход из программы\n-2.Сменить уровень сложности");
                if (Players.players.get(cycleCount).getSEX().equals(Players.Sex.Man)) {
                    int inputMan = scanInt.nextInt();
                    if (inputMan == 1) {
                        if (Players.players.get(cycleCount).getCountTrue() >= 3) {
                            System.out.println("Вы использовали уже 3 правды, придется исполнить действие!"); //TODO некорректно считает использованные правды
                            Players.players.get(cycleCount).countTruePlusOrZero(0);
                            System.out.println("Действие для " + Players.players.get(cycleCount).getNAME() + ": " +
                                    actionMan.get(random.nextInt(actionMan.size())));
                        } else {
                            System.out.println("Вопрос для " + Players.players.get(cycleCount).getNAME() + ": "
                                    + truthMan.get(random.nextInt(truthMan.size()))); //вызывается лист с рандомным вопросом
                            // правды
                            //countTrueMan++;
                            Players.players.get(cycleCount).countTruePlusOrZero(1);
                        }
                    } else if (inputMan == 2) {
                        System.out.println("Действие для " + Players.players.get(cycleCount).getNAME() + ": " +
                                actionMan.get(random.nextInt(actionMan.size()))); //вызывается лист с рандомным действием
                    } else if (inputMan == -1) {
                        System.exit(0);
                    } else if (inputMan == -2) {
                        System.out.println("Выберите уровень (введите нужную цифру):\n1. Разминка\n2. Вечеринка\n3. Хардкор 18+");
                        switch (inputMan = scanInt.nextInt()) {
                            case 1 -> Game.startTruthOrAction(Main.Level.easy);
                            case 2 -> Game.startTruthOrAction(Main.Level.normal);
                            case 3 -> Game.startTruthOrAction(Main.Level.hard);
                        }
                    } else if (inputMan == 900) {
                        Main.developerMode();
                    } else {
                        System.out.println("Вы ввели некорректное число"); // start();
                    }
                } else if (Players.players.get(cycleCount).getSEX().equals(Players.Sex.Woman)) {
                    int inputWoman = scanInt.nextInt();
                    if (inputWoman == 1) {
                        if (Players.players.get(cycleCount).getCountTrue() >= 3) {
                            System.out.println("Вы использовали уже 3 правды, придется исполнить действие!");
                            Players.players.get(cycleCount).countTruePlusOrZero(0);
                            System.out.println("Действие для " + Players.players.get(cycleCount).getNAME() + ": " +
                                    actionWoman.get(random.nextInt(actionWoman.size())));
                        } else {
                            System.out.println("Вопрос для " + Players.players.get(cycleCount).getNAME() + ": "
                                    + truthWoman.get(random.nextInt(truthWoman.size()))); //вызывается лист с рандомным вопросом
                            // правды
                            Players.players.get(cycleCount).countTruePlusOrZero(1);
                        }
                    } else if (inputWoman == 2) {
                        System.out.println("Действие для " + Players.players.get(cycleCount).getNAME() + ": " +
                                actionWoman.get(random.nextInt(actionWoman.size()))); //вызывается лист с рандомным действием
                    } else if (inputWoman == -1) {
                        System.exit(0);
                    } else if (inputWoman == -2) {
                        System.out.println("Выберите уровень (введите нужную цифру):\n1. Разминка\n2. Вечеринка\n3. Хардкор 18+");
                        switch (inputWoman = scanInt.nextInt()) {
                            case 1 -> Game.startTruthOrAction(Main.Level.easy);
                            case 2 -> Game.startTruthOrAction(Main.Level.normal);
                            case 3 -> Game.startTruthOrAction(Main.Level.hard);
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
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число, попробуйте еще раз");
                scanInt.next(); // Очистка буфера ввода после ошибочного ввода
                gameLevel();
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

    public static void startINever(){
        System.out.println(defaultLists.iNever.get(random.nextInt(defaultLists.iNever.size())));
        System.out.println("\nНажмите 1 для продолжения, 2 что б прочитать правила игры, 3 для выхода в главное меню," +
                " -1 для выхода из игры");
        try {
            switch (scanInt.nextInt()) {
                case 2 -> theRulesOfGameINever();
                case 3 -> Main.welcome();
                case -1 -> System.exit(0);
                default -> startINever();
            }
        } catch (InputMismatchException e){
                System.out.println("Вы ввели не число, попробуйте еще раз");
                scanInt.next(); // Очистка буфера ввода после ошибочного ввода
                startINever();
        }
    }

    public static void theRulesOfGameINever(){
        System.out.println("Правила игры в \"Я никогда НЕ\":\nИгра вам пишет какой-либо факт, ведущий его озвучивает." +
                " Если Вы это делали - пьете, если нет, то не пьете.\nНапример, ведущий говорит: Я никогда не летал на" +
                " самолете. Те, кто летали - пьют. Кто НЕ летали - не пьют\nНачинаем игру?\nНажми \"y\", что б начать" +
                " игру, либо \"n\", что б выйти в главное меню");
        switch (scanStr.nextLine()){
            case "y" -> startINever();
            case "n" -> Main.welcome();
            default -> theRulesOfGameINever();
        }
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
            out.writeObject(defaultLists.iNever);
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
            defaultLists.iNever = (List<String>) in.readObject();
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