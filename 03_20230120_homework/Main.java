// Проделать код ревью своих работ! Оптимизиривать интерфейс так, чтобы в клиент коде было видно только публичные поля. Добавить поведение (метод step) для лучников.
// 1.Если стрел больше нуля заглушка выстрел и уменьшение количества стрел
// 2.Проверить есть ли крестьяне и свободны ли хоть один из них. Если да, то вернуть одну стрелу и сбросить флаг свободен у крестьянина.
// 3.Крестьяне должны уметь поднимать свой статус "свободен"
// 4.Сделать так, чтобы по нажатию Enter программа повторяла вывод на экран состояние персонажей и вызов метода step.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int unitsCount = 10;
    public static ArrayList<BaseUnit> personList1 = new ArrayList<>();
    public static ArrayList<BaseUnit> personList2 = new ArrayList<>();

    public static String getName() {
        Random random = new Random();
        return EnumeratorSurnames.values()[random.nextInt(EnumeratorSurnames.values().length)] + " "
                + EnumeratorNames.values()[random.nextInt(EnumeratorNames.values().length)];
    }

    public static void getEqual(String unitType, ArrayList<BaseUnit> personList) {
        for (var item : personList) {
            if (item.getClass().getName().equals(unitType)) {
                System.out.print(item);
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < unitsCount; i++) {
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

        // for (int i = 0; i < unitsCount; i++) {
        // switch (new Random().nextInt(4)) {
        // case 0:
        // personList2.add(new Farmer(getName()));
        // break;
        // case 1:
        // personList2.add(new Pikeman(getName()));
        // break;
        // case 2:
        // personList2.add(new Arbalester(getName()));
        // break;
        // case 3:
        // personList2.add(new Monk(getName()));
        // break;
        // }
        // }

        int turn = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("Команда1. Количество бойцов: " + unitsCount + " Начало игры ");
        Collections.sort(personList1, new ComporatorByType());
        System.out.print(personList1);
        System.out.print("\nДля выхода из программы введите: 0, для продолжения: Enter ");

        while (!scanner.nextLine().equals("0")) {
            System.out.println("\n--------------------------------------------------------------------------");
            for (var item : personList1) {
                item.step(personList1);
            }
            System.out.print(personList1);
            System.out.println("\n--------------------------------------------------------------------------");
            System.out.println("\nКоманда1: завершен [" + (++turn) + "] ход");
            System.out.print("Для выхода из программы введите: 0, для продолжения: Enter ");
        }

        scanner.close();

    }

}
