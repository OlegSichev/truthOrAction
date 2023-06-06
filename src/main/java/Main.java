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
        System.out.println("Добро пожаловать в игру \"Правда или действие\"!\nВыполнить загрузку сохраненной игры?" +
                " Файл сохранения должен быть в папке с программой.\nНажмите y (yes) или n (no)\nPowered by Oleg" +
                " Sychev 2023");
        String input = scanStr.nextLine();
        if (input.equals("y")) {
            Game.deserializeLists();
            menu();
        } else if (input.equals("n")) {
            System.out.println("Загрузка сохраненной игры не была выполнена. Были применены настройки с базой данных правды или действия по умолчанию.\n" +
                    " Открываю меню игры");
            defaultLists.defaultQuestionsAndActions();
            menu();
        } else {
            System.out.println("Загрузка сохраненной игры не была выполнена. Были применены настройки с базой данных правды или действия по умолчанию.\n" +
                    " Открываю меню игры");
            defaultLists.defaultQuestionsAndActions();
            menu();
        }
        //menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("Добро пожаловать в игру \"Правда или действие\"\nВыберите режим:\n1. Игра на двоих\n2." +
                    " Игра на компанию\nP.S. Взаимодействие с игрой производится путем ввода цифры пункта меню.\nДля" +
                    " выхода из программы введите -1");

            int input = scanInt.nextInt();

            switch (input){
                case 1 -> {
                    System.out.println("Введите имя парня");
                Players.newPlayer(scanStr.nextLine(), Players.Sex.Man);
                System.out.println("Введите имя девушки");
                Players.newPlayer(scanStr.nextLine(), Players.Sex.Woman);
                System.out.println("Выберите сложность игры:\n1.Разминка\n2.Вечеринка 18+\n3.Хардкор");
                int level = scanInt.nextInt();
                if (level == 1) {
                    Game.start(Level.easy);
                } else if (level == 2) {
                    Game.start(Level.normal);
                } else if (level == 3) {
                    Game.start(Level.hard);
                }
                }
                case 2 -> System.out.println("Режим больше двух игроков пока недоступен");
                case -1 -> System.exit(0);
                case 900 -> developerMode();
                default -> System.out.println("Такой цифры не существует, попробуем еще раз :)");
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
                case -1 -> menu();
                case -2 -> System.exit(0);
                default -> {
                    System.out.println("Такого пункта не существует. Открываю меню разработчика");
                    developerMode();
                }
            }
        }
    }
}
