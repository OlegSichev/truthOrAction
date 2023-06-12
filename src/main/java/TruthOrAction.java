import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TruthOrAction {
    static Scanner scanInt = new Scanner(System.in);
    static Random random = new Random();
    static List<String> truthMan;
    static List<String> truthWoman;
    static List<String> actionMan;
    static List<String> actionWoman;
    static int cycleCount = 0;

    public static void menuTruthOrAction() {
        while (true) {
            System.out.println("Запущена игра \"Правда или действие\"\nВыберите режим:\n1. Игра на двоих\n2." +
                    " Игра на компанию\nP.S. Взаимодействие с игрой производится путем ввода цифры пункта меню.\nДля" +
                    " выхода из программы введите -1");

            int input = scanInt.nextInt();

            try {
                switch (input) {
                    case 1 -> {
                        Players.newTwoPlayers();
                        TruthOrAction.gameLevel();
                    }
                    case 2 -> {
                        Players.newPlayers();
                        TruthOrAction.gameLevel();
                    }
                    case -1 -> System.exit(0);
                    case 900 -> Main.developerMode();
                    default -> System.out.println("Такой цифры не существует, попробуем еще раз :)");
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число, попробуйте еще раз");
                scanInt.next();
                menuTruthOrAction();
            }
        }
    }

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
            truthMan = GameLists.easyTruthMan;
            truthWoman = GameLists.easyTruthWoman;
            actionMan = GameLists.easyActionMan;
            actionWoman = GameLists.easyActionWoman;
        } else if (level.equals(Main.Level.normal)) {
            truthMan = GameLists.normalTruthMan;
            truthWoman = GameLists.normalTruthWoman;
            actionMan = GameLists.normalActionMan;
            actionWoman = GameLists.normalActionWoman;
        } else if (level.equals(Main.Level.hard)) {
            truthMan = GameLists.hardTruthMan;
            truthWoman = GameLists.hardTruthWoman;
            actionMan = GameLists.hardActionMan;
            actionWoman = GameLists.hardActionWoman;
        }

        while (true) {
            try {
                System.out.println("Вопрос для " + Players.players.get(cycleCount).getNAME() + "\nВыбери:\n1.Правда\n" +
                        "2.Действие\n-1.Выход из программы\n-2.Сменить уровень сложности");
                if (Players.players.get(cycleCount).getSEX().equals(Players.Sex.Man)) {
                    int inputMan = scanInt.nextInt();
                    if (inputMan == 1) {
                        if (Players.players.get(cycleCount).getCountTrue() >= 3) {
                            System.out.println("Вы использовали уже 3 правды, придется исполнить действие!");
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
                            case 1 -> TruthOrAction.startTruthOrAction(Main.Level.easy);
                            case 2 -> TruthOrAction.startTruthOrAction(Main.Level.normal);
                            case 3 -> TruthOrAction.startTruthOrAction(Main.Level.hard);
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
                            case 1 -> TruthOrAction.startTruthOrAction(Main.Level.easy);
                            case 2 -> TruthOrAction.startTruthOrAction(Main.Level.normal);
                            case 3 -> TruthOrAction.startTruthOrAction(Main.Level.hard);
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
                scanInt.next();
                gameLevel();
            }
        }
    }
}