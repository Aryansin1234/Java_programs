import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CircleSquareApplet extends JPanel implements ActionListener {

    private JButton circleSquareButton;
    private JButton squareCircleButton;
    private Graphics g;
    private boolean isCircleWithinSquare = true;

    public CircleSquareApplet() {
        setLayout(new BorderLayout());

        circleSquareButton = new JButton("Circle Within Square");
        circleSquareButton.addActionListener(this);
        add(circleSquareButton, BorderLayout.WEST);

        squareCircleButton = new JButton("Square Within Circle");
        squareCircleButton.addActionListener(this);
        add(squareCircleButton, BorderLayout.EAST);
    }

    public void actionPerformed(ActionEvent e) {
        isCircleWithinSquare = !isCircleWithinSquare;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 3;
        int squareSide = radius * 2 / 3;

        if (isCircleWithinSquare) {
            // Draw square
            g.setColor(Color.BLACK);
            g.drawRect(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            // Draw circle
            g.setColor(Color.RED);
            g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        } else {
            // Draw circle
            g.setColor(Color.BLACK);
            g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            // Draw square
            g.setColor(Color.RED);
            g.fillRect(centerX - squareSide / 2, centerY - squareSide / 2, squareSide, squareSide);
        }
    }

    public static void main(String[] args) {
        // Create and show the application window
        JFrame frame = new JFrame("Circle and Square Applet");
        CircleSquareApplet appletPanel = new CircleSquareApplet();
        frame.add(appletPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

