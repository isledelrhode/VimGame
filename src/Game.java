import javax.swing.JFrame;


public class Game extends JFrame {
    public Game() {
        setTitle("Vim Nav Trainer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);
    }

    public static void main(String[] args) {
        Game frame = new Game();
        frame.setVisible(true);
    }
}
