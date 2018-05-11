
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alexpsitos
 */
public class WinningUserView extends JFrame {

    private final GoFish goFish;

    public WinningUserView(GoFish goFish) {
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
        JLabel compScore = new JLabel("Computer's Score: " + goFish.getCompScore());
        compScore.setBounds(425, 10, 200, 100);
        JLabel message = new JLabel("You have won!");
        message.setBounds(275, 50, 200, 100);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(userScore);
        getContentPane().add(compScore);
        getContentPane().add(message);

        getContentPane().setLayout(null);
        setVisible(true);
    }
}
