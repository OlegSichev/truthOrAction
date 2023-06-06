import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Players {
    enum Sex {
        Man,
        Woman
    }

    static Scanner scanStr = new Scanner(System.in);
    static Scanner scanInt = new Scanner(System.in);
    static List<Players> players = new ArrayList<>();
    static int input;
    private int countTrue = 0;
    private final String NAME;
    private final Sex SEX;

    public Players(String NAME, Sex SEX) {
        this.NAME = NAME;
        this.SEX = SEX;
    }

    public void countTruePlusOrZero(int zeroOrOne) {
        switch (zeroOrOne) {
            case 0 -> countTrue = 0;
            case 1 -> countTrue++;
        }
    }

    public int getCountTrue() {
        return countTrue;
    }

    public static void newTwoPlayers() {
        System.out.println("Введите имя парня");
        players.add(new Players(scanStr.nextLine(), Players.Sex.Man));
        System.out.println("Введите имя девушки");
        players.add(new Players(scanStr.nextLine(), Sex.Woman));
    }

    public static void newPlayers() {
        String namePlayer;
        System.out.println("Введите количество игроков (от 2 до 6):");
        int sex = 0;
        input = scanInt.nextInt();
        for (int i = 0; i < input; i++) {
            System.out.println("Введите имя для " + (i + 1) + " игрока:");
            namePlayer = scanStr.nextLine();
            System.out.println("Выберите пол для " + (i + 1) + " игрока:\n1. Мужской\n2. Женский");
            sex = scanInt.nextInt();
            if (sex == 1) {
                Players player = new Players(namePlayer, Players.Sex.Man);
                players.add(player);
                System.out.println("Имя игрока: " + player.getNAME() + ". Пол: " + player.getSEX() + ". - Игрок" +
                        " создан.");
            } else if (sex == 2) {
                Players player = new Players(namePlayer, Players.Sex.Woman);
                players.add(player);
                System.out.println("Имя игрока: " + player.getNAME() + ". Пол: " + player.getSEX() + ". - Игрок" +
                        " создан.");
            } else {
                System.out.println("Такой цифры не существует. Попробуйте еще раз");
            }
        }
    }

    public String getNAME() {
        return NAME;
    }

    public Sex getSEX() {
        return SEX;
    }

    @Override
    public String toString() {
        return "Имя игрока: " + NAME;
    }
}
