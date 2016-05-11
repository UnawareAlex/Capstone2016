import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Hashtable;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
     * Adds labels and buttons to the ControlPanel panel along with their corresponding ActionListener
     * 
     * @param drawing       an instance of the Sketch class which allows access to the Sketch class through the use of accessor methods in the ActionListeners
     */
    public ControlPanel(Sketch drawing)
    {
        //this.buttonPanel = new JPanel();
        
        this.sketch = drawing;
        
        ButtonListener listener = new ButtonListener();
        
        this.sizeLabel = new JLabel("Line Thickness: " + sketch.getDim());
            this.add(sizeLabel);
        
        this.biggerLine = new JButton("↑");
            this.biggerLine.addActionListener(listener);
            this.biggerLine.setFocusable(false);
            this.add(biggerLine);
        
        this.smallerLine = new JButton("↓");
            this.smallerLine.addActionListener(listener);
            this.smallerLine.setFocusable(false);
            this.add(smallerLine);
            
        this.pickColor = new JButton("Pick Color"); //adding the buttons to the ControlPanel
            this.pickColor.addActionListener(listener);
            this.pickColor.setFocusable(false);
            this.add(this.pickColor);
            
        this.clear = new JButton("Clear");
            this.clear.addActionListener(listener);
            this.clear.setFocusable(false);
            this.add(clear);
    }
    
    public class ButtonListener implements ActionListener
    {
        /**
         * Creates ActionListener for all buttons in ControlPanel. The ActionListener updates the thickness of the lines,
         *      the color of the line and clears the Board when the ActionCommands are called.
         * 
         * @param e
         */
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("↑"))
            {
                sketch.updateThickness(1);
                sizeLabel.setText("Line Thickness: " + sketch.getDim());
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
                sketch.clearList();
            }
            else if (e.getActionCommand().equals("Pick Color"))
            {
                sketch.pickColor();
            }
        }
    }
}