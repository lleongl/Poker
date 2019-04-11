import java.util.ArrayList;
import java.util.LinkedList;

public class Calculatrice {
    public float[] lancerCalcul(int x, ArrayList<Carte> Hand, ArrayList<Carte> River) {
        int nbAdversaires = x - 1;
        int nbTirages = 10000;
        int[] tCompteurs = new int[9];
        float[] tProba = new float[11];
        Joueur[] tJoueurs = new Joueur[nbAdversaires + 1];
        boolean egalite;
        int cartesDevoilees = 0;
        int defaites=0;

        //crée le tableau de joueurs
        for (int n = 0; n < tJoueurs.length; n++) {
            tJoueurs[n] = new Joueur();
        }

        //création deck trié
        Deck paquet = new Deck();

        //établit les 2 cartes initiales du joueur
        tJoueurs[0].les2Cartes.add(Hand.get(0));
        tJoueurs[0].les2Cartes.add(Hand.get(1));

        LinkedList<Carte> les5Cartes = new LinkedList<>();
        //remplit le tableau des 5 cartes par les cartes que le joueur a choisi
        for (int n = 0; n < River.size(); n++) {
            if (River.get(n).getValeur() != -1) {
                les5Cartes.add(River.get(n));
                cartesDevoilees++;
            }
        }
        //enleve du paquet les cartes présentes sur la table
        for (int n = 0; n < les5Cartes.size(); n++) {
            paquet.removeCard(les5Cartes.get(n).getValeur(), (les5Cartes.get(n).getCouleur()));
        }

        //calculs effectués nbTirages fois
        for (int k = 0; k < nbTirages; k++) {
            egalite = false;

            paquet.removeCard(tJoueurs[0].les2Cartes.get(0).getValeur(), tJoueurs[0].les2Cartes.get(0).getCouleur());
            paquet.removeCard(tJoueurs[0].les2Cartes.get(1).getValeur(), tJoueurs[0].les2Cartes.get(1).getCouleur());

            //distribution des cartes aux adversaires
            paquet.distribution(tJoueurs, nbAdversaires);

            //tirage du reste des 5 cartes
            paquet.tirage(les5Cartes);

            //regroupement des 2 cartes des joueurs et de celles sur la table
            for (int i = 0; i < tJoueurs.length; i++) {
                tJoueurs[i].les7Cartes = new Les7Cartes(les5Cartes, tJoueurs[i].les2Cartes);
            }

            //Opération de la chaine de test
            for (int p = 0; p < tJoueurs.length; p++) {
                tJoueurs[p].les7Cartes.chaineTest(tCompteurs, tJoueurs, p);
            }

            //Gestion des égalités
            LinkedList<Joueur> joueursMaxScore = new LinkedList<>();
            joueursMaxScore.add(tJoueurs[0]);
            for (int i = 1; i < tJoueurs.length; i++) {
                if (tJoueurs[i].getScore() == joueursMaxScore.get(0).getScore() || tJoueurs[i].getScore() == joueursMaxScore.get(0).getScore() - 0.5) {
                    tJoueurs[i].les7Cartes.testEgalite(tJoueurs, joueursMaxScore, i);
                }
                if (tJoueurs[i].getScore()>joueursMaxScore.get(0).getScore()){
                    joueursMaxScore.clear();
                    joueursMaxScore.add(tJoueurs[i]);
                }
            }

            if (joueursMaxScore.size() > 1) {
                egalite = true;
            }

            if (!joueursMaxScore.contains(tJoueurs[0])){
                defaites++;
            }

            if (!egalite) {
                joueursMaxScore.get(0).setVictoire(joueursMaxScore.get(0).getVictoire() + 1);
            }

            //remet les cartes des adversaires dans le paquet et réinitialise les 2 cartes de chaque adversaire
            for (int i = 1; i < tJoueurs.length; i++) {
                paquet.contenu.add(tJoueurs[i].les2Cartes.get(0));
                paquet.contenu.add(tJoueurs[i].les2Cartes.get(1));
                tJoueurs[i].les2Cartes.clear();
                tJoueurs[i].setScore(0);
            }

            //enleve les cartes tirées au hasard pour les5Cartes et les remet dans le paquet, tout en conservant celles sélectionnées par l'utilisateur
            for (int i = cartesDevoilees; i < 5; i++) {
                paquet.contenu.add(les5Cartes.get(cartesDevoilees));
                les5Cartes.remove(les5Cartes.get(cartesDevoilees));
            }

        }

        //calcule les probabilités de victoire et de défaite
        for (int i = 0; i < tCompteurs.length; i++) {
            tProba[i] = (tCompteurs[i] / (float) nbTirages) * 100;
        }

        tProba[9] = (tJoueurs[0].getVictoire() / (float) nbTirages) * 100;
        tProba[10] = (defaites / (float) nbTirages) * 100;

        return tProba;
    }

}
