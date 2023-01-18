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
    private int health;
    private int speed;

    public BaseUnit(String type, String name, int attack, int defense,
            int[] damage, int maxHealth, int speed) {

        this.type = type;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = (this.maxHealth - new Random().nextInt(this.maxHealth)) * 100 / this.maxHealth;
        this.speed = speed;
    }

    @Override
    public void step(ArrayList<BaseUnit> list) {
    };

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public String toString() {
        return String.format(
                "\n{Роль: %10s} {Имя: %23s} {Атака: %3d} {Защита: %3d} {Урон %9s} {Здоровье: %3d%%} {Скорость: %3d}",
                type, name, attack, defense, Arrays.toString(damage), health, speed);
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

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}