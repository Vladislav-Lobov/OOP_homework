// Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo(); 
// Реализовать имнтерфейс в абстрактном классе. Создать два списка в классе main. 
// В кждый из списков добавить по десять экземнляров наследников BaseHero. 
// Крестьянин, Разбойник, Снайпер и Колдун могут быть в одном и 
// Крестьянин, копейщик, арбалетчик и монах в другой. 
// Реализовать метод step() для магов таким образом, чтобы они могли лечить самого повреждённого из своих однополчан!) 
// Удалить ненужные методы из абстрактного класса, если такие есть.

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static ArrayList<BaseUnit> personList1 = new ArrayList<>();
    public static ArrayList<BaseUnit> personList2 = new ArrayList<>();

    public static String getName(){
        Random random = new Random();
        return EnumeratorSurnames.values()[random.nextInt(EnumeratorSurnames.values().length)] + " " + EnumeratorNames.values()[random.nextInt(EnumeratorNames.values().length)];
    }

    public static void getEqual(String unitType, ArrayList<BaseUnit> personList) {
        for (var item : personList) {
            if (item.getClass().getName().equals(unitType)) {
                System.out.print(item);
            }
        }
    }

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    personList1.add(new Farmer(getName()));
                    break;
                case 1:
                    personList1.add(new Bandit(getName()));
                    break;
                case 2:
                    personList1.add(new Sniper(getName()));
                    break;
                case 3:
                    personList1.add(new Magician(getName()));
                    break;
            }
        }

        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    personList2.add(new Farmer(getName()));
                    break;
                case 1:
                    personList2.add(new Pikeman(getName()));
                    break;
                case 2:
                    personList2.add(new Arbalester(getName()));
                    break;
                case 3:
                    personList2.add(new Monk(getName()));
                    break;
            }
        }

        System.out.println("\n--------------------");
        System.out.println("Список1:");
        System.out.print(personList1);
        Magician mag1 = new Magician("знахарь Афанасий");
        mag1.step(personList1);

        System.out.println("\n--------------------");
        System.out.println("Список2:");
        System.out.print(personList2);
        Monk monk1 = new Monk("дьяк Сергей");
        monk1.step(personList2);
    }

}
