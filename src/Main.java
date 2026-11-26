import java.time.DayOfWeek;
void main() {
    // EVERYTHING CURRENTLY UNDER THIS IS TESTING ONLY!!
    Flower tulip = new Flower("Tulip", "closed",
            "partially open", "fully open");

    Flower daisy = new Flower("Daisy", "closed",
            "partially open", "fully open");

    Flower hibiscus = new Flower("Hibiscus", "closed",
            "partially open", "fully open");

    Garden garden = new Garden();
    garden.addFlower(tulip);
    garden.addFlower(daisy);
    garden.addFlower(hibiscus);

    System.out.println(garden.getFlowerForDay(DayOfWeek.MONDAY).getName());
    System.out.println(garden.getFlowerForDay(DayOfWeek.TUESDAY).getName());

    GardenGUI gui = new GardenGUI(garden); //passing existing argument to constructor in GardenGUI
}
