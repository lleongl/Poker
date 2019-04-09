import sun.awt.image.ImageWatched;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;

public class Les7Cartes {
    ArrayList<Carte> tLes7Cartes = new ArrayList<>();
    long compteur;
    int compteurBrelan = 0;
    int compteurPaire = 0;
    int compteurCouleur = 0;
    boolean suiteAS5 = false;
    char[] compteurValChar;
    boolean meilleureMain = false;

    public Les7Cartes(LinkedList<Carte> les5Cartes, ArrayList<Carte> tLes2Cartes) {
        //regroupe les 2Cartes et les 5Cartes dans tLes7Cartes
        for (int i = 0; i < les5Cartes.size() + tLes2Cartes.size(); i++) {
            if (i < tLes2Cartes.size()) {
                tLes7Cartes.add(tLes2Cartes.get(i));
            } else {
                tLes7Cartes.add(les5Cartes.get(i - tLes2Cartes.size()));
            }
        }
        //récupère le compteur propre à chaque ensemble de 7Cartes pour l'utiliser dans les tests de combinaison
        this.getCompteur();
    }

    public void chaineTest(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        //tests pour la Quinte Flush
        this.quinteFlush(tCompteurs, tJoueurs, p);

        //tests pour le Carre
        if (!meilleureMain) {
            this.carre(tCompteurs, tJoueurs, p);
        }

        //tests pour le Full
        if (!meilleureMain) {
            this.full(tCompteurs, tJoueurs, p);
        }

        //tests pour la Couleur
        if (!meilleureMain) {
            this.couleur(tCompteurs, tJoueurs, p);
        }

        //tests pour la Suite
        if (!meilleureMain) {
            this.suite(tCompteurs, tJoueurs, p);
        }

        //tests pour le Brelan
        if (!meilleureMain) {
            this.brelan(tCompteurs, tJoueurs, p);
        }

        //tests pour la Double Paire
        if (!meilleureMain) {
            this.doublePaire(tCompteurs, tJoueurs, p);
        }


        //tests pour la Paire
        if (!meilleureMain) {
            this.paire(tCompteurs, tJoueurs, p);
        }

        //tests pour la Carte Haute
        if (!meilleureMain) {
            this.carteHaute(tCompteurs, tJoueurs, p);
        }

    }

    public void testEgalite(Joueur[] tJoueurs, int joueurMaxScore, int i) {

        //Egalite carte haute
        if (tJoueurs[i].getScore() == 1) {
            this.egaliteCarteHaute(tJoueurs, joueurMaxScore, i);
        }

        //egalite paire
        if (tJoueurs[i].getScore() == 2) {
            this.egalitePaire(tJoueurs, joueurMaxScore, i);
        }

        //egalite double Paire
        if (tJoueurs[i].getScore() == 3) {
            this.egaliteDoublePaire(tJoueurs, joueurMaxScore, i);
        }

        //egalite Brelan
        if (tJoueurs[i].getScore() == 4) {
            this.egaliteBrelan(tJoueurs, joueurMaxScore, i);
        }

        //egalite Suite
        if (tJoueurs[i].getScore() == 5) {
            this.egaliteSuite(tJoueurs, joueurMaxScore, i);
        }

        //egalite Couleur
        if (tJoueurs[i].getScore() == 6) {
            this.egaliteCouleur(tJoueurs, joueurMaxScore, i);
        }

        //egalite Full
        if (tJoueurs[i].getScore() == 7) {
            this.egaliteFull(tJoueurs, joueurMaxScore, i);
        }

        //egalite Carre
        if (tJoueurs[i].getScore() == 8) {
            this.egaliteCarre(tJoueurs, joueurMaxScore, i);

        }

        //egalite Quinte Flush
        if (tJoueurs[i].getScore() == 9) {
            this.egaliteQuinteFlush(tJoueurs, joueurMaxScore, i);
        }
    }

    public void getCompteur() {
        for (Carte c : tLes7Cartes) {
            int val = c.getValeur();
            this.compteur += Math.pow(10, val);
        }
    }

