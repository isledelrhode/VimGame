import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Image;


public class Game extends JFrame {

    // Declarations
    private JPanel dvdLogo;

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

        // DVD Logo
        dvdLogo = new JPanel();
        dvdLogo.setBackground(new Color(0, 0, 200));
        dvdLogo.setBounds(0, 0, 100, 200);
        dvdLogo.setLayout(null);

        Image dvdLogoImg = loadImage();



    }

    // Main function
    public static void main(String[] args) {
        Game frame = new Game();
        frame.setVisible(true);
    }

    // Helper functions
    private ImageIcon loadImage(String path, int width, int height) {
        // Attempts to get image at file path and scale it. Returns proper ImageIcon if successful
        try {
            Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (NullPointerException e) {
            System.out.println("Can't retrieve file at file path because path is null.");
        }

        // Returns a blank ImageIcon if error is thrown
        return new ImageIcon();
    }


}
