
import javax.swing.ImageIcon;
public class Carte implements Comparable<Carte> {

    private String couleur;
    private int valeur;
    private ImageIcon pic;
    

    public Carte(int valeur, String couleur) {
        this.couleur = couleur;
        this.valeur = valeur;
        
        
        pic =new ImageIcon("images/"+getValPath()+"-"+couleur+".jpg");
        
    }
    
    public Carte() {//NUlle ou folded
    	pic=new ImageIcon("images/card-back.jpg","cachee");
    	valeur =-1;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getValeur() {
        return valeur;
    }
    
    public ImageIcon getIcon() {
    	pic =new ImageIcon("images/"+getValPath()+"-"+couleur+".jpg");
    	return pic;
    	
    }
    public void setCouleur(String C) { //delete this
    	this.couleur=C;
    }
    
    public void setValeur(int V) { //delete this
    	this.valeur=V;
    }
    public String getValPath() {
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
					break;
			case -1 :
	        
	        default: ValPath = "card";
	        		 couleur = "back";
	                 break;
        }
<<<<<<< HEAD
        return ValPath;
=======
        
        pic =new ImageIcon("images/"+ValPath+"-"+couleur+".jpg");
        
    }
    
    public Carte() {//NUlle ou folded
    	pic=new ImageIcon("images/card-back.jpg","cach�e");
    	valeur =-1;
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
<<<<<<< Updated upstream
    public void setCouleur(String C) { //delete this
    	this.couleur=C;
    }
    
    public void setValeur(int V) { //delete this
    	this.valeur=V;
>>>>>>> b2a7b917aac4ed32d2e3dfc89520285865c25f8b
    }
=======


    public int compareTo(Carte autreCarte){
		if (this.getValeur()<autreCarte.getValeur()){
			return -1;
		}
		else if (this.getValeur()>autreCarte.getValeur()){
			return 1;
		}
		else {
			return 0;
		}
	}

>>>>>>> Stashed changes
}
