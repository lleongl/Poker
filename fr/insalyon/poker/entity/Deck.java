package fr.insalyon.poker.entity;

import java.util.LinkedList;
import java.util.Random;

public class Deck {
    private LinkedList<Carte> contenu;
    private Random geny;

    public Deck() {
        contenu = new LinkedList<Carte>();
        geny = new Random(System.nanoTime());
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                switch(j) {
                    case 0 : this.contenu.add(new Carte(i, "Pique"));
                        break;
                    case 1 : this.contenu.add(new Carte(i, "Coeur"));
                        break;
                    case 2 : this.contenu.add(new Carte(i, "Trefle"));
                        break;
                    case 3 : this.contenu.add(new Carte(i, "Carreau"));
                        break;
                }
            }
        }
    }

    public LinkedList<Carte> creationJeuCartes() {
        LinkedList<Carte> jeuCartes=new LinkedList<>();
        while(contenu.size()!=0){
            int randomNb = geny.nextInt(contenu.size());
            Carte t= this.contenu.get(randomNb);
            jeuCartes.add(t);
            this.contenu.remove(t);
        }
        return jeuCartes;
    }

    public LinkedList<Carte> getContenu() {
        return contenu;
    }

    public void removeCard(LinkedList<Carte> paquet, int valeur, String couleur){
        for (int i=0 ; i<paquet.size();i++){
            if (paquet.get(i).getValeur()==valeur && paquet.get(i).getCouleur()==couleur){
                paquet.remove(i);
                break;
            }
        }
    }
}
