package fr.insalyon.poker.entity;

import java.util.LinkedList;

public class laMain {
    private LinkedList<Carte> main = new LinkedList<>();
    private static int compteurBrelan = 0;
    private float probaBrelan = 0;
    private static int compteurCarre = 0;
    float probaCarre;
    private int nbTirages;


    //regroupe les cartes initiales du joueur et celles qui ont été tirées
    public laMain(LinkedList<Carte> cartesInit, LinkedList<Carte> tableCartes, int nbTirages) {
        for (int i = 0; i < tableCartes.size() + cartesInit.size(); i++) {
            if (i < cartesInit.size()) {
                main.add(cartesInit.get(i));
            } else {
                main.add(tableCartes.get(i - cartesInit.size()));
            }
        }
        this.nbTirages = nbTirages;
    }

    public LinkedList<Carte> getMain() {
        return main;
    }

    //compte le nombre de fois où il y a 3 valeurs identiques
    public void Brelan() {
        long compteur = 0;
        int compteurIntermediaire = 0;
        String t = "";
        char[] tChar;
        for (int j = 0; j < this.main.size(); j++) {
            int val = this.main.get(j).getValeur();
            compteur += Math.pow(10, val);
        }
        //transforme en String le compteur (a changer)
        t = compteur + "";
        tChar = t.toCharArray();
        for (int k = 0; k < tChar.length; k++) {
            if (tChar[k] == '3') {
                compteurIntermediaire++;
            }
        }
        if (compteurIntermediaire > 0) {
            laMain.compteurBrelan++;
        }
/*        System.out.println("le compteur :" + compteur);
        System.out.print("tChar : ");
        for (int k = 0; k < tChar.length; k++) {
            System.out.print(tChar[k] + " ");
        }
        System.out.println();*/
    }

    public float getProbaBrelan() {
        probaBrelan = compteurBrelan / (float) nbTirages;
        return probaBrelan * 100;
    }

    public void Carre() {
        long compteur = 0;
        String t = "";
        char[] tChar;
        for (int j = 0; j < this.main.size(); j++) {
            int val = this.main.get(j).getValeur();
            compteur += Math.pow(10, val);
        }
        //transforme en String le compteur (a changer)
        t = compteur + "";
        tChar = t.toCharArray();
        for (int k = 0; k < tChar.length; k++) {
            if (tChar[k] == '4') {
                laMain.compteurCarre++;
            }
        }

    }

    public float getProbaCarre() {
        probaCarre = compteurCarre / (float) nbTirages;
        return probaCarre * 100;
    }
}
