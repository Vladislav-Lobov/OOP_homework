import java.util.ArrayList;

public class BaseMagic extends BaseUnit {
    private int mana;

    public BaseMagic(String type, String name, int attack, int defense,
            int[] damage, int maxHealth, int speed, int mana) {
        super(type, name, attack, defense, damage, maxHealth, speed);
        this.mana = mana;
    }

    @Override
    public void step(ArrayList<BaseUnit> list) {
        int index = 0;
        int min = list.get(0).getHealth();
        for (int i = 0; i < list.size(); i++) {
            if (min > list.get(i).getHealth()) {
                min = list.get(i).getHealth();
                index = i;
            }
        }

        if (list.get(index).getHealth() < 100) {
            int addHealth = (-1) * this.getDamage()[0] * 100 / list.get(index).getMaxHealth(); // прибавляемое здоровье
                                                                                               // в
                                                                                               // процентах
            System.out.print("\nБоец -" + this.getType() + "- по имени '" + this.getName() + "' лечит -"
                    + list.get(index).getType() + "- по имени '" + list.get(index).getName() + "' здоровье которого "
                    + list.get(index).getHealth() + "% на " + this.getDamage()[0] * (-1) + " пункта (" + addHealth
                    + "%)");

            list.get(index).setHealth(list.get(index).getHealth() + addHealth);
            if (list.get(index).getHealth() > 100) {
                list.get(index).setHealth(100);
            }

        }
    }

    @Override
    public String toString() {
        return super.toString() + " {Магия: " + mana + "}";
    }

    public int getMana() {
        return mana;
    }
}
