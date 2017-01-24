import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ExecuteTotoGame {

	private JFrame frmTotoGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExecuteTotoGame window = new ExecuteTotoGame();
					window.frmTotoGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExecuteTotoGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTotoGame = new JFrame();
		frmTotoGame.setTitle("Toto Game");
		frmTotoGame.setBounds(100, 100, 450, 300);
		frmTotoGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Run game");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTotoGame.dispose();
				TotoGameBody gameBody = new TotoGameBody();
				gameBody.setVisible(true);
			}
		});
		btnNewButton.setBounds(55, 162, 126, 23);
		frmTotoGame.add(btnNewButton);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setBackground(new Color(153, 255, 204));
		lblWelcome.setForeground(new Color(153, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(35, 25, 160, 120);
		frmTotoGame.add(lblWelcome);
		
	}

}
