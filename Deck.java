import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Deck {
    ArrayList<Carte> contenu = new ArrayList<>();

    public Deck() {
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                switch(j) {
                    case 0 : contenu.add(new Carte(i, "spades"));
                        break;
                    case 1 : contenu.add(new Carte(i, "hearts"));
                        break;
                    case 2 : contenu.add(new Carte(i, "clubs"));
                        break;
                    case 3 : contenu.add(new Carte(i, "diamonds"));
                        break;
                }
            }
        }


    }

//    public LinkedList<Carte> melangePaquet() {
//        //tant qu'il y a des cartes, prend une carte du paquet trié au hasard et la met dans un nouveau paquet pour le remplir
//        Random geny = new Random(System.nanoTime());
//        LinkedList<Carte> paquet2 = new LinkedList<>();
//        while (this.contenu.size() != 0) {
//            int randomNb = geny.nextInt(this.contenu.size());
//            Carte t = this.contenu.get(randomNb);
//            paquet2.add(t);
//            this.contenu.remove(t);
//        }
//        return paquet2;
//    }

    public void removeCard(int valeur, String couleur){
        //enleve une carte du paquet
        for (Carte c : this.contenu){
            if (c.getValeur()==valeur && c.getCouleur()==couleur){
                this.contenu.remove(c);
                break;
            }
        }
    }

    public void distribution(Joueur[] tJoueurs, int nbAdversaires){
        //distribue 2 cartes par avdersaire
        for (int j=1; j<nbAdversaires+1;j++){
            Random geny= new Random(System.nanoTime());
            Carte t1= this.contenu.get(geny.nextInt(this.contenu.size()));
            tJoueurs[j].les2Cartes.add(t1);
            this.removeCard(t1.getValeur(),t1.getCouleur());
            Carte t2= this.contenu.get(geny.nextInt(this.contenu.size()));
            tJoueurs[j].les2Cartes.add(t2);
            this.removeCard(t2.getValeur(),t2.getCouleur());
        }



    }
     public void tirage(LinkedList<Carte> les5Cartes){
         //tire 5 carte au hasard du paquet et la met dans les5Cartes
         while (les5Cartes.size() < 5) {
             Random geny= new Random(System.nanoTime());
             Carte t= this.contenu.get(geny.nextInt(this.contenu.size()));
             les5Cartes.add(t);
             this.removeCard(t.getValeur(), t.getCouleur());
         }
     }
}
