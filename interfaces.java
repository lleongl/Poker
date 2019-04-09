import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.*;

public class interfaces extends JFrame  implements MouseListener{

	private JPanel contentPane;
    private JButton Launcher;
    private JButton Reset;
	
	private JTextField txtField_nbj;
	private JLabel lblQuinteFlushRoyale,lollosingchances,lblCarr,
	lblFull,lblCouleur,lblSuite,lblBrelan,lblDoublePaire,lblPaire,
	lblCarteHaute,lblwin;
	
	
	private ArrayList<Carte> Hand =new ArrayList<Carte>(2);
	private ArrayList<Carte> River =new ArrayList<Carte>(5);
	
	private Select lblA,lblB,lblC,lblD,lblE,lblF,lblG;
	
	private Deck InternalDeck = new Deck();
	
	
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
		contentPane.setBackground(new Color(240, 240, 240));
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
		panelRiver.setBounds(194, 43, 544, 220);
		contentPane.add(panelRiver);
		panelRiver.setLayout(new BorderLayout(0, 0));
		
		JLabel riverTxt = new JLabel("TURN/FLOP/RIVER\r\n");
		riverTxt.setHorizontalAlignment(SwingConstants.CENTER);
		riverTxt.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panelRiver.add(riverTxt, BorderLayout.NORTH);
		
		JPanel Table = new JPanel();	//GridLayout
		panelRiver.add(Table, BorderLayout.CENTER);
		Table.setLayout(new GridLayout(0, 5, 10, 10));
		
