import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorMenuApp extends JFrame {

    public ColorMenuApp() {
        setTitle("Color Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu colorMenu = new JMenu("Color");
        menuBar.add(colorMenu);

        JMenuItem redItem = new JMenuItem("Red");
        JMenuItem greenItem = new JMenuItem("Green");
        JMenuItem blueItem = new JMenuItem("Blue");
        JMenuItem exitItem = new JMenuItem("Exit");

        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);
        colorMenu.add(exitItem);

        redItem.addActionListener(new ColorActionListener(Color.RED));
        greenItem.addActionListener(new ColorActionListener(Color.GREEN));
        blueItem.addActionListener(new ColorActionListener(Color.BLUE));
        exitItem.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private class ColorActionListener implements ActionListener {
        private Color color;

        public ColorActionListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().setBackground(color);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorMenuApp::new);
    }
}

