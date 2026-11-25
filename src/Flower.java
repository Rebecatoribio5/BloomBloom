import org.w3c.dom.ls.LSOutput;
//private instance variables
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


    //getters
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

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setClosedImage(String closedImage) {
        this.closedImage = closedImage;
    }

    public void setPartiallyOpenImage(String partiallyOpenImage) {
        this.partiallyOpenImage = partiallyOpenImage;
    }

    public void setFullyOpenImage(String fullyOpenImage) {
        this.fullyOpenImage = fullyOpenImage;
    }

    public void setCurrentStage(FlowerStage currentStage) {
        this.currentStage = currentStage;
    }


    //switch method for obtaining the correct image depending on flower stage
    public String getCurrentImage() {

        switch (currentStage) {
            case CLOSED:
                return closedImage;

            case PARTIALLY_OPEN:
                return partiallyOpenImage;

            case FULLY_OPEN:
                return fullyOpenImage;

            default:
                return closedImage;




        }

    }

}
