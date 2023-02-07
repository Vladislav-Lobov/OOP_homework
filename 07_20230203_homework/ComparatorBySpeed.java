import java.util.Comparator;

public class ComparatorBySpeed implements Comparator<BaseUnit> {
    @Override
    public int compare(BaseUnit unit1, BaseUnit unit2) {
        if (unit1.getSpeed() < unit2.getSpeed()){
            return 1;
        } else if(unit1.getSpeed() == unit2.getSpeed()){
            return 0;
        } else {
            return -1;
        }
    }
}
