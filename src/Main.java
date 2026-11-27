import java.time.DayOfWeek;



void main() {
    // EVERYTHING CURRENTLY UNDER THIS IS TESTING ONLY!!
    //"images/..." gives the location of the image as a text
    Flower tulip = new Flower("Tulip", "images/tulip_closed.png",
            "images/tulip_partial.png", "images/tulip_open.png");

    Flower daisy = new Flower("Daisy", "images/daisy_closed.png",
            "images/daisy_partial.png", "images/daisy_open.png");

   // Flower hibiscus = new Flower("Hibiscus", "closed",
         //   "partially open", "fully open");

    Garden garden = new Garden();
    garden.addFlower(tulip);
    garden.addFlower(daisy);
    //garden.addFlower(hibiscus);
    // garden.addFlower();
    // garden.addFlower();

    System.out.println(garden.getFlowerForDay(DayOfWeek.MONDAY).getName());
    System.out.println(garden.getFlowerForDay(DayOfWeek.TUESDAY).getName());
    // System.out.println(garden.getFlowerForDay(DayOfWeek.WEDNSDAY).getName());
    // System.out.println(garden.getFlowerForDay(DayOfWeek.THURSDAY).getName());
    // System.out.println(garden.getFlowerForDay(DayOfWeek.FRIDAY).getName());

    GardenGUI gui = new GardenGUI(garden); //passing existing argument to constructor in GardenGUI
}
