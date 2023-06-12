import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Crocodile {
    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);
    static Random random = new Random();

    public static void menuTheGameCrocodile() {
        System.out.println("Запущена игра \"Крокодил\". Выберите нужный пункт в меню (ввод происходит с помощью" +
                " цифр).\n1. Поехали!\n2. Правила игры\n3. Выход в главное меню\n-1 Выход из игры");
        try {
            switch (scanInt.nextInt()) {
                case 1 -> startCrocodile();
                case 2 -> theRulesOfGameCrocodile();
                case 3 -> Main.welcome();
                case 4 -> System.exit(0);
                case 900 -> Main.developerMode();
                default -> menuTheGameCrocodile();
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            scanInt.next(); // Очистка буфера ввода после ошибочного ввода
            menuTheGameCrocodile();
        }
    }

    public static void startCrocodile() {
        System.out.println(GameLists.crocodile.get(random.nextInt(GameLists.crocodile.size())));
        System.out.println("\nНажмите 1 для продолжения, 2 что б прочитать правила игры, 3 для выхода в главное меню," +
                " -1 для выхода из игры");
        try {
            switch (scanInt.nextInt()) {
                case 2 -> theRulesOfGameCrocodile();
                case 3 -> Main.welcome();
                case -1 -> System.exit(0);
                default -> startCrocodile();
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            scanInt.next();
            startCrocodile();
        }
    }

    public static void theRulesOfGameCrocodile() {
        System.out.println("Правила игры в \"Крокодил\":\nИгра вам пишет какое-либо слово - это может быть персонаж" +
                " из фильма, политик, бизнесмен, что-то неодушевленное и т.п.,\n вам нужно это изобразить. Другие пусть" +
                " угадывают. Участник, который угадал - получает следующее слово и начинает его изображать.\nЕсли не" +
                " угадал никто, участник выбирает другое слово и начинает его изображать.\nНачинаем игру?\nНажми" +
                " \"y\", что б начать игру, либо \"n\", что б выйти в главное меню");
        switch (scanStr.nextLine()) {
            case "y" -> startCrocodile();
            case "n" -> Main.welcome();
            default -> theRulesOfGameCrocodile();
        }
    }
}
