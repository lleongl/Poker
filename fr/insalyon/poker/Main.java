package fr.insalyon.poker;

import fr.insalyon.poker.entity.Carte;
import fr.insalyon.poker.entity.Deck;
import fr.insalyon.poker.entity.laMain;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Deck deck ;
        Random geny1 = new Random(System.nanoTime());
        Random geny2 = new Random(System.nanoTime());
        laMain joueurCartes = null;
        LinkedList<Carte> jeuCartes;
        LinkedList<Carte> tableCartes = new LinkedList<>();
        LinkedList<Carte> cartesInit = new LinkedList<>();
        boolean brelan=true;
        boolean carre=true;
        int nbTirages = 10000;
        //initialise le cartes initiales du joueur et les enleve du jeuCartes
        for (int k = 0; k < nbTirages; k++) {
            deck = new Deck();
            jeuCartes = deck.creationJeuCartes();

/*
            for(int i=0;i<jeuCartes.size();i++) {
                System.out.println("carte "+i+":");
                System.out.println(jeuCartes.get(i).getCouleur());
                System.out.println(jeuCartes.get(i).getValeur());
            }
*/

            //au clavier pour le moment
           /* Scanner sc = new Scanner(System.in);
            System.out.println("couleur de la premiere carte ?");
            String couleur1 = sc.next();
            System.out.println("valeur de la premiere carte ?");
            int valeur1 = sc.nextInt();
            System.out.println("couleur de la deuxieme carte ?");
            String couleur2 = sc.next();
            System.out.println("valeur de la deuxieme carte ?");
            int valeur2 = sc.nextInt();
            Carte carte1 = new Carte(valeur1, couleur1);
            Carte carte2 = new Carte(valeur2, couleur2);*/
            Carte carte1=new Carte(10, "Pique");
            Carte carte2=new Carte(1, "Carreau");
            cartesInit.add(carte1);
            cartesInit.add(carte2);
            deck.removeCard(jeuCartes,10,"Pique");
            deck.removeCard(jeuCartes,1,"Carreau");

/*
            for(int i=0;i<jeuCartes.size();i++) {
                System.out.println("carte "+i+":");
                System.out.println(jeuCartes.get(i).getCouleur());
                System.out.println(jeuCartes.get(i).getValeur());
            }
*/

            //enleve 2 cartes au hasard (1 adversaire) du jeuCartes
            int randomNb1 = geny1.nextInt(jeuCartes.size());
            Carte t1= jeuCartes.get(randomNb1);
            deck.removeCard(jeuCartes,t1.getValeur(),t1.getCouleur());
            int randomNb2 = geny2.nextInt(jeuCartes.size());
            Carte t2= jeuCartes.get(randomNb2);
            deck.removeCard(jeuCartes,t2.getValeur(),t2.getCouleur());

/*            for(int i=0;i<jeuCartes.size();i++) {
                System.out.println("carte "+i+":");
                System.out.println(jeuCartes.get(i).getCouleur());
                System.out.println(jeuCartes.get(i).getValeur());
            }*/

            //Tire les cartes sur la table
            while (tableCartes.size() < 5) {
                tableCartes.add(jeuCartes.get(0));
                jeuCartes.remove(jeuCartes.get(0));
            }

/*            for(int i=0;i<jeuCartes.size();i++) {
                System.out.println("carte "+i+":");
                System.out.println(jeuCartes.get(i).getCouleur());
                System.out.println(jeuCartes.get(i).getValeur());
            }*/

            //Défini les Cartes que le joueur peut utiliser
            joueurCartes = new laMain(cartesInit, tableCartes,nbTirages);


/*            System.out.println("les cartes : ");
            for (int p=0;p<joueurCartes.getMain().size();p++){
                System.out.print(joueurCartes.getMain().get(p).getValeur()+" ");
            }
            System.out.println();*/
            if (brelan==true) {
                joueurCartes.Brelan();
            }
            if(carre==true) {
                joueurCartes.Carre();
            }

            tableCartes.clear();
            cartesInit.clear();
//            System.out.println();
        }

        if (brelan==true) {
            System.out.println("proba Brelan : " + joueurCartes.getProbaBrelan()+"%");
        }

        if(carre==true) {
            System.out.println("proba Carre : " + joueurCartes.getProbaCarre()+"%");
        }
    }

    //Affiche les cartes de la table
        /*for(int i=0;i<tableCartes.size();i++) {
            System.out.println("carte "+i+":");
            System.out.println(tableCartes.get(i).getCouleur());
            System.out.println(tableCartes.get(i).getValeur());
        }

        //Affiche les 7 cartes
        for(int i=0;i<joueurCartes.size();i++) {
            System.out.println("carte "+i+":");
            System.out.println(joueurCartes.get(i).getCouleur());
            System.out.println(joueurCartes.get(i).getValeur());
        }*/
}

