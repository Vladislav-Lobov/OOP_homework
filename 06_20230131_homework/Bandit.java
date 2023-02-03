import java.util.ArrayList;
import java.util.Random;

import static java.util.Random.*;

public class Bandit extends BaseUnit {

    public Bandit(ArrayList<BaseUnit> gang, String name, int x, int y) {
        super("bandit", name, 8, 3, new int[]{2, 4}, 10, 6);
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BaseUnit> list) {
        if (status.equals("dead")) {
            return;
        }

        float distance = getTarget(list)[0];
        int indexMinDistance = (int) getTarget(list)[1];
        if ((int) indexMinDistance == -1) {
            System.out.printf("\n------------Игра окончена------------");
            return;
        }


        if (distance <= 1) {
            int defect = attackCalculation(list, 0, indexMinDistance);
            list.get(indexMinDistance).hasDamage(defect);
            return;
        }

        int x = getPosition().x;
        int y = getPosition().y;


        if (list.get(indexMinDistance).getPosition().y > getPosition().y && checkPosition(new Vector2(x, y + 1), list)) {
            setPosition(new Vector2(x, y + 1));
        } else if (list.get(indexMinDistance).getPosition().y < getPosition().y && checkPosition(new Vector2(x, y - 1), list)) {
            setPosition(new Vector2(x, y - 1));
        } else if (list.get(indexMinDistance).getPosition().x < getPosition().x && checkPosition(new Vector2(x - 1, y), list)) {
            setPosition(new Vector2(x - 1, y));
        } else if (list.get(indexMinDistance).getPosition().x > getPosition().x && checkPosition(new Vector2(x + 1, y), list)) {
            setPosition(new Vector2(x + 1, y));
        }

        ifStops(x, y, list);

    }

    public void ifStops(int x, int y, ArrayList<BaseUnit> list) {

        while (getPosition().x == x && getPosition().y == y) {

            int value = new Random().nextInt(4);
            switch (value) {
                case 0:
                    if (checkPosition(new Vector2(x, y + 1), list)) {
                        setPosition(new Vector2(x, y + 1));
                    }
                    break;
                case 1:
                    if (checkPosition(new Vector2(x, y - 1), list)) {
                        setPosition(new Vector2(x, y - 1));
                    }
                    break;
                case 2:
                    if (checkPosition(new Vector2(x - 1, y), list)) {
                        setPosition(new Vector2(x - 1, y));
                    }
                    break;
                case 3:
                    if (checkPosition(new Vector2(x + 1, y), list)) {
                        setPosition(new Vector2(x + 1, y));
                    }
                    break;
            }
        }
    }


}

