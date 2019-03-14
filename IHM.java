import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class IHM extends JFrame {

	private JPanel contentPane;
    private JPanel NbJoeur;
    /*
    private JPanel River;
    private JPanel Result;
    private JPanel Hand;
	*/
    
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
        //-----------------------Initialisation------------------------------\\
        
        setTitle("Poker Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 300, 1350, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
        
        //-----------------------Jpanel------------------------------\\
        
        NbJoeur = new JPanel ();
        NbJoeur.setBounds(50,50,150,150);
        NbJoeur.setLayout(null);
            
            JLabel nbJ = new JLabel("Nombre de \n joeurs :");
            nbJ.setBounds(0,0,100,50);
            JTextField nbrJ = new JTextField();
            nbrJ.setText("1");
            nbrJ.setBounds(0,50,100,100);
            
        NbJoeur.add(nbJ);
        NbJoeur.add(nbrJ);
        
        contentPane.add(NbJoeur);
        /*
        contentPane.add(Hand);
        contentPane.add(Result);
        contentPane.add(River);
        */
	}

}
