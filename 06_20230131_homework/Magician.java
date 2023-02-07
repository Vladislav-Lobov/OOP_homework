import java.util.ArrayList;

public class Magician extends BaseMagic {
    Magician(ArrayList<BaseUnit> gang, String name, int x, int y) {
        super("magician", name, 17, 12, new int[]{-5, -5}, 30, 9, 1);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
}