    //valeurs du compteur stockées dans un tableau
    public void getCompteurValChar() {
        String t;
        t = this.compteur + "";
        this.compteurValChar = t.toCharArray();
    }

    //crée un tableau permettant de récupérer les couleurs des 7 Cartes
    public char[] getStockageCouleurChar() {
        int stockageCouleur = 0;
        char[] stockageCouleurChar;
        int val = 0;

        for (Carte c : tLes7Cartes) {
            String couleur = c.getCouleur();
            switch (couleur) {
                case "spades":
                    val = 0;
                    break;
                case "diamonds":
                    val = 1;
                    break;
                case "hearts":
                    val = 2;
                    break;
                case "clubs":
                    val = 3;
                    break;
            }
            stockageCouleur += Math.pow(10, val);
        }
        String t = stockageCouleur + "";
        stockageCouleurChar = t.toCharArray();
        return stockageCouleurChar;
    }

    public int valeurBrelan() {
        int valeurBrelan = 0;
        for (int k = 0; k < this.compteurValChar.length; k++) {
            if (this.compteurValChar[k] == '3') {
                valeurBrelan = this.compteurValChar.length - k - 1;
                break;
            }
        }
        return valeurBrelan;
    }

    public int valeurPaire() {
        int valeurPaire = 0;
        for (int k = 0; k < this.compteurValChar.length; k++) {
            if (this.compteurValChar[k] == '2') {
                valeurPaire = this.compteurValChar.length - k - 1;
                break;
            }
        }
        return valeurPaire;
    }

    public int[] getMaxVal(int nbCartes, int combinaisonValeur){
        Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
        int [] maxVal=new int[nbCartes];
        int i=0;
        for (Carte c : this.tLes7Cartes) {
            if (c.getValeur() != combinaisonValeur) {
                maxVal[i]=c.getValeur();
                i++;
            }
            if (i==nbCartes){
                break;
            }
        }
        return maxVal;
    }

    public LinkedList<Carte> getCartesMemeCouleur() {
        LinkedList<Carte> cartesMemeCouleur = new LinkedList<>();
        char[] stockageCouleurChar;
        String couleur = null;
        stockageCouleurChar = getStockageCouleurChar();

        //Vérifie s'il y a une couleur et récupère la couleur correspondante le cas échéant
        for (int j = 0; j < stockageCouleurChar.length; j++) {
            if (stockageCouleurChar[j] == '5' || stockageCouleurChar[j] == '6' || stockageCouleurChar[j] == '7') {
                compteurCouleur++;
                if (((stockageCouleurChar.length) - j) == 1) {
                    couleur = "spades";
                }
                if (((stockageCouleurChar.length) - j) == 2) {
                    couleur = "diamonds";
                }
                if (((stockageCouleurChar.length) - j) == 3) {
                    couleur = "hearts";
                }
                if (((stockageCouleurChar.length) - j) == 4) {
                    couleur = "clubs";
                }
                break;
            }
        }

        //stocke les cartes ayant la même couleur
        for (Carte c : tLes7Cartes) {
            if (c.getCouleur() == couleur) {
                cartesMemeCouleur.add(c);
            }
        }
        return cartesMemeCouleur;
    }


    public void quinteFlush(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        LinkedList<Carte> cartesMemeCouleur = getCartesMemeCouleur();
        char[] compteurValCharQF;
        long compteurQF = 0;

        //crée un compteur de valeurs des cartes de même couleur
        for (Carte c : cartesMemeCouleur) {
            int val = c.getValeur();
            compteurQF += Math.pow(10, val);
        }

        String t = compteurQF + "";
        compteurValCharQF = t.toCharArray();

        //Vérifie si les cartes de meme couleur ont des valeurs qui se suivent
        for (int k = 0; k < compteurValCharQF.length - 5; k++) {
            if (compteurValCharQF[k] != '0' && compteurValCharQF[k + 1] != '0' && compteurValCharQF[k + 2] != '0' && compteurValCharQF[k + 3] != '0' && compteurValCharQF[k + 4] != '0') {
                if (p == 0) {
                    tCompteurs[0]++;
                }
                tJoueurs[p].setScore(9);
                meilleureMain = true;
                break;
            }
        }

        //cas particulier de la QF de as à 5
        if (!meilleureMain) {
            if (compteurValCharQF.length == 15) {
                if (compteurValCharQF[0] != '0' && compteurValCharQF[9] != '0' && compteurValCharQF[10] != '0' && compteurValCharQF[11] != '0' && compteurValCharQF[12] != '0') {
                    if (p == 0) {
                        tCompteurs[0]++;
                    }
                    tJoueurs[p].setScore(9);
                    meilleureMain = true;
                }
            }
        }
    }


