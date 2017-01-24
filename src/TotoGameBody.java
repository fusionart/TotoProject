import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TotoGameBody extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToggleButton toggleButton_01 = new JToggleButton("1");
		toggleButton_01.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		toggleButton_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		toggleButton_01.setBounds(100, 200, 30, 30);
		toggleButton_01.setMargin(new Insets(0, 0, 0, 0));
		contentPane.add(toggleButton_01);
		
		JToggleButton toggleButton_02 = new JToggleButton("2");
		toggleButton_02.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		toggleButton_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		toggleButton_02.setBounds(100, 235, 30, 30);
		toggleButton_02.setMargin(new Insets(0, 0, 0, 0));
		contentPane.add(toggleButton_02);
	}

}
