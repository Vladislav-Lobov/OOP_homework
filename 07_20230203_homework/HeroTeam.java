

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeroTeam {
    public static final int GANG_SIZE = 10;

    public static ArrayList<BaseUnit> whiteSide;
    public static ArrayList<BaseUnit> darkSide;

    public static void Init() {

        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            whiteSide.add(createWhiteUnit(x, y));
            y++;
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            darkSide.add(createDarkUnit(x, y));
            y++;
        }

    }

    public static BaseUnit createWhiteUnit(int x, int y) {
        BaseUnit unit = null;
        int value = new Random().nextInt(4);
        switch (value) {
            case 0:
                unit = new Farmer(whiteSide, getName(), x, y);
                break;
            case 1:
                unit = new Bandit(whiteSide, getName(), x, y);
                break;
            case 2:
                unit = new Sniper(whiteSide, getName(), x, y);
                break;
            case 3:
                unit = new Magician(whiteSide, getName(), x, y);
                break;
        }
        return unit;
    }

    public static BaseUnit createDarkUnit(int x, int y) {
        BaseUnit unit = null;
        int value = new Random().nextInt(4);
        switch (value) {
            case 0:
                unit = new Monk(darkSide, getName(), x, y);
                break;
            case 1:
                unit = new Farmer(darkSide, getName(), x, y);
                break;
            case 2:
                unit = new Pikeman(darkSide, getName(), x, y);
                break;
            case 3:
                unit = new Arbalester(darkSide, getName(), x, y);
                break;
        }
        return unit;
    }



    public static boolean deadTeam(List<BaseUnit> team) {
        for (BaseUnit npc : team) {
            if (!npc.status.equals("dead")) return false;
        }
        return true;
    }

    public static String getName() {
        Random random = new Random();
        return EnumeratorSurnames.values()[random.nextInt(EnumeratorSurnames.values().length)] + " "
                + EnumeratorNames.values()[random.nextInt(EnumeratorNames.values().length)];
    }
}
