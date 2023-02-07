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
        if (status.equals("dead")) {
            return;
        }


        float distance = getTarget(list)[0];
        int indexMinDistance = (int) getTarget(list)[1];
        if ((int) indexMinDistance == -1) {
            System.out.printf("\n------------Игра окончена------------");
            return;
        }
        int defect = attackCalculation(list, distance, indexMinDistance);
        list.get(indexMinDistance).hasDamage(defect);

        if (shots > 0) {
            shots--;
            System.out.printf("\nБоец -%s- по имени '%s' произвел один выстрел в '%s', урон которого составил %d. Осталось %d выстрелов. ",
                    getType(), getName(), list.get(indexMinDistance).getName(), defect, shots);
        }

        for (int i = 0; i < gang.size(); i++) {
            if (gang.get(i).getType().equals("farmer")
                    && ((Farmer) gang.get(i)).getSupply() == 1
                    && !gang.get(i).status.equals("dead")) {
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
        String outStr = String.format("%21s %10s ⚔%-2d \uD83D\uDEE1%-2d ♥%-5.2f/%-2d ☠%-2d/%-2d \uD83D\uDD57%-2d ↗%-2d",
                getName(), getType(), getAttack(), getDefense(), getHealth(), getMaxHealth(),
                getDamage()[0], getDamage()[1], getSpeed(), getShots());
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
