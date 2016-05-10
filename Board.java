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

public class Board extends JFrame
{
    private static final int FRAME_WIDTH = 2560;
    private static final int FRAME_HEIGHT = 1600;
    private Sketch sketch;
    private JFrame frame;
    private JPanel buttonPanel;
    private JPanel panel;
    private JButton biggerLine;
    private JButton smallerLine;
    private JLabel sizeLabel;
    
    
    public Board() 
    {
        this.sketch = new Sketch();
        
        this.buttonPanel = new JPanel();
        
        this.sizeLabel = new JLabel("Line Thickness: " + sketch.getSize());
            this.buttonPanel.add(sizeLabel);
        
        this.biggerLine = new JButton("↑");
            this.biggerLine.addActionListener(new ButtonListener());
            this.biggerLine.setFocusable(false);
            this.buttonPanel.add(biggerLine);
        
        this.smallerLine = new JButton("↓");
            this.smallerLine.addActionListener(new ButtonListener());
            this.smallerLine.setFocusable(false);
            this.buttonPanel.add(smallerLine);
        
        this.panel = new JPanel(new BorderLayout());
            this.panel.add(sketch, BorderLayout.CENTER);
            this.panel.add(buttonPanel, BorderLayout.SOUTH);
      
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Etch-a-Sketch");
        this.setLayout(new BorderLayout());
        this.add(panel);
        this.setVisible(true);
        
        this.addKeyListener(new EventListener());
        this.requestFocusInWindow();
    }
    
    public class EventListener implements KeyListener
    {
        public void keyPressed(KeyEvent e) 
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                sketch.updatePoints(-4, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                sketch.updatePoints(4, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                sketch.updatePoints(0, -4);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                sketch.updatePoints(0, 4);
            }
        }
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }
    
    public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("↑"))
            {
                sketch.updateThickness(1);
            }
            else if (e.getActionCommand().equals("↓"))
            {
                if (sketch.getDim() > 3)
                {
                    sketch.updateThickness(-1);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Board board = new Board();
    }
}