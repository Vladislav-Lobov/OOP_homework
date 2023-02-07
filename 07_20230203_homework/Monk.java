import java.util.ArrayList;

public class Monk extends BaseMagic {
    public Monk(ArrayList<BaseUnit> gang, String name, int x, int y) {
        super("monk", name, 12, 7, new int[]{-4, -4}, 30, 5, 1);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
}
