import java.util.Arrays;

public class BaseUnit {

    private String type;
    private String name;
    private int attack;
    private int defense;
    private int[] damage;
    private int health;
    private int speed;

    public BaseUnit(String type, String name, int attack, int defense,
            int[] damage, int health, int speed) {

        this.type = type;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format(
                "\n{Роль: %10s} {Имя: %23s} {Атака: %3d} {Защита: %3d} {Урон %9s} {Здоровье: %3d} {Скорость: %3d}",
                type, name, attack, defense, Arrays.toString(damage), health, speed);
    }

    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int[] getDamage(){
        return damage;
    }
    public int getHealth(){
        return health;
    }
    public int getSpeed(){
        return speed;
    }

}