

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HeroTeam {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseUnit> whiteSide;
    public static ArrayList<BaseUnit> darkSide;
    public static ArrayList<BaseUnit> orderByYWhiteSide;
    public static ArrayList<BaseUnit> getOrderByYDarkSide;

    public static void Init() {
        Random random = new Random();
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            int value = random.nextInt(4);
            switch (value) {
                case 0:
                    whiteSide.add(new Farmer(whiteSide, getName(), x, y++));
                    break;
                case 1:
                    whiteSide.add(new Bandit(whiteSide, getName(), x, y++));
                    break;
                case 2:
                    whiteSide.add(new Sniper(whiteSide, getName(), x, y++));
                    break;
                case 3:
                    whiteSide.add(new Magician(whiteSide, getName(), x, y++));
                    break;
            }
        }

        orderByYWhiteSide = new ArrayList<>(List.copyOf(whiteSide));
        Collections.sort(whiteSide, new ComporatorByType());

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            int value = random.nextInt(4);
            switch (value) {
                case 0:
                    darkSide.add(new Monk(darkSide, getName(), x, y++));
                    break;
                case 1:
                    darkSide.add(new Farmer(darkSide, getName(), x, y++));
                    break;
                case 2:
                    darkSide.add(new Pikeman(darkSide, getName(), x, y++));
                    break;
                case 3:
                    darkSide.add(new Arbalester(darkSide, getName(), x, y++));
                    break;
            }
        }

        getOrderByYDarkSide = new ArrayList<>(List.copyOf(darkSide));
        Collections.sort(darkSide, new ComporatorByType());
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
