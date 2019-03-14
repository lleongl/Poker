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
	
	private JTextField txtField_nbj;
	
	private Carte X= new Carte(1,"diamonds");
	
	private ArrayList<Carte> Hand =new ArrayList<Carte>(2);
	private ArrayList<Carte> River =new ArrayList<Carte>(5);
	
	private JLabel lblA,lblB,lblC,lblD,lblE,lblF,lblG;
	
	
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
		//------------------Fenetre---------------------\\
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//------------------Panel pour le nombre de Joueur---------------------\\ utilise un FlowLayout
		
		JPanel panelNbJ = new JPanel();
		panelNbJ.setBounds(24, 43, 117, 52);
		contentPane.add(panelNbJ);
		panelNbJ.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblnbj = new JLabel("Nombre de joueurs");
		panelNbJ.add(lblnbj);
		
	
		txtField_nbj = new JTextField();
		txtField_nbj.setText("1");
		panelNbJ.add(txtField_nbj);
		txtField_nbj.setColumns(2);
		
		//------------------Panel pour la River---------------------\\ utilise un Border Layout
		
		JPanel panelRiver = new JPanel();
		panelRiver.setBounds(194, 43, 550, 265);
		contentPane.add(panelRiver);
		panelRiver.setLayout(new BorderLayout(0, 0));
		
		JLabel riverTxt = new JLabel("TURN/FLOP/RIVER\r\n");
		riverTxt.setHorizontalAlignment(SwingConstants.CENTER);
		riverTxt.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panelRiver.add(riverTxt, BorderLayout.NORTH);
		
		JPanel Table = new JPanel();	//GridLayout
		panelRiver.add(Table, BorderLayout.CENTER);
		Table.setLayout(new GridLayout(0, 5, 10, 10));
		
		lblA = new JLabel();
		lblA.setSize(100,160);
		Table.add(lblA);
		
		lblB = new JLabel();
		lblB.setSize(100,160);
		Table.add(lblB);
		
		lblC = new JLabel();
		lblC.setSize(100,160);
		Table.add(lblC);
		
		lblD = new JLabel();
		lblD.setSize(100,160);
		Table.add(lblD);
		
		lblE = new JLabel();
		lblE.setSize(100,160);
		Table.add(lblE);
		
		//------------------Fenetre---------------------\\
		
		JPanel panelResults = new JPanel();
		panelResults.setBounds(767, 43, 202, 409);
		contentPane.add(panelResults);
		panelResults.setLayout(new GridLayout(12, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Probabilit\u00E9s");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelResults.add(lblNewLabel_2);
		
		JLabel label = new JLabel("Probabilit\u00E9s");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label);
		
		JLabel label_1 = new JLabel("Probabilit\u00E9s");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_1);
		
		JLabel label_2 = new JLabel("Probabilit\u00E9s");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_2);
		
		JLabel label_4 = new JLabel("Probabilit\u00E9s");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_4);
		
		JLabel label_5 = new JLabel("Probabilit\u00E9s");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_5);
		
		JLabel label_7 = new JLabel("Probabilit\u00E9s");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_7);
		
		JLabel label_6 = new JLabel("Probabilit\u00E9s");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_6);
		
		JLabel label_3 = new JLabel("Probabilit\u00E9s");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_3);
		
		JLabel label_8 = new JLabel("Probabilit\u00E9s");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_8);
		
		JLabel label_9 = new JLabel("Probabilit\u00E9s");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(label_9);
		
		JLabel lblChanceDeGagner = new JLabel("chance de gagner :");
		lblChanceDeGagner.setHorizontalAlignment(SwingConstants.CENTER);
		lblChanceDeGagner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelResults.add(lblChanceDeGagner);
		
		//------------------Panel Hand---------------------\\ utilise un GridLayout
		
		JPanel panelHand = new JPanel();
		panelHand.setBounds(364, 370, 210, 160);
		contentPane.add(panelHand);
		panelHand.setLayout(new GridLayout(1, 2, 10, 0));
		
		lblF = new JLabel("");
		lblF.setSize(100,160);
		panelHand.add(lblF);
		
		lblG = new JLabel();
		lblG.setSize(100,160);
		panelHand.add(lblG);
		
		//------------------Boutons pour lancer ou reset---------------------\\
		
		JButton btnNewButton = new JButton("Lancer !");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(364, 319, 210, 40);
		contentPane.add(btnNewButton);
		
		
		//------------------Reste du constructeur---------------------\\
		
		Reset();
		UpdateJpanel();
	}

	public ImageIcon getCardLogo(JLabel panneau,Carte card) { //mets l'image aux dimensions du pannel d'entrée
		Image img =card.getIcon().getImage().getScaledInstance(panneau.getWidth(),panneau.getHeight(),Image.SCALE_SMOOTH);
		return (new ImageIcon(img));
	}
	
	
	public void UpdateJpanel() {//mets à jour l'affichage des cartes :)  en fonction du contenue des listes
		lblA.setIcon( getCardLogo(lblA,River.get(0)) );
		lblB.setIcon( getCardLogo(lblB,River.get(1)) ); 
		lblC.setIcon( getCardLogo(lblC,River.get(2)) );
		lblD.setIcon( getCardLogo(lblD,River.get(3)) );
		lblE.setIcon( getCardLogo(lblE,River.get(4)) );
		lblF.setIcon( getCardLogo(lblF,River.get(0)) );
		lblG.setIcon( getCardLogo(lblG,River.get(1)) );
	}
	
	
	public void Reset() { // Vide les listes Hand et River
		Hand.clear();
		for (int i =0;i<2;i++) { 
		    Hand.add(new Carte());
		}
		
		River.clear();
		for (int i =0;i<5;i++) { 
			River.add(new Carte());
		}
	}
	
	public ArrayList<Carte> getHand(){ //renvoie l'arrayList des cartes dans la Hand
		return Hand;
	}
	
	public ArrayList<Carte> getRiver(){ //renvoie l'arrayList des cartes dans la river
		return River;
	}
	
	public int getNbj() {// Retourne le nombre de joueur entré !! Si le nombre entré n'est pas un entier ou est < à 1 renvoie 0 !!!
		
		try {
	        int d = Integer.parseInt(txtField_nbj.getText());
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return 0;
	    }
		if(Integer.parseInt(txtField_nbj.getText())<1){
			return 0;
		}else {
	    return Integer.parseInt(txtField_nbj.getText());
		}
	}
	
	
	
	
	
	
	
}
