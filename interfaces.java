import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;


public class interfaces extends JFrame  {
	
	private JPanel contentPane;// Panneau principal 
	
    private JButton Launcher;// bouton lancer
    private JButton Reset;//bouton reset
	
	private JTextField txtField_nbj;// le nombre de joueur
	
	private JLabel lblQuinteFlushRoyale,lollosingchances,lblCarr,
	lblFull,lblCouleur,lblSuite,lblBrelan,lblDoublePaire,lblPaire,
	lblCarteHaute,lblwin; //le texte des resultats
	
	
	private ArrayList<Carte> Hand =new ArrayList<Carte>(2);	//main du joueur
	private ArrayList<Carte> River =new ArrayList<Carte>(5);	//Table (flop/river/turn)
	
	private Select lblA,lblB,lblC,lblD,lblE,lblF,lblG; // les 5 cartes sur la table et les 2 cartes du joueur
	
	private Deck InternalDeck = new Deck(); // pioche
	
	
	public static void main(String[] args) {// main qui permet de lancer le programme
		interfaces fenetre = new interfaces();
		fenetre.setVisible(true);
	}

	
	
	public interfaces() {
		//------------------Fenetre---------------------\\
		
		setTitle("Poker Master");
		setResizable(false);// non redimensionnable 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);//position et taille de la fenetre 
		setIconImage(Toolkit.getDefaultToolkit().getImage(interfaces.class.getResource("/images/pokerIcon.png")));// icone de la fenetre

		//--------------panneau principal ----------------\\utilise un Absolute Layout

		contentPane = new JPanel();
			contentPane.setBackground(new Color(240, 240, 240));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			
		setContentPane(contentPane);
		
		//------------------Panel pour le nombre de Joueur---------------------\\ utilise un FlowLayout
		
		JPanel panelNbJ = new JPanel();
			panelNbJ.setBackground(new Color(255, 255, 255,63));
			panelNbJ.setBounds(24, 43, 117, 52);
			panelNbJ.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		contentPane.add(panelNbJ);	
		
		JLabel lblnbj = new JLabel("Nombre de joueurs");// Jlabel du nombre de joueur
			lblnbj.setForeground(new Color(255, 255, 255));
			lblnbj.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		panelNbJ.add(lblnbj);
			
		
		txtField_nbj = new JTextField(); // JTextField associé au nombre de joueur
			txtField_nbj.setText("2");
			txtField_nbj.setColumns(2);// set à taille du JTextField
			
		panelNbJ.add(txtField_nbj);
		
		//------------------Panel pour la River---------------------\\ utilise un Border Layout
		
		JPanel panelRiver = new JPanel();
			panelRiver.setBackground(new Color(255, 255, 255,63));
			panelRiver.setBounds(194, 43, 544, 220);
			panelRiver.setLayout(new BorderLayout(0, 0));

		contentPane.add(panelRiver);
		
		JLabel riverTxt = new JLabel("TURN/FLOP/RIVER\r\n");
			riverTxt.setHorizontalAlignment(SwingConstants.CENTER);
			riverTxt.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		panelRiver.add(riverTxt, BorderLayout.NORTH);
			
		JPanel Table = new JPanel();	//GridLayout de 1 ligne et 5 colonnes
			Table.setBackground(new Color(255, 255, 255,0));
			Table.setLayout(new GridLayout(1, 5, 10, 10));
		panelRiver.add(Table, BorderLayout.CENTER);
				
		//Instanciation des cartes de taille 100*160 et ajout au Pannel Table
		
				lblA = new Select(this);
				Table.add(lblA);
				
				lblB = new Select(this);
				Table.add(lblB);
		        
				lblC = new Select(this);
				Table.add(lblC);
		        
				
				lblD = new Select(this);
				Table.add(lblD);
		        
				
				lblE = new Select(this);
				Table.add(lblE);
        
        
		
		//------------------Panel des resultats---------------------\\
		
		JPanel panelResults = new JPanel();
			panelResults.setBackground(new Color(255, 255, 255,100)); //couleur blanche et opacite 40 %
			panelResults.setBounds(748, 43, 236, 409);
			panelResults.setLayout(new GridLayout(12, 1, 0, 0));// grille de 12 lignes et 1 colonne
		
		contentPane.add(panelResults);
			
		// instanciation et ajout des JtextField qui permettent d'afficher les resultats
		
		JLabel lblproba = new JLabel("Probabilit\u00E9s");
			lblproba.setBackground(new Color(255, 255, 255));
			lblproba.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblproba.setHorizontalAlignment(SwingConstants.CENTER);
			
		panelResults.add(lblproba);
			
			lblQuinteFlushRoyale = new JLabel("Quinte flush royale :");
			lblQuinteFlushRoyale.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblQuinteFlushRoyale);
			
			
			lblCarr = new JLabel("Carr\u00E9 :");
			lblCarr.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblCarr);
			
			lblFull = new JLabel("Full :");
			lblFull.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblFull);
			
			lblCouleur = new JLabel("Couleur :");
			lblCouleur.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblCouleur);
			
			lblSuite = new JLabel("Suite :");
			lblSuite.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblSuite);
			
			lblBrelan = new JLabel("Brelan :");
			lblBrelan.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblBrelan);
			
			lblDoublePaire = new JLabel("Double paire :");
			lblDoublePaire.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblDoublePaire);
			
			lblPaire = new JLabel("Paire : ");
			lblPaire.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblPaire);
			
			lblCarteHaute = new JLabel("Carte haute : ");
			lblCarteHaute.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblCarteHaute);
			
			lblwin = new JLabel("Chance de gagner : ");
			lblwin.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lblwin);
	
	
			lollosingchances = new JLabel("Quinte flush :");
			lollosingchances.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelResults.add(lollosingchances);
		
		//------------------Panel Hand---------------------\\ utilise un GridLayout
		
		JPanel panelHand = new JPanel();
			panelHand.setBackground(new Color(0, 0, 0,0)); // fond totalement transparent
			panelHand.setBounds(364, 370, 210, 160);
			panelHand.setLayout(new GridLayout(1, 2, 10, 0)); //grille d'une ligne et de deux colonnes espacees de 10 px horizontalement 

		contentPane.add(panelHand);
			
		// ajout des Select corespondant a la main du joueur au pannel
		
			lblF = new Select(this);
			panelHand.add(lblF);
			
			lblG = new Select(this);
			panelHand.add(lblG);
        
		
        
		//------------------Bouton pour lancer ---------------------\\

		Launcher = new JButton("Lancer !");
		Launcher.setBackground(new Color(173, 255, 47));
		Launcher.setFont(new Font("Tahoma", Font.BOLD, 19));
		Launcher.setBounds(240, 319, 210, 40);
		Launcher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) { 
				
				UpdateHR();// On met a jour Hand et River
				if(Hand.get(0).getValeur() <0 || Hand.get(1).getValeur() <0) {
					//On verifie la taille de la main en verifiant que la valeur des cartes est positives 
					//( si valeur negative i.e. -1 alors la carte est cachee)
			        JOptionPane.showMessageDialog(null, " Veuillez choisir au moins deux cartes", "Poker Master : Main incomplete" , JOptionPane.INFORMATION_MESSAGE);
				}else{// puis on fait de meme pour la main qui doit avoir soit 0 carte positive soit au moins 3
					int c=0;
					for (Carte x:River) {// permet de compter le nombre de carte active sur la table uniquement (River)
						if(x.getValeur()>0)
							c++;
					}
					if(c==0 || c>=3) {// Cas ou toutes les conditions sont respectees on peut lancer sans crainte le calcul
						setProba(new Calculatrice().lancerCalcul(getNbj(),getHand(),getRiver()));
						repaint();// permet de regler quelques soucis d'affichage
					}else {// cas ou le nombre de cartes selectionnes est incoherent
						JOptionPane.showMessageDialog(null,"Veuillez poser au moins 3 cartes ou aucune carte", "Poker Master : Table incomplete" , JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		contentPane.add(Launcher);
		
		
		//------------------bouton Reset---------------------\\
		
		Reset = new JButton("Reset");
		Reset.setBackground(new Color(153, 50, 204));
		Reset.setFont(new Font("Tahoma", Font.BOLD, 19));
		Reset.setBounds(492, 319, 210, 40);
		Reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Reset();
			}
		});
		
		contentPane.add(Reset);
		
		
		//------------------Background---------------------\\
		
		JLabel lblBG = new JLabel();
			lblBG.setHorizontalAlignment(SwingConstants.CENTER);			
			//permet de mettre l'image aux dimensions de la fenetre
			Image img =new ImageIcon(Select.class.getResource("/images/bgPoker.jpg")).getImage().getScaledInstance(994,571,Image.SCALE_SMOOTH);
			lblBG.setIcon(new ImageIcon(img));
			lblBG.setBounds(0, 0, 994, 571);
		
		contentPane.add(lblBG);
		
		
		//------------------Tourner chaque carte---------------------\\
		
		Reset();

	}
	
	public void UpdateHR(){ // mets a jours les arrays List de Carte a partir des jlabels et de leur contenu :) *Nouveau mets aussi a jour la pioche (InternalDeck)*
		River.set(0, lblA.getCard());
		River.set(1, lblB.getCard());
		River.set(2, lblC.getCard());
		River.set(3, lblD.getCard());
		River.set(4, lblE.getCard());
		
		Hand.set(0,lblF.getCard());
		Hand.set(1,lblG.getCard());
		//l'utilisation du set permet de simplifier le code car on remplace directement les cartes plutot que de retirer les anciennes et rajouter les nouvelles
		
		InternalDeck = new Deck(); //reset a chaque fois le deck interne permet de simplifier les calculs mais on aura un temps plus long d'execution
		
		//ensuite on retire les cartes selectionnees de la pioche
		for(Carte x : Hand) 
			InternalDeck.removeCard(x.getValeur(), x.getCouleur());
		
		for(Carte x : River) 
			InternalDeck.removeCard(x.getValeur(), x.getCouleur());
		
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
		// reset les valeurs de la carte des Select 
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


	public int getNbj() {// Retourne le nombre de joueur entre !! Si le nombre entre n'est pas un entier ou est < a 1 renvoie 0 !!!
		int d; // d est le nombre de joueur rentre
		try {
			 d=Integer.parseInt(txtField_nbj.getText());
			 
			 if (d<2) {// SI le nombre de joueur entrer est trop petit on prendra la valeur minimum de 2 joueurs
				 JOptionPane.showMessageDialog(null,txtField_nbj.getText()+ " est inferieur a 2!", "nombre de joueur insufisant" , JOptionPane.INFORMATION_MESSAGE);
				 d =2;
				 txtField_nbj.setText("2");
			 }
			 
			 if (d>10){// Si le nombre de joueur entrer est trop grand on prendra la valeur max de 10 joueurs
				 JOptionPane.showMessageDialog(null,txtField_nbj.getText()+ " est superieur a 10!", "nombre de joueur trop grand" , JOptionPane.INFORMATION_MESSAGE);
				 d =10;
				 txtField_nbj.setText("10");
			 }
				 
				 
	    } catch (NumberFormatException  e) { //si le String entree n'est pas un entier on prendra par defaut la valeur de 2 joueur
	        JOptionPane.showMessageDialog(null,txtField_nbj.getText()+ " n'est pas un entier", "Poker Master : Pas un entier" , JOptionPane.INFORMATION_MESSAGE);
	        d=2;
	        txtField_nbj.setText("2");
	    
	    }
		// Remarque dans tous les cas le programme se corrigera s'il le faut et se lancera en affichant au prealable un message d'erreur
		return d;
	}

	public void setProba(float []t) {
		/* permets de changer les probabilitees et d'afficher le resultats :
		a rentrer dans l'ordre :
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
	
	public ArrayList<Carte> getInternalDeck() {	
		//Methode utiliser par les Select elle permet de recuperer la pioche
		UpdateHR();
		return InternalDeck.getDeck();
	}


}
