import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeApplet extends JApplet implements ActionListener {
    private String selectedShape;

    public void init() {
        JButton circleInSquareButton = new JButton("Circle within Square");
        JButton squareInCircleButton = new JButton("Square within Circle");

        circleInSquareButton.addActionListener(this);
        squareInCircleButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(circleInSquareButton);
        panel.add(squareInCircleButton);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        selectedShape = e.getActionCommand();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (selectedShape != null) {
            g.setColor(Color.BLACK);

            if (selectedShape.equals("Circle within Square")) {
                drawCircleWithinSquare(g);
            } else if (selectedShape.equals("Square within Circle")) {
                drawSquareWithinCircle(g);
            }
        }
    }

    private void drawCircleWithinSquare(Graphics g) {
        int squareSize = 100;
        int x = 50;
        int y = 50;

        g.drawRect(x, y, squareSize, squareSize);

        int circleDiameter = squareSize;
        int circleX = x;
        int circleY = y;

        g.drawOval(circleX, circleY, circleDiameter, circleDiameter);
    }

    private void drawSquareWithinCircle(Graphics g) {
        int circleDiameter = 100;
        int x = 50;
        int y = 50;

        g.drawOval(x, y, circleDiameter, circleDiameter);

        int squareSize = circleDiameter;
        int squareX = x;
        int squareY = y;

        g.drawRect(squareX, squareY, squareSize, squareSize);
    }
}

