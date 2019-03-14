
import javax.swing.ImageIcon;
public class Carte {

    private String couleur;
    private int valeur;
    private ImageIcon pic;
    private ImageIcon folded =new ImageIcon("images/card-back.jpg","cachée");
    

    public Carte(int valeur, String couleur) {
        this.couleur = couleur;
        this.valeur = valeur;
        
        String ValPath ;
        switch (valeur) {
	        case 1:  ValPath = "ace";
	                 break;
	        case 2:  ValPath = "two";
	                 break;
	        case 3:  ValPath = "three";
	                 break;
	        case 4:  ValPath = "four";
	                 break;
	        case 5:  ValPath = "five";
	                 break;
	        case 6:  ValPath = "six";
	                 break;
	        case 7:  ValPath = "seven";
	                 break;
	        case 8:  ValPath = "eight";
	                 break;
	        case 9:  ValPath = "nine";
	                 break;
	        case 10: ValPath = "ten";
	                 break;
	        case 11: ValPath = "jack";
	                 break;
	        case 12: ValPath = "queen";
	                 break;
	        case 13: ValPath =  "king";
	        
	        default: ValPath = "card";
	                 break;
        }
        
        pic =new ImageIcon("images/"+ValPath+"-"+couleur+".jpg");
        
    }

    public String getCouleur() {
        return couleur;
    }

    public int getValeur() {
        return valeur;
    }
    
    public ImageIcon getIcon() {
    	return pic;
    	
    }
    
    public ImageIcon getFolded() {
    	return folded;
    }
}
