import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandlingExample extends JFrame {
    private JTextField textField;

    public EventHandlingExample() {
        // Set up the JFrame
        super("Event Handling Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create and add a JTextField
        textField = new JTextField(20);
        textField.addKeyListener(getKeyListener());
        add(textField);

        // Add MouseListener to the JFrame
        addMouseListener(getMouseListener());

        // Set JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventHandlingExample::new);
    }

    private KeyListener getKeyListener() {
        return new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed: " + e.getKeyChar());
            }
        };
    }

    private MouseListener getMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }
        };
    }
}

