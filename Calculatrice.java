import java.util.ArrayList;
import java.util.LinkedList;

public class Calculatrice {
    public float[] lancerCalcul(int x,  ArrayList <Carte> Hand, ArrayList <Carte> River) {
        int nbAdversaires = x-1;
        int nbTirages = 100000;
        int [] tCompteurs= new int [9];
        float[] tProba= new float[11];
        Joueur [] tJoueurs= new Joueur[nbAdversaires+1];
        boolean egalite;
        int cartesDevoilees=0;

        //crée le tableau de joueurs
        for (int n=0; n<tJoueurs.length;n++){
            tJoueurs[n]=new Joueur();
        }

        //création deck trié
        Deck paquet = new Deck();

        //établit les 2 cartes initiales du joueur
        tJoueurs[0].tLes2Cartes.add(Hand.get(0));
        tJoueurs[0].tLes2Cartes.add(Hand.get(1));

        LinkedList<Carte> les5Cartes = new LinkedList<>();
        //remplit le tableau des 5 cartes par les cartes que le joueur a choisi
        for (int n=0; n< River.size();n++){
            if (River.get(n).getValeur()!=-1) {
                les5Cartes.add(River.get(n));
                cartesDevoilees++;
            }
        }

        //calculs effectués nbTirages fois
        for (int k = 0; k < nbTirages; k++) {
            egalite=false;

            paquet.removeCard(tJoueurs[0].tLes2Cartes.get(0).getValeur(), tJoueurs[0].tLes2Cartes.get(0).getCouleur());
            paquet.removeCard(tJoueurs[0].tLes2Cartes.get(1).getValeur(), tJoueurs[0].tLes2Cartes.get(1).getCouleur());

            //enleve du paquet les cartes présentes sur la table
            for (int n=0; n< les5Cartes.size();n++) {
                paquet.removeCard(River.get(n).getValeur(), (River.get(n).getCouleur()));
            }

            //distribution des cartes aux adversaires
            paquet.distribution(tJoueurs, nbAdversaires);

            //tirage du reste des 5 cartes
            paquet.tirage(les5Cartes);

            //regroupement des 2 cartes des joueurs et de celles sur la table
            for (int i=0; i<tJoueurs.length;i++){
                tJoueurs[i].les7Cartes=new Les7Cartes(les5Cartes, tJoueurs[i].tLes2Cartes);
            }

            //Opération de la chaine de test
            for (int p=0; p<tJoueurs.length;p++) {
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

            //remet les cartes des adversaires dans le paquet et réinitialise les 2 cartes de chaque adversaire
            for (int i=1; i<tJoueurs.length;i++){
                paquet.contenu.add(tJoueurs[i].tLes2Cartes.get(0));
                paquet.contenu.add(tJoueurs[i].tLes2Cartes.get(1));
                tJoueurs[i].tLes2Cartes.clear();
                tJoueurs[i].setScore(0);
            }

            //enleve les cartes tirées au hasard pour les5Cartes et les remet dans le paquet, tout en conservant celles sélectionnées par l'utilisateur
            for (int i=0; i<River.size()-cartesDevoilees;i++){
                paquet.contenu.add(les5Cartes.get(les5Cartes.size()-1));
                les5Cartes.remove(les5Cartes.size()-1);
            }


        }

        //calcule les probabilités de victoire et de défaite
        int victoiresAdversaires=0;
        for (int i=1; i<tJoueurs.length;i++){
            victoiresAdversaires+=tJoueurs[i].getVictoire();
        }

        for (int i=0; i<tProba.length-2;i++){
            tProba[i]=(tCompteurs[i]/(float) nbTirages)*100;
        }
        tProba[9]=(tJoueurs[0].getVictoire()/(float)nbTirages)*100;
        tProba[10]=(victoiresAdversaires/(float)nbTirages)*100;

        return tProba;
    }

}
