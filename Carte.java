import javax.swing.ImageIcon;
public class Carte implements Comparable<Carte> {

    private String couleur;
    private int valeur;
    private ImageIcon pic;
    

    public Carte(int valeur, String couleur) { // constructeur de la carte
        this.couleur = couleur;
        this.valeur = valeur;
    }
    
    
    public ImageIcon getIcon() {// retourne l'ImageIcon de la carte
    	pic =new ImageIcon(Carte.class.getResource("images/"+getValPath()+"-"+couleur+".jpg"));
    	return pic;
    }
    
    public String getValPath() {// permet de definir de facon claire le prefixe du fichier image associe a une valeur particuliere
    	String ValPath ;
        switch (valeur) {
	        case 14:  ValPath = "ace";
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
        return ValPath;
        
        
    }
    
    public Carte() {//Constructeur si la carte est tournee
    	pic=new ImageIcon(Carte.class.getResource("images/card-back.jpg"),"cachee"); // affichera le dos de la carte
    	valeur =-1;// la valeur -1 represente une carte tourne
    }

    public String getCouleur() {	//permet de recuperer la couleur de la carte
        return couleur;
    }

    public int getValeur() {	//permet de recuperer la valeur de la carte
        return valeur;
    }


    public void setCouleur(String C) { //permet de changer la couleur de la carte
    	this.couleur=C;
    }
    
    public void setValeur(int V) { //permet de changer la valeur de la carte
    	this.valeur=V;
    }


    public int compareTo(Carte autreCarte){ // methode CompareTo
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
    
    public String toString() {	//methode ToString
    	return this.getValPath()+" of "+couleur ; 
    	
    }
    


}
