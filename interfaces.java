import sun.misc.Launcher;

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
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
<<<<<<< Updated upstream
import java.awt.CardLayout;
public class interfaces extends JFrame {
=======
import java.awt.event.ActionListener;
public class interfaces extends JFrame implements ActionListener{
>>>>>>> Stashed changes

	private JPanel contentPane;
    private JButton Launcher;
    private JButton Reset;
	
	private JTextField txtField_nbj;
	private JLabel lblQuinteFlushRoyale,lblQuinteFlush,lblCarr,
	lblFull,lblCouleur,lblSuite,lblBrelan,lblDoublePaire,lblPaire,
	lblCarteHaute,lblwin;
	
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
		setTitle("Poker Master");
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
		
		//------------------Panel des resultats---------------------\\
		
		JPanel panelResults = new JPanel();
		panelResults.setBounds(767, 43, 202, 409);
		contentPane.add(panelResults);
		panelResults.setLayout(new GridLayout(12, 1, 0, 0));
		
		JLabel lblproba = new JLabel("Probabilit\u00E9s");
		lblproba.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblproba.setHorizontalAlignment(SwingConstants.CENTER);
		panelResults.add(lblproba);
		
		 lblQuinteFlushRoyale = new JLabel("Quinte flush royale :");
		lblQuinteFlushRoyale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblQuinteFlushRoyale);
		
		 lblQuinteFlush = new JLabel("Quinte flush :");
		lblQuinteFlush.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblQuinteFlush);
		
		 lblCarr = new JLabel("Carr\u00E9 :");
		lblCarr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblCarr);
		
		 lblFull = new JLabel("Full :");
		lblFull.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblFull);
		
		 lblCouleur = new JLabel("Couleur :");
		lblCouleur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblCouleur);
		
		 lblSuite = new JLabel("Suite :");
		lblSuite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblSuite);
		
		 lblBrelan = new JLabel("Brelan :");
		lblBrelan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblBrelan);
		
		 lblDoublePaire = new JLabel("Double paire :");
		lblDoublePaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblDoublePaire);
		
		 lblPaire = new JLabel("Paire : ");
		lblPaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblPaire);
		
		 lblCarteHaute = new JLabel("Carte haute : ");
		lblCarteHaute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblCarteHaute);
		
		 lblwin = new JLabel("Chance de gagner : ");
		lblwin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lblwin);
		
		//------------------Panel Hand---------------------\\ utilise un GridLayout
		
		JPanel panelHand = new JPanel();
		panelHand.setBounds(372, 370, 210, 160);
		contentPane.add(panelHand);
		panelHand.setLayout(new GridLayout(1, 2, 10, 0));
		
		lblF = new JLabel("");
		lblF.setSize(100,160);
		panelHand.add(lblF);
		
		lblG = new JLabel();
		lblG.setSize(100,160);
		panelHand.add(lblG);
		
		//------------------Boutons pour lancer ou reset---------------------\\
		
		Launcher = new JButton("Lancer !");
		Launcher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Launcher.setBounds(256, 319, 210, 40);
		contentPane.add(Launcher);
		Launcher.addActionListener(this);
		
		Reset = new JButton("Reset");
		Reset.addActionListener(this);
		Reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Reset();
				UpdateJpanel();
			}
		});
		Reset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Reset.setBounds(473, 319, 210, 40);
		contentPane.add(Reset);
		
		
		//------------------Reste du constructeur---------------------\\
		
		Reset();
		River.remove(4);River.add(X);

		UpdateJpanel();
	}

	public ImageIcon getCardLogo(JLabel panneau,Carte card) { //mets l'image aux dimensions du pannel d'entr�e
		Image img =card.getIcon().getImage().getScaledInstance(panneau.getWidth(),panneau.getHeight(),Image.SCALE_SMOOTH);
		return (new ImageIcon(img));
	}
	
	
	public void UpdateJpanel() {//mets � jour l'affichage des cartes :)  en fonction du contenue des listes
		lblA.setIcon( getCardLogo(lblA,River.get(0)) );
		lblB.setIcon( getCardLogo(lblB,River.get(1)) ); 
		lblC.setIcon( getCardLogo(lblC,River.get(2)) );
		lblD.setIcon( getCardLogo(lblD,River.get(3)) );
		lblE.setIcon( getCardLogo(lblE,River.get(4)) );
		lblF.setIcon( getCardLogo(lblF,Hand.get(0)) );
		lblG.setIcon( getCardLogo(lblG,Hand.get(1)) );
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
	
	public int getNbj() {// Retourne le nombre de joueur entr� !! Si le nombre entr� n'est pas un entier ou est < � 1 renvoie 0 !!!
		
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
	
	public void setProba(double a,double b,double c,double d,double e,double f,double g,double h,double i,double j,double k) {/* permets de changer les probabilit�s afficher en r�sultats :
		� rentr� dans l'ordre :
		QuinteFlushRoyale
		QuinteFlush
		carr�
		full
		Couleur
		suite
		brelan
		double paire
		paire
		carte haute
		winning chances
		*/
		lblQuinteFlushRoyale.setText("Quinte flush royale : "+a+" %");
		lblQuinteFlush.setText("Quinte flush : "+b+" %");
		lblCarr.setText("carr\\u00E9 : "+c+" %");
		lblFull.setText("Full : "+d+" %");
		lblCouleur.setText("Couleur : "+e+" %");
		lblSuite.setText("Suite : "+f+" %");
		lblBrelan.setText("Brelan : "+g+" %");
		lblDoublePaire.setText("Double paire : "+h+" %");
		lblPaire.setText("Paire : "+i+" %");
		lblCarteHaute.setText("Carte haute : "+j+" %");
		lblwin.setText("Chance de gagner : "+k+" %");
	}

	public void actionPerformed (ActionEvent e){
        if(e.getSource()== Launcher){
            Calculatrice k = new Calculatrice();
            k.lancerCalcul();
        }
        else {
            this.Reset();
        }
	}
}
