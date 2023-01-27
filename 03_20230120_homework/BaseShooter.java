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

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType().equals("farmer") && ((Farmer) list.get(i)).getSupply() == 1) {
                ((Farmer) list.get(i)).setSupply(0);
                shots++;
                System.out.printf("Крестьянин по имени '%s' осуществляет доставку. Осталось выстрелов %d",
                        list.get(i).getName(), shots);
                break;
            }
        }

    }

    @Override
    public String toString() {
        return super.toString() + " {Выстрелы: " + shots + "}";
    }

    public int getShots() {
        return shots;
    }

}
