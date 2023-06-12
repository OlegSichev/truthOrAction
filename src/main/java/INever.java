import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class INever {

    static Random random = new Random();
    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);

    public static void menuTheGameINever() {
        System.out.println("Запущена игра \"Я никогда не\". Выберите нужный пункт в меню (ввод происходит с помощью" +
                " цифр).\n1. Поехали!\n2. Правила игры\n3. Выход в главное меню\n-1 Выход из игры");
        try {
            switch (scanInt.nextInt()) {
                case 1 -> INever.startINever();
                case 2 -> INever.theRulesOfGameINever();
                case 3 -> Main.welcome();
                case 4 -> System.exit(0);
                case 900 -> Main.developerMode();
                default -> menuTheGameINever();
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            scanInt.next(); // Очистка буфера ввода после ошибочного ввода
            menuTheGameINever();
        }
    }

    public static void startINever() {
        System.out.println(GameLists.iNever.get(random.nextInt(GameLists.iNever.size())));
        System.out.println("\nНажмите 1 для продолжения, 2 что б прочитать правила игры, 3 для выхода в главное меню," +
                " -1 для выхода из игры");
        try {
            switch (scanInt.nextInt()) {
                case 2 -> theRulesOfGameINever();
                case 3 -> Main.welcome();
                case -1 -> System.exit(0);
                default -> startINever();
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            scanInt.next();
            startINever();
        }
    }

    public static void theRulesOfGameINever() {
        System.out.println("Правила игры в \"Я никогда НЕ\":\nИгра вам пишет какой-либо факт, ведущий его озвучивает." +
                " Если Вы это делали - пьете, если нет, то не пьете.\nНапример, ведущий говорит: Я никогда не летал на" +
                " самолете. Те, кто летали - пьют. Кто НЕ летали - не пьют\nНачинаем игру?\nНажми \"y\", что б начать" +
                " игру, либо \"n\", что б выйти в главное меню");
        switch (scanStr.nextLine()) {
            case "y" -> startINever();
            case "n" -> Main.welcome();
            default -> theRulesOfGameINever();
        }
    }
}
