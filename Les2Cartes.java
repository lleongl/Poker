import java.util.LinkedList;

public class Les2Cartes {
    LinkedList<Carte> tLes2Cartes=new LinkedList<>();
    public Les2Cartes(int valeur1, int valeur2, String couleur1, String couleur2) {
        Carte carte1=new Carte(valeur1, couleur1);
        Carte carte2=new Carte(valeur2, couleur2);
        tLes2Cartes.add(carte1);
        tLes2Cartes.add(carte2);
    }
}
