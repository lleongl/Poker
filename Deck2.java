import java.util.LinkedList;
import java.util.Random;

public class Deck2 {
    LinkedList<Carte> contenu = new LinkedList<>();;

    public Deck2() {
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

    public void distribution( LinkedList<Carte> tLes5Cartes, int nbAdversaires){
        //enleve au hasard 2 cartes par avdersaire
        for (int j=0; j<nbAdversaires;j++){
            Random geny= new Random(System.nanoTime());
            Carte t1= this.contenu.get(geny.nextInt(this.contenu.size()));
            Carte t2= this.contenu.get(geny.nextInt(this.contenu.size()));
            this.removeCard(t1.getValeur(),t1.getCouleur());
            this.removeCard(t2.getValeur(),t2.getCouleur());
        }

        //tirage des cartes sur la table
/*        tLes5Cartes.add(new Carte(7, "Pique"));
        tLes5Cartes.add(new Carte(13, "Pique"));
        tLes5Cartes.add(new Carte(1, "Pique"));
        tLes5Cartes.add(new Carte(3, "Pique"));
        tLes5Cartes.add(new Carte(5, "Pique"));*/
        while (tLes5Cartes.size() < 5) {
            tLes5Cartes.add(this.contenu.get(0));
            this.contenu.remove(this.contenu.get(0));
        }

    }
}
