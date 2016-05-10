/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly 
*/
// SwingSliderExample.java
// An example of JSlider with default labels.
//

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class SwingSliderExample extends JPanel {

  public SwingSliderExample() {

    super(true);
    this.setLayout(new BorderLayout());
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);

    slider.setMinorTickSpacing(2);
    slider.setMajorTickSpacing(10);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);

    // We'll just use the standard numeric labels for now...
    slider.setLabelTable(slider.createStandardLabels(10));

    add(slider, BorderLayout.CENTER);
  }

  public static void main(String s[]) {
    JFrame frame = new JFrame("Slider Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new SwingSliderExample());
    frame.pack();
    frame.setVisible(true);
  }
}