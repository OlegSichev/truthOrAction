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
        }
    }
}
