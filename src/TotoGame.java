import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TotoGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotoGame frame = new TotoGame();
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
	public TotoGame() {
		setTitle("Toto Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Run game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateNumbersMatrix();
				System.out.println("test");
			}
		});
		btnNewButton.setBounds(58, 49, 89, 23);
		contentPane.add(btnNewButton);

	}

	public void GenerateNumbersMatrix() {
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		JToggleButton toggleButton_01 = new JToggleButton("1");
		toggleButton_01.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		toggleButton_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		toggleButton_01.setBounds(108, 310, 30, 30);
		toggleButton_01.setMargin(new Insets(0, 0, 0, 0));
		contentPane.add(toggleButton_01);
	}
}
