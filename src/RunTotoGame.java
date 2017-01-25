import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RunTotoGame {

	private JFrame frmTotoGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunTotoGame window = new RunTotoGame();
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
	public RunTotoGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTotoGame = new JFrame();
		frmTotoGame.setTitle("Toto Game");
		frmTotoGame.setBounds(10, 10, 250, 250);
		frmTotoGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnNewButton = new JButton("Start game");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTotoGame.dispose();
				TotoGameBody gameBody = new TotoGameBody();
				gameBody.setVisible(true);
			}
		});
		frmTotoGame.getContentPane().setLayout(null);
		btnNewButton.setBounds(40, 150, 150, 30);
		frmTotoGame.getContentPane().add(btnNewButton);

		JLabel lblWelcome = new JLabel("WELCOME TO");
		lblWelcome.setBackground(new Color(153, 255, 204));
		lblWelcome.setForeground(new Color(153, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(0, 25, 234, 60);
		frmTotoGame.getContentPane().add(lblWelcome);
		
		JLabel lblToto = new JLabel("TOTO");
		lblToto.setHorizontalAlignment(SwingConstants.CENTER);
		lblToto.setForeground(new Color(153, 0, 0));
		lblToto.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblToto.setBackground(new Color(153, 255, 204));
		lblToto.setBounds(0, 82, 234, 60);
		frmTotoGame.getContentPane().add(lblToto);

	}

}