    public void carre(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        this.getCompteurValChar();

        //Vérifie si 4 cartes de même valeur sont dans les7Cartes
        for (int k = 0; k < compteurValChar.length; k++) {
            if (compteurValChar[k] == '4') {
                if (p == 0) {
                    tCompteurs[1]++;
                }
                tJoueurs[p].setScore(8);
                meilleureMain = true;
            }
        }
    }

    public void full(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        //Vérifie s'il y a 3 cartes ayant une même valeur et 2 autres cartes ayant une même valeur (différentes de celle des 3 cartes)
        for (int k = 0; k < compteurValChar.length; k++) {
            if (compteurValChar[k] == '3') {
                compteurBrelan++;
            }
            if (compteurValChar[k] == '2') {
                compteurPaire++;
            }
        }
        if ((compteurBrelan > 0 && compteurPaire > 0) || compteurBrelan == 2) {
            if (p == 0) {
                tCompteurs[2]++;
            }
            tJoueurs[p].setScore(7);
            meilleureMain = true;
        }
    }

    public void couleur(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        if (compteurCouleur > 0) {
            if (p == 0) {
                tCompteurs[3]++;
            }
            tJoueurs[p].setScore(6);
            meilleureMain = true;
        }
    }

    public void suite(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        for (int k = 0; k < compteurValChar.length - 5; k++) {
            if (compteurValChar[k] != '0' && compteurValChar[k + 1] != '0' && compteurValChar[k + 2] != '0' && compteurValChar[k + 3] != '0' && compteurValChar[k + 4] != '0') {
                if (p == 0) {
                    tCompteurs[4]++;
                }
                tJoueurs[p].setScore(5);
                meilleureMain = true;
                break;
            }
        }

        //cas particulier de la suite de As à 5
        if (!meilleureMain) {
            if (compteurValChar.length == 15) {
                if (compteurValChar[0] != '0' && compteurValChar[9] != '0' && compteurValChar[10] != '0' && compteurValChar[11] != '0' && compteurValChar[12] != '0') {
                    if (p == 0) {
                        tCompteurs[4]++;
                    }
                    suiteAS5 = true;
                    tJoueurs[p].setScore(5);
                    meilleureMain = true;
                }
            }
        }
    }

    public void brelan(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        if (compteurBrelan > 0) {
            if (p == 0) {
                tCompteurs[5]++;
            }
            tJoueurs[p].setScore(4);
            meilleureMain = true;
        }
    }

    public void doublePaire(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        if (compteurPaire > 1) {
            if (p == 0) {
                tCompteurs[6]++;
            }
            tJoueurs[p].setScore(3);
            meilleureMain = true;
        }
    }

    public void paire(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        if (compteurPaire > 0) {
            if (p == 0) {
                tCompteurs[7]++;
            }
            tJoueurs[p].setScore(2);
            meilleureMain = true;
        }
    }

    public void carteHaute(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        if (p == 0) {
            tCompteurs[8]++;
        }
        tJoueurs[p].setScore(1);
    }

