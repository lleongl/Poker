import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class interfaces extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaces frame = new interfaces();
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
	public interfaces() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 43, 117, 113);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(207, 66, 578, 265);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(819, 43, 150, 409);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(330, 352, 332, 159);
		contentPane.add(panel_3);
	}
}
