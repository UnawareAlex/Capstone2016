import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Adds labels and buttons to the ControlPanel panel along with their corresponding ActionListener
 * 
 * Alex Arnold
 * 5/10/16
 */
    public class ControlPanel extends JPanel
{
    private JPanel buttonPanel;
    private JButton biggerLine;
    private JButton smallerLine;
    private JLabel sizeLabel;
    private JButton clear;
    private JButton pickColor;
    private Sketch sketch;
    /**
     * Default constructor for objects of class ControlPanel
     * 
     * @param drawing       an instance of the Sketch class which allows access to the Sketch class through the use of accessor methods in the ActionListeners
     */
    public ControlPanel(Sketch drawing)
    {
        this.sketch = drawing;
        
        ButtonListener listener = new ButtonListener(); //will be used for all my buttons
        
        this.sizeLabel = new JLabel("Line Thickness: " + sketch.getDim()); //will show the current line thickness based on the buttons clicked
            this.add(sizeLabel);
        
        this.biggerLine = new JButton("↑");
            this.biggerLine.addActionListener(listener);
            this.biggerLine.setFocusable(false); //user will still be able to use keyboard to move line despite pressing on the buttons
            this.add(biggerLine);
        
        this.smallerLine = new JButton("↓");
            this.smallerLine.addActionListener(listener);
            this.smallerLine.setFocusable(false);
            this.add(smallerLine);
            
        this.pickColor = new JButton("Pick Color"); 
            this.pickColor.addActionListener(listener);
            this.pickColor.setFocusable(false);
            this.add(this.pickColor);
            
        this.clear = new JButton("Clear");
            this.clear.addActionListener(listener);
            this.clear.setFocusable(false);
            this.add(clear);
    }
    
    /**
     * Creates ActionListener for all buttons in ControlPanel. The ActionListener updates the thickness of the lines,
     *      the color of the line and clears the Board when the ActionCommands are called.
     *      
     */
        public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("↑"))
            {
                sketch.updateThickness(1); //increasing the width and height of the squares that make up the liny by 1
                sizeLabel.setText("Line Thickness: " + sketch.getDim()); //resetting the text of the label to reflect the new thickness
            }
            else if (e.getActionCommand().equals("↓"))
            {
                if (sketch.getDim() > 3)
                {
                    sketch.updateThickness(-1);
                    sizeLabel.setText("Line Thickness: " + sketch.getDim());
                }
            }
            else if (e.getActionCommand().equals("Clear"))
            {
                sketch.clearList(); //removes all lines from board
            }
            else if (e.getActionCommand().equals("Pick Color"))
            {
                sketch.pickColor();
            }
        }
    }
}