		lblA = new Select();
		lblA.setSize(100,160);
		Table.add(lblA);
        lblA.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseReleased(MouseEvent e) {
                  SendDeckToSelect();
              }
          });
		
		lblB = new Select();
		lblB.setSize(100,160);
		Table.add(lblB);
		lblB.addMouseListener(this);
        
		lblC = new Select();
		lblC.setSize(100,160);
		Table.add(lblC);
		lblC.addMouseListener(this);
        
		
		lblD = new Select();
		lblD.setSize(100,160);
		Table.add(lblD);
		lblD.addMouseListener(this);
        
		
		lblE = new Select();
		lblE.setSize(100,160);
		Table.add(lblE);
		lblE.addMouseListener(this);
        
        
        addMouseListener(this);
		
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


		 lollosingchances = new JLabel("Quinte flush :");
		lollosingchances.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResults.add(lollosingchances);
		
		//------------------Panel Hand---------------------\\ utilise un GridLayout
		
		JPanel panelHand = new JPanel();
		panelHand.setBounds(372, 370, 210, 160);
		contentPane.add(panelHand);
		panelHand.setLayout(new GridLayout(1, 2, 10, 0));
		
		lblF = new Select();
		panelHand.add(lblF);
		lblF.addMouseListener(this);
		
		lblG = new Select();
		lblG.setSize(100,160);
		panelHand.add(lblG);
		lblG.addMouseListener(this);
        
		
        
        
        addMouseListener(this);
		//------------------Boutons pour lancer ou reset---------------------\\

		Launcher = new JButton("Lancer !");
		Launcher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) { //Completer ca
				UpdateHR();
				setProba(new Calculatrice().lancerCalcul(getNbj(),getHand(),getRiver()));
			}
		});
		Launcher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Launcher.setBounds(256, 319, 210, 40);
		contentPane.add(Launcher);
		
		Reset = new JButton("Reset");
		Reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Reset();
			}
		});
		Reset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Reset.setBounds(473, 319, 210, 40);
		contentPane.add(Reset);
		
		
		//------------------Reste du constructeur---------------------\\
		
		Reset();

	}
	
	public void UpdateHR(){ // mets a jours les arrays List de Carte a partir des jlabels et de leur contenu :)
		River.set(0, lblA.getCard());
		River.set(1, lblB.getCard());
		River.set(2, lblC.getCard());
		River.set(3, lblD.getCard());
		River.set(4, lblE.getCard());
		
		Hand.set(0,lblF.getCard());
		Hand.set(1,lblG.getCard());
		//l'utilisation du set permet de simplifier le code car on remplace directement les cartes plutôt que de retirer les anciennes et rajouter les nouvelles
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
		lblA.ResetCard();
		lblB.ResetCard();
		lblC.ResetCard();
		lblD.ResetCard();
		lblE.ResetCard();
		
		lblF.ResetCard();
		lblG.ResetCard();
		
	}
	
	public ArrayList<Carte> getHand(){ //renvoie l'arrayList des cartes dans la Hand
		return Hand;
	}
	
	public ArrayList<Carte> getRiver(){ //renvoie l'arrayList des cartes dans la river
		return River;
	}


	public int getNbj() {// Retourne le nombre de joueur entrï¿½ !! Si le nombre entrï¿½ n'est pas un entier ou est < ï¿½ 1 renvoie 0 !!!
		int d;
		try {
			 d=Integer.parseInt(txtField_nbj.getText());
			 
			 if (d<2) {// SI le nombre de joueur entrer est trop petit on prendra la valeur minimum de 2 joueurs
				 JOptionPane.showMessageDialog(null,txtField_nbj.getText()+ " est inférieur à 2!", "nombre de joueur insufisant" , JOptionPane.INFORMATION_MESSAGE);
				 d =2;
				 txtField_nbj.setText("2");
			 }
			 
			 if (d>10){// Si le nombre de joueur entrer est trop grand on prendra la valeur max de 10 joueurs
				 JOptionPane.showMessageDialog(null,txtField_nbj.getText()+ " est supérieur à 10!", "nombre de joueur trop grand" , JOptionPane.INFORMATION_MESSAGE);
				 d =10;
				 txtField_nbj.setText("10");
			 }
				 
				 
	    } catch (NumberFormatException  e) { //si le String entré n'est pas un entier on prendra par défaut la valeur de 2 joueur
	        JOptionPane.showMessageDialog(null,txtField_nbj.getText()+ " n'est pas un entier", "Poker Master : Pas un entier" , JOptionPane.INFORMATION_MESSAGE);
	        d=2;
	        txtField_nbj.setText("2");
	    
	    }
		
		return d;
	}

	public void setProba(float []t) {/* permets de changer les probabilitï¿½s afficher en rï¿½sultats :
		ï¿½ rentrï¿½ dans l'ordre :
		QuinteFlush
		carre
		full
		Couleur
		suite
		brelan
		double paire
		paire
		carte haute
		winning chances
		losing chances
		*/
		


		lblQuinteFlushRoyale.setText("Quinte flush : "+t[0]+" %");
		lblCarr.setText("Carr\u00E9 : "+t[1]+" %");
		lblFull.setText("Full : "+t[2]+" %");
		lblCouleur.setText("Couleur : "+t[3]+" %");
		lblSuite.setText("Suite : "+t[4]+" %");
		lblBrelan.setText("Brelan : "+t[5]+" %");
		lblDoublePaire.setText("Double paire : "+t[6]+" %");
		lblPaire.setText("Paire : "+t[7]+" %");
		lblCarteHaute.setText("Carte haute : "+t[8]+" %");
		lblwin.setText("Chance de gagner : "+t[9]+" %");
		lollosingchances.setText("Chance de perdre : "+t[10]+" %");
	}
	
	public void SendDeckToSelect() {
		UpdateHR();//permet de toujours avoir les vrais cartes qui sont dans la River et Hand avant de les retirer du deck interne.
		
		InternalDeck = new Deck(); //reset à chaque fois le deck interne permet de simplifier les calculs mais on aura un temps plus long d'exécution
		
		//ensuite on retire les cartes déjà sélectionné
		for(Carte x : Hand) 
			InternalDeck.removeCard(x.getValeur(), x.getCouleur());
		
		for(Carte x : River) {
			InternalDeck.removeCard(x.getValeur(), x.getCouleur());
		}
		
		// Ici on met a jour le deck interne à chaque objet Select
		// Set Internal Deck devra alors s'occupé lui même des choix possibles ou non
		lblA.SetInternalDeck(InternalDeck.getDeck());
		lblB.SetInternalDeck(InternalDeck.getDeck());
		lblC.SetInternalDeck(InternalDeck.getDeck());
		lblD.SetInternalDeck(InternalDeck.getDeck());
		lblE.SetInternalDeck(InternalDeck.getDeck());
		lblF.SetInternalDeck(InternalDeck.getDeck());
		lblG.SetInternalDeck(InternalDeck.getDeck());
	}
	
	public void mouseClicked(MouseEvent e) {
				SendDeckToSelect();
    }
	
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }


}
