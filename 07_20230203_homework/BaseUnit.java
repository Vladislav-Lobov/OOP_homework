import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseUnit implements Interface1 {

    private String type;
    private String name;
    private int attack;
    private int defense;
    private int[] damage;
    private int maxHealth;
    private float health;
    private int speed;

    protected String status;

    protected ArrayList<BaseUnit> gang;
    protected Vector2 position;

    public BaseUnit(String type, String name, int attack, int defense,
                    int[] damage, int maxHealth, int speed) {

        this.type = type;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.speed = speed;
        status = "alive";
    }

    @Override
    public void step(ArrayList<BaseUnit> list) {
    }

    @Override
    public String getInfo() {
        String outStr = String.format("%21s %10s ⚔%-2d \uD83D\uDEE1%-2d ♥%-5.2f/%-2d ☠%-2d/%-2d \uD83D\uDD57%-2d    ", name, type, attack, defense, health,
                maxHealth, damage[0], damage[1], speed);
        return outStr;
    }

    @Override
    public String toString() {
        return String.format(
                "\n{Роль: %10s} {Имя: %23s} {Атака: %3d} {Защита: %3d} {Урон %9s} {Здоровье: %5.2f/%3d} {Скорость: %3d}",
                type, name, attack, defense, Arrays.toString(damage), health, maxHealth, speed);
    }


    public void hasDamage(int defect) {
        health -= defect;
        if (health <= 0) {
            health = 0;
            status = "dead";
        }
    }

    public int attackCalculation(ArrayList<BaseUnit> list, float minDistance, int indexPlayer) {
        int defect = 0;
        if (minDistance > 4) {
            if (list.get(indexPlayer).defense < attack) {
                defect = damage[0] + 1;
            } else {
                defect = damage[0] - 1;
            }
        } else {
            if (list.get(indexPlayer).defense < attack) {
                defect = damage[1] + 1;
            } else {
                defect = damage[1] - 1;
            }
        }
        return defect;
    }

    public float[] getTarget(ArrayList<BaseUnit> list) {
        float minDistance = Float.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).status.equals("dead")) {
                if (minDistance > getPosition().getDistance(list.get(i).getPosition().x, list.get(i).getPosition().y)) {
                    minDistance = getPosition().getDistance(list.get(i).getPosition().x, list.get(i).getPosition().y);
                    minIndex = i;
                }
            }
        }


        return new float[]{minDistance, (float) minIndex};
    }

    protected boolean checkPosition(Vector2 position, ArrayList<BaseUnit> list) {
        for (BaseUnit npc : this.gang) {
            if (npc.getPosition().isEquals(position))
                return false;
        }

        for (var item : list) {
            if (item.getPosition().isEquals(position))
                return false;
        }


        return true;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int[] getDamage() {
        return damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public float getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

}