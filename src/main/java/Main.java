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
            menu();
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
                System.out.println("Выбран режим разработчика\nВыберите пункт меню цифрой:\n1. Редактирование легкого" +
                        " режима\n2. Редактирование среднего режима\n3. Редактирование тяжелого режима");
                int correctInput = scanInt.nextInt();
                if (correctInput == 1){
                    System.out.println("1.Добавить правду в легкий режим для девушки\n2. Добавить правду в легкий" +
                            " режим для парня\n3. Добавить действие в легкий режим для девушки\n4. Добавить действие" +
                            " в легкий режим для парня");
                    correctInput = scanInt.nextInt();
                    if (correctInput == 1){
                        System.out.println("Введите правду в легкий режим для девушки:");
                        //String easyTruthWoman = scanStr.nextLine(); если не будет работать, то использовать
                        // эту переменную
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
                    if (correctInput == 1){
                        System.out.println("Введите правду в тяжелый режим для девушки:");
                        Game.hardTruthWoman.add(scanStr.nextLine());
                    } else if (correctInput == 2){
                        System.out.println("Введите правду в тяжелый режим для парня:");
                        Game.hardTruthMan.add(scanStr.nextLine());
                    } else if (correctInput == 3) {
                        System.out.println("Введите действие в тяжелый режим для девушки:");
                        Game.hardActionWoman.add(scanStr.nextLine());
                    } else if (correctInput == 4) {
                        System.out.println("Введите действие в тяжелый режим для парня:");
                        Game.hardActionMan.add(scanStr.nextLine());
                    }
                }
            } else {
                System.out.println("Такой цифры не существует, попробуем еще раз :)");
            }
        }
    }
}
