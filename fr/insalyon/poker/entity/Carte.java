package fr.insalyon.poker.entity;

import java.util.LinkedList;

public class Carte {

    private String couleur;
    private int valeur;

    public Carte(int valeur, String couleur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public LinkedList<Carte> deck() {
        LinkedList<Carte> deck = new LinkedList<Carte>;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                switch(j) {
                    case 0 : deck.add(Carte carte = new Carte(i, "Pique"));
                    break;
                    case 1 : deck.add(Carte carte = new Carte(i, "Coeur"));
                        break;
                    case 2 : deck.add(Carte carte = new Carte(i, "Trefle"));
                        break;
                    case 3 : deck.add(Carte carte = new Carte(i, "Carreau"));
                        break;
                }

            }
        }
    }

    public String getPrenom() {
        return couleur;
    }


}
