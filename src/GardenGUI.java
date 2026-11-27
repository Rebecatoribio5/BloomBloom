//class for the graphical user interface/GUI

/*swing provides the tools we'll to create the application window (JFrame),
display text (JLabel), and organize the layout (JPanel).*/

/*organization for dummies: create window > create panel > create labels >
add labels to panel > finally, attach the panel to the window*/

import org.w3c.dom.ls.LSOutput;

import javax.swing.*; // "*" imports all accessible classes in javax.swing
import java.time.DayOfWeek;
import java.awt.Image; //image is class in awt with methods for image quality/size
import java.awt.GridBagLayout;  //type of layout manager

public class GardenGUI {
    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    private JLabel dayLabel; //separate label to independently display day from flower name
    private JLabel imageLabel;
    private Garden garden; //so GUI can access the garden/flowers even after constructor done running

    //creates a new application window that displays Bloom Bloom at top
    public GardenGUI(Garden garden) {
        this.garden = garden;
        frame = new JFrame("Bloom Bloom"); //only window title

        DayOfWeek today = RaleighTimeZone.getRaleighTime().getDayOfWeek();
        /* accesses created time zone class, then retrieves the current date+time,
        after it figures out what exact weekday
         */



        frame.setSize(500, 500);
        // frame doesn't fully close when "X" is clicked. must tell java to close application.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel(); //area inside window where objects such as flower image can be held


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); /* setLayout() tells the panel which layout
                                                                  manager to use, boxlayout is a swing layout
                                                                  manager to arrange components in a single row/column,
                                                                  Y_AXIS to stack vertically.*/

        Flower flower = garden.getFlowerForDay(today);//flower based off current day
        if (flower != null ) {
            ImageIcon originalImage = new ImageIcon(flower.getCurrentImage()); /*keeping reference to OG image
                                                                                 before scaling */

            Image scaledImage = originalImage.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);                      /* Image represents actual image,
                                                                                  ImageIcon is Swing class for using
                                                                                  image in components like JLabel
                                                                                              */
            ImageIcon flowerImage = new ImageIcon(scaledImage); //JLabel displays the image through an ImageIcon
            

            label = new JLabel(flower.getName()); //text INSIDE the window
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);        /*sets alignment horizontally within
                                                                  vertical BoxLayout and centers it horizontally*/
            imageLabel = new JLabel(flowerImage);
            imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);


        }else { //accounting for weekends/null
            label = new JLabel("The garden is resting. . .");
        }

        JPanel flowerPanel = new JPanel();

        flowerPanel.setLayout(new BoxLayout(flowerPanel, BoxLayout.Y_AXIS));

        //BoxLayout.Y_AXIS stacks components in order added, so add according to order: day,image,name
        dayLabel = new JLabel(today.toString());
        dayLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

       panel.add(Box.createVerticalGlue());            // creates/fills empty space above

        panel.add(dayLabel);                          // weekday added to outer/main panel

        panel.add(Box.createVerticalGlue());         //  creates empty space between weekday and flower name+image

        if (flower!= null) {
            flowerPanel.add(imageLabel);           // image added to inner panel
        }
        flowerPanel.add(label);                   // flower name added to inner panel

        panel.add(flowerPanel);                 // adding inner flower panel to outer main panel

        panel.add(Box.createVerticalGlue());   // creates empty space below

        frame.add(panel);                      // add the main panel(including flower panel) to the window

        frame.setVisible(true);









    }
}
