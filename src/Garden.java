import java.time.DayOfWeek;
import java.util.ArrayList;

public class Garden {
    private ArrayList<Flower> flowers;

    public Garden() {
        flowers = new ArrayList<>();


    }
    // adding flowers to the garden
    public void addFlower(Flower flower) {
        if (flower != null && flowers.size() < 5) {
            flowers.add(flower);
        }
    }
    // finding the flower that is assigned to a weekday
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
    // returns all flowers in the garden
    public ArrayList<Flower> getFlowers() {
        return new ArrayList<>(flowers);
    }
}
