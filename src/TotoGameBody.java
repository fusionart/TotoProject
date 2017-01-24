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
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JButton;

public class TotoGameBody extends JFrame {
	public int[] userNumbersArr = { 0, 0, 0, 0, 0, 0 };
	private JPanel contentPane;
	private JTextField userNumbers;

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

		userNumbers = new JTextField();
		userNumbers.setBounds(43, 35, 512, 45);
		contentPane.add(userNumbers);
		userNumbers.setColumns(10);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRun.setBounds(466, 527, 89, 23);
		contentPane.add(btnRun);

		Action numberAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userNumbers.replaceSelection(e.getActionCommand());
				userNumbers.replaceSelection(", ");
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
							addNumberToUserNumbers(number, "add");
						} else {
							System.out.println("button " + e.getActionCommand() + " not selected");
							int number = Integer.parseInt(e.getActionCommand());
							removeNumberFromUserNumbers(number, "del");
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

	private void addNumberToUserNumbers(int number, String addOrDel) {
		for (int i = 0; i < userNumbersArr.length; i++) {
			if (userNumbersArr[i] == 0) {
				userNumbersArr[i] = number;
				break;
			}
		}
		System.out.println(" array - " + Arrays.toString(userNumbersArr));
	}

	private void removeNumberFromUserNumbers(int number, String addOrDel) {
		for (int i = 0; i < userNumbersArr.length; i++) {
			if (userNumbersArr[i] == number) {
				userNumbersArr[i] = 0;
			}
		}
		System.out.println(" array - " + Arrays.toString(userNumbersArr));
	}
}
