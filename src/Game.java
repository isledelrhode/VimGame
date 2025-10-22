import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import java.awt.Color;


public class Game extends JFrame {
    // Constructor
    public Game() {
        setTitle("Vim Nav Trainer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);

        // Main Content Pane
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(50, 50, 52));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        setContentPane(contentPane);

        DVDLogo dvdPanel = new DVDLogo();
        contentPane.add(dvdPanel);
    }

    // Main function
    public static void main(String[] args) {
        Game frame = new Game();
        frame.setVisible(true);
    }

    // Helper functions



}
