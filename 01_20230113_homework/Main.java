// Разработать иерархию классов персонажей описанных в таблице. 
// Провести анализ(абстракция) полей необходимых данных и перенести обьщие в базовый класс. 
// Так же в базовом классе переопределить метод toString для вывода подробной информации о персонаже. 
// Описать удобный конструктор базового класса и классов наследников так, 
// чтобы необходимые параметры передавались вызовом пустого конструктора класса наследника. 
// В основном классе создать список и заполнить его экземплярами каждого нового класса. 
// Вывести в консоль содержание списка переопределённым иетодом toString(). 
// *Создать список из 50 персонажей выбранных случайным числом и статический метод 
// выбирающий из списка только элементы конкретного, переданного в параметре класса и выводящий их описание в консоль!

import java.util.ArrayList;

public class Main {
    public static ArrayList<BaseUnit> personList = new ArrayList<>();

    public static void getEqual(String unitType) {
        for (var item : personList) {
            if (item.getClass().getName().equals(unitType)) {
                System.out.print(item);
            }
        }
    }

    public static void main(String[] args) {
        Generator generator = new Generator();

        for (int i = 0; i < 50; i++) {
            switch (generator.getUnitType()) {
                case "arbalester":
                    personList.add(new Arbalester(generator.getName()));
                    break;
                case "bandit":
                    personList.add(new Bandit(generator.getName()));
                    break;
                case "farmer":
                    personList.add(new Farmer(generator.getName()));
                    break;
                case "magician":
                    personList.add(new Magician(generator.getName()));
                    break;
                case "monk":
                    personList.add(new Monk(generator.getName()));
                    break;
                case "pikeman":
                    personList.add(new Pikeman(generator.getName()));
                    break;
                case "sniper":
                    personList.add(new Sniper(generator.getName()));
                    break;
                default:
                    System.out.println("ошибка. такого персонажа нет.");
                    break;
            }
        }

        System.out.println("\n--------------------");
        System.out.println("Вывод всего списка:");
        System.out.print(personList);
        System.out.println("\n--------------------");
        System.out.println("Вывод по персонажам: ");

        getEqual("Arbalester");
        getEqual("Bandit");
        getEqual("Farmer");
        getEqual("Magician");
        getEqual("Monk");
        getEqual("Pikeman");
        getEqual("Sniper");

    }

}
