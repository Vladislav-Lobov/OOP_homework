public class BaseShooter extends BaseUnit {
    private int shots;

    public BaseShooter(String type, String name, int attack, int defense,
            int[] damage, int maxHealth, int speed, int shots) {
        super(type, name, attack, defense, damage, maxHealth, speed);
        this.shots = shots;
    }

    @Override
    public String toString() {
        return super.toString() + " {Выстрелы: " + shots + "}";
    }

    public int getShots() {
        return shots;
    }

}
