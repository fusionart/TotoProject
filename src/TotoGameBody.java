import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class TotoGameBody extends JFrame {
	public JButton btnRun;
	public JToggleButton button;
	public int userNumbersCounter = 0;
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
	private JLabel lblPrice;

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
		setBounds(100, 100, 600, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRun = new JButton("Let's play TOTO");
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRun.setBackground(new Color(102, 153, 204));
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totoNumbersRoundOne();
				totoNumbersRoundTwo();
				totoNumbersRoundThree();
				showAdditionlInfo();
			}
		});
		btnRun.setBounds(177, 400, 240, 30);
		contentPane.add(btnRun);
		btnRun.setVisible(false);

		lblPleaseSelect = new JLabel("Please select 6 numbers");
		lblPleaseSelect.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelect.setBounds(200, 100, 200, 20);
		contentPane.add(lblPleaseSelect);

		lblOurNumbers = new JLabel("Your numbers");
		lblOurNumbers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOurNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		lblOurNumbers.setBounds(220, 15, 160, 20);
		contentPane.add(lblOurNumbers);

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

		rdbtnDrawOne = new JRadioButton("Draw One");
		rdbtnDrawOne.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnDrawOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDrawNumbers(totoNumbersArrFirstRound);
			}
		});
		buttonGroup.add(rdbtnDrawOne);
		rdbtnDrawOne.setBounds(149, 507, 85, 23);
		contentPane.add(rdbtnDrawOne);
		rdbtnDrawOne.setVisible(false);

		rdbtnDrawTwo = new JRadioButton("Draw Two");
		rdbtnDrawTwo.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnDrawTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDrawNumbers(totoNumbersArrSecondRound);
			}
		});
		buttonGroup.add(rdbtnDrawTwo);
		rdbtnDrawTwo.setBounds(247, 507, 98, 23);
		contentPane.add(rdbtnDrawTwo);
		rdbtnDrawTwo.setVisible(false);

		rdbtnDrawThree = new JRadioButton("Draw Three");
		rdbtnDrawThree.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnDrawThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDrawNumbers(totoNumbersArrThirdRound);
			}
		});
		buttonGroup.add(rdbtnDrawThree);
		rdbtnDrawThree.setBounds(347, 507, 98, 23);
		contentPane.add(rdbtnDrawThree);
		rdbtnDrawThree.setVisible(false);

		drawNumberOne = new JTextField();
		drawNumberOne.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberOne.setForeground(new Color(0, 0, 0));
		drawNumberOne.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberOne.setEditable(false);
		drawNumberOne.setColumns(10);
		drawNumberOne.setBackground(new Color(255, 204, 51));
		drawNumberOne.setBounds(155, 547, 40, 40);
		contentPane.add(drawNumberOne);
		drawNumberOne.setVisible(false);

		drawNumberTwo = new JTextField();
		drawNumberTwo.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberTwo.setForeground(new Color(0, 0, 0));
		drawNumberTwo.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberTwo.setEditable(false);
		drawNumberTwo.setColumns(10);
		drawNumberTwo.setBackground(new Color(255, 204, 51));
		drawNumberTwo.setBounds(205, 547, 40, 40);
		contentPane.add(drawNumberTwo);
		drawNumberTwo.setVisible(false);

		drawNumberThree = new JTextField();
		drawNumberThree.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberThree.setForeground(new Color(0, 0, 0));
		drawNumberThree.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberThree.setEditable(false);
		drawNumberThree.setColumns(10);
		drawNumberThree.setBackground(new Color(255, 204, 51));
		drawNumberThree.setBounds(255, 547, 40, 40);
		contentPane.add(drawNumberThree);
		drawNumberThree.setVisible(false);

		drawNumberFour = new JTextField();
		drawNumberFour.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberFour.setForeground(new Color(0, 0, 0));
		drawNumberFour.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberFour.setEditable(false);
		drawNumberFour.setColumns(10);
		drawNumberFour.setBackground(new Color(255, 204, 51));
		drawNumberFour.setBounds(305, 547, 40, 40);
		contentPane.add(drawNumberFour);
		drawNumberFour.setVisible(false);

		drawNumberFive = new JTextField();
		drawNumberFive.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberFive.setForeground(new Color(0, 0, 0));
		drawNumberFive.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberFive.setEditable(false);
		drawNumberFive.setColumns(10);
		drawNumberFive.setBackground(new Color(255, 204, 51));
		drawNumberFive.setBounds(355, 547, 40, 40);
		contentPane.add(drawNumberFive);
		drawNumberFive.setVisible(false);

		drawNumberSix = new JTextField();
		drawNumberSix.setHorizontalAlignment(SwingConstants.CENTER);
		drawNumberSix.setForeground(new Color(0, 0, 0));
		drawNumberSix.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawNumberSix.setEditable(false);
		drawNumberSix.setColumns(10);
		drawNumberSix.setBackground(new Color(255, 204, 51));
		drawNumberSix.setBounds(405, 547, 40, 40);
		contentPane.add(drawNumberSix);
		drawNumberSix.setVisible(false);
		
		lblShowDraw = new JLabel("Please, select a draw to see the numbers and what you win");
		lblShowDraw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblShowDraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowDraw.setBounds(111, 475, 362, 30);
		contentPane.add(lblShowDraw);
		lblShowDraw.setVisible(false);
		
		lblYouHave = new JLabel("You have xxx numbers and your price is:");
		lblYouHave.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYouHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHave.setBounds(120, 610, 360, 20);
		contentPane.add(lblYouHave);
		lblYouHave.setVisible(false);
		
		lblPrice = new JLabel("New label");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(200, 640, 200, 40);
		contentPane.add(lblPrice);
		lblPrice.setVisible(false);

		Action numberAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// userNumbers.replaceSelection(e.getActionCommand());
				// userNumbers.replaceSelection(", ");
			}
		};

		int offsetX;
		int offsetY;
		int counter = 1;
		for (int i = 0; i < 7; i++) {
			offsetX = 0;
			offsetY = 35 * i;
			for (int j = 0; j < 7; j++) {
				String text = String.valueOf(counter);
				counter++;
				button = new JToggleButton(text);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JToggleButton tBtn = (JToggleButton) e.getSource();
						if (tBtn.isSelected()) {
							System.out.println("button " + e.getActionCommand() + " selected");
							int number = Integer.parseInt(e.getActionCommand());
							addNumberToUserNumbers(number);
						} else {
							System.out.println("button " + e.getActionCommand() + " not selected");
							int number = Integer.parseInt(e.getActionCommand());
							removeNumberFromUserNumbers(number);
						}
					}

				});
				button.addActionListener(numberAction);
				button.setFont(new Font("Tahoma", Font.PLAIN, 11));
				button.setMargin(new Insets(0, 0, 0, 0));
				button.setBounds(177 + offsetX, 125 + offsetY, 30, 30);
				offsetX += 35;
				contentPane.add(button);
				UIManager.put("ToggleButton.select", Color.ORANGE);
				SwingUtilities.updateComponentTreeUI(button);
			}
		}
	}

	protected void showAdditionlInfo() {
		drawNumberOne.setVisible(true);
		drawNumberTwo.setVisible(true);
		drawNumberThree.setVisible(true);
		drawNumberFour.setVisible(true);
		drawNumberFive.setVisible(true);
		drawNumberSix.setVisible(true);
		rdbtnDrawOne.setVisible(true);
		rdbtnDrawTwo.setVisible(true);
		rdbtnDrawThree.setVisible(true);
		lblShowDraw.setVisible(true);
		lblPrice.setVisible(true);
		lblYouHave.setVisible(true);
		btnRun.setVisible(false);
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
		System.out.println(" array - " + Arrays.toString(userNumbersArr));
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
		System.out.println(" array - " + Arrays.toString(userNumbersArr));
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

	private void setRunButtonVisible(int userNumbersCounter2) {
		if (userNumbersCounter == 6) {
			btnRun.setVisible(true);
		} else {
			btnRun.setVisible(false);
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
		System.out.println(Arrays.toString(totoNumbersArrFirstRound));
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
		System.out.println(Arrays.toString(totoNumbersArrSecondRound));
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
		System.out.println(Arrays.toString(totoNumbersArrThirdRound));
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
