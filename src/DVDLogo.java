import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;

public class DVDLogo extends JPanel {
    private final JLabel dvdLabel;
    private final JPanel parentPanel;

    private boolean hitCorner;
    private int freezeFrameIndex = -1;
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

        // Other fields
        this.parentPanel = parentPanel;
        speed = new int[] {1, 1};
        hitCorner = false;
    }

    // Handle actions
    public void actionPerformed(ActionEvent e) {
        if (freezeFrameIndex > 0) {
            freezeFrameIndex--;
        } else if (freezeFrameIndex == 0) {
            freezeFrameIndex--;
            parentPanel.setBackground(new Color(50, 50, 52));
        } else {
            movePanel();
        }
        if (hitCorner) {
            System.out.println("Hit Corner!\n");
            freezeFrameIndex = 3;
            parentPanel.setBackground(new Color(255, 255, 255));
            hitCorner = false;
        }
    }

    // Minor functions
    private void movePanel() {
        boolean hitX = false;
        boolean hitY = false;

        setLocation(getX() + speed[0], getY());
        if (getX() + getWidth() >= parentPanel.getWidth()) {
            setLocation(getX() - (parentPanel.getWidth() - getX() + getWidth()), getY());
            speed[0] *= -1;
            hitX = true;
        } else if (getX() <= 0) {
            setLocation(-getX(), getY());
            speed[0] *= -1;
            hitX = true;
        }

        setLocation(getX(), getY() + speed[1]);
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
