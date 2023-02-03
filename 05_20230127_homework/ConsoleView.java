
import java.util.Collections;

public class ConsoleView {

    private static int step = 1;
    // ----------------отрисовка строчек псевдографики таблицы ---------начало
    // ----------------
    private static final String top10 = formateDiv("a") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1, formateDiv("-b"))) + formateDiv("-c");
    private static final String mid10 = formateDiv("d") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1, formateDiv("-e"))) + formateDiv("-f");
    private static final String bott10 = formateDiv("g") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1, formateDiv("-h"))) + formateDiv("-i");

    // ----------------отрисовка строчек псевдографики таблицы
    // --------конец-----------------
    public static void view() {

        if (ConsoleView.step == 1) {
            System.out.println(AnsiColors.ANSI_GREEN + "\nFirst step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.println("\nStep " + step + ".");
        }
        step++;

        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getHeroChar(new Vector2(j, i)));
            }
            // System.out.println("|");
            System.out.println();
            // System.out.println(Main.darkSide.get(i).getInfo());
            System.out.println(ConsoleView.mid10);
        }
        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getHeroChar(new Vector2(j, Main.GANG_SIZE)));
        }
        // System.out.println("|");
        System.out.println();
        System.out.println(ConsoleView.bott10);

    }

    private static String formateDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    private static String getHeroChar(Vector2 position) {
        String temp = "";
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {


            for (var item : Main.whiteSide) {
                if (item.getPosition().y == position.y) {
                    temp = item.getInfo();
                    temp = (item.status.equals("dead") ? AnsiColors.ANSI_RED : AnsiColors.ANSI_GREEN) + temp;
                }
            }


            if (Main.darkSide.get(i).getPosition().isEquals(position)) {
                str = "|" + AnsiColors.ANSI_BLUE + Main.darkSide.get(i).getType().toUpperCase().charAt(0)
                        + AnsiColors.ANSI_RESET + "|"
                        + " ".repeat(3) + AnsiColors.ANSI_GREEN + temp + AnsiColors.ANSI_RESET
                        + " ".repeat(3) + (Main.darkSide.get(i).status.equals("dead") ? AnsiColors.ANSI_RED : AnsiColors.ANSI_BLUE)
                        + Main.darkSide.get(i).getInfo()
                        + AnsiColors.ANSI_RESET;
            }

            if (Main.whiteSide.get(i).getPosition().isEquals(position)) {
                str = "|" + AnsiColors.ANSI_GREEN
                        + Main.whiteSide.get(i).getType().toUpperCase().charAt(0)
                        + AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

}
