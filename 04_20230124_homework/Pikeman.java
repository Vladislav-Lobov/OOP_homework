import java.util.ArrayList;

public class Pikeman extends BaseUnit {
    public Pikeman(ArrayList<BaseUnit> gang, String name, int x, int y) {
        super("pikeman", name, 4, 5, new int[] { 1, 3 }, 10, 4);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

}
