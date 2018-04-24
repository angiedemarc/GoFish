
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;


/**
 *
 * @author Rachael
 */
public class View extends JFrame {
    
    private JPanel compTurnPanel;
    private JPanel cardPanel;    
    private JPanel buttonPanel;
    private JTextField compCardField;
    private DefaultListModel model;
    private JList list; 
    private JScrollPane pane;
    private final GoFish goFish;

    public View(GoFish goFish) {
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

        model = new DefaultListModel();
        list = new JList(model);
        pane = new JScrollPane(list);
        
        compTurnPanel = new JPanel(new BorderLayout());
        compTurnPanel.add(new JLabel("Do you have a: "), BorderLayout.NORTH);
        compCardField = new JTextField();
        compTurnPanel.add(compCardField, BorderLayout.CENTER);
        
        cardPanel = new JPanel(new BorderLayout());
        cardPanel.add(new JLabel("Your cards"), BorderLayout.NORTH);
        cardPanel.add(pane, BorderLayout.CENTER);
               
        JButton goFishButton = new JButton("Go Fish!");
        JButton giveCardButton = new JButton("Give card");
        JButton askButton = new JButton("Ask for card");
        JButton drawCardButton = new JButton("Draw new card");
               
        buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(goFishButton);
        buttonPanel.add(giveCardButton);
        buttonPanel.add(askButton);
        buttonPanel.add(drawCardButton);
               
        goFishButton.addActionListener(event -> goFish());
        askButton.addActionListener(event -> askForCard());
        drawCardButton.addActionListener(event -> drawCard());
        giveCardButton.addActionListener(event -> giveCard());
        
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(compTurnPanel, BorderLayout.NORTH);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            
        setVisible(true);
    }
    
    public void setCardDisplay() {
        
    }
    
    public void goFish() {
        // connects to method in GoFish
//        if(!goFish.getDeck().isEmpty()){
//            goFish.getDeck().getNextCard();
//        }
//        else{
//            System.out.println("No cards left in deck!");
//        }
//        
//        //
//        
//        goFish.noMatchGoFish(symbol);
//        
       
    }
    
    public void askForCard() {
        // connects to method in GoFish
    }
    
    public void drawCard() {
        // connects to method in GoFish, user draws card from deck
    }
    
    public void giveCard() {
        // connects to method in GoFish, 
    }
}
