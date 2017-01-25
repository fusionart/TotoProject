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

public class TotoGameBody extends JFrame {
	public JButton btnRun;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totoNumbers();
			}
		});
		btnRun.setBounds(466, 527, 89, 23);
		contentPane.add(btnRun);
		
		lblPleaseSelect = new JLabel("Please select 6 numbers");
		lblPleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelect.setBounds(33, 22, 522, 53);
		contentPane.add(lblPleaseSelect);
		
		lblOurNumbers = new JLabel("Your numbers");
		lblOurNumbers.setBounds(21, 86, 89, 14);
		contentPane.add(lblOurNumbers);
		
		userNumberOne = new JTextField();
		userNumberOne.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberOne.setBounds(103, 73, 40, 40);
		contentPane.add(userNumberOne);
		userNumberOne.setColumns(10);
		
		userNumberTwo = new JTextField();
		userNumberTwo.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberTwo.setColumns(10);
		userNumberTwo.setBounds(153, 73, 40, 40);
		contentPane.add(userNumberTwo);
		
		userNumberThree = new JTextField();
		userNumberThree.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberThree.setColumns(10);
		userNumberThree.setBounds(203, 73, 40, 40);
		contentPane.add(userNumberThree);
		
		userNumberFour = new JTextField();
		userNumberFour.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberFour.setColumns(10);
		userNumberFour.setBounds(253, 73, 40, 40);
		contentPane.add(userNumberFour);
		
		userNumberFive = new JTextField();
		userNumberFive.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberFive.setColumns(10);
		userNumberFive.setBounds(303, 73, 40, 40);
		contentPane.add(userNumberFive);
		
		userNumberSix = new JTextField();
		userNumberSix.setHorizontalAlignment(SwingConstants.CENTER);
		userNumberSix.setColumns(10);
		userNumberSix.setBounds(353, 73, 40, 40);
		contentPane.add(userNumberSix);
		btnRun.setVisible(false);

		Action numberAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//userNumbers.replaceSelection(e.getActionCommand());
				//userNumbers.replaceSelection(", ");
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
				JToggleButton button = new JToggleButton(text);
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
				button.setBounds(100 + offsetX, 250 + offsetY, 30, 30);
				offsetX += 35;
				contentPane.add(button);
			}
		}
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
		userNumbersArr=sortArrays(userNumbersArr);
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
		userNumbersArr=sortArrays(userNumbersArr);
		showUserNumbers(userNumbersArr);
		System.out.println(" array - " + Arrays.toString(userNumbersArr));
	}
	
	private void showUserNumbers(int[] userNumbersArr2) {
		if (userNumbersArr2[0]!=0){
			userNumberOne.setText(Integer.toString(userNumbersArr2[0]));
		} else {
			userNumberOne.setText("");
		}
		if (userNumbersArr2[1]!=0){
			userNumberTwo.setText(Integer.toString(userNumbersArr2[1]));
		} else {
			userNumberTwo.setText("");
		}
		if (userNumbersArr2[2]!=0){
			userNumberThree.setText(Integer.toString(userNumbersArr2[2]));
		} else {
			userNumberThree.setText("");
		}
		if (userNumbersArr2[3]!=0){
			userNumberFour.setText(Integer.toString(userNumbersArr2[3]));
		} else {
			userNumberFour.setText("");
		}
		if (userNumbersArr2[4]!=0){
			userNumberFive.setText(Integer.toString(userNumbersArr2[4]));
		} else {
			userNumberFive.setText("");
		}
		if (userNumbersArr2[5]!=0){
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

	private void totoNumbers() {
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
