import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.util.LinkedList;
import java.util.ArrayList;
public class interfaces extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Carte X= new Carte(1,"diamonds");
	private ArrayList<Carte> Hand =new ArrayList<Carte>(2);
	private ArrayList<Carte> River =new ArrayList<Carte>(5);
	private JLabel lblA,lblB,lblC,lblD,lblE,lblF,lblG;
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

	
	
	public interfaces() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 43, 117, 52);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel nbJLbl = new JLabel("Nombre de joueurs");
		panel.add(nbJLbl);
		
		textField = new JTextField();
		textField.setText("1");
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(194, 43, 550, 265);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("TURN/FLOP/RIVER\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 5, 10, 10));
		
		lblA = new JLabel();
		lblA.setSize(100,160);
		lblA.setIcon( getCardLogo(lblA,X) );
		panel_4.add(lblA);
		
		lblB = new JLabel();
		lblB.setSize(100,160);
		lblB.setIcon( getCardLogo(lblB,X) );
		panel_4.add(lblB);
		
		lblC = new JLabel();
		lblC.setSize(100,160);
		lblC.setIcon( getCardLogo(lblC,X) );
		panel_4.add(lblC);
		
		lblD = new JLabel();
		lblD.setSize(100,160);
		lblD.setIcon( getCardLogo(lblD,X) );
		panel_4.add(lblD);
		
		lblE = new JLabel();
		lblE.setSize(100,160);
		lblE.setIcon( getCardLogo(lblE,X) );
		panel_4.add(lblE);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(819, 43, 150, 409);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(11, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Probabilit\u00E9s");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		JLabel label = new JLabel("Probabilit\u00E9s");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Probabilit\u00E9s");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Probabilit\u00E9s");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_2);
		
		JLabel label_4 = new JLabel("Probabilit\u00E9s");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Probabilit\u00E9s");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_5);
		
		JLabel label_7 = new JLabel("Probabilit\u00E9s");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_7);
		
		JLabel label_6 = new JLabel("Probabilit\u00E9s");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_6);
		
		JLabel label_3 = new JLabel("Probabilit\u00E9s");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_3);
		
		JLabel label_8 = new JLabel("Probabilit\u00E9s");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Probabilit\u00E9s");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(label_9);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(364, 370, 210, 160);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 10, 0));
		
		lblF = new JLabel("");
		lblF.setSize(100,160);
		lblF.setIcon( getCardLogo(lblF,X) );
		panel_3.add(lblF);
		
		lblG = new JLabel();
		lblG.setSize(100,160);
		panel_3.add(lblG);
		lblG.setIcon( getCardLogo(lblG,X) );
		
		JButton btnNewButton = new JButton("Sexy Button");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(364, 319, 210, 40);
		contentPane.add(btnNewButton);
		UpdateJpanel();
	}

	public ImageIcon getCardLogo(JLabel panneau,Carte card) { //mets l'image aux dimensions du pannel d'entrée
		Image img =card.getIcon().getImage().getScaledInstance(panneau.getWidth(),panneau.getHeight(),Image.SCALE_SMOOTH);
		return (new ImageIcon(img));
	}
	
	public void addCard(Carte C,LinkedList<Carte> X) {
		
		
	}
	
	public void UpdateJpanel() {
		
		if(Hand.get(1)==null)
			System.out.println("null");
		
	}
}
