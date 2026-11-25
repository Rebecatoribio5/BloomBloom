//class for the graphical user interface/GUI

/*swing provides the tools we'll to create the application window (JFrame),
display text (JLabel), and organize the layout (JPanel).*/

/*organization for dummies: create window > create panel > create labels >
add labels to panel > finally, attach the panel to the window*/

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.time.DayOfWeek;

public class GardenGUI {
    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    private JLabel dayLabel; //separate label to independently display day from flower name
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

        //frame doesn't fully close when "X" is clicked. must tell java to close application.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel(); //area inside window where objects such as flower image can be held


        Flower flower = garden.getFlowerForDay(today);//flower based off current day
        if (flower != null ) {
            label = new JLabel(flower.getName()); //text INSIDE the window
        }else { //accounting for weekends/null
            label = new JLabel("The garden is resting. . .");
        }

        dayLabel = new JLabel(today.toString());

        //now actually adding the label to panel
        panel.add(label);
        panel.add(dayLabel);

        //apparently panel isn't automatically put inside the window, so we must tell it to connect
        frame.add(panel);

        frame.setVisible(true);









    }
}
