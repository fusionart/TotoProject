import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TotoGameBody extends JFrame {
	public Boolean buttonsDisabled = false;
	public JToggleButton matrixButtons[];
	public JToggleButton tBtn;
	public JPanel numbersMatrixPanel;
	public JButton btnRun;
	public JToggleButton button;
	public int userNumbersCounter = 0;
	public int numbersGuessed;
	public int[] userNumbersArr = { 0, 0, 0, 0, 0, 0 };
	public int[] totoNumbersArrFirstRound = new int[6];
	public int[] totoNumbersArrSecondRound = new int[6];
	public int[] totoNumbersArrThirdRound = new int[6];
	private JPanel contentPane;
	private JLabel lblPleaseSelect;
	private JLabel lblOurNumbers;
	private JTextField userNumberOne;
	private JTextField userNumberTwo;
	private JTextField userNumberThree;
	private JTextField userNumberFour;
	private JTextField userNumberFive;
	private JTextField userNumberSix;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField drawNumberOne;
	private JTextField drawNumberTwo;
	private JTextField drawNumberThree;
	private JTextField drawNumberFour;
	private JTextField drawNumberFive;
	private JTextField drawNumberSix;
	private JRadioButton rdbtnDrawOne;
	private JRadioButton rdbtnDrawTwo;
	private JRadioButton rdbtnDrawThree;
	private JLabel lblShowDraw;
	private JLabel lblYouHave;
	public JLabel lblPrice;
	private JButton btnPlayAgain;
	public Action numberAction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotoGameBody frame = new TotoGameBody();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TotoGameBody() {
		setTitle("Toto Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 102, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		numberAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};
		// Creates GUI
		createNumbersMatrix();
		createUserNumbersVisualization();
		playTotoBtn();
	}

	private void createNumbersMatrix() {
		numbersMatrixPanel = new JPanel();
		numbersMatrixPanel.setForeground(new Color(255, 255, 255));
		numbersMatrixPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 0, 51)));
		numbersMatrixPanel.setBounds(150, 150, 300, 300);
		numbersMatrixPanel.setLayout(new GridLayout(0, 7));
		contentPane.add(numbersMatrixPanel);
		matrixButtons = new JToggleButton[49];
		for (int j = 0; j < matrixButtons.length; j++) {
			matrixButtons[j] = new JToggleButton(String.valueOf(j + 1));
			matrixButtons[j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tBtn = (JToggleButton) e.getSource();
					if (tBtn.isSelected()) {
						int number = Integer.parseInt(e.getActionCommand());
						addNumberToUserNumbers(number);
					} else {
						int number = Integer.parseInt(e.getActionCommand());
						removeNumberFromUserNumbers(number);
					}
				}
			});
			matrixButtons[j].addActionListener(numberAction);
			matrixButtons[j].setFont(new Font("Tahoma", Font.PLAIN, 11));
			matrixButtons[j].setMargin(new Insets(0, 0, 0, 0));
			numbersMatrixPanel.add(matrixButtons[j]);
			UIManager.put("ToggleButton.select", Color.ORANGE);
			SwingUtilities.updateComponentTreeUI(matrixButtons[j]);
		}
		addNumberMatrixTextInfo();
	}

	private void addNumberMatrixTextInfo() {
		lblPleaseSelect = new JLabel("Please select 6 numbers");
		lblPleaseSelect.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelect.setBounds(200, 115, 200, 20);
		contentPane.add(lblPleaseSelect);

		lblOurNumbers = new JLabel("Your numbers");
		lblOurNumbers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOurNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		lblOurNumbers.setBounds(220, 15, 160, 20);
		contentPane.add(lblOurNumbers);
	}

	private void setMatrixButtonsDisable() {
		Boolean found = false;
		buttonsDisabled = true;
		for (int i = 0; i < matrixButtons.length; i++) {
			found = false;
			for (int j = 0; j < userNumbersArr.length; j++) {
				if (userNumbersArr[j] == i + 1) {
					found = true;
				}
			}
			if (!found) {
				matrixButtons[i].setEnabled(false);
			}
		}
	}

	private void setMatrixButtonsEnable() {
		for (int i = 0; i < matrixButtons.length; i++) {
			matrixButtons[i].setEnabled(true);
		}
	}

	private void createUserNumbersVisualization() {
		userNumberOne = new JTextField();
		userNumberOne.setForeground(new Color(204, 0, 0));
		userNumberOne.setFont(new Font("Tahoma", Font.BOLD, 13));
		userNumberOne.setBackground(new Color(255, 255, 204));
		userNumberOne.setEditable(false);
		userNumberOne.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberOne.setBounds(155, 50, 40, 40);
		contentPane.add(userNumberOne);
		userNumberOne.setColumns(10);

		userNumberTwo = new JTextField();
		userNumberTwo.setForeground(new Color(204, 0, 0));
		userNumberTwo.setFont(new Font("Tahoma", Font.BOLD, 13));
		userNumberTwo.setBackground(new Color(255, 255, 204));
		userNumberTwo.setEditable(false);
		userNumberTwo.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberTwo.setColumns(10);
		userNumberTwo.setBounds(205, 50, 40, 40);
		contentPane.add(userNumberTwo);

		userNumberThree = new JTextField();
		userNumberThree.setForeground(new Color(204, 0, 0));
		userNumberThree.setFont(new Font("Tahoma", Font.BOLD, 13));
		userNumberThree.setBackground(new Color(255, 255, 204));
		userNumberThree.setEditable(false);
		userNumberThree.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberThree.setColumns(10);
		userNumberThree.setBounds(255, 50, 40, 40);
		contentPane.add(userNumberThree);

		userNumberFour = new JTextField();
		userNumberFour.setForeground(new Color(204, 0, 0));
		userNumberFour.setFont(new Font("Tahoma", Font.BOLD, 13));
		userNumberFour.setBackground(new Color(255, 255, 204));
		userNumberFour.setEditable(false);
		userNumberFour.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberFour.setColumns(10);
		userNumberFour.setBounds(305, 50, 40, 40);
		contentPane.add(userNumberFour);

		userNumberFive = new JTextField();
		userNumberFive.setForeground(new Color(204, 0, 0));
		userNumberFive.setFont(new Font("Tahoma", Font.BOLD, 13));
		userNumberFive.setBackground(new Color(255, 255, 204));
		userNumberFive.setEditable(false);
		userNumberFive.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberFive.setColumns(10);
		userNumberFive.setBounds(355, 50, 40, 40);
		contentPane.add(userNumberFive);

		userNumberSix = new JTextField();
		userNumberSix.setForeground(new Color(204, 0, 0));
		userNumberSix.setFont(new Font("Tahoma", Font.BOLD, 13));
		userNumberSix.setBackground(new Color(255, 255, 204));
		userNumberSix.setEditable(false);
		userNumberSix.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberSix.setColumns(10);
		userNumberSix.setBounds(405, 50, 40, 40);
		contentPane.add(userNumberSix);
	}

	private void createDrawNumbersVisualization() {
		int yPos = 210;
		drawNumberOne = new JTextField();
		drawNumberOne.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberOne.setForeground(new Color(0, 0, 0));
		drawNumberOne.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberOne.setEditable(false);
		drawNumberOne.setColumns(10);
		drawNumberOne.setBackground(new Color(255, 204, 51));
		drawNumberOne.setBounds(155, yPos, 40, 40);
		contentPane.add(drawNumberOne);

		drawNumberTwo = new JTextField();
		drawNumberTwo.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberTwo.setForeground(new Color(0, 0, 0));
		drawNumberTwo.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberTwo.setEditable(false);
		drawNumberTwo.setColumns(10);
		drawNumberTwo.setBackground(new Color(255, 204, 51));
		drawNumberTwo.setBounds(205, yPos, 40, 40);
		contentPane.add(drawNumberTwo);

		drawNumberThree = new JTextField();
		drawNumberThree.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberThree.setForeground(new Color(0, 0, 0));
		drawNumberThree.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberThree.setEditable(false);
		drawNumberThree.setColumns(10);
		drawNumberThree.setBackground(new Color(255, 204, 51));
		drawNumberThree.setBounds(255, yPos, 40, 40);
		contentPane.add(drawNumberThree);

		drawNumberFour = new JTextField();
		drawNumberFour.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberFour.setForeground(new Color(0, 0, 0));
		drawNumberFour.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberFour.setEditable(false);
		drawNumberFour.setColumns(10);
		drawNumberFour.setBackground(new Color(255, 204, 51));
		drawNumberFour.setBounds(305, yPos, 40, 40);
		contentPane.add(drawNumberFour);

		drawNumberFive = new JTextField();
		drawNumberFive.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberFive.setForeground(new Color(0, 0, 0));
		drawNumberFive.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberFive.setEditable(false);
		drawNumberFive.setColumns(10);
		drawNumberFive.setBackground(new Color(255, 204, 51));
		drawNumberFive.setBounds(355, yPos, 40, 40);
		contentPane.add(drawNumberFive);

		drawNumberSix = new JTextField();
		drawNumberSix.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberSix.setForeground(new Color(0, 0, 0));
		drawNumberSix.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberSix.setEditable(false);
		drawNumberSix.setColumns(10);
		drawNumberSix.setBackground(new Color(255, 204, 51));
		drawNumberSix.setBounds(405, yPos, 40, 40);
		contentPane.add(drawNumberSix);
	}

	private void createRadioButtonsForDraw() {
		rdbtnDrawOne = new JRadioButton("Draw One");
		rdbtnDrawOne.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnDrawOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDrawNumbers(totoNumbersArrFirstRound);
				numbersGuessed(totoNumbersArrFirstRound);
			}
		});
		buttonGroup.add(rdbtnDrawOne);
		rdbtnDrawOne.setBounds(150, 160, 85, 25);
		contentPane.add(rdbtnDrawOne);

		rdbtnDrawTwo = new JRadioButton("Draw Two");
		rdbtnDrawTwo.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnDrawTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDrawNumbers(totoNumbersArrSecondRound);
				numbersGuessed(totoNumbersArrSecondRound);
			}
		});
		buttonGroup.add(rdbtnDrawTwo);
		rdbtnDrawTwo.setBounds(250, 160, 100, 25);
		contentPane.add(rdbtnDrawTwo);

		rdbtnDrawThree = new JRadioButton("Draw Three");
		rdbtnDrawThree.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnDrawThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDrawNumbers(totoNumbersArrThirdRound);
				numbersGuessed(totoNumbersArrThirdRound);
			}
		});
		buttonGroup.add(rdbtnDrawThree);
		rdbtnDrawThree.setBounds(350, 160, 100, 25);
		contentPane.add(rdbtnDrawThree);
	}

	private void playTotoBtn() {
		btnRun = new JButton("Let's play TOTO");
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRun.setBackground(new Color(102, 153, 204));
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totoNumbersRoundOne();
				totoNumbersRoundTwo();
				totoNumbersRoundThree();
				showGameResults();
			}
		});
		btnRun.setBounds(150, 480, 300, 35);
		contentPane.add(btnRun);
		btnRun.setVisible(false);
	}

	private void setRunButtonVisible(int userNumbersCounter2) {
		if (userNumbersCounter == 6) {
			btnRun.setVisible(true);
			setMatrixButtonsDisable();
		} else {
			btnRun.setVisible(false);
			if (buttonsDisabled) {
				setMatrixButtonsEnable();
			}
		}
	}

	private void playAgainBtn() {
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnPlayAgain.setBackground(new Color(255, 0, 51));
				btnPlayAgain.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(53, 0, 0)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPlayAgain.setBackground(new Color(255, 153, 51));
				btnPlayAgain.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(153, 0, 0)));
			}
		});
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TotoGameBody gameBody = new TotoGameBody();
				gameBody.setVisible(true);
			}
		});
		btnPlayAgain.setBackground(new Color(255, 153, 51));
		btnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnPlayAgain.setBounds(70, 420, 440, 80);
		btnPlayAgain.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(153, 0, 0)));
		contentPane.add(btnPlayAgain);
	}

	private void createAddionalInfo() {
		lblShowDraw = new JLabel("Please, select a draw to see the numbers and what you win");
		lblShowDraw.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblShowDraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowDraw.setBounds(100, 120, 400, 30);
		contentPane.add(lblShowDraw);

		lblYouHave = new JLabel("");
		lblYouHave.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYouHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHave.setBounds(100, 270, 400, 20);
		contentPane.add(lblYouHave);

		lblPrice = new JLabel("");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(100, 300, 400, 40);
		contentPane.add(lblPrice);
	}

	private void showGameResults() {
		btnRun.setVisible(false);
		lblPleaseSelect.setVisible(false);
		numbersMatrixPanel.setVisible(false);
		createRadioButtonsForDraw();
		createDrawNumbersVisualization();
		createAddionalInfo();
		playAgainBtn();
		revalidate();
		repaint();
	}

	private void numbersGuessed(int[] totoNumbers) {
		numbersGuessed = 0;
		for (int i = 0; i < totoNumbers.length; i++) {
			for (int j = 0; j < totoNumbers.length; j++) {
				if (userNumbersArr[i] == totoNumbers[j]) {
					numbersGuessed++;
				}
			}
		}
		lblYouHave.setText("You have " + Integer.toString(numbersGuessed) + " numbers and your prize is:");
		showPrice(numbersGuessed);
	}

	private void showPrice(int numbersGuessed) {
		switch (numbersGuessed) {
		case 3:
			lblPrice.setText("4,00");
			break;
		case 4:
			lblPrice.setText("80,00");
			break;
		case 5:
			lblPrice.setText("5000,00");
			break;
		case 6:
			lblPrice.setText("1 000 000,00");
			break;

		default:
			lblPrice.setText("You didn't win. Try again.");
			break;
		}

	}

	private void showDrawNumbers(int[] totoNumbers) {
		drawNumberOne.setText(Integer.toString(totoNumbers[0]));
		drawNumberTwo.setText(Integer.toString(totoNumbers[1]));
		drawNumberThree.setText(Integer.toString(totoNumbers[2]));
		drawNumberFour.setText(Integer.toString(totoNumbers[3]));
		drawNumberFive.setText(Integer.toString(totoNumbers[4]));
		drawNumberSix.setText(Integer.toString(totoNumbers[5]));
	}

	private void addNumberToUserNumbers(int number) {
		userNumbersCounter++;
		for (int i = 0; i < userNumbersArr.length; i++) {
			if (userNumbersArr[i] == 0) {
				userNumbersArr[i] = number;
				break;
			}
		}
		setRunButtonVisible(userNumbersCounter);
		userNumbersArr = sortArrays(userNumbersArr);
		showUserNumbers(userNumbersArr);
	}

	private void removeNumberFromUserNumbers(int number) {
		userNumbersCounter--;
		for (int i = 0; i < userNumbersArr.length; i++) {
			if (userNumbersArr[i] == number) {
				userNumbersArr[i] = 0;
			}
		}
		setRunButtonVisible(userNumbersCounter);
		userNumbersArr = sortArrays(userNumbersArr);
		showUserNumbers(userNumbersArr);
	}

	private void showUserNumbers(int[] userNumbersArr2) {
		if (userNumbersArr2[0] != 0) {
			userNumberOne.setText(Integer.toString(userNumbersArr2[0]));
		} else {
			userNumberOne.setText("");
		}
		if (userNumbersArr2[1] != 0) {
			userNumberTwo.setText(Integer.toString(userNumbersArr2[1]));
		} else {
			userNumberTwo.setText("");
		}
		if (userNumbersArr2[2] != 0) {
			userNumberThree.setText(Integer.toString(userNumbersArr2[2]));
		} else {
			userNumberThree.setText("");
		}
		if (userNumbersArr2[3] != 0) {
			userNumberFour.setText(Integer.toString(userNumbersArr2[3]));
		} else {
			userNumberFour.setText("");
		}
		if (userNumbersArr2[4] != 0) {
			userNumberFive.setText(Integer.toString(userNumbersArr2[4]));
		} else {
			userNumberFive.setText("");
		}
		if (userNumbersArr2[5] != 0) {
			userNumberSix.setText(Integer.toString(userNumbersArr2[5]));
		} else {
			userNumberSix.setText("");
		}

	}

	// Toto numbers for three rounds, randomly generated
	private void totoNumbersRoundOne() {
		Random rnm = new Random();
		Boolean checkRnmNum;
		int rnmNum;
		for (int i = 0; i < totoNumbersArrFirstRound.length; i++) {
			do {
				checkRnmNum = false;
				rnmNum = rnm.nextInt(50);
				for (int j = 0; j < i; j++) {
					if (totoNumbersArrFirstRound[j] == rnmNum) {
						checkRnmNum = true;
					}
				}
			} while (rnmNum == 0 || checkRnmNum);
			totoNumbersArrFirstRound[i] = rnmNum;
		}
		totoNumbersArrFirstRound = sortArrays(totoNumbersArrFirstRound);
	}

	private void totoNumbersRoundTwo() {
		Random rnm = new Random();
		Boolean checkRnmNum;
		int rnmNum;
		for (int i = 0; i < totoNumbersArrSecondRound.length; i++) {
			do {
				checkRnmNum = false;
				rnmNum = rnm.nextInt(50);
				for (int j = 0; j < i; j++) {
					if (totoNumbersArrSecondRound[j] == rnmNum) {
						checkRnmNum = true;
					}
				}
			} while (rnmNum == 0 || checkRnmNum);
			totoNumbersArrSecondRound[i] = rnmNum;
		}
		totoNumbersArrSecondRound = sortArrays(totoNumbersArrSecondRound);
	}

	private void totoNumbersRoundThree() {
		Random rnm = new Random();
		Boolean checkRnmNum;
		int rnmNum;
		for (int i = 0; i < totoNumbersArrThirdRound.length; i++) {
			do {
				checkRnmNum = false;
				rnmNum = rnm.nextInt(50);
				for (int j = 0; j < i; j++) {
					if (totoNumbersArrThirdRound[j] == rnmNum) {
						checkRnmNum = true;
					}
				}
			} while (rnmNum == 0 || checkRnmNum);
			totoNumbersArrThirdRound[i] = rnmNum;
		}
		totoNumbersArrThirdRound = sortArrays(totoNumbersArrThirdRound);
	}

	private int[] sortArrays(int[] arrayToSort) {
		int temp;
		for (int i = 0; i < arrayToSort.length; i++) {
			for (int j = 0; j < arrayToSort.length - 1; j++) {
				if (arrayToSort[j] > arrayToSort[j + 1]) {
					temp = arrayToSort[j];
					arrayToSort[j] = arrayToSort[j + 1];
					arrayToSort[j + 1] = temp;
				}
			}
		}
		return arrayToSort;
	}
}
