
import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(HeroTeam.GANG_SIZE - 1, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(HeroTeam.GANG_SIZE - 1, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(HeroTeam.GANG_SIZE - 1, formatDiv("-h"))) + formatDiv("-i");

    public static void view() {
        if (step++ == 0) {
            System.out.print(AnsiColors.ANSI_RED + "First step!" + AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(45, formatDiv(" "))) + "White Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(65, formatDiv(" "))) + "Dark Team" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "\nStep: " + step + AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(45, formatDiv(" "))) + "White Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(65, formatDiv(" "))) + "Dark Team" + AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 1; i <= HeroTeam.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= HeroTeam.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(j, i)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 1; j <= HeroTeam.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, HeroTeam.GANG_SIZE)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position) {

        String str = "| ";
        boolean alive = false;
        for (int i = 0; i < HeroTeam.GANG_SIZE; i++) {
            if (HeroTeam.darkSide.get(i).getPosition().isEquals(position)) {
                if (HeroTeam.darkSide.get(i).status.equals("dead"))
                    str = "|" + AnsiColors.ANSI_RED + HeroTeam.darkSide.get(i).getType().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
                else {
                    str = "|" + AnsiColors.ANSI_GREEN + HeroTeam.darkSide.get(i).getType().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (HeroTeam.whiteSide.get(i).getPosition().isEquals(position) && !alive) {
                if (HeroTeam.whiteSide.get(i).status.equals("dead"))
                    str = "|" + AnsiColors.ANSI_RED + HeroTeam.whiteSide.get(i).getType().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
                else
                    str = "|" + AnsiColors.ANSI_BLUE + HeroTeam.whiteSide.get(i).getType().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String PrintInfo(int index) {
        String str = "";

        if (index == -1) {
            return str;
        }
        if (HeroTeam.whiteSide.get(index).status.equals("dead"))
            str += "     " + AnsiColors.ANSI_RED + HeroTeam.whiteSide.get(index).getInfo() + AnsiColors.ANSI_RESET;
        else str += "     " + AnsiColors.ANSI_BLUE + HeroTeam.whiteSide.get(index).getInfo() + AnsiColors.ANSI_RESET;


        if (index == -1) {
            return str;
        }

        if (HeroTeam.darkSide.get(index).status.equals("dead"))
            str += "     " + AnsiColors.ANSI_RED + HeroTeam.darkSide.get(index).getInfo() + AnsiColors.ANSI_RESET;
        else str += "     " + AnsiColors.ANSI_GREEN + HeroTeam.darkSide.get(index).getInfo() + AnsiColors.ANSI_RESET;

        return str;
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}
