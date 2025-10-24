import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.Color;


public class Game extends JFrame {
    public Timer timer;

    // Constructor
    public Game() {
        setTitle("Vim Nav Trainer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 200);

        // Timer
        timer = new Timer(17, null);
        timer.setCoalesce(false);
        timer.start();

        // Main Content Pane
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(50, 50, 52));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        setContentPane(contentPane);

        DVDLogo dvdPanel = new DVDLogo(contentPane);
        timer.addActionListener(dvdPanel::actionPerformed);
        contentPane.add(dvdPanel);
    }

    // Main function
    public static void main(String[] args) {
        Game frame = new Game();
        frame.setVisible(true);
    }

    // Helper functions



}
