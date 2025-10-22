import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;

public class DVDLogo extends JPanel {
    private final JLabel dvdLabel;
    private final Timer timer;
    private boolean hitCorner;
    private JPanel parentPanel;

    private int[] speed;

    public DVDLogo(JPanel parentPanel) {
        // Set the panel as a whole
        setBackground(new Color(0, 0, 255, 0));
        setBounds(0, 0, 250, 100);
        setLayout(null);

        // Initialize and set the label
        dvdLabel = new JLabel("DvD Logo");
        dvdLabel.setName("DvD Logo");
        dvdLabel.setIcon(loadImage("assets/dvd_logo.png", 250, 100));
        dvdLabel.setBounds(0, 0, 250, 100);
        add(dvdLabel);

        // Timer
        timer = new Timer(1, this::actionPerformed);
        timer.setCoalesce(false);
        timer.start();

        // Other fields
        this.parentPanel = parentPanel;
        speed = new int[] {1, 1};
        hitCorner = false;
    }

    // Handle actions
    public void actionPerformed(ActionEvent e) {
        movePanel();

        if (hitCorner) {
            System.out.println("Hit Corner!\n");
            hitCorner = false;
        }
    }

    // Minor functions
    private void movePanel() {
        boolean hitX = false;
        boolean hitY = false;

        setBounds(getX() + speed[0], getY() + speed[1], getWidth(), getHeight());

        if (getX() + getWidth() >= parentPanel.getWidth() || getX() <= 0) {
            speed[0] *= -1;
            hitX = true;
        }
        if (getY() + getHeight() >= parentPanel.getHeight() || getY() <= 0) {
            speed[1] *= -1;
            hitY = true;
        }

        if (hitX && hitY) {
            hitCorner = true;
        }
    }

    // Helper function
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
