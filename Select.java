import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.*;


public class Select extends JPanel implements ActionListener, MouseListener  {

    private CardLayout C1 = new CardLayout();// le Layout de la classe Select
    
    //-------les differents Panels contenu dans Select-------\\
    private JPanel Day = new JPanel();
    private JPanel months = new JPanel();
    private JPanel seasons = new JPanel();

    //-------------Les boutons present dans seasons------------\\
    
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

    //--------------La carte interne a Select--------------\\
    
    private Carte Card = new Carte();

    //---------------Valeur initiale de la carte--------------\\
    
    private int valeur = -1;
    private String Couleur;

    //--------Les Jpanels representant les couleurs---------\\
    
    private final JLabel C_Carreau = new JLabel();
    private final JLabel C_pique = new JLabel();
    private final JLabel C_trefle = new JLabel();
    private final JLabel C_Coeur = new JLabel();
    
    private JLabel lblDay = new JLabel();	// Permet d'afficher l'image de la carte courante
    
    private interfaces Parent;	//permet d'acceder a tout moment a son parent


    public Select(interfaces Parent) {
    	
        this.Parent =Parent;// son parent est l'interface qui l'a cree, il nous permettra de récuperer les valeurs de autres cartes presentes

        this.setSize(100, 160);    // taille de 100*160
        Day.setBackground(new Color(0, 0, 0, 0));
        months.setBackground(Color.DARK_GRAY);    //fond de Months noir
        seasons.setBackground(Color.BLACK);//fond de saison noir gris

        this.setLayout(C1); //la classe select aura un Card layout
        this.add(Day);

        //--------------------Days-------------------\\


        Day.setLayout(null); // le Panel Day n'a pas besoin de Layout particulier :)
        lblDay.addMouseListener(this);// on mets un MouseListener dessus pour detecter les clics dessus
        lblDay.setHorizontalAlignment(SwingConstants.CENTER);// permet de centrer la carte dans le Jpanel Day
        lblDay.setBounds(0, 0, 100, 160); // set la taille de 100*160 permet de remplir entierement le Jpanel Select
        UpdatePic(); // mettre une premiere fois a jour permet d'afficher une carte retourner
        Day.add(lblDay);

        
        //--------------------Seasons-------------------\\

        this.add(seasons);
        seasons.setLayout(new GridLayout(3, 5, 1, 1));
        // months utilisera un grid layout de 3 lignes et 5 colonnes
        // avec un ecart horizontal et vertical de 1 pour faire office de separateur
        
        butonSetup(btnAs);
        butonSetup(btn2);
        butonSetup(btn3);
        butonSetup(btn4);
        butonSetup(btn5);
        butonSetup(btn6);
        butonSetup(btn7);
        butonSetup(btn8);
        butonSetup(btn9);
        butonSetup(btn10);
        butonSetup(btn11);
        butonSetup(btn12);
        butonSetup(btn13);
        butonSetup(btnCancel);
        butonSetup(btnBack);

        //--------------------Months-------------------\\

        this.add(months);
        months.setLayout(new GridLayout(0, 2, 2, 0));// Seasons utilisera un Grid Layout de 2 par 2

        //Ici on met au clair les dimensions de l'image c'est a dire 50 de largeur et 40 de hauteur
        Image img = new ImageIcon(Select.class.getResource("/images/Couleur_Carreau.png")).getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        ColorSetup(C_Carreau,img);
        
        img = new ImageIcon(Select.class.getResource("/images/Couleur_Pique.png")).getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        ColorSetup(C_pique,img);

        img = new ImageIcon(Select.class.getResource("/images/Couleur_Trefle.png")).getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        ColorSetup(C_trefle,img);

        img = new ImageIcon(Select.class.getResource("/images/Couleur_Coeur.png")).getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        ColorSetup(C_Coeur,img);

        
        addMouseListener(this);
    }

    public void Next() { // change le panneau afficher par la card Layout en passant a  la suivante
        C1.next(this);
    }

    public void Previous() { // change le panneau afficher par la card Layout en passant a la precedente
        C1.previous(this);
    }


    public void UpdatePic() {    
    	// mets a  jour le panneau lblDay qui est cense afficher la carte en utilisant les variables valeur et couleurs modifie ou non
        //change les attributs interne de la Carte
        Card.setCouleur(Couleur);
        Card.setValeur(valeur);

        //recupere depuis la carte l'icone a afficher puis fit sa taille au Jpanel lblDay
        Image shot = Card.getIcon().getImage().getScaledInstance(lblDay.getWidth(), lblDay.getHeight(), Image.SCALE_SMOOTH);
        //mets a  jour l'icone a afficher
        lblDay.setIcon(new ImageIcon(shot));

    }

    public Carte getCard() {
        //retourne la current card
        return Card;
    }

    public void ResetCard() {
        //clear la  carte
        Card = new Carte();

        // la valeur negative -1 et une valeur arbitraire qui nous permet d'afficher une carte tournee
        valeur = -1;

        //mets a jour lblDay pour afficher cette carte tourner
        UpdatePic();
    }

