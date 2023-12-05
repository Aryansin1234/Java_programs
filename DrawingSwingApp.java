import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingSwingApp extends JFrame {

    private int shapeType = 0; // 0: Circle, 1: Line, 2: Rectangle
    private int startX, startY, endX, endY;
    private Color fillColor = Color.RED;

    public DrawingSwingApp() {
        setTitle("Drawing Shapes");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton circleButton = new JButton("Draw Circle");
        JButton lineButton = new JButton("Draw Line");
        JButton rectangleButton = new JButton("Draw Rectangle");
        JButton colorButton = new JButton("Choose Color");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(circleButton);
        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(colorButton);

        add(buttonPanel, BorderLayout.NORTH);

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawShapes(g);
            }
        };
        add(drawingPanel, BorderLayout.CENTER);

        circleButton.addActionListener(e -> setShapeType(0));
        lineButton.addActionListener(e -> setShapeType(1));
        rectangleButton.addActionListener(e -> setShapeType(2));
        colorButton.addActionListener(e -> chooseColor());

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                drawingPanel.repaint();
            }
        });

        setVisible(true);
    }

    private void drawShapes(Graphics g) {
        switch (shapeType) {
            case 0:
                drawCircle(g);
                break;
            case 1:
                drawLine(g);
                break;
            case 2:
                drawRectangle(g);
                break;
        }
    }

    private void drawCircle(Graphics g) {
        int diameter = Math.max(endX - startX, endY - startY);
        g.setColor(fillColor);
        g.fillOval(startX, startY, diameter, diameter);
    }

    private void drawLine(Graphics g) {
        g.setColor(fillColor);
        g.drawLine(startX, startY, endX, endY);
    }

    private void drawRectangle(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(startX, startY, endX - startX, endY - startY);
    }

    private void setShapeType(int type) {
        shapeType = type;
    }

    private void chooseColor() {
        fillColor = JColorChooser.showDialog(this, "Choose Color", fillColor);
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawingSwingApp::new);
    }
}

