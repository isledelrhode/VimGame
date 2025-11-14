import javax.swing.JFrame;


public class Game extends JFrame {
<<<<<<< Updated upstream
=======
    public Timer timer;

    public static void run() {
        Game frame = new Game();
        frame.setVisible(true);
    }


    // Constructor
>>>>>>> Stashed changes
    public Game() {
        setTitle("Vim Nav Trainer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< Updated upstream
        setBounds(100, 100, 900, 700);
    }

    public static void main(String[] args) {
        Game frame = new Game();
        frame.setVisible(true);
    }
=======
        setBounds(0, 0, 750, 600);

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
    // Helper functions



>>>>>>> Stashed changes
}
