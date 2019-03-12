import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class IHM extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHM frame = new IHM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public IHM() {
        setTitle("Poker Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 300, 1350, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
