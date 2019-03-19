import java.util.ArrayList;

public class Calculatrice {
    public float[] lancerCalcul(int x,  ArrayList <Carte> Hand, ArrayList <Carte> River) {
        int nbAdversaires = x-1;
        int nbTirages = 10000;
        int [] tCompteurs= new int [9];
        float[] tProba= new float[11];
        Joueur [] tJoueurs= new Joueur[nbAdversaires+1];
        boolean quinteFlush=true;
        boolean carre =true;
        boolean full=true;
        boolean couleur=true;
        boolean suite=true;
        boolean brelan=true;
        boolean doublePaire=true;
        boolean paire=true;
        boolean carteHaute=true;
        boolean egalite;

        //crée le tableau de joueurs
        for (int n=0; n<tJoueurs.length;n++){
            tJoueurs[n]=new Joueur();
        }

        //établit les 2 cartes initiales du joueur
        tJoueurs[0].tLes2Cartes.add(Hand.get(0));
        tJoueurs[0].tLes2Cartes.add(Hand.get(1));



        for (int k = 0; k < nbTirages; k++) {
            egalite=false;
            //création deck trié
            Deck paquet = new Deck();
            //melange du paquet
            paquet.contenu = paquet.melangePaquet();
            paquet.removeCard(tJoueurs[0].tLes2Cartes.get(0).getValeur(), tJoueurs[0].tLes2Cartes.get(0).getCouleur());
            paquet.removeCard(tJoueurs[0].tLes2Cartes.get(1).getValeur(), tJoueurs[0].tLes2Cartes.get(1).getCouleur());

            //distribution des cartes aux adversaires
            paquet.distribution(tJoueurs, nbAdversaires);
//            tJoueurs[1].tLes2Cartes.clear();

            //tirage des 5 cartes
            Les5Cartes les5Cartes = new Les5Cartes();

            for(int i=0; i<River.size();i++) {
                les5Cartes.tLes5Cartes.add(River.get(i));
                paquet.removeCard(River.get(i).getValeur(), (River.get(i).getCouleur()));
            }
            paquet.tirage(les5Cartes.tLes5Cartes);
//            tJoueurs[1].tLes2Cartes.add(new Carte (valeur1, "Coeur"));
//            tJoueurs[1].tLes2Cartes.add(new Carte (valeur2, "Trefle"));

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

            //regroupement des 2 cartes des joueurs et de celles sur la table
            for (int n=0; n<tJoueurs.length;n++){
                tJoueurs[n].les7Cartes=new Les7Cartes(les5Cartes.tLes5Cartes, tJoueurs[n].tLes2Cartes);
            }

     //       Les7Cartes les7Cartes = new Les7Cartes(les5Cartes.tLes5Cartes, les2Cartes.tLes2Cartes);

            /*
            System.out.println("les 7 Cartes :");
            for (int i = 0; i < les7Cartes.tLes7Cartes.size(); i++) {
                System.out.println("carte " + i + ":");
                System.out.println(les7Cartes.tLes7Cartes.get(i).getCouleur());
                System.out.println(les7Cartes.tLes7Cartes.get(i).getValeur());
            }*/

            //Opération de la chaine de test

            for (int p=0; p<nbAdversaires+1;p++) {
                tJoueurs[p].les7Cartes.chaineTest(tCompteurs, tJoueurs, p);
            }

            int joueurMaxScore=0;
            float maxScore=0;
            int joueurEgalite=0;
            for (int i=0; i<tJoueurs.length;i++){
                if (tJoueurs[i].getScore()==maxScore || tJoueurs[i].getScore()==maxScore-0.5){
                    tJoueurs[i].les7Cartes.testEgalite(tJoueurs,joueurMaxScore,i);
                }
                if (tJoueurs[i].getScore()> maxScore){
                    maxScore=tJoueurs[i].getScore();
                    joueurMaxScore=i;
                }
            }

            for (int i=0; i<tJoueurs.length;i++) {
                if (i != joueurMaxScore && tJoueurs[joueurMaxScore].getScore() == tJoueurs[i].getScore()) {
                    egalite=true;
                    break;
                }
            }

            if(!egalite) {
                tJoueurs[joueurMaxScore].setVictoire(tJoueurs[joueurMaxScore].getVictoire() + 1);
            }

            for (int i=1; i<tJoueurs.length;i++){
                tJoueurs[i].tLes2Cartes.clear();
                tJoueurs[i].setScore(0);
            }
        }

/*      System.out.println("Tableau de compteurs : ");
        for (int i=0; i<tCompteurs.length; i++){
            System.out.print(tCompteurs[i]+" ");
        }*/

        //Affiche les probabilités recherchées
        int victoiresAdversaires=0;
        for (int i=1; i<tJoueurs.length;i++){
            victoiresAdversaires+=tJoueurs[i].getVictoire();
        }

        for (int i=0; i<tProba.length-2;i++){
            tProba[i]=(tCompteurs[i]/(float) nbTirages)*100;
        }
        tProba[9]=(tJoueurs[0].getVictoire()/(float)nbTirages)*100;
        tProba[10]=(victoiresAdversaires/(float)nbTirages)*100;

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

        System.out.println("Probabilité de gagner : "+(tJoueurs[0].getVictoire()/(float)nbTirages)*100+"%");
        System.out.println("Probabilité de perdre : "+(victoiresAdversaires/(float)nbTirages)*100+"%");

        return tProba;
    }

}
