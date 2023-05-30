import java.util.Scanner;

public class Main {
    enum Level{
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
        if (input.equals("y")){
            Game.deserializeLists();
            menu();
        } else if (input.equals("n")) {
            menu();
        } else {
            System.out.println("Загрузка сохраненной игры не была выполнена. Открываю меню игры");
            menu();
        }
        //menu();
        }

    public static void menu(){
        while (true){
            System.out.println("Добро пожаловать в игру \"Правда или действие\"\nВыберите режим:\n1. Игра на двоих\n2." +
                    " Игра на компанию\nP.S. Взаимодействие с игрой производится путем ввода цифры пункта меню.\nДля" +
                    " выхода из программы введите -1");

            int input = scanInt.nextInt();

            if (input == 1){
                System.out.println("Введите имя парня");
                Players.newPlayer(scanStr.nextLine(), Players.Sex.Man);
                System.out.println("Введите имя девушки");
                Players.newPlayer(scanStr.nextLine(), Players.Sex.Woman);
                System.out.println("Выберите сложность игры:\n1.Разминка\n2.Вечеринка 18+\n3.Хардкор");
                int level = scanInt.nextInt();
                if (level == 1){
                    Game.start(Level.easy);
                } else if (level == 2){
                    Game.start(Level.normal);
                } else if (level == 3) {
                    Game.start(Level.hard);
                }
                //Game.start();
            } else if (input == 2) {
                System.out.println("Режим больше двух игроков пока недоступен");
            } else if (input == -1) {
                System.exit(0);
            } else if (input == 900) {
                developerMode();
            } else {
                System.out.println("Такой цифры не существует, попробуем еще раз :)");
            }
        }
    }

    public static void developerMode(){
        while (true){
            System.out.println("Выбран режим разработчика\nВыберите пункт меню цифрой:\n1. Редактирование легкого" +
                    " режима\n2. Редактирование среднего режима\n3. Редактирование тяжелого режима\n4. Сериализация\n" +
                    "5. Десериализация\n6. Удалить все правды и действия для всех режимов\n7. Добавить правду в легкий режим по умолчанию\n-1 для выхода в главное меню\n-2 для завершения программы");
            int correctInput = scanInt.nextInt();
            if (correctInput == 1){
                System.out.println("1.Добавить правду в легкий режим для девушки\n2. Добавить правду в легкий" +
                        " режим для парня\n3. Добавить действие в легкий режим для девушки\n4. Добавить действие" +
                        " в легкий режим для парня");
                correctInput = scanInt.nextInt();
                if (correctInput == 1){
                    System.out.println("Введите правду в легкий режим для девушки:");
                    Game.easyTruthWoman.add(scanStr.nextLine());
                } else if (correctInput == 2){
                    System.out.println("Введите правду в легкий режим для парня:");
                    Game.easyTruthMan.add(scanStr.nextLine());
                } else if (correctInput == 3) {
                    System.out.println("Введите действие в легкий режим для девушки:");
                    Game.easyActionWoman.add(scanStr.nextLine());
                } else if (correctInput == 4) {
                    System.out.println("Введите действие в легкий режим для парня:");
                    Game.easyActionMan.add(scanStr.nextLine());
                }
            } else if (correctInput == 2) {
                System.out.println("1.Добавить правду в средний режим для девушки\n2. Добавить правду в средний " +
                        "режим для парня\n3. Добавить действие в средний режим для девушки\n4. Добавить действие в средний режим для парня");
                correctInput = scanInt.nextInt();
                if (correctInput == 1){
                    System.out.println("Введите правду в средний режим для девушки:");
                    Game.normalTruthWoman.add(scanStr.nextLine());
                } else if (correctInput == 2){
                    System.out.println("Введите правду в средний режим для парня:");
                    Game.normalTruthMan.add(scanStr.nextLine());
                } else if (correctInput == 3) {
                    System.out.println("Введите действие в средний режим для девушки:");
                    Game.normalActionWoman.add(scanStr.nextLine());
                } else if (correctInput == 4) {
                    System.out.println("Введите действие в средний режим для парня:");
                    Game.normalActionMan.add(scanStr.nextLine());
                }
            } else if (correctInput == 3) {
                System.out.println("1.Добавить правду в тяжелый режим для девушки\n2. Добавить правду в тяжелый " +
                        "режим для парня\n3. Добавить действие в тяжелый режим для девушки\n4. Добавить" +
                        " действие в тяжелый режим для парня");
                correctInput = scanInt.nextInt();
                if (correctInput == 1) {
                    System.out.println("Введите правду в тяжелый режим для девушки:");
                    Game.hardTruthWoman.add(scanStr.nextLine());
                } else if (correctInput == 2) {
                    System.out.println("Введите правду в тяжелый режим для парня:");
                    Game.hardTruthMan.add(scanStr.nextLine());
                } else if (correctInput == 3) {
                    System.out.println("Введите действие в тяжелый режим для девушки:");
                    Game.hardActionWoman.add(scanStr.nextLine());
                } else if (correctInput == 4) {
                    System.out.println("Введите действие в тяжелый режим для парня:");
                    Game.hardActionMan.add(scanStr.nextLine());
                }
            } else if (correctInput == 4) {
                Game.serializeLists();
            } else if (correctInput == 5) {
                Game.deserializeLists();
            } else if (correctInput == 6) {
                Game.clearAllLists();
            } else if (correctInput == 7) {
                Game.defaultEasyQuestions();
            } else if (correctInput == -1) {
                menu();
                //Game.serialize();
            } else if (correctInput == -2) {
                //Game.serialize();
                System.exit(0);
            } else {
                System.out.println("Такого пункта не существует. Открываю меню разработчика");
                developerMode();
            }
        }
    }
}
