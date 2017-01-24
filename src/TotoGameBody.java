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
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;

public class TotoGameBody extends JFrame {

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
		Action numberAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// display.setCaretPosition( display.getDocument().getLength()
				// );
				userNumbers.replaceSelection(e.getActionCommand());
			}
		};
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

		int offsetX = 0;
		int offsetY = 0;
		int counter = 1;
		for (int i = 1; i <= 7; i++) {
			offsetX = 0;
			offsetY = 35 * i;
			for (int j = 1; j <= 7; j++) {
				String text = String.valueOf(counter);
				counter++;
				JToggleButton button = new JToggleButton(text);
				button.addActionListener(numberAction);
				button.setFont(new Font("Tahoma", Font.PLAIN, 11));
				button.setMargin(new Insets(0, 0, 0, 0));
				button.setBounds(100 + offsetX, 250 + offsetY, 30, 30);
				offsetX += 35;
				contentPane.add(button);
			}

		}

	}
}
