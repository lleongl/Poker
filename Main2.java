import java.util.LinkedList;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        int nbAdversaires = 2;
        int nbTirages = 10000;
        int [] tCompteurs= new int [9];
        boolean quinteFlush=true;
        boolean carre =true;
        boolean full=true;
        boolean couleur=true;
        boolean suite=true;
        boolean brelan=true;
        boolean doublePaire=true;
        boolean paire=true;
        boolean carteHaute=true;

        //établit les 2 cartes initiales du joueur
        int valeur1 = 1;
        int valeur2 = 2;
        String couleur1 = "Carreau";
        String couleur2 = "Coeur";
        Les2Cartes les2Cartes = new Les2Cartes(valeur1, valeur2, couleur1, couleur2);


        for (int k = 0; k < nbTirages; k++) {
            //création deck trié
            Deck2 paquet = new Deck2();
            //melange du paquet
            paquet.contenu = paquet.melangePaquet();
            paquet.removeCard(les2Cartes.tLes2Cartes.get(0).getValeur(), les2Cartes.tLes2Cartes.get(0).getCouleur());
            paquet.removeCard(les2Cartes.tLes2Cartes.get(1).getValeur(), les2Cartes.tLes2Cartes.get(1).getCouleur());

            //distribution des cartes aux adversaires et tirage des 5 cartes
            Les5Cartes les5Cartes = new Les5Cartes();
            paquet.distribution(les5Cartes.tLes5Cartes, nbAdversaires);

            //(Affichage des cartes du paquet)
/*            for (int i = 0; i < paquet.contenu.size(); i++) {
                System.out.println("carte " + i + ":");
                System.out.println(paquet.contenu.get(i).getCouleur());
                System.out.println(paquet.contenu.get(i).getValeur());
            }

            System.out.println("les 2 Cartes :");
            for (int i = 0; i < les2Cartes.tLes2Cartes.size(); i++) {
                System.out.println("carte " + i + ":");
                System.out.println(les2Cartes.tLes2Cartes.get(i).getCouleur());
                System.out.println(les2Cartes.tLes2Cartes.get(i).getValeur());
            }

            System.out.println("les 5 Cartes :");
            for (int i = 0; i < les5Cartes.tLes5Cartes.size(); i++) {
                System.out.println("carte " + i + ":");
                System.out.println(les5Cartes.tLes5Cartes.get(i).getCouleur());
                System.out.println(les5Cartes.tLes5Cartes.get(i).getValeur());
            }*/

            //regroupement des 2 cartes du joueurs et de celles sur la table
            Les7Cartes les7Cartes = new Les7Cartes(les5Cartes.tLes5Cartes, les2Cartes.tLes2Cartes);
/*
            System.out.println("les 7 Cartes :");
            for (int i = 0; i < les7Cartes.tLes7Cartes.size(); i++) {
                System.out.println("carte " + i + ":");
                System.out.println(les7Cartes.tLes7Cartes.get(i).getCouleur());
                System.out.println(les7Cartes.tLes7Cartes.get(i).getValeur());
            }*/

            //Opération de la chaine de test
            les7Cartes.chaineTest(tCompteurs);
        }
/*      System.out.println("Tableau de compteurs : ");
        for (int i=0; i<tCompteurs.length; i++){
            System.out.print(tCompteurs[i]+" ");
        }*/

        //Affiche les probabilités recherchées
        if (quinteFlush==true){
            System.out.println("Probabilité d'avoir une Quinte Flush : "+(tCompteurs[0]/(float) nbTirages)*100+"%");
        }
        if (carre==true){
            System.out.println("Probabilité d'avoir un Carre : "+(tCompteurs[1]/(float) nbTirages)*100+"%");
        }
        if (full==true){
            System.out.println("Probabilité d'avoir un Full : "+(tCompteurs[2]/(float) nbTirages)*100+"%");
        }
        if (couleur==true){
            System.out.println("Probabilité d'avoir une Couleur : "+(tCompteurs[3]/(float) nbTirages)*100+"%");
        }
        if (suite==true){
            System.out.println("Probabilité d'avoir une Suite : "+(tCompteurs[4]/(float) nbTirages)*100+"%");
        }
        if (brelan==true){
            System.out.println("Probabilité d'avoir un Brelan : "+(tCompteurs[5]/(float) nbTirages)*100+"%");
        }
        if (doublePaire==true){
            System.out.println("Probabilité d'avoir une Double Paire : "+(tCompteurs[6]/(float) nbTirages)*100+"%");
        }
        if (paire==true){
            System.out.println("Probabilité d'avoir une Paire : "+(tCompteurs[7]/(float) nbTirages)*100+"%");
        }
        if (carteHaute==true){
            System.out.println("Probabilité d'avoir une Carte Haute : "+(tCompteurs[8]/(float) nbTirages)*100+"%");
        }

        float total=0;
        for (int n=0; n<9;n++){
            total+=(tCompteurs[n]/(float) nbTirages)*100;

        }
        System.out.println("total :" +total);
    }

}
