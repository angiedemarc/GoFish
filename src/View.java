
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Rachael
 */
public class View extends JFrame {

    private JPanel compTurnPanel;
    private JPanel cardPanel;
    private JPanel buttonPanel;
    private JLabel compAskLabel;
    private JTextArea alert;
    private DefaultListModel model;
    private JList list;
    private JScrollPane pane;
    private boolean mustAskForCard = false;
    private final GoFish goFish;

    private String request;

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
        compAskLabel = new JLabel("");
        alert = new JTextArea("INSTRUCTIONS: When it's your turn, select a card from your list and hit 'ask for card'. \n "
                + "If the computer has that card, it will be added to your deck. Otherwise, the computer will say 'go fish' and you must click 'draw card' to draw a card from the deck. \n"
                + "When it's the computer's turn, they will ask if you have any of a certain symbol and you will either click 'go fish' or select a card and say 'give card.'");
        alert.setLineWrap(true);
        compTurnPanel.add(compAskLabel, BorderLayout.NORTH);
        compTurnPanel.add(alert);

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
        setCardDisplay();
        setVisible(true);
    }

    public void setCardDisplay() {
        model.clear();
        for (int i = 0; i < goFish.getUserHandSize(); i++) {
            model.add(i, goFish.getUserHand().get(i));
        }
    }

    public void compTurn() {
        String requestTemp = request;
        request = goFish.compTurn();
        if (!request.equals("endGame")){
        while (requestTemp.equals(request)) {
            request = goFish.compTurn();
        }
        compAskLabel.setText("Do you have any..." + request + "s?");
    }
        else{
            checkHands();
        }
    }

    public void goFish() {
        // connects to method in GoFish
        if (!goFish.getUserTurn() && !mustAskForCard) {
            if (!goFish.noMatchGoFish(request)) {
                alert.setText("Actually, you had a " + request + " and it was given to the computer");
            } else {
                alert.setText("Your turn!");
            }
            compTurn();
        }
        if (goFish.getUserTurn() && !mustAskForCard) {
            compAskLabel.setText("");
        }
        setCardDisplay();
        checkHands();
    }

    public void askForCard() {
        if (goFish.getUserTurn() && !alert.getText().equals("Go Fish!") && !mustAskForCard) {
            alert.setText("");
            if (list.getSelectedIndex() != -1) {
                request = goFish.getUserHand().get(list.getSelectedIndex()).getSymbol();
                if (goFish.noMatchGoFish(request)) {
                    compAskLabel.setText("Go Fish!");
                    mustAskForCard = true;
                }
            } else {
                checkHands();
                alert.setText("You must select a card to ask for the symbol of!");
            }

        }
        setCardDisplay();
        checkHands();
    }

    public void drawCard() {
        alert.setText("");
        if (goFish.getUserTurn() && compAskLabel.getText().equals("Go Fish!")) {
            goFish.drawCard();
            mustAskForCard = false;
            checkHands();
            compTurn();
        }
        setCardDisplay();
        checkHands();
    }

    public void giveCard() {
        alert.setText("");
//        if (!goFish.getUserTurn() && goFish.getUserHand().get(list.getSelectedIndex()).getSymbol() == request){
//            goFish.giveCard(list.getSelectedIndex());
//        }
        if (!goFish.getUserTurn() && !mustAskForCard) {
            if (!(goFish.getUserHand().get(list.getSelectedIndex()).getSymbol().equals(request))) {
                alert.setText("That actually wasn't a match!");
            } else {
                if (!goFish.giveCard(list.getSelectedIndex())) {
                    compTurn();
                    checkHands();
                }
            }
        }
        setCardDisplay();
        checkHands();
    }
    
    public void checkHands(){
    if (goFish.checkEmptyHandsAndEndGame()) {
            endGame();
        }
    }
    public void endGame() {
        if (goFish.getCompScore()> goFish.getUserScore()){            
            //set view to losing view
            WinningCompView wcv = new WinningCompView(goFish);
            wcv.setVisible(true);
            this.dispose();
        }
        else {
            //set view to winning view
            WinningUserView wuv = new WinningUserView(goFish);
            wuv.setVisible(true);
            this.dispose();
        }
    }
}