    public void SetInternalDeck() {
    	
    	ArrayList<Carte> interfaceDeck = Parent.getInternalDeck();
    	
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
            if (x.getValeur() == 14)
                btnAs.setEnabled(true);
            if (x.getValeur() == 2)
                btn2.setEnabled(true);
            if (x.getValeur() == 3)
                btn3.setEnabled(true);
            if (x.getValeur() == 4)
                btn4.setEnabled(true);
            if (x.getValeur() == 5)
                btn5.setEnabled(true);
            if (x.getValeur() == 6)
                btn6.setEnabled(true);
            if (x.getValeur() == 7)
                btn7.setEnabled(true);
            if (x.getValeur() == 8)
                btn8.setEnabled(true);
            if (x.getValeur() == 9)
                btn9.setEnabled(true);
            if (x.getValeur() == 10)
                btn10.setEnabled(true);
            if (x.getValeur() == 11)
                btn11.setEnabled(true);
            if (x.getValeur() == 12)
                btn12.setEnabled(true);
            if (x.getValeur() == 13)
                btn13.setEnabled(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAs) {
            valeur = 14; //on modifie la variable valeur en fonction du bouton sur lequel on appuie
            Next();    // on passe au panel suivant c'est a dire Seasons
        } else if (e.getSource() == btn2) {
            valeur = 2;
            Next();
        } else if (e.getSource() == btn3) {
            valeur = 3;
            Next();
        } else if (e.getSource() == btn4) {
            valeur = 4;
            Next();
        } else if (e.getSource() == btn5) {
            valeur = 5;
            Next();
        } else if (e.getSource() == btn6) {
            valeur = 6;
            Next();
        } else if (e.getSource() == btn7) {
            valeur = 7;
            Next();
        } else if (e.getSource() == btn8) {
            valeur = 8;
            Next();
        } else if (e.getSource() == btn9) {
            valeur = 9;
            Next();
        } else if (e.getSource() == btn10) {
            valeur = 10;
            Next();
        } else if (e.getSource() == btn11) {
            valeur = 11;
            Next();
        } else if (e.getSource() == btn12) {
            valeur = 12;
            Next();
        } else if (e.getSource() == btn13) {
            valeur = 13;
            Next();
        } else if (e.getSource() == btnCancel) {
            Previous();// une simple methode pour aller a la carte predente c'est a  dire lblDay sans modifier valeur ni couleur :)
        } else if (e.getSource() == btnBack) {
            valeur = -1;    // la valeur negative -1 nous permet de retourner la carte
            UpdatePic(); // update pic permet de mettre a jour l'affichage de la carte en fonction des valeurs courantes (valeur,couleur) de Select
            Previous();// On passe ici au Panel precedent c'est a dire lblDay

            //remarque : on ne reset pas la valeur de couleur car dans le code de carte si jamais la carte a la valeur negative -1 sa couleur sera automatiquement modifier
            // cela  nous permet de nous simplifier la vie car l'affichage est controle par la valeur !

        }


    }

    public void mouseReleased(MouseEvent e) {
    	if (e.getSource() ==lblDay) {
    		Next();
    	}
    	
    	//--------------------Choix de la couleur-------------------\\
    	if (e.getSource() ==C_Carreau) {
    		ColorChoice("diamonds");
    	}else if (e.getSource() ==C_pique) {
    		ColorChoice("spades");
    	}else if (e.getSource() ==C_trefle) {
    		ColorChoice("clubs");
    	}else if (e.getSource() ==C_Coeur) {
    		ColorChoice("hearts");
    	}
    	
    	
    }
    
    
    public void mousePressed(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {
		SetInternalDeck();//On verifie les cartes selectionnable
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
    }
    
    //Les methodes Setup nous permettrons d'alleger le constructeur en code redondant.
    public void butonSetup(JButton btn) {
    	btn.addActionListener(this);
    	// on a prefere un action Listener a un MouseListener car le MosueListener 
        //n'aurait pas pris en compte le set enable du bouton
    	
        btn.setBorder(null);//set les bordures du bouton a null nous permet de resoudre un probleme d'affichage du texte
        seasons.add(btn);
    }

    public void ColorSetup(JLabel C,Image img) {
    	C.addMouseListener(this);
        C.setHorizontalAlignment(SwingConstants.CENTER); // permet de centrer l'image
        C.setIcon(new ImageIcon(img)); //afficher l'image dans le label
        months.add(C);
    }
    
    public void ColorChoice(String x) {
    	boolean selectionnable =false;
        ArrayList<Carte> Pioche = Parent.getInternalDeck();
        for(Carte y: Pioche) 
        	if(y.getValeur()==valeur && y.getCouleur()==x)
        		selectionnable=true;
        
        
    	if(selectionnable) {// On verifie que la pioche contient bien cette couleur
            Couleur = x;
        	UpdatePic();// on met a jour lblDay ( l'image de la carte)
            Next();
    		}else {
    			JOptionPane.showMessageDialog(null,"Cette Carte est deja posee", "Poker Master : Couleur indisponible" , JOptionPane.INFORMATION_MESSAGE);
    		}
    }
}
