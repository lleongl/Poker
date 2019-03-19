import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Select extends JPanel {
	private CardLayout C1 = new CardLayout();
	private String[] listContent={"CARD_1", "CARD_2", "CARD_3"};
	private JPanel Day = new JPanel();
	private JPanel months = new JPanel();
	private JPanel seasons = new JPanel();
	private final JButton btnAs = new JButton("As");
	private final JButton btn2 = new JButton("deux");
	private final JButton btn3 = new JButton("trois");
	private final JButton btn4 = new JButton("quatre");
	private final JButton btn5 = new JButton("cinq");
	private final JButton btn6 = new JButton("six");
	private final JButton btn7 = new JButton("sept");
	private final JButton btn8 = new JButton("huit");
	private final JButton btn9 = new JButton("neuf");
	private final JButton btn10 = new JButton("10");
	private final JButton btn11 = new JButton("valet");
	private final JButton btn12 = new JButton("dame");
	private final JButton btn13 = new JButton("roi");
	private final JButton btnCancel = new JButton("X");
	private final JButton btnBack = new JButton("R");
	private Carte Card= new Carte();
	private int valeur=-1;
	private String Couleur;
	private final JLabel C_Carreau = new JLabel("");
	private final JLabel C_pique = new JLabel("");
	private final JLabel C_trefle = new JLabel("");
	private final JLabel C_Coeur = new JLabel("");
	
	private JLabel lblDay;
	

	public Select() { //content = this
		this.setSize(100,160);
		Day.setBackground(new Color(0,0,0,0));
	    months.setBackground(new Color(0,0,0,0));	
	    seasons.setBackground(Color.DARK_GRAY);
	    this.setLayout(C1);
	    this.add(Day, listContent[0]);
	    
	    //--------------------Days-------------------\\

	    
	    Day.setLayout(null);
	    
	    lblDay = new JLabel();
	    lblDay.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		Next();
	    	}
	    });
	    lblDay.setHorizontalAlignment(SwingConstants.CENTER);
	    lblDay.setBounds(0, 0, 100, 160);
		UpdatePic();
	    Day.add(lblDay);
	    
	    //--------------------Months-------------------\\
	    
		    this.add(months, listContent[1]);
		    months.setLayout(new GridLayout(3, 5, 0, 0));
		    btnAs.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    
		    btnAs.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent arg0) {
		    		valeur =1;
		    		Next();
		    	}
		    });
		    
		    months.add(btnAs);
		    btn2.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn2.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =2;
		    		Next();
		    	}
		    });
		    
		    months.add(btn2);
		    btn3.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn3.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =3;
		    		Next();
		    	}
		    });
		    
		    months.add(btn3);
		    btn4.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn4.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =4;
		    		Next();
		    	}
		    });
		    
		    months.add(btn4);
		    btn5.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn5.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =5;
		    		Next();
		    	}
		    });
		    
		    months.add(btn5);
		    btn6.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn6.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent arg0) {
		    		valeur =6;
		    		Next();
		    	}
		    });
		    
		    months.add(btn6);
		    btn7.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn7.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =7;
		    		Next();
		    	}
		    });
		    
		    months.add(btn7);
		    btn8.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn8.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =8;
		    		Next();
		    	}
		    });
		    
		    months.add(btn8);
		    btn9.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn9.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =9;
		    		Next();
		    	}
		    });
		    
		    months.add(btn9);
		    btn10.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn10.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =10;
		    		Next();
		    	}
		    });
		    
		    months.add(btn10);
		    btn11.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn11.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =11;
		    		Next();
		    	}
		    });
		    
		    months.add(btn11);
		    btn12.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn12.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =12;
		    		Next();
		    	}
		    });
		    
		    months.add(btn12);
		    btn13.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btn13.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =13;
		    		Next();
		    	}
		    });
		    
		    months.add(btn13);
		    btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btnCancel.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		Previous();
		    	}
		    });
		    
		    months.add(btnCancel);
		    btnBack.setFont(new Font("Tahoma", Font.PLAIN, 5));
		    btnBack.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseReleased(MouseEvent e) {
		    		valeur =-1;
		    		UpdatePic();
		    		Previous();
		    	}
		    });
		    
		    months.add(btnBack);
		    
		//--------------------Months-------------------\\
		    
	    this.add(seasons, listContent[2]);
	    seasons.setLayout(new GridLayout(0, 2, 2, 0));
	    
	    Image img =new ImageIcon(Select.class.getResource("/images/Couleur_Carreau.png")).getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
	    C_Carreau.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		Couleur = "diamonds";
	    		Next();
	    		UpdatePic();
	    	}
	    });
	    C_Carreau.setHorizontalAlignment(SwingConstants.CENTER);
	    C_Carreau.setIcon(new ImageIcon(img));
	    
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
	    
	    seasons.add(C_Carreau);
	    
	    seasons.add(C_pique);
	    
	    seasons.add(C_trefle);
	    
	    seasons.add(C_Coeur);
	    
	  //--------------------reste de l'année-------------------\\
	    
	}
	
	public void Next() {
		C1.next(this);
	}
	public void Previous() {
		C1.previous(this);
	}
	

	
	public void UpdatePic() {
		Card.setCouleur(Couleur);
		Card.setValeur(valeur);
	    Image shot =Card.getIcon().getImage().getScaledInstance(lblDay.getWidth(),lblDay.getHeight(),Image.SCALE_SMOOTH);
	    lblDay.setIcon(new ImageIcon(shot));
		
	}
	
	public Carte getCard() {
		return Card;
	}
	public void ResetCard() {
		Card = new Carte();
		valeur =-1;
		UpdatePic();
	}
}
