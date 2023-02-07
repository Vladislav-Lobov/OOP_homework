import java.util.ArrayList;

public class Bandit extends BaseWalker {

    public Bandit(ArrayList<BaseUnit> gang, String name, int x, int y) {
        super("bandit", name, 8, 3, new int[]{2, 4}, 10, 6);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
}


