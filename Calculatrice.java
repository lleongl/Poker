import java.util.ArrayList;
import java.util.LinkedList;

public class Calculatrice {
    public float[] lancerCalcul(int x,  ArrayList <Carte> Hand, ArrayList <Carte> River) {
        int nbAdversaires = x-1;
        int nbTirages = 10000;
        int [] tCompteurs= new int [9];
        float[] tProba= new float[11];
        Joueur [] tJoueurs= new Joueur[nbAdversaires+1];
        boolean egalite;
        int cartesDevoilees=0;

        //crée le tableau de joueurs
        for (int n=0; n<tJoueurs.length;n++){
            tJoueurs[n]=new Joueur();
        }

        //établit les 2 cartes initiales du joueur
        tJoueurs[0].tLes2Cartes.add(Hand.get(0));
        tJoueurs[0].tLes2Cartes.add(Hand.get(1));

        LinkedList<Carte> les5Cartes = new LinkedList<>();
        //cartes dévoilées
        for (int n=0; n< River.size();n++){
            if (River.get(n).getValeur()!=-1) {
                les5Cartes.add(River.get(n));
                cartesDevoilees++;
            }
        }

        for (int k = 0; k < nbTirages; k++) {
            egalite=false;
            //création deck trié
            Deck paquet = new Deck();
            //melange du paquet
            paquet.contenu = paquet.melangePaquet();
            paquet.removeCard(tJoueurs[0].tLes2Cartes.get(0).getValeur(), tJoueurs[0].tLes2Cartes.get(0).getCouleur());
            paquet.removeCard(tJoueurs[0].tLes2Cartes.get(1).getValeur(), tJoueurs[0].tLes2Cartes.get(1).getCouleur());

            for (int n=0; n< les5Cartes.size();n++) {
                paquet.removeCard(River.get(n).getValeur(), (River.get(n).getCouleur()));
            }

            //distribution des cartes aux adversaires
            paquet.distribution(tJoueurs, nbAdversaires);

            //tirage des 5 cartes
            paquet.tirage(les5Cartes);

            //regroupement des 2 cartes des joueurs et de celles sur la table
            for (int i=0; i<tJoueurs.length;i++){
                tJoueurs[i].les7Cartes=new Les7Cartes(les5Cartes, tJoueurs[i].tLes2Cartes);
            }

            //Opération de la chaine de test

            for (int p=0; p<nbAdversaires+1;p++) {
                tJoueurs[p].les7Cartes.chaineTest(tCompteurs, tJoueurs, p);
            }

            int joueurMaxScore=0;
            float maxScore=0;
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

            for (int i=0; i<River.size()-cartesDevoilees;i++){
                les5Cartes.remove(les5Cartes.size()-1);
            }
        }

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

        float total=0;
        for (int n=0; n<9;n++){
            total+=(tCompteurs[n]/(float) nbTirages)*100;
        }
        System.out.println("total :" +total);

        return tProba;
    }

}
