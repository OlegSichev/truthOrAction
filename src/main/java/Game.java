import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
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

//    static void createLists() {
//        easyActionMan.add("Пробное легкое действие");
//        easyActionMan.add("Пробное легкое действие2");
//    }

    public static void start(Main.Level level) {
        //createLists();
        if (level.equals(Main.Level.easy)) {
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
            System.out.println("Вопрос для " + Players.players.get(0).getNAME() + "\nВыбери:\n1.Правда\n2.Действие\n-1.Выход из программы\n-2.Сменить уровень сложности");
            int inputMan = scanner.nextInt();
            if (inputMan == 1) {
                if (countTrueMan >= 3) {
                    System.out.println("Вы использовали уже 3 правды, придется исполнить действие!");
                    countTrueMan = 0;
                    System.out.println("Действие для " + Players.players.get(1).getNAME() + ": " + actionMan.get(random.nextInt(actionMan.size())));
                }
                countTrueMan++;
                System.out.println("Вопрос для " + Players.players.get(0).getNAME() + ": " + truthMan.get(random.nextInt(truthMan.size()))); //вызывается лист с рандомным вопросом правды
            } else if (inputMan == 2) {
                System.out.println("Действие для " + Players.players.get(0).getNAME() + ": " + actionMan.get(random.nextInt(actionMan.size()))); //вызывается лист с рандомным действием
            } else if (inputMan == -1) {
                System.exit(0);
            } else if (inputMan == -2) {
                System.out.println("Выберите уровень (введите нужную цифру):\n1. Разминка\n2. Вечеринка\n3. Хардкор 18+");
                switch (inputMan = scanner.nextInt()) {
                    case 1:
                        Game.start(Main.Level.easy);
                        break;
                    case 2:
                        Game.start(Main.Level.normal);
                        break;
                    case 3:
                        Game.start(Main.Level.hard);
                        break;
                }
            } else if (inputMan == 900) {
                Main.developerMode();
            } else {
                System.out.println("Вы ввели некорректное число"); // start();
            }
            System.out.println();
            System.out.println("Вопрос для " + Players.players.get(1).getNAME() + "\nВыбери:\n1.Правда\n2.Действие\n-1.Выход из программы\n-2.Сменить уровень сложности");
            int inputWoman = scanner.nextInt();
            if (inputWoman == 1) {
                if (countTrueWoman >= 3) {
                    System.out.println("Вы использовали уже 3 правды, придется исполнить действие!");
                    countTrueWoman = 0;
                    System.out.println("Действие для " + Players.players.get(1).getNAME() + ": " + actionWoman.get(random.nextInt(actionWoman.size())));
                }
                countTrueMan++;
                System.out.println("Вопрос для " + Players.players.get(1).getNAME() + ": " + truthWoman.get(random.nextInt(truthWoman.size()))); //вызывается лист с рандомным вопросом правды
            } else if (inputMan == 2) {
                System.out.println("Действие для " + Players.players.get(1).getNAME() + ": " + actionWoman.get(random.nextInt(actionWoman.size()))); //вызывается лист с рандомным действием
            } else if (inputWoman == -1) {
                System.exit(0);
            } else if (inputMan == -2) {
                System.out.println("Выберите уровень (введите нужную цифру):\n1. Разминка\n2. Вечеринка\n3. Хардкор 18+\n-2.Сменить уровень сложности");
                switch (inputMan = scanner.nextInt()) {
                    case 1:
                        Game.start(Main.Level.easy);
                        break;
                    case 2:
                        Game.start(Main.Level.normal);
                        break;
                    case 3:
                        Game.start(Main.Level.hard);
                        break;
                }
            } else if (inputMan == 900) {
                Main.developerMode();
            } else {
                System.out.println("Вы ввели некорректное число");
                System.out.println();
                start(level);
            }
            System.out.println();
        }
    }

    public static void defaultQuestionsAndActions() { //TODO добавить правду и действия для всех листов

        //легкий уровень
        easyTruthWoman.add("Как думаешь, ты здесь самая красивая?");
        easyTruthWoman.add("Ты считаешь нас друзьями или приятелями, с которыми легко прекратишь общение?");
        easyTruthWoman.add("Какой поступок вспоминаешь и стыдишься его?");
        easyTruthWoman.add("Что мне нужно изменить в себе, чтобы ты влюбилась?");
        easyTruthWoman.add("Что выберешь: выбрить одну бровь или сделать ирокез?");
        easyTruthWoman.add("Если твой парень сильно заболеет, попадет в аварию и станет инвалидом, вы расстанетесь?");
        easyTruthWoman.add("Хочешь секса, когда пьяная?");
        easyTruthWoman.add("Сможешь встречаться с парнем, который ниже тебя ростом?");
        easyTruthWoman.add("Что тебя бесит в лучшей подруге?");
        easyTruthWoman.add("Кого из нас возьмешь с собой в отпуск?");
        easyTruthWoman.add("Смогла бы увести парня у подруги?");
        easyTruthWoman.add("Флиртовала с мужем сестры?");
        easyTruthWoman.add("У тебя есть враги?");
        easyTruthWoman.add("Если ты и твоя лучшая подружка влюбитесь в одного мальчика, ты уступишь или будешь бороться до конца?");
        easyTruthWoman.add("Носила когда-нибудь мужские вещи?");
        easyTruthWoman.add("У тебя есть кумир среди знаменитостей?");
        easyTruthWoman.add("Как назовешь детей, когда они появятся?");
        easyTruthWoman.add("Сколько зарабатываешь?");
        easyTruthWoman.add("Что мечтаешь купить?");
        easyTruthWoman.add("Хочешь стать знаменитой и богатой?");
        easyTruthWoman.add("Можешь соврать маме, подруге, парню?");
        easyTruthWoman.add("Чем ты лучше подруги?");
        easyTruthWoman.add("Что предпримешь, если твой парень нравится другой?");
        easyTruthWoman.add("Играешь в азартные игры?");
        easyTruthWoman.add("Можешь выйти на улицу без нижнего белья?");
        easyTruthWoman.add("От чего можешь отказаться в жизни: деньги, карьера, родители, ради любимого?");
        easyTruthWoman.add("Изменяла парню?");
        easyTruthWoman.add("Предавала подругу когда-либо?");
        easyTruthWoman.add("От чего никогда не откажешься?");
        easyTruthWoman.add("Отдашь почку подруге, если ей грозит смерть?");
        easyTruthWoman.add("Чем выводишь неприятный запах изо рта?");
        easyTruthWoman.add("Кто из твоих подруг самая красивая, самая умная, самая смелая?");
        easyTruthWoman.add("Сидишь на диете?");
        easyTruthWoman.add("Когда ты последний раз была в спа?");
        easyTruthWoman.add("Сколько тратишь денег на красоту?");
        easyTruthWoman.add("Любишь сладости?");
        easyTruthWoman.add("Часто выпиваешь?");
        easyTruthWoman.add("Какого вопроса боишься сегодня больше всего?");
        easyTruthWoman.add("Расскажи о самой неудачной шутке в твоей жизни?");
        easyTruthWoman.add("Если станешь невидимкой, что будешь делать?");
        easyTruthWoman.add("Зачем ты открываешь рот, когда красишь ресницы?");
        easyTruthWoman.add("Сколько можешь молчать?");
        easyTruthWoman.add("Твои родители счастливы в браке?");
        easyTruthWoman.add("У тебя есть жизненный девиз?");
        easyTruthWoman.add("Чай или кофе? Пиво или вино?");
        easyTruthWoman.add("Как относишься к лесбиянкам и геям?");
        easyTruthWoman.add("Что важнее изменить: тело или характер?");
        easyTruthWoman.add("Что думаешь, когда смотришь на любимого?");
        easyTruthWoman.add("Что такое романтика для тебя?");
        easyTruthWoman.add("Можешь выполнить желание любимого без раздумий?");

        easyTruthMan.add("С каким количеством людей одновременно ты можешь переписываться?");
        easyTruthMan.add("Шумные мероприятия тебе по душе?");
        easyTruthMan.add("Скинешь свою откровенную фотографию?");
        easyTruthMan.add("В интернете ты более открыт для общения, чем в реальной жизни?");
        easyTruthMan.add("Какое количество раз мне нужно улыбнуться, чтобы ты растаял?");
        easyTruthMan.add("Какую роль играет спорт в твоей жизни?");
        easyTruthMan.add("Любишь есть чеснок?");
        easyTruthMan.add("Ты зарегистрирован на сайтах знакомств?");
        easyTruthMan.add("Могут ли возникнуть отношения через переписку в интернете?");
        easyTruthMan.add("Тебе нравится кататься на аттракционах?");
        easyTruthMan.add("Расстояние является проблемой для близких отношений?");
        easyTruthMan.add("Чем бы ты занялся, если бы внезапно пропал интернет на неопределенный срок?");
        easyTruthMan.add("Смог бы сочинить стихотворение для девушки, чтобы впечатлить ее?");
        easyTruthMan.add("Какой жанр фильмов тебе доставляет удовольствие?");
        easyTruthMan.add("У тебя есть личный список добрых дел?");
        easyTruthMan.add("Какое сообщение было самым долгожданным в твоей жизни?");
        easyTruthMan.add("Ты нарушал когда-нибудь законы или имел проблемы с правоохранительными органами?");
        easyTruthMan.add("Какой твой самый любимый смайлик?");
        easyTruthMan.add("Тебя обижает, если человек онлайн и долго не отвечает на твое сообщение?");
        easyTruthMan.add("Каких два качества ты ненавидишь больше всего в людях?");
        easyTruthMan.add("О чем лучше тебя не спрашивать, когда ты в плохом настроении?");
        easyTruthMan.add("У тебя есть прозвище, которое тебе придумали друзья?");
        easyTruthMan.add("Увлекаешься компьютерными играми?");
        easyTruthMan.add("Как реагируешь, если девушка делает первый шаг и настойчиво тебя добивается?");
        easyTruthMan.add("Какой праздник тебе нравится больше всего?");
        easyTruthMan.add("Во сколько лет ты первый раз влюбился?");
        easyTruthMan.add("Что для тебя значит верность?");
        easyTruthMan.add("Какое самое романтическое свидание было в твоей жизни?");
        easyTruthMan.add("Как ты относишься к однополым бракам?");
        easyTruthMan.add("Хочешь иметь детей?");
        easyTruthMan.add("Смог бы встречаться с бывшей девушкой лучшего друга?");
        easyTruthMan.add("Ты был когда-нибудь во френдзоне?");
        easyTruthMan.add("Если бы твой любимый человек серьезно заболел, ты бы остался с ним?");
        easyTruthMan.add("Какими ты видишь свои идеальные отношения?");
        easyTruthMan.add("Хотел бы только одну девушку на всю жизнь?");
        easyTruthMan.add("Смог бы простить измену?");
        easyTruthMan.add("Ты встречался одновременно с несколькими девушками?");
        easyTruthMan.add("Готов пойти ради любимой на опасные поступки?");
        easyTruthMan.add("У тебя был болезненный разрыв в отношениях?");
        easyTruthMan.add("Будешь добиваться девушку, после ее отказа?");
        easyTruthMan.add("Хотел бы в жены девственницу?");
        easyTruthMan.add("С каким недостатком девушки ты бы не смог смириться?");
        easyTruthMan.add("В отношениях ты активный или инициатива в руках девушки?");
        easyTruthMan.add("Какая измена на твой взгляд хуже: физическая или моральная?");
        easyTruthMan.add("Смог бы жениться на нелюбимой девушке ради выгоды?");
        easyTruthMan.add("Обратишься за советом к друзьям, если в отношениях возникнут проблемы?");
        easyTruthMan.add("Как ты относишься к курящим девушкам?");
        easyTruthMan.add("Веришь в существование платонической любви?");
        easyTruthMan.add("Кто в семье должен распоряжаться деньгами?");
        easyTruthMan.add("Тебе важно, чтобы твоя девушка нравилась твоему окружению?");

        easyActionWoman.add("Обними игрока мужского пола");
        easyActionWoman.add("Отшлепай второго игрока");
        easyActionWoman.add("Поцелуй в щеку второго игрока");
        easyActionWoman.add("Съешь максимально сексуально любой фрукт");
        easyActionWoman.add("Соси палец второму игроку");
        easyActionWoman.add("Шлепни себя по попе с очень сексуальным постаныванием");
        easyActionWoman.add("Покажи в какой позе Ты обычно спишь");
        easyActionWoman.add("Прочитай в слух последнее собщение в любой соц сети (ВК, Телега, Вотсап и т.п.");
        easyActionWoman.add("В течени 10 минут харизматично добавляй цитаты к любой своей фразе или фразе второго" + " игрока, начинай с... \"Как сказал бы ... (твоя фраза - выдумай ее)");
        easyActionWoman.add("Изобрази, словно едешь на лошади");
        easyActionWoman.add("Изображай звуки плохо работающего крана на кухне");
        easyActionWoman.add("Сядь на колени второму игроку");
        easyActionWoman.add("Изобрази модель на подиуме");
        easyActionWoman.add("Сделай приседания 20 раз (можно больше ;))");
        easyActionWoman.add("Сделай сэлфи со вторым игроком");
        easyActionWoman.add("Изображай коуча одну минуту");
        easyActionWoman.add("Представь, что Ты алкоголичка и пришла на сбор анонимных алкоголиков. Разыграй эту" + " сценку");
        easyActionWoman.add("Сексуально ругайся матом одну минуту");
        easyActionWoman.add("Спой колыбельную второму игроку");
        easyActionWoman.add("Выговори скороговорку из интернета");
        easyActionWoman.add("Изображай одного из игроков, что б другие не догадались");
        easyActionWoman.add("Сними один элемент одежды");
        easyActionWoman.add("Если есть гитара - сыграй на ней любую песню, если нет - спой акапеллой, либо" + " зачитай рэп");
        easyActionWoman.add("Прочитай стихотворение");
        easyActionWoman.add("В течении 5 минут тараторишь, как Тина Канделаки");
        easyActionWoman.add("Расскажи пошлый анекдот (можно прочитать из интернета, но лучше самой");
        easyActionWoman.add("Засунь 4 пальца в рот и разговаривай так на протяжении 5 минут");
        easyActionWoman.add("В течени 5 минут - каждые 30 секунд говоришь - Я  - суперзвезда, трепещите, нищеброды!");
        easyActionWoman.add("На протяжении минуты разговаривай сама с собой вслух");
        easyActionWoman.add("Выпей до дна свой напиток");
        easyActionWoman.add("Пой песню с закрытым ртом, что б другие угадали");

        easyActionMan.add("Расскажи пошлый анекдот (можно прочитать из интернета, но лучше самому)");
        easyActionMan.add("Сними любой предмет одежды");
        easyActionMan.add("Если есть гитара - сыграй на гитаре, если нет, то спой песню акапеллой или зачитай рэп");
        easyActionMan.add("Отожмись 20 раз (Можно больше ;))");
        easyActionMan.add("Представь, что Ты - бодибилдер на сцене. Сними рубашку и похвастайся мышцами");
        easyActionMan.add("На протяжении минуты разговаривай сам с собой вслух");
        easyActionMan.add("Выпей до дна свой напиток");

        //средний уровень
        normalTruthWoman.add("Сколько партнеров в сексе у тебя было за всю жизнь?");
        normalTruthWoman.add("Нижнее белье какого цвета на тебе сейчас?");
        normalTruthWoman.add("Какая по твоему мнению идеальная длина и ширана члена партнера?");
        normalTruthWoman.add("С кем у тебя был самый плохой секс и самый лучший? Чем он запомнился в обеих случаях?" + " Расскажи");
        normalTruthWoman.add("Расскажи максимально сексуальным голосом эротическую историю, можно из жизни," + " можно из интернета. Твоя цель - возбудить второго игрока этой историей");

        normalActionWoman.add("Сними 2 любых элемента одежды (цепочки, сережки и т.п. не считаются)");
        normalActionWoman.add("Целуйся по французски в течении минуты со вторым игроком");
        normalActionWoman.add("Целуй второго игрока в губы по французски и в шею, одновременно соблазняя его" + " прикосновениями. Трогать можно где угодно, но под одежду залезать нельзя!");
        normalActionWoman.add("Станцуй стриптиз под музыку, которую включит второй игрок");

        normalTruthMan.add("Сними 2 любых элемента одежды (цепочки, сережки и т.п. не считаются)");

        normalActionMan.add("Опиши свой самый яркий секс - чем он запомнился и с кем он был");


        //сложный уровень
        hardTruthWoman.add("Хотела бы попробовать секс втроем? МЖМ? Или ЖМЖ?");

        hardActionWoman.add("Сделай миньет второму игроку");

        hardTruthMan.add("Хотел бы попробовать секс втроем? МЖМ? Или ЖМЖ?");

        hardActionMan.add("Сделай куни второму игроку");


    }

    public static void clearAllLists() { //можно потом доработать метод так, что б он принимал параметр с цифрой
        // и по ней чистил все правды и действиятолько для определенного режима игры, либо чистил только
        // листы с правдой, или чистил только листы для девушек или только для парней
        easyTruthMan.clear();
        easyTruthWoman.clear();
        easyActionMan.clear();
        easyActionWoman.clear();
        normalTruthMan.clear();
        normalTruthWoman.clear();
        normalActionMan.clear();
        normalActionWoman.clear();
        hardTruthMan.clear();
        hardTruthWoman.clear();
        hardActionMan.clear();
        hardActionWoman.clear();
    }

    public static void serializeLists() {
        try {
            FileOutputStream fileOut = new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(easyTruthMan);
            out.writeObject(easyTruthWoman);
            out.writeObject(normalTruthMan);
            out.writeObject(normalTruthWoman);
            out.writeObject(hardTruthMan);
            out.writeObject(hardTruthWoman);
            out.writeObject(easyActionMan);
            out.writeObject(easyActionWoman);
            out.writeObject(normalActionMan);
            out.writeObject(normalActionWoman);
            out.writeObject(hardActionMan);
            out.writeObject(hardActionWoman);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void deserializeLists() {
        try {
            FileInputStream fileIn = new FileInputStream("data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            easyTruthMan = (List<String>) in.readObject();
            easyTruthWoman = (List<String>) in.readObject();
            normalTruthMan = (List<String>) in.readObject();
            normalTruthWoman = (List<String>) in.readObject();
            hardTruthMan = (List<String>) in.readObject();
            hardTruthWoman = (List<String>) in.readObject();
            easyActionMan = (List<String>) in.readObject();
            easyActionWoman = (List<String>) in.readObject();
            normalActionMan = (List<String>) in.readObject();
            normalActionWoman = (List<String>) in.readObject();
            hardActionMan = (List<String>) in.readObject();
            hardActionWoman = (List<String>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("List class not found");
            c.printStackTrace();
            return;
        }
    }
}