    public void egaliteQuinteFlush(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        int QFHauteur1;
        int QFHauteur2;
        LinkedList<Carte> cartesMemeCouleur1 = this.getCartesMemeCouleur();
        LinkedList<Carte> cartesMemeCouleur2 = tJoueurs[joueurMaxScore].les7Cartes.getCartesMemeCouleur();

        Collections.sort(cartesMemeCouleur1, Collections.reverseOrder());
        Collections.sort(cartesMemeCouleur2, Collections.reverseOrder());

        if (cartesMemeCouleur1.get(0).getValeur() != 14) {
            QFHauteur1 = cartesMemeCouleur1.get(0).getValeur();
        } else QFHauteur1 = cartesMemeCouleur1.get(1).getValeur();

        if (cartesMemeCouleur2.get(0).getValeur() != 14) {
            QFHauteur2 = cartesMemeCouleur2.get(0).getValeur();
        } else QFHauteur2 = cartesMemeCouleur2.get(1).getValeur();

        if (QFHauteur1 > QFHauteur2) {
            tJoueurs[i].setScore(9.5);
            tJoueurs[joueurMaxScore].setScore(9);
        }
        if (QFHauteur1 < QFHauteur2) {
            tJoueurs[joueurMaxScore].setScore(9.5);
        }
    }

    public void egaliteCarre(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        int carreVal1 = 0;
        int carreVal2 = 0;

        for (int k = 0; k < this.compteurValChar.length; k++) {
            if (this.compteurValChar[k] == '4') {
                carreVal1 = this.compteurValChar.length - k - 1;
                break;
            }
        }
        for (int k = 0; k < tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length; k++) {
            if (tJoueurs[joueurMaxScore].les7Cartes.compteurValChar[k] == '4') {
                carreVal2 = tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length - k - 1;
                break;
            }
        }

        if (carreVal1 > carreVal2) {
            tJoueurs[i].setScore(8.5);
            tJoueurs[joueurMaxScore].setScore(8);
        }
        if (carreVal1 < carreVal2) {
            tJoueurs[joueurMaxScore].setScore(8.5);
        } else {
            int maxVal1 = this.getMaxVal(1, carreVal1)[0];
            int maxVal2 = tJoueurs[joueurMaxScore].les7Cartes.getMaxVal(1, carreVal1)[0];

            if (maxVal1 > maxVal2) {
                tJoueurs[i].setScore(8.5);
                tJoueurs[joueurMaxScore].setScore(8);
            }
            if (maxVal1 < maxVal2) {
                tJoueurs[joueurMaxScore].setScore(8.5);
            }
        }
    }

    public void egaliteFull(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        int brelanVal1 = this.valeurBrelan();
        int brelanVal2 = tJoueurs[joueurMaxScore].les7Cartes.valeurBrelan();

        if (brelanVal1 == brelanVal2) {
            int paireVal1 = this.valeurPaire();
            int paireVal2 = tJoueurs[joueurMaxScore].les7Cartes.valeurPaire();

            if (paireVal1 > paireVal2) {
                tJoueurs[i].setScore(7.5);
                tJoueurs[joueurMaxScore].setScore(7);
            }
            if (paireVal1 < paireVal2) {
                tJoueurs[joueurMaxScore].setScore(7);
            }
        } else {
            if (brelanVal1 > brelanVal2) {
                tJoueurs[i].setScore(7.5);
                tJoueurs[joueurMaxScore].setScore(7);
            }
            if (brelanVal1 < brelanVal2) {
                tJoueurs[joueurMaxScore].setScore(7.5);
            }
        }
    }

    public void egaliteCouleur(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        LinkedList<Carte> cartesMemeCouleur1 = this.getCartesMemeCouleur();
        LinkedList<Carte> cartesMemeCouleur2 = tJoueurs[joueurMaxScore].les7Cartes.getCartesMemeCouleur();
        Collections.sort(cartesMemeCouleur1, Collections.reverseOrder());
        Collections.sort(cartesMemeCouleur2, Collections.reverseOrder());

        for (int j = 0; j < 5; j++) {
            if (cartesMemeCouleur1.get(j).getValeur() > cartesMemeCouleur2.get(j).getValeur()) {
                tJoueurs[i].setScore(6.5);
                tJoueurs[joueurMaxScore].setScore(6);
                break;
            }
            if (cartesMemeCouleur1.get(j).getValeur() < cartesMemeCouleur2.get(j).getValeur()) {
                tJoueurs[joueurMaxScore].setScore(6.5);
                break;
            }
        }
    }

    public void egaliteSuite(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        int suiteHauteur1 = 0;
        int suiteHauteur2 = 0;
        Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
        Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

        if (this.suiteAS5) {
            suiteHauteur1 = 5;
        }
        if (!this.suiteAS5) {
            for (int k = 0; k < compteurValChar.length - 5; k++) {
                if (compteurValChar[k] != '0' && compteurValChar[k + 1] != '0' && compteurValChar[k + 2] != '0' && compteurValChar[k + 3] != '0' && compteurValChar[k + 4] != '0') {
                    suiteHauteur1 = this.compteurValChar.length - k - 1;
                    break;
                }
            }
        }

        if (tJoueurs[joueurMaxScore].les7Cartes.suiteAS5) {
            suiteHauteur2 = 5;
        }
        if (!tJoueurs[joueurMaxScore].les7Cartes.suiteAS5) {
            for (int k = 0; k < tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length - 5; k++) {
                if (tJoueurs[joueurMaxScore].les7Cartes.compteurValChar[k] != '0' && tJoueurs[joueurMaxScore].les7Cartes.compteurValChar[k + 1] != '0' && tJoueurs[joueurMaxScore].les7Cartes.compteurValChar[k + 2] != '0' && tJoueurs[joueurMaxScore].les7Cartes.compteurValChar[k + 3] != '0' && tJoueurs[joueurMaxScore].les7Cartes.compteurValChar[k + 4] != '0') {
                    suiteHauteur2 = tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length - k - 1;
                    break;
                }
            }
        }

        if (suiteHauteur1 > suiteHauteur2) {
            tJoueurs[i].setScore(5.5);
            tJoueurs[joueurMaxScore].setScore(5);
        }
        if (suiteHauteur1 < suiteHauteur2) {
            tJoueurs[joueurMaxScore].setScore(5.5);
        }
    }

    public void egaliteBrelan(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        int brelanVal1 = this.valeurBrelan();
        int brelanVal2 = tJoueurs[joueurMaxScore].les7Cartes.valeurBrelan();

        if (brelanVal1 > brelanVal2) {
            tJoueurs[i].setScore(4.5);
            tJoueurs[joueurMaxScore].setScore(4);
        }
        if (brelanVal1 < brelanVal2) {
            tJoueurs[joueurMaxScore].setScore(4.5);
        } else {
            int [] maxVal1=this.getMaxVal(2,brelanVal1);
            int [] maxVal2=tJoueurs[joueurMaxScore].les7Cartes.getMaxVal(2,brelanVal1);
            for(int j=0; j< maxVal1.length;j++) {
                if (maxVal1[j] > maxVal2[j]) {
                    tJoueurs[i].setScore(8.5);
                    tJoueurs[joueurMaxScore].setScore(8);
                    break;
                }
                if (maxVal1[j] < maxVal2[j]) {
                    tJoueurs[joueurMaxScore].setScore(8.5);
                    break;
                }
            }
        }
    }

    public void egaliteDoublePaire(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        boolean egalite1 = false;
        boolean egalite2 = false;
        int comparaison;
        int j = 0;

        int cartesEgales = 4;
        Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
        Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

        int index1 = 0;
        int index2 = 0;
        int compteurPaire = 0;
        for (int k = 0; k < this.compteurValChar.length; k++) {
            if (this.compteurValChar[k] == '2') {
                if (compteurPaire == 0) {
                    index1 = k;
                    compteurPaire++;
                }
                if (compteurPaire == 1) {
                    index2 = k;
                }
            }
        }
        int paire1Val1 = this.compteurValChar.length - index1 - 1;
        int paire2Val1 = this.compteurValChar.length - index2 - 1;

        compteurPaire = 0;
        for (int k = 0; k < tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length; k++) {
            if (tJoueurs[joueurMaxScore].les7Cartes.compteurValChar[k] == '2') {
                if (compteurPaire == 1) {
                    index2 = k;
                }
                if (compteurPaire == 0) {
                    index1 = k;
                    compteurPaire++;
                }

            }
        }
        int paire1Val2 = tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length - index1 - 1;
        int paire2Val2 = tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length - index2 - 1;

        if (paire1Val1 == paire1Val2) {
            egalite1 = true;
        }
        if (paire2Val1 == paire2Val2) {
            egalite2 = true;
        }

        if (egalite1 && egalite2) {
            do {
                comparaison = this.tLes7Cartes.get(j).compareTo(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.get(j));
                switch (comparaison) {
                    case 1:
                        tJoueurs[i].setScore(3.5);
                        tJoueurs[joueurMaxScore].setScore(3);
                        break;
                    case -1:
                        tJoueurs[i].setScore(2.5);
                        break;
                    case 0:
                        if (this.tLes7Cartes.get(j).getValeur() != paire1Val1 && this.tLes7Cartes.get(j).getValeur() != paire2Val1) {
                            cartesEgales++;
                        }
                }
                j++;
            } while (comparaison == 0 && cartesEgales != 5);
        }

        if (!egalite1) {
            if (paire1Val1 > paire1Val2) {
                tJoueurs[i].setScore(3.5);
                tJoueurs[joueurMaxScore].setScore(3);
            } else {
                tJoueurs[i].setScore(2.5);
            }
            egalite2 = true;
        }
        if (!egalite2) {
            if (paire2Val1 > paire2Val2) {
                tJoueurs[i].setScore(3.5);
            } else {
                tJoueurs[i].setScore(2.5);
            }
        }
    }

    public void egalitePaire(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        boolean egalite1 = false;
        int comparaison;
        int j = 0;

        int cartesEgales = 2;
        Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
        Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

        int index = 0;
        for (int k = 0; k < this.compteurValChar.length; k++) {
            if (this.compteurValChar[k] == '2') {
                index = k;
                break;
            }
        }
        int paireVal1 = this.compteurValChar.length - index - 1;

        for (int k = 0; k < tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length; k++) {
            if (tJoueurs[joueurMaxScore].les7Cartes.compteurValChar[k] == '2') {
                index = k;
                break;
            }
        }
        int paireVal2 = tJoueurs[joueurMaxScore].les7Cartes.compteurValChar.length - index - 1;

        if (paireVal1 == paireVal2) {
            egalite1 = true;
        }

        if (egalite1 == true) {
            do {
                comparaison = this.tLes7Cartes.get(j).compareTo(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.get(j));
                switch (comparaison) {
                    case 1:
                        tJoueurs[i].setScore(2.5);
                        tJoueurs[joueurMaxScore].setScore(2);
                        break;
                    case -1:
                        tJoueurs[i].setScore(1.5);
                        break;
                    case 0:
                        if (this.tLes7Cartes.get(j).getValeur() != paireVal1) {
                            cartesEgales++;
                        }
                }
                j++;
            } while (comparaison == 0 && cartesEgales != 5);
        } else {
            if (paireVal1 > paireVal2) {
                tJoueurs[i].setScore(2.5);
                tJoueurs[joueurMaxScore].setScore(2);
            } else {
                tJoueurs[i].setScore(1.5);
            }
        }
    }

    public void egaliteCarteHaute(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        int j = 0;
        int comparaison;

        int cartesEgales = 0;
        Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
        Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());
        do {
            comparaison = this.tLes7Cartes.get(j).compareTo(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.get(j));
            switch (comparaison) {
                case 1:
                    tJoueurs[i].setScore(1.5);
                    tJoueurs[joueurMaxScore].setScore(1);
                    break;
                case -1:
                    tJoueurs[i].setScore(0.5);
                    break;
                case 0:
                    cartesEgales++;
            }
            j++;
        } while (comparaison == 0 && cartesEgales != 5);

    }
}
