import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.LinkedList;

public class playground extends JFrame {

	private JPanel contentPane;
	private CardLayout c1 = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playground frame = new playground();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public playground() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//-------------------------------------------------\\
		
		
		LinkedList<Carte> t=new LinkedList<Carte>();
		t.add(new Carte(1,"clubs"));
		t.add(new Carte(5,"clubs"));
		t.add(new Carte(4,"clubs"));
		t.add(new Carte(3,"clubs"));
		t.add(new Carte(5,"clubs"));
		
		System.out.println(t);
		Collections.sort(t);
		System.out.println(t);
		
	
		Select CardA = new Select();
		CardA.setLocation(320, 115);
		
		getContentPane().add(CardA);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		btnNewButton.setBounds(320, 344, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
