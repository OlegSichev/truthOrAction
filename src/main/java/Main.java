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

    public static void welcome() {
        System.out.println("Добро пожаловать в игру \"Алкогольная вечеринка\"!\nВыполнить загрузку сохраненной игры?" +
                " Файл сохранения должен быть в папке с программой.\nНажмите y (yes) или n (no)\nPowered by Oleg" +
                " Sychev 2023");
        switch (scanStr.nextLine()) {
            case "y" -> {
                WorkingWithLists.deserializeLists();
                menu();
            }
            default -> {
                System.out.println("Загрузка сохраненной игры не была выполнена. Были применены настройки с базой данных правды или действия по умолчанию.\n" +
                        " Открываю меню игры");
                gameLists.defaultQuestionsAndActions();
                menu();
            }
        }
    }

    public static void menu() {
        System.out.println("Меню игр:\n1.Правда или действие\n2.Я никогда не\n-1.Выход из игры");
        try {
            switch (scanInt.nextInt()) {
                case 1 -> TruthOrAction.menuTruthOrAction();
                case 2 -> INever.menuTheGameINever();
                case -1 -> System.exit(0);
                case 900 -> developerMode();
                default -> menu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            scanInt.next();
            menu();
        }
    }

    public static void developerMode() {
        while (true) {
            System.out.println("Выбран режим разработчика\nВыберите пункт меню цифрой:\n1. Редактирование легкого" +
                    " режима в игре \"Правда или действие\"\n2. Редактирование среднего режима в игре \"Правда или" +
                    " действие\"\n3. Редактирование тяжелого режима в игре \"Правда или действие\"\n4. Добавить" +
                    " задания для игры в \"Я никогда НЕ\"\n5. Добавить задания для всех игр по умолчанию\n6. Удалить" +
                    " все задания для всех\n7. Сериализация\n8. Десериализация игр\n-1 для выхода в главное меню\n-2" +
                    " для завершения программы");
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
                            gameLists.easyTruthWoman.add(scanStr.nextLine());
                        } else if (correctInput == 2) {
                            System.out.println("Введите правду в легкий режим для парня:");
                            gameLists.easyTruthMan.add(scanStr.nextLine());
                        } else if (correctInput == 3) {
                            System.out.println("Введите действие в легкий режим для девушки:");
                            gameLists.easyActionWoman.add(scanStr.nextLine());
                        } else if (correctInput == 4) {
                            System.out.println("Введите действие в легкий режим для парня:");
                            gameLists.easyActionMan.add(scanStr.nextLine());
                        }
                    }
                    case 2 -> {
                        System.out.println("1.Добавить правду в средний режим для девушки\n2. Добавить правду в средний " +
                                "режим для парня\n3. Добавить действие в средний режим для девушки\n4. Добавить действие в средний режим для парня");
                        correctInput = scanInt.nextInt();
                        if (correctInput == 1) {
                            System.out.println("Введите правду в средний режим для девушки:");
                            gameLists.normalTruthWoman.add(scanStr.nextLine());
                        } else if (correctInput == 2) {
                            System.out.println("Введите правду в средний режим для парня:");
                            gameLists.normalTruthMan.add(scanStr.nextLine());
                        } else if (correctInput == 3) {
                            System.out.println("Введите действие в средний режим для девушки:");
                            gameLists.normalActionWoman.add(scanStr.nextLine());
                        } else if (correctInput == 4) {
                            System.out.println("Введите действие в средний режим для парня:");
                            gameLists.normalActionMan.add(scanStr.nextLine());
                        }
                    }
                    case 3 -> {
                        System.out.println("1.Добавить правду в тяжелый режим для девушки\n2. Добавить правду в тяжелый " +
                                "режим для парня\n3. Добавить действие в тяжелый режим для девушки\n4. Добавить" +
                                " действие в тяжелый режим для парня");
                        correctInput = scanInt.nextInt();
                        if (correctInput == 1) {
                            System.out.println("Введите правду в тяжелый режим для девушки:");
                            gameLists.hardTruthWoman.add(scanStr.nextLine());
                        } else if (correctInput == 2) {
                            System.out.println("Введите правду в тяжелый режим для парня:");
                            gameLists.hardTruthMan.add(scanStr.nextLine());
                        } else if (correctInput == 3) {
                            System.out.println("Введите действие в тяжелый режим для девушки:");
                            gameLists.hardActionWoman.add(scanStr.nextLine());
                        } else if (correctInput == 4) {
                            System.out.println("Введите действие в тяжелый режим для парня:");
                            gameLists.hardActionMan.add(scanStr.nextLine());
                        }
                    }
                    case 4 -> {
                        System.out.println("Введите новое задание для игры в \"Я никогда НЕ\":");
                        gameLists.iNever.add(scanStr.nextLine());
                    }
                    case 5 -> gameLists.defaultQuestionsAndActions();
                    case 6 -> WorkingWithLists.clearAllLists();
                    case 7 -> WorkingWithLists.serializeLists();
                    case 8 -> WorkingWithLists.deserializeLists();
                    case -1 -> menu();
                    case -2 -> System.exit(0);
                    default -> {
                        System.out.println("Такого пункта не существует. Открываю меню разработчика");
                        developerMode();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число, попробуйте еще раз");
                scanInt.next();
                developerMode();
            }
        }
    }
}
