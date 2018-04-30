
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;


public class TiedGameView extends JFrame {

    private final GoFish goFish;

    public TiedGameView(GoFish goFish) {
        this.goFish = goFish;
        createVisual();
    }

    public void createVisual() {

        final int FRAME_WIDTH = 700;
        final int FRAME_HEIGHT = 200;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("GO FISH");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userScore = new JLabel("User's Score: " + goFish.getUserScore());
        userScore.setBounds(125, 10, 100, 100);
      

        
        
        JLabel compScore = new JLabel("Computer's Score: " + goFish.getUserScore());
        compScore.setBounds(425, 10, 200, 100);
        JLabel message = new JLabel("You both tied!");
        message.setBounds(250, 50, 200, 100);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(userScore);
        getContentPane().add(compScore);
        getContentPane().add(message);

        getContentPane().setLayout(null);

        setVisible(true);

    }
}
