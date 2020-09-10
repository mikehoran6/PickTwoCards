// GUI version of app from ch7

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PickTwoCards extends JFrame implements ActionListener
{
	//GUI components
	Font mainFont = new Font("Verdana", Font.BOLD, 32);
	Color myColor = new Color(93,245,32);
	JLabel mainTitle = new JLabel("Pick Two Cards");
	JLabel compLabel = new JLabel("Computer's card is: ");
	JLabel compResult = new JLabel("");
	JLabel playerLabel = new JLabel("Player's card is: ");
	JLabel playerResult = new JLabel("");
	JLabel endResult = new JLabel("");
	JButton button = new JButton("Draw Cards");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();

	//constructor
	public PickTwoCards()
	{
		super("Two Cards GUI");
		setBounds(600,300,310,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(7,1));

		//customize
		getContentPane().setBackground(myColor);
		mainTitle.setFont(mainFont);
		button.setForeground(Color.RED);

		//add components to frame and panels

		add(mainTitle);
		panel1.add(compLabel);
		panel1.add(compResult);
		panel1.setBackground(myColor);
		panel2.add(playerLabel);
		panel2.add(playerResult);
		panel2.setBackground(myColor);
		panel3.add(endResult);
		panel3.setBackground(myColor);
		panel4.add(button);
		panel4.setBackground(myColor);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		setVisible(true);

		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		//call playGame() method
		playGame();
	}

	public void playGame()
	{
		// variables and constants
		final int CARDS_IN_SUIT = 13;
		int comValue;
		int userValue;
		String msg;
		Card comCard = new Card();
		Card userCard = new Card();
		// calculation phase
		comValue = ((int)(Math.random() * CARDS_IN_SUIT + 1));
		userValue = ((int)(Math.random() * CARDS_IN_SUIT + 1));

		comCard.setValue(comValue);
		userCard.setValue(userValue);

		//array of suits randomly chosen for each card
		String[] cardSuits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		comCard.setSuit(cardSuits[(int)(Math.random()*4)]);
		userCard.setSuit(cardSuits[(int)(Math.random()*4)]);
		// Determine a winner
		if(comCard.getValue() > userCard.getValue())
		{
			msg = "Sorry, the Computer has won.";
		}
		else
		{
			if(comCard.getValue() < userCard.getValue())
			{
				msg = "Congratulations, you win!";
			}
			else
			{
				msg = "We have a tie!";
			}
		}
		// Output phase
		compResult.setText(comCard.getRank() + " of " + comCard.getSuit());
		playerResult.setText(userCard.getRank() + " of " + userCard.getSuit());
		endResult.setText(msg);
	}

	public static void main(String[] args)
	{
		PickTwoCards frame = new PickTwoCards();

	}
}