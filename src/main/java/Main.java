import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    enum Level {
        easy,
        normal,
        hard
    }

    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);

    public static void main(String[] args) {
        welcome();
    }

    public static void menuTheGameINever() {
        System.out.println("Запущена игра \"Я никогда не\". Выберите нужный пункт в меню (ввод происходит с помощью" +
                " цифр.\n1. Поехали!\n2. Правила игры\n3. Выход в главное меню\n-1 Выход из игры");
        try {
            switch (scanInt.nextInt()) {
                case 1 -> Game.startINever();
                case 2 -> Game.theRulesOfGameINever();
                case 3 -> welcome();
                case 4 -> System.exit(0);
                case 900 -> developerMode();
                default -> menuTheGameINever();
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            scanInt.next(); // Очистка буфера ввода после ошибочного ввода
            menuTheGameINever();
        }
    }

    public static void welcome() {
        System.out.println("Добро пожаловать в игру \"Алкогольная вечеринка\"!\nВыполнить загрузку сохраненной игры?" +
                " Файл сохранения должен быть в папке с программой.\nНажмите y (yes) или n (no)\nPowered by Oleg" +
                " Sychev 2023");
        switch (scanStr.nextLine()) {
            case "y" -> {
                Game.deserializeLists();
                menu();
            }
            default -> {
                System.out.println("Загрузка сохраненной игры не была выполнена. Были применены настройки с базой данных правды или действия по умолчанию.\n" +
                        " Открываю меню игры");
                defaultLists.defaultQuestionsAndActions();
                menu();
            }
        }
    }

    public static void menu() {
        System.out.println("Меню игр:\n1.Правда или действие\n2.Я никогда не\n-1.Выход из игры");
        try {
            switch (scanInt.nextInt()) {
                case 1 -> menuTruthOrAction();
                case 2 -> menuTheGameINever();
                case -1 -> System.exit(0);
                case 900 -> developerMode();
                default -> menu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            scanInt.next(); // Очистка буфера ввода после ошибочного ввода
            menu();
        }
    }

    public static void menuTruthOrAction() {
        while (true) {
            System.out.println("Добро пожаловать в игру \"Правда или действие\"\nВыберите режим:\n1. Игра на двоих\n2." +
                    " Игра на компанию\nP.S. Взаимодействие с игрой производится путем ввода цифры пункта меню.\nДля" +
                    " выхода из программы введите -1");

            int input = scanInt.nextInt();

            try {
                switch (input) {
                    case 1 -> {
                        Players.newTwoPlayers();
                        Game.gameLevel();
                    }
                    case 2 -> {
                        Players.newPlayers();
                        Game.gameLevel();
                    }
                    case -1 -> System.exit(0);
                    case 900 -> developerMode();
                    default -> System.out.println("Такой цифры не существует, попробуем еще раз :)");
                }
            } catch (InputMismatchException e) {
                    System.out.println("Вы ввели не число, попробуйте еще раз");
                    scanInt.next();
                    menuTruthOrAction();
            }
        }
    }

    public static void developerMode() {
        while (true) {
            System.out.println("Выбран режим разработчика\nВыберите пункт меню цифрой:\n1. Редактирование легкого" +
                    " режима\n2. Редактирование среднего режима\n3. Редактирование тяжелого режима\n4. Сериализация\n" +
                    "5. Десериализация\n6. Удалить все правды и действия для всех режимов\n7. Добавить базу правды" +
                    " и действия по умолчанию\n-1 для выхода в главное меню\n-2 для завершения программы");
            int correctInput = scanInt.nextInt();
            try {
                switch (correctInput) {
                    case 1 -> {
                        System.out.println("1.Добавить правду в легкий режим для девушки\n2. Добавить правду в легкий" +
                                " режим для парня\n3. Добавить действие в легкий режим для девушки\n4. Добавить действие" +
                                " в легкий режим для парня");
                        correctInput = scanInt.nextInt();
                        if (correctInput == 1) {
                            System.out.println("Введите правду в легкий режим для девушки:");
                            defaultLists.easyTruthWoman.add(scanStr.nextLine());
                        } else if (correctInput == 2) {
                            System.out.println("Введите правду в легкий режим для парня:");
                            defaultLists.easyTruthMan.add(scanStr.nextLine());
                        } else if (correctInput == 3) {
                            System.out.println("Введите действие в легкий режим для девушки:");
                            defaultLists.easyActionWoman.add(scanStr.nextLine());
                        } else if (correctInput == 4) {
                            System.out.println("Введите действие в легкий режим для парня:");
                            defaultLists.easyActionMan.add(scanStr.nextLine());
                        }
                    }
                    case 2 -> {
                        System.out.println("1.Добавить правду в средний режим для девушки\n2. Добавить правду в средний " +
                                "режим для парня\n3. Добавить действие в средний режим для девушки\n4. Добавить действие в средний режим для парня");
                        correctInput = scanInt.nextInt();
                        if (correctInput == 1) {
                            System.out.println("Введите правду в средний режим для девушки:");
                            defaultLists.normalTruthWoman.add(scanStr.nextLine());
                        } else if (correctInput == 2) {
                            System.out.println("Введите правду в средний режим для парня:");
                            defaultLists.normalTruthMan.add(scanStr.nextLine());
                        } else if (correctInput == 3) {
                            System.out.println("Введите действие в средний режим для девушки:");
                            defaultLists.normalActionWoman.add(scanStr.nextLine());
                        } else if (correctInput == 4) {
                            System.out.println("Введите действие в средний режим для парня:");
                            defaultLists.normalActionMan.add(scanStr.nextLine());
                        }
                    }
                    case 3 -> {
                        System.out.println("1.Добавить правду в тяжелый режим для девушки\n2. Добавить правду в тяжелый " +
                                "режим для парня\n3. Добавить действие в тяжелый режим для девушки\n4. Добавить" +
                                " действие в тяжелый режим для парня");
                        correctInput = scanInt.nextInt();
                        if (correctInput == 1) {
                            System.out.println("Введите правду в тяжелый режим для девушки:");
                            defaultLists.hardTruthWoman.add(scanStr.nextLine());
                        } else if (correctInput == 2) {
                            System.out.println("Введите правду в тяжелый режим для парня:");
                            defaultLists.hardTruthMan.add(scanStr.nextLine());
                        } else if (correctInput == 3) {
                            System.out.println("Введите действие в тяжелый режим для девушки:");
                            defaultLists.hardActionWoman.add(scanStr.nextLine());
                        } else if (correctInput == 4) {
                            System.out.println("Введите действие в тяжелый режим для парня:");
                            defaultLists.hardActionMan.add(scanStr.nextLine());
                        }
                    }
                    case 4 -> Game.serializeLists();
                    case 5 -> Game.deserializeLists();
                    case 6 -> Game.clearAllLists();
                    case 7 -> defaultLists.defaultQuestionsAndActions();
                    case -1 -> menuTruthOrAction();
                    case -2 -> System.exit(0);
                    default -> {
                        System.out.println("Такого пункта не существует. Открываю меню разработчика");
                        developerMode();
                    }
                }
            } catch (InputMismatchException e) {
                    System.out.println("Вы ввели не число, попробуйте еще раз");
                    scanInt.next(); // Очистка буфера ввода после ошибочного ввода
                    developerMode();
            }
        }
    }
}
