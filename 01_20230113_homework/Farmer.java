public class Farmer extends BaseUnit {
    private int supply;

    public Farmer(String name) {
        super("farmer", name, 1, 1, new int[] { 1, 1 }, 1, 3);
        this.supply = 1;
    }

    @Override
    public String toString() {
        return super.toString() + " {Доставка: " + supply + "}";
    }

    public int getSupply(){
        return supply;
    }

}
