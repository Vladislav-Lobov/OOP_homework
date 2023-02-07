import java.util.ArrayList;

public class BaseMagic extends BaseUnit {
    private int mana;
    private boolean restAfterRevive;

    public BaseMagic(String type, String name, int attack, int defense,
                     int[] damage, int maxHealth, int speed, int mana) {
        super(type, name, attack, defense, damage, maxHealth, speed);
        this.mana = mana;
        this.restAfterRevive = false;
    }

    @Override
    public void step(ArrayList<BaseUnit> list) {
        if (status.equals("dead")) {
            return;
        }

        if (restAfterRevive) {
            restAfterRevive = false;
            return;
        }

        int index = healingIndex();
        if (index == -1) {
            System.out.printf("\n------------Игра окончена------------");
            return;
        }

        if (gang.get(index).status.equals("dead")) {
            revive(index);
            restAfterRevive = true;
        } else {
            healing(index);
        }

    }

    private void revive(int index) {
        System.out.printf("\nБоец -%s- по имени '%s' воскрешает -%s- по имени '%s'.",
                getType(), getName(), gang.get(index).getType(), gang.get(index).getName());


        int x = (gang.equals(HeroTeam.whiteSide)) ? 1 : HeroTeam.GANG_SIZE;
        int y = index + 1;

        if (gang.equals(HeroTeam.whiteSide)) {
            BaseUnit unit = HeroTeam.createWhiteUnit(x, y);
            HeroTeam.whiteSide.set(index, unit);
        } else {
            BaseUnit unit = HeroTeam.createDarkUnit(x, y);
            HeroTeam.darkSide.set(index, unit);

        }
        System.out.printf(" Боец -%s- по имени '%s' заново родился.",
                gang.get(index).getType(), gang.get(index).getName());
    }


    private void healing(int index) {
        if (gang.get(index).getHealth() < gang.get(index).getMaxHealth()) {
            float addHealth = (-1) * getDamage()[0];

            System.out.print("\nБоец -" + getType() + "- по имени '" + getName() + "' лечит -"
                    + gang.get(index).getType() + "- по имени '" + gang.get(index).getName() + "' здоровье которого "
                    + gang.get(index).getHealth() + " на " + addHealth + " пункта");

            gang.get(index).setHealth(gang.get(index).getHealth() + addHealth);
            if (gang.get(index).getHealth() > gang.get(index).getMaxHealth()) {
                gang.get(index).setHealth(gang.get(index).getMaxHealth());
            }
        }
    }

    private int healingIndex() {
        int index = -1;
        float min = Float.MAX_VALUE;
        for (int i = 0; i < gang.size(); i++) {
            if (min > gang.get(i).getHealth() / gang.get(i).getMaxHealth()) {
                min = gang.get(i).getHealth() / gang.get(i).getMaxHealth();
                index = i;
            }
        }
        return index;
    }


    @Override
    public String toString() {
        return super.toString() + " {Магия: " + mana + "}";
    }

    public int getMana() {
        return mana;
    }
}
