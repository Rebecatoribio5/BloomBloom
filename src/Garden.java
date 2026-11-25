import java.time.DayOfWeek;
import java.util.ArrayList;

public class Garden {
    private ArrayList<Flower> flowers;

    public Garden() {
        flowers = new ArrayList<>();


    }
    public void addFlower(Flower flower) {
        if (flowers.size() < 5) {
            flowers.add(flower);
        }
    }
    public Flower getFlowerForDay(DayOfWeek day) {
        if (day == null || day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            return null;
        }
        int index = day.getValue() - 1;
        if (index < flowers.size()) {
            return flowers.get(index);
        }
        return null;
    }
    public ArrayList<Flower> getFlowers() {
        return flowers;
    }
}
