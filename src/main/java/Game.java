import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L; // версия программя для сериализации
    // TODO заполнить ArrayList'ы правдой и действием, проверить работоспособность программы
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int countTrueMan = 0;
    static int countTrueWoman = 0;
    static List<String> easyTruthMan = new ArrayList<>();

    static List<String> easyTruthWoman = new ArrayList<>();
    static List<String> normalTruthMan = new ArrayList<>();
    static List<String> normalTruthWoman = new ArrayList<>();
    static List<String> hardTruthMan = new ArrayList<>();
    static List<String> hardTruthWoman = new ArrayList<>();

    static List<String> easyActionMan = new ArrayList<>();
    static List<String> easyActionWoman = new ArrayList<>();
    static List<String> normalActionMan = new ArrayList<>();
    static List<String> normalActionWoman = new ArrayList<>();
    static List<String> hardActionMan = new ArrayList<>();
    static List<String> hardActionWoman = new ArrayList<>();

    static List<String> truthMan;
    static List<String> truthWoman;
    static List<String> actionMan;
    static List<String> actionWoman;

    static void serialization(){
        List<List>listsSerialization = new ArrayList<>();
        //todo
        listsSerialization.add(easyTruthMan);
        listsSerialization.add(easyTruthWoman);
        listsSerialization.add(easyActionMan);
        listsSerialization.add(easyActionWoman);
        listsSerialization.add(normalTruthMan);
        listsSerialization.add(normalTruthWoman);
        listsSerialization.add(normalActionMan);
        listsSerialization.add(normalActionWoman);
        listsSerialization.add(hardTruthMan);
        listsSerialization.add(hardTruthWoman);
        listsSerialization.add(hardActionMan);
        listsSerialization.add(hardActionWoman);
    }

    static void createLists(){
        //TODO написать логику для создания только тех листов, которые нам нужны для выбранного Левела (если лень, можно и все создавать)
        easyActionMan.add("Пробное легкое действие");
        easyActionMan.add("Пробное легкое действие2");
    }

    public static void start(Main.Level level){
        createLists();
        if (level.equals(Main.Level.easy)){
            truthMan = easyTruthMan;
            truthWoman = easyTruthWoman;
            actionMan = easyActionMan;
            actionWoman = easyActionWoman;
        } else if (level.equals(Main.Level.normal)) {
            truthMan = normalTruthMan;
            truthWoman = normalTruthWoman;
            actionMan = normalActionMan;
            actionWoman = normalActionWoman;
        } else if (level.equals(Main.Level.hard)) {
            truthMan = hardTruthMan;
            truthWoman = hardTruthWoman;
            actionMan = hardActionMan;
            actionWoman = hardActionWoman;
        }
        while (true) {
            System.out.println("Вопрос для " + Players.players.get(0).getNAME() + "\nВыбери:\n1.Правда\n2.Действие\n-1.Выход из программы");
            int inputMan = scanner.nextInt();
            if (inputMan == 1) {
                if (countTrueMan >= 3) {
                    System.out.println("Вы использовали уже 3 правды, придется исполнить действие!");
                    countTrueMan = 0;
                    System.out.println(actionMan.get(random.nextInt(actionMan.size())));
                }
                countTrueMan++;
                System.out.println(truthMan.get(random.nextInt(truthMan.size())));
                //вызывается лист с рандомным вопросом правды
            } else if (inputMan == 2) {
                System.out.println(actionMan.get(random.nextInt(actionMan.size())));
                //вызывается лист с рандомным действием
            } else if (inputMan == -1) {
                System.exit(0);
            } else {
                System.out.println("Вы ввели некорректное число");
               // start();
            }
            System.out.println("Нажмите Enter для продолжения");
            scanner.nextLine();
            System.out.println("Вопрос для " + Players.players.get(1).getNAME() + "\nВыбери:\n1.Правда\n2.Действие\n-1.Выход из программы");
            int inputWoman = scanner.nextInt();
            if (inputWoman == 1) {
                if (countTrueWoman >= 3) {
                    System.out.println("Вы использовали уже 3 правды, придется исполнить действие!");
                    countTrueWoman = 0;
                    System.out.println(actionWoman.get(random.nextInt(actionWoman.size())));
                }
                countTrueMan++;
                System.out.println(truthWoman.get(random.nextInt(truthWoman.size())));
                //вызывается лист с рандомным вопросом правды
            } else if (inputMan == 2) {
                System.out.println(actionWoman.get(random.nextInt(actionWoman.size())));
                //вызывается лист с рандомным действием
            } else if (inputWoman == -1) {
                System.exit(0);
            } else {
                System.out.println("Вы ввели некорректное число");
                start(level);
            }
        }
    }
}
