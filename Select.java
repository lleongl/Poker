import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Select extends JPanel implements ActionListener{
	
	private CardLayout C1 = new CardLayout();
	
	private JPanel Day = new JPanel();
	private JPanel months = new JPanel();
	private JPanel seasons = new JPanel();
	
	private final JButton btnAs = new JButton("1");
	private final JButton btn2 = new JButton("2");
	private final JButton btn3 = new JButton("3");
	private final JButton btn4 = new JButton("4");
	private final JButton btn5 = new JButton("5");
	private final JButton btn6 = new JButton("6");
	private final JButton btn7 = new JButton("7");
	private final JButton btn8 = new JButton("8");
	private final JButton btn9 = new JButton("9");
	private final JButton btn10 = new JButton("10");
	private final JButton btn11 = new JButton("V");
	private final JButton btn12 = new JButton("D");
	private final JButton btn13 = new JButton("R");
	private final JButton btnCancel = new JButton("B");
	private final JButton btnBack = new JButton("X");
	
	
	
	private Carte Card= new Carte();
	
	private int valeur=-1;
	private String Couleur;
	
	private final JLabel C_Carreau = new JLabel();
	private final JLabel C_pique = new JLabel();
	private final JLabel C_trefle = new JLabel();
	private final JLabel C_Coeur = new JLabel();
	
	private JLabel lblDay=new JLabel();
	

	public Select() { 
		this.setSize(100,160);	// taille de 100*160
		Day.setBackground(new Color(0,0,0,0)); 
	    months.setBackground(Color.BLACK);	//fond de Months noir
	    seasons.setBackground(Color.DARK_GRAY);//fon de saison noir grisé
	    
	    this.setLayout(C1); //la classe select aura un Card layout
	    this.add(Day, "CARD_1");
	    
	    //--------------------Days-------------------\\

	    
	    Day.setLayout(null); // le Panel Day n'a pas besoin de Layout particulier :)
	    
	    lblDay.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		Next(); // passe au panneau suivant nous permettant d'éditer la carte
	    	}
	    });
	    lblDay.setHorizontalAlignment(SwingConstants.CENTER);// permet de centrer la carte dans le Jpanel Day
	    lblDay.setBounds(0,0,100, 160); // set la taille de 100*160 permet de remplir entièrement le Jpanel Select
		UpdatePic(); // mettre une première fois à jour permet d'afficher une carte retourné
	    Day.add(lblDay);
	    
	    //--------------------Months-------------------\\
	    
		    this.add(months, "CARD_2");
		    months.setLayout(new GridLayout(3, 5, 1, 1)); 
		    // months utilisera un grid layout de 3 lignes et 5 colonnes
			// avec un écart horizontal et vertical de 1 pour faire office de séparateur
		    
		    
		    
				//***Bouton As : 1***\\

            btnAs.addActionListener(this);
		    btnAs.setBorder(null); //set les bordures du bouton à null nous permet de résoudre un problème d'affichage du texte
		    months.add(btnAs);
		    
		    
				//***Bouton 2***\\
		    
		    btn2.addActionListener(this);
		    btn2.setBorder(null);
		    months.add(btn2);
		    
		    
				//***Bouton 3***\\
		    
		    btn3.addActionListener(this);
		    btn3.setBorder(null);
		    months.add(btn3);
		    
		    
				//***Bouton 4***\\
		    
		    btn4.addActionListener(this);
		    btn4.setBorder(null);
		    months.add(btn4);
		    
		    
				//***Bouton 5***\\
		    
		    btn5.addActionListener(this);
		    btn5.setBorder(null);
		    months.add(btn5);
		    
		    
				//***Bouton 6***\\
		    
		    btn6.addActionListener(this);
		    btn6.setBorder(null);
		    months.add(btn6);
		    
		    
				//***Bouton 7***\\
		    
		    btn7.addActionListener(this);
		    btn7.setBorder(null);
		    months.add(btn7);
		    
				//***Bouton 8***\\
		    
		    btn8.addActionListener(this);
		    btn8.setBorder(null);
		    months.add(btn8);
		    
		    
				//***Bouton 9***\\
		    
		    btn9.addActionListener(this);
		    btn9.setBorder(null);
		    months.add(btn9);
		    
				//***Bouton 10***\\
		    
		    btn10.addActionListener(this);
		    btn10.setBorder(null);
		    months.add(btn10);
		    
				//***Bouton Valet : 11***\\
		    
		    btn11.addActionListener(this);
		    btn11.setBorder(null);
		    months.add(btn11);
		    
				//***Bouton Dame : 12***\\
		    
		    btn12.addActionListener(this);
		    
		    btn12.setBorder(null);
		    months.add(btn12);
		    
		    
				//***Bouton Roi : 13***\\
		    
		    btn13.addActionListener(this);
		    
		    btn13.setBorder(null);
		    months.add(btn13);
		    
				//***Bouton Cancel***\\
				
		    btnCancel.addActionListener(this);
		    btnCancel.setBorder(null);
		    months.add(btnCancel);
		    
				//***Bouton Back***\\
				
		    btnBack.addActionListener(this);
		    btnBack.setBorder(null);
		    months.add(btnBack);
		    
		//--------------------Months-------------------\\
		    
	    this.add(seasons, "CARD_3");
	    seasons.setLayout(new GridLayout(0, 2, 2, 0));// Season utilisera un Grid Layout de 2 par 2
	    
	    //Ici on met au clair les dimensions de l'image c'est à dire 50 de largeur et 40 de hauteur
	    Image img =new ImageIcon(Select.class.getResource("/images/Couleur_Carreau.png")).getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
	    
	    C_Carreau.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		Couleur = "diamonds";
	    		Next();// on passe au Panel suivant
	    		UpdatePic();// on met à jour lblDay
	    	}
	    });
	    C_Carreau.setHorizontalAlignment(SwingConstants.CENTER); // permet de centrer l'image
	    C_Carreau.setIcon(new ImageIcon(img)); //afficher l'image dans le label
	    
	    
	    
	    img =new ImageIcon(Select.class.getResource("/images/Couleur_Pique.png")).getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
	    C_pique.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		Couleur = "spades";
	    		Next();
	    		UpdatePic();
	    	}
	    });
	    C_pique.setHorizontalAlignment(SwingConstants.CENTER);
	    C_pique.setIcon(new ImageIcon(img));
	    
	    
	    
	    img =new ImageIcon(Select.class.getResource("/images/Couleur_Trefle.png")).getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
	    C_trefle.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		Couleur = "clubs";
	    		Next();
	    		UpdatePic();
	    	}
	    });
	    C_trefle.setHorizontalAlignment(SwingConstants.CENTER);
	    C_trefle.setIcon(new ImageIcon(img));
	    
	    
	    
	    img =new ImageIcon(Select.class.getResource("/images/Couleur_Coeur.png")).getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
	    C_Coeur.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		Couleur = "hearts";
	    		Next();
	    		UpdatePic();
	    	}
	    });
	    C_Coeur.setHorizontalAlignment(SwingConstants.CENTER);
	    C_Coeur.setIcon(new ImageIcon(img));
	    
	    
	    //ajoute au paneau season les Jlabels des couleurs
	    seasons.add(C_Carreau);
	    seasons.add(C_pique);
	    seasons.add(C_trefle);
	    seasons.add(C_Coeur);
	    
	    
	}
	
	public void Next() { // change le panneau afficher par la card Layout en passant à la suivante
		C1.next(this);
	}
	public void Previous() { // change le panneau afficher par la card Layout en passant à la précédente
		C1.previous(this);
	}
	

	
	public void UpdatePic() {	// mets à jour le panneau lblDay qui est censé afficher la carte en utilisant les variables valeur et couleurs modifié ou non
		//change les attributs interne de la Carte
		Card.setCouleur(Couleur);
		Card.setValeur(valeur);
		
		//récupère depuis la carte l'icone a afficher puis fit sa taille au Jpanel lblDay
	    Image shot =Card.getIcon().getImage().getScaledInstance(lblDay.getWidth(),lblDay.getHeight(),Image.SCALE_SMOOTH);
	    //mets à jour l'icone a afficher
	    lblDay.setIcon(new ImageIcon(shot));
		
	}
	
	public Carte getCard() {
		//retourne la current card 
		return Card;
	}
	public void ResetCard() {
		//clear la  carte
		Card = new Carte();
		
		// la valeur négative -1 et une valeur arbitraire qui nous permet d'afficher une carte tourné
		valeur =-1;
		
		//mets à jour lblDay pour afficher cette carte tourner
		UpdatePic();
	}

	public void SetInternalDeck(ArrayList<Carte> interfaceDeck) {
		btnAs.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
		btn10.setEnabled(false);
		btn11.setEnabled(false);
		btn12.setEnabled(false);
		btn13.setEnabled(false);
		
        
		for (Carte x : interfaceDeck) {
			if(x.getValeur()==14)
				btnAs.setEnabled(true);
			if(x.getValeur()==2)
				btn2.setEnabled(true);
			if(x.getValeur()==3)
				btn3.setEnabled(true);
			if(x.getValeur()==4)
				btn4.setEnabled(true);
			if(x.getValeur()==5)
				btn5.setEnabled(true);
			if(x.getValeur()==6)
				btn6.setEnabled(true);
			if(x.getValeur()==7)
				btn7.setEnabled(true);
			if(x.getValeur()==8)
				btn8.setEnabled(true);
			if(x.getValeur()==9)
				btn9.setEnabled(true);
			if(x.getValeur()==10)
				btn10.setEnabled(true);
			if(x.getValeur()==11)
				btn11.setEnabled(true);
			if(x.getValeur()==12)
				btn12.setEnabled(true);
			if(x.getValeur()==13)
				btn13.setEnabled(true);
		}
	}
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==btnAs){
            valeur =14; //on modifie la variable valeur en fonction du bouton sur lequel on appuie
            Next();	// on passe au panel suivant c'est à dire Seasons
        }else if (e.getSource()==btn2) {
        	valeur =2;
            Next();
        }else if (e.getSource()==btn3) {
        	valeur =3;
            Next();
        }else if (e.getSource()==btn4) {
        	valeur =4;
            Next();
        }else if (e.getSource()==btn5) {
        	valeur =5;
            Next();
        }else if (e.getSource()==btn6) {
        	valeur =6;
            Next();
        }else if (e.getSource()==btn7) {
        	valeur =7;
            Next();
        }else if (e.getSource()==btn8) {
        	valeur =8;
            Next();
        }else if (e.getSource()==btn9) {
        	valeur =9;
            Next();
        }else if (e.getSource()==btn10) {
        	valeur =10;
            Next();
        }else if (e.getSource()==btn11) {
        	valeur =11;
            Next();
        }else if (e.getSource()==btn12) {
        	valeur =12;
            Next();
        }else if (e.getSource()==btn13) {
        	valeur =13;
            Next();
        }else if (e.getSource()==btnCancel) {
    		Previous();// une simple méthode pour aller à la carte précédente c'est à dire lblDay sans modifier valeur ni couleur :)
        }else if(e.getSource()==btnBack) {
        	valeur =-1;	// la valeur négative -1 nous permet de retourner la carte
    		UpdatePic(); // update pic permet de mettre à jour l'affichage de la carte en fonction des valeurs courantes (valeur,couleur) de Select
    		Previous();// On passe ici au Paneal précédent c'est à dire lblDay
    		
    		//remarque : on ne reset pas la valeur de couleur car dans le code de carte si jaamis la carte à la valeur négative -1 sa couleur sera automatiquement modifier
    		// celà nous permet de nous simplifier la vie car l'affichage est controlé par la valeur !
        	
        }
        
        
	}
	
	
}
