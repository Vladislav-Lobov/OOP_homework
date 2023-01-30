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
        int min = gang.get(0).getHealth();
        for (int i = 0; i < gang.size(); i++) {
            if (min > gang.get(i).getHealth()) {
                min = gang.get(i).getHealth();
                index = i;
            }
        }

        if (gang.get(index).getHealth() < 100) {
            int addHealth = (-1) * this.getDamage()[0] * 100 / gang.get(index).getMaxHealth(); // прибавляемое здоровье
                                                                                               // в
                                                                                               // процентах
            System.out.print("\nБоец -" + this.getType() + "- по имени '" + this.getName() + "' лечит -"
                    + gang.get(index).getType() + "- по имени '" + gang.get(index).getName() + "' здоровье которого "
                    + gang.get(index).getHealth() + "% на " + this.getDamage()[0] * (-1) + " пункта (" + addHealth
                    + "%)");

            gang.get(index).setHealth(gang.get(index).getHealth() + addHealth);
            if (gang.get(index).getHealth() > 100) {
                gang.get(index).setHealth(100);
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
