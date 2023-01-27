import java.util.ArrayList;

public class Farmer extends BaseUnit {
    private int supply;

    public Farmer(ArrayList<BaseUnit> gang, String name, int x, int y) {
        super("farmer", name, 1, 1, new int[] { 1, 1 }, 1, 3);
        this.supply = 1;
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BaseUnit> list) {
        if (supply == 0) {
            supply = 1;
            System.out.printf("\nБоец -%s- по имени '%s' отдохнул. Он способен сделать доставку ", getType(),
                    getName());
        }
    }

    @Override
    public String toString() {
        return super.toString() + " {Доставка: " + supply + "}";
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

}
