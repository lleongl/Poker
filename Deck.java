import java.util.LinkedList;
import java.util.Random;

public class Deck {
    LinkedList<Carte> contenu = new LinkedList<>();;

    public Deck() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                switch(j) {
                    case 0 : contenu.add(new Carte(i, "Pique"));
                        break;
                    case 1 : contenu.add(new Carte(i, "Coeur"));
                        break;
                    case 2 : contenu.add(new Carte(i, "Trefle"));
                        break;
                    case 3 : contenu.add(new Carte(i, "Carreau"));
                        break;
                }
            }
        }


    }

    public LinkedList<Carte> melangePaquet() {
        Random geny = new Random(System.nanoTime());
        LinkedList<Carte> paquet2 = new LinkedList<>();
        while (this.contenu.size() != 0) {
            int randomNb = geny.nextInt(this.contenu.size());
            Carte t = this.contenu.get(randomNb);
            paquet2.add(t);
            this.contenu.remove(t);
        }
        return paquet2;
    }

    public void removeCard(int valeur, String couleur){
        for (int i=0 ; i<this.contenu.size();i++){
            if (this.contenu.get(i).getValeur()==valeur && this.contenu.get(i).getCouleur()==couleur){
                this.contenu.remove(i);
                break;
            }
        }
    }

    public void distribution(Joueur[] tJoueurs, int nbAdversaires){
        //distribue 2 cartes par avdersaire
        for (int j=1; j<nbAdversaires+1;j++){
            Random geny= new Random(System.nanoTime());
            Carte t1= this.contenu.get(geny.nextInt(this.contenu.size()));
            Carte t2= this.contenu.get(geny.nextInt(this.contenu.size()));
            tJoueurs[j].tLes2Cartes.add(t1);
            tJoueurs[j].tLes2Cartes.add(t2);
            this.removeCard(t1.getValeur(),t1.getCouleur());
            this.removeCard(t2.getValeur(),t2.getCouleur());
        }



    }
     public void tirage(LinkedList<Carte> tLes5Cartes){
         //tirage des cartes sur la table
/*        tLes5Cartes.add(new Carte(7, "Coeur"));
        tLes5Cartes.add(new Carte(4, "Coeur"));
        tLes5Cartes.add(new Carte(1, "Trefle"));
        tLes5Cartes.add(new Carte(3, "Coeur"));
        tLes5Cartes.add(new Carte(5, "Coeur"));*/
         while (tLes5Cartes.size() < 5) {
             tLes5Cartes.add(this.contenu.get(0));
             this.contenu.remove(this.contenu.get(0));
         }
     }
}
