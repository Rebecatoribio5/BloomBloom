import org.w3c.dom.ls.LSOutput;

public class Flower {
    private String name;
    private String closedImage;
    private String partiallyOpenImage;
    private String fullyOpenImage;
    private FlowerStage currentStage;

    public Flower(String name, String closedImage,
                  String partiallyOpenImage, String fullyOpenImage) {

        this.name = name;
        this.closedImage = closedImage;
        this.partiallyOpenImage = partiallyOpenImage;
        this.fullyOpenImage = fullyOpenImage;
        this.currentStage = FlowerStage.CLOSED;
    }

    public String getName() {
        return name;
    }

    public String getClosedImage() {
        return closedImage;
    }

    public String getPartiallyOpenImage() {
        return partiallyOpenImage;
    }

    public String getFullyOpenImage() {
        return fullyOpenImage;
    }

    public FlowerStage getCurrentStage() {
        return currentStage;
    }

}
