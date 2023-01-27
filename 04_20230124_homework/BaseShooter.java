import java.util.ArrayList;

public class BaseShooter extends BaseUnit {
    private int shots;

    public BaseShooter(String type, String name, int attack, int defense,
            int[] damage, int maxHealth, int speed, int shots) {
        super(type, name, attack, defense, damage, maxHealth, speed);
        this.shots = shots;
    }

    @Override
    public void step(ArrayList<BaseUnit> list) {

        if (shots > 0) {
            shots--;
            System.out.printf("\nБоец -%s- по имени '%s' произвел один выстрел. Осталось %d выстрелов. ", getType(),
                    getName(), shots);
        }

        for (int i = 0; i < gang.size(); i++) {
            if (gang.get(i).getType().equals("farmer") && ((Farmer) gang.get(i)).getSupply() == 1) {
                ((Farmer) gang.get(i)).setSupply(0);
                shots++;
                System.out.printf("Крестьянин по имени '%s' осуществляет доставку. Осталось выстрелов %d",
                        gang.get(i).getName(), shots);
                break;
            }
        }

    }

    @Override
    public String getInfo() {
        String outStr = String.format("⚔ %3d\t\uD83D\uDEE1 %3d\t♥%3d%%\t☠%3d\t\uD83D\uDD57%3d\t↗%3d", getAttack(), getDefense(),
                getHealth(),
                (getDamage()[0] + getDamage()[1]) / 2,getSpeed(), getShots());
        return outStr;
    }

    @Override
    public String toString() {
        return super.toString() + " {Выстрелы: " + shots + "}";
    }

    public int getShots() {
        return shots;
    }

}
