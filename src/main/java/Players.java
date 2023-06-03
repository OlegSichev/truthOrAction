import java.util.ArrayList;
import java.util.List;

public class Players {
    enum Sex {
        Man,
        Woman
    }

    static List<Players> players = new ArrayList<>();
    private final String NAME;
    private final Sex SEX;

    public Players(String NAME, Sex SEX) {
        this.NAME = NAME;
        this.SEX = SEX;
    }

    public static void newPlayer(String name, Sex sex) {
        players.add(new Players(name, sex));
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return "Имя игрока: " + NAME;
    }
}
