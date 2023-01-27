import java.util.ArrayList;

public class Sniper extends BaseShooter {
    public Sniper(ArrayList<BaseUnit> gang, String name, int x, int y) {
        super("sniper", name, 12, 10, new int[] { 8, 10 }, 15, 9, 32);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
}
