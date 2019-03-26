import java.util.Collections;
import java.util.LinkedList;

public class Les7Cartes {
    LinkedList<Carte> tLes7Cartes = new LinkedList<>();
    private long compteur;

    public Les7Cartes(LinkedList<Carte> tLes5Cartes, LinkedList<Carte> tLes2Cartes) {
        for (int i = 0; i < tLes5Cartes.size() + tLes2Cartes.size(); i++) {
            if (i < tLes2Cartes.size()) {
                tLes7Cartes.add(tLes2Cartes.get(i));
            } else {
                tLes7Cartes.add(tLes5Cartes.get(i - tLes2Cartes.size()));
            }
        }
        long compteur = 0;
        for (int j = 0; j < this.tLes7Cartes.size(); j++) {
            int val = this.tLes7Cartes.get(j).getValeur();
            compteur += Math.pow(10, val);
        }
    }

    public void chaineTest(int[] tCompteurs, Joueur[] tJoueurs, int p) {
        boolean meilleureMain = false;
        char[] compteurValChar;
        char[] compteurCouleurChar;
        int[] compteurValInt;

        //tests pour la Quinte Flush
        int compteurCouleur = 0;
        int chiffreCouleur = 0;
        String couleur = null;
        LinkedList<Carte> cartesCouleur = new LinkedList<>();

        compteurCouleurChar = getCompteurCouleurChar();
        for (int j = 0; j < compteurCouleurChar.length; j++) {
            if (compteurCouleurChar[j] == '5' || compteurCouleurChar[j] == '6' || compteurCouleurChar[j] == '7') {
                chiffreCouleur = (compteurCouleurChar.length) - j;
                compteurCouleur++;
            }
        }
        if (compteurCouleur == 1) {
            switch (chiffreCouleur) {
                case 1:
                    couleur = "Pique";
                    break;
                case 2:
                    couleur = "Carreau";
                    break;
                case 3:
                    couleur = "Coeur";
                    break;
                case 4:
                    couleur = "Trefle";
                    break;
            }
            for (int i = 0; i < this.tLes7Cartes.size(); i++) {
                if (this.tLes7Cartes.get(i).getCouleur() == couleur) {
                    cartesCouleur.add(tLes7Cartes.get(i));
                }
            }

            long compteur = 0;
            String t;

            for (int j = 0; j < cartesCouleur.size(); j++) {
                int val = cartesCouleur.get(j).getValeur();
                compteur += Math.pow(10, val);
            }

//            System.out.println("compteur des cartes de meme couleur : "+compteur);

            //transforme en String le compteur (a changer)
            t = compteur + "";
            compteurValChar = t.toCharArray();
            compteurValInt = new int[compteurValChar.length];
            for (int i = 0; i < compteurValChar.length; i++) {
                compteurValInt[i] = compteurValChar[i] - '0';
            }
            for (int k = 0; k < compteurValInt.length - 4; k++) {
                if (compteurValInt[k] > 0 && compteurValInt[k + 1] > 0 && compteurValInt[k + 2] > 0 && compteurValInt[k + 3] > 0 && compteurValInt[k + 4] > 0) {
                    if (p == 0) {
                        tCompteurs[0]++;
                    }
                    tJoueurs[p].setScore(9);
                    meilleureMain = true;
                    break;
                }
            }
        }

        //tests pour le Carre
        if (!meilleureMain) {
            compteurValChar = getCompteurValChar();
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


        //tests pour le Full
        if (!meilleureMain) {
            int compteurBrelan = 0;
            int compteurPaire = 0;
            compteurValChar = getCompteurValChar();
            for (int k = 0; k < compteurValChar.length; k++) {
                if (compteurValChar[k] == '3') {
                    compteurBrelan++;
                }
                if (compteurValChar[k] == '2') {
                    compteurPaire++;
                }
            }
            if (compteurBrelan == 1 && compteurPaire == 1) {
                if (p == 0) {
                    tCompteurs[2]++;
                }
                tJoueurs[p].setScore(7);
                meilleureMain = true;
            }
        }

        //tests pour la Couleur
        if (!meilleureMain) {
            compteurCouleurChar = getCompteurCouleurChar();
            for (int k = 0; k < compteurCouleurChar.length; k++) {
                if (compteurCouleurChar[k] == '5' || compteurCouleurChar[k] == '6' || compteurCouleurChar[k] == '7') {
                    if (p == 0) {
                        tCompteurs[3]++;
                    }
                    tJoueurs[p].setScore(6);
                    meilleureMain = true;
                }
            }
        }

        //tests pour la Suite
        if (!meilleureMain) {
            compteurValChar = getCompteurValChar();
            compteurValInt = new int[compteurValChar.length];
            for (int i = 0; i < compteurValChar.length; i++) {
                compteurValInt[i] = compteurValChar[i] - '0';
            }
            for (int k = 0; k < compteurValInt.length - 4; k++) {
                if (compteurValInt[k] > 0 && compteurValInt[k + 1] > 0 && compteurValInt[k + 2] > 0 && compteurValInt[k + 3] > 0 && compteurValInt[k + 4] > 0) {
                    if (p == 0) {
                        tCompteurs[4]++;
                    }
                    tJoueurs[p].setScore(5);
                    meilleureMain = true;
                    break;
                }

            }
        }

        //tests pour le Brelan
        if (!meilleureMain) {
            compteurValChar = getCompteurValChar();
            for (int k = 0; k < compteurValChar.length; k++) {
                if (compteurValChar[k] == '3') {
                    if (p == 0) {
                        tCompteurs[5]++;
                    }
                    tJoueurs[p].setScore(4);
                    meilleureMain = true;
                }

            }
        }

        //tests pour la Double Paire
        if (!meilleureMain) {
            int compteurPaire = 0;
            compteurValChar = getCompteurValChar();
            for (int k = 0; k < compteurValChar.length; k++) {
                if (compteurValChar[k] == '2') {
                    compteurPaire++;
                }
            }
            if (compteurPaire == 2 || compteurPaire == 3) {
                if (p == 0) {
                    tCompteurs[6]++;
                }
                tJoueurs[p].setScore(3);
                meilleureMain = true;
            }

        }


        //tests pour la Paire
        if (!meilleureMain) {
            compteurValChar = getCompteurValChar();
            for (int k = 0; k < compteurValChar.length; k++) {
                if (compteurValChar[k] == '2') {
                    if (p == 0) {
                        tCompteurs[7]++;
                    }
                    tJoueurs[p].setScore(2);
                    meilleureMain = true;
                }

            }
        }

        //tests pour la Carte Haute
        if (!meilleureMain) {
            if (p == 0) {
                tCompteurs[8]++;
            }
            tJoueurs[p].setScore(1);
        }

        //Affiche le compteur de valeur en char
/*        compteurValChar = getCompteurValChar();
        System.out.print("compteurValChar : ");
        for (int k = 0; k < compteurValChar.length; k++) {
            System.out.print(compteurValChar[k] + " ");
        }
        System.out.println();

        //Affiche le compteur de couleur
        compteurCouleurChar=getCompteurCouleurChar();
        System.out.print("compteurCouleurChar : ");
        for (int k = 0; k < compteurCouleurChar.length; k++) {
            System.out.print(compteurCouleurChar[k] + " ");
        }
        System.out.println();*/

//Affiche le compteur de valeur en entiers
/*      compteurValChar = getCompteurValChar();
        int [] compteurValInt=new int [compteurValChar.length];
        for (int i = 0; i < compteurValChar.length; i++) {
            compteurValInt[i]=compteurValChar[i]-'0';
        }
        System.out.print("compteurValInt : ");
        for (int k = 0; k < compteurValInt.length; k++) {
            System.out.print(compteurValInt[k] + " ");
        }
        System.out.println();*/
    }

    public void testEgalite(Joueur[] tJoueurs, int joueurMaxScore, int i) {
        boolean egalite1 = false;
        boolean egalite2 = false;
        int j = 0;
        int cartesEgales;
        int comparaison = 0;

        if (tJoueurs[i].getScore() == 1) {
			if (tJoueurs[i].compteur > tJoueurs[joueurMaxScore].compteur){
				tJoueurs[i].setScore(1.5);
                tJoueurs[joueurMaxScore].setScore(1);
            if (tJoueurs[i].compteur < tJoueurs[joueurMaxScore].compteur){
				tJoueurs[i].setScore(0.5);       
				

        //egalite paire

        if (tJoueurs[i].getScore() == 2) {
            cartesEgales = 2;
            Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
            Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

            char[] compteurValChar1 = getCompteurValChar();
            int index = 0;
            for (int k = 0; k < compteurValChar1.length; k++) {
                if (compteurValChar1[k] == '2') {
                    index = k;
                    break;
                }
            }
            int paireVal1 = compteurValChar1.length - index - 1;

            char[] compteurValChar2 = tJoueurs[joueurMaxScore].les7Cartes.getCompteurValChar();
            for (int k = 0; k < compteurValChar2.length; k++) {
                if (compteurValChar2[k] == '2') {
                    index = k;
                    break;
                }
            }
            int paireVal2 = compteurValChar2.length - index - 1;

            if (paireVal1 == paireVal2) {
                if (tJoueurs[i].compteur > tJoueurs[joueurMaxScore].compteur){
					tJoueurs[i].setScore(2.5);
					tJoueurs[joueurMaxScore].setScore(2);
				if (tJoueurs[i].compteur < tJoueurs[joueurMaxScore].compteur){
					tJoueurs[i].setScore(1.5);
        }

        //egalite double Paire
        
        if (tJoueurs[i].getScore() == 3) {
            cartesEgales = 4;
            Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
            Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

            char[] compteurValChar1 = getCompteurValChar();
            int index1 = 0;
            int index2 = 0;
            int compteurPaire = 0;
            for (int k = 0; k < compteurValChar1.length; k++) {
                if (compteurValChar1[k] == '2') {
                    if (compteurPaire == 0) {
                        index1 = k;
                        compteurPaire++;
                    }
                    if (compteurPaire == 1) {
                        index2 = k;
                    }
                }
            }
            int paire1Val1 = compteurValChar1.length - index1 - 1;
            int paire2Val1 = compteurValChar1.length - index2 - 1;

            char[] compteurValChar2 = tJoueurs[joueurMaxScore].les7Cartes.getCompteurValChar();
            compteurPaire = 0;
            for (int k = 0; k < compteurValChar2.length; k++) {
                if (compteurValChar2[k] == '2') {
                    if (compteurPaire == 1) {
                        index2 = k;
                    }
                    if (compteurPaire == 0) {
                        index1 = k;
                        compteurPaire++;
                    }

                }
            }
            int paire1Val2 = compteurValChar2.length - index1 - 1;
            int paire2Val2 = compteurValChar2.length - index2 - 1;

            if (paire1Val1 == paire1Val2) {
                egalite1 = true;
            }
            if (paire2Val1 == paire2Val2) {
                egalite2 = true;
            }

            if (egalite1 && egalite2) {
                if (tJoueurs[i].compteur > tJoueurs[joueurMaxScore].compteur){
					tJoueurs[i].setScore(3.5);
					tJoueurs[joueurMaxScore].setScore(3);
				if (tJoueurs[i].compteur < tJoueurs[joueurMaxScore].compteur){
					tJoueurs[i].setScore(2.5);
            }

            if (!egalite1){
                if (paire1Val1>paire1Val2){
                    tJoueurs[i].setScore(3.5);
                    tJoueurs[joueurMaxScore].setScore(3);
                }
                else{
                    tJoueurs[i].setScore(2.5);
                }
                egalite2=true;
            }
            if (!egalite2){
                if (paire2Val1>paire2Val2){
                    tJoueurs[i].setScore(3.5);
                    tJoueurs[joueurMaxScore].setScore(3);
                }
                else{
                    tJoueurs[i].setScore(2.5);
                }
            }
        }

        //egalite Brelan
        if (tJoueurs[i].getScore() == 4) {
            cartesEgales = 3;
            Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
            Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

            char[] compteurValChar1 = getCompteurValChar();
            int index = 0;
            for (int k = 0; k < compteurValChar1.length; k++) {
                if (compteurValChar1[k] == '3') {
                    index = k;
                    break;
                }
            }
            int brelanVal1 = compteurValChar1.length - index - 1;

            char[] compteurValChar2 = tJoueurs[joueurMaxScore].les7Cartes.getCompteurValChar();
            for (int k = 0; k < compteurValChar2.length; k++) {
                if (compteurValChar2[k] == '3') {
                    index = k;
                    break;
                }
            }
            int brelanVal2 = compteurValChar2.length - index - 1;

            if (brelanVal1 == brelanVal2) {
                egalite1 = true;
            }

            if (egalite1 == true) {
                if (tJoueurs[i].compteur > tJoueurs[joueurMaxScore].compteur){
					tJoueurs[i].setScore(4.5);
					tJoueurs[joueurMaxScore].setScore(4);
				if (tJoueurs[i].compteur < tJoueurs[joueurMaxScore].compteur){
					tJoueurs[i].setScore(3.5);
            } else {
                if (brelanVal1 > brelanVal2) {
                    tJoueurs[i].setScore(4.5);
                    tJoueurs[joueurMaxScore].setScore(4);
                } else {
                    tJoueurs[i].setScore(3.5);
                }
            }
        }

        //egalite Suite
        if (tJoueurs[i].getScore() == 5) {
            int suiteHauteur1=0;
            int suiteHauteur2=0;
            Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
            Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

            for (int k=0; k< this.tLes7Cartes.size()-4; k++){
				if(compteurValInt[k] > 0 && compteurValInt[k + 1] > 0 && compteurValInt[k + 2] > 0 && compteurValInt[k + 3] > 0 && compteurValInt[k + 4] > 0){
					suiteHauteur1 = k;
                    break;
                }
            }
            for (int k=0; k< tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.size()-4; k++) {
				if(compteurValInt[k] > 0 && compteurValInt[k + 1] > 0 && compteurValInt[k + 2] > 0 && compteurValInt[k + 3] > 0 && compteurValInt[k + 4] > 0){
                    suiteHauteur2 = k;
                    break;
                }
            }

            if (suiteHauteur1>suiteHauteur2){
                tJoueurs[i].setScore(5.5);
                tJoueurs[joueurMaxScore].setScore(5);
            }
            if (suiteHauteur1<suiteHauteur2){
                tJoueurs[i].setScore(4.5);
            }
        }

        //egalite Couleur
        if (tJoueurs[i].getScore() == 6) {
            int couleurHauteur1=0;
            int couleurHauteur2=0;
            int chiffreCouleur=0;
            int compteurCouleur=0;
            String couleur = null;

            Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
            Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());
            char []compteurCouleurChar = getCompteurCouleurChar();

            for (int k = 0; k < compteurCouleurChar.length; k++) {
                if (compteurCouleurChar[k] == '5' || compteurCouleurChar[k] == '6' || compteurCouleurChar[k] == '7') {
                    chiffreCouleur = (compteurCouleurChar.length) - k;
                    compteurCouleur++;
                }
            }
            if (compteurCouleur == 1) {
                switch (chiffreCouleur) {
                    case 1:
                        couleur = "Pique";
                        break;
                    case 2:
                        couleur = "Carreau";
                        break;
                    case 3:
                        couleur = "Coeur";
                        break;
                    case 4:
                        couleur = "Trefle";
                        break;
                }
            }

            for (int k=0; k< this.tLes7Cartes.size()-4; k++){
                if(this.tLes7Cartes.get(k).getCouleur()==couleur){
                    couleurHauteur1=this.tLes7Cartes.get(k).getValeur();
                    break;
                }
            }
            for (int k=0; k< tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.size()-4; k++) {
                if(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.get(k).getCouleur()==couleur){
                    couleurHauteur2 = tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.get(k).getValeur();
                    break;
                }
            }

            if (couleurHauteur1>couleurHauteur2){
                tJoueurs[i].setScore(6.5);
                tJoueurs[joueurMaxScore].setScore(6);
            }
            if (couleurHauteur1<couleurHauteur2){
                tJoueurs[i].setScore(5.5);
            }
        }

        //egalite Full
        if (tJoueurs[i].getScore() == 7) {
            Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
            Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

            char[] compteurValChar1 = getCompteurValChar();
            int index = 0;
            for (int k = 0; k < compteurValChar1.length; k++) {
                if (compteurValChar1[k] == '3') {
                    index = k;
                    break;
                }
            }
            int brelanVal1 = compteurValChar1.length - index - 1;

            char[] compteurValChar2 = tJoueurs[joueurMaxScore].les7Cartes.getCompteurValChar();
            for (int k = 0; k < compteurValChar2.length; k++) {
                if (compteurValChar2[k] == '3') {
                    index = k;
                    break;
                }
            }
            int brelanVal2 = compteurValChar2.length - index - 1;
            

            if (brelanVal1 == brelanVal2) {
                for (int k = 0; k < compteurValChar1.length; k++) {
                    if (compteurValChar1[k] == '2') {
                        index = k;
                        break;
                    }
                }
                int paireVal1 = compteurValChar1.length - index - 1;

                for (int k = 0; k < compteurValChar2.length; k++) {
                    if (compteurValChar2[k] == '2') {
                        index = k;
                        break;
                    }
                }
                int paireVal2 = compteurValChar2.length - index - 1;

                if (paireVal1 > paireVal2) {
                    tJoueurs[i].setScore(7.5);
                    tJoueurs[joueurMaxScore].setScore(7);
                }
                if (paireVal1 < paireVal2) {
                    tJoueurs[i].setScore(6.5);
                }
            }
            else{
                if (brelanVal1>brelanVal2){
                    tJoueurs[i].setScore(7.5);
                    tJoueurs[joueurMaxScore].setScore(7);
                }
                if (brelanVal1<brelanVal2){
                    tJoueurs[i].setScore(6.5);
                }
            }
        }

        //egalite Carre
        if (tJoueurs[i].getScore() == 8) {
            cartesEgales = 4;
            Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
            Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());

            char[] compteurValChar1 = getCompteurValChar();
            int index = 0;
            for (int k = 0; k < compteurValChar1.length; k++) {
                if (compteurValChar1[k] == '4') {
                    index = k;
                    break;
                }
            }
            int carreVal1 = compteurValChar1.length - index - 1;

            char[] compteurValChar2 = tJoueurs[joueurMaxScore].les7Cartes.getCompteurValChar();
            for (int k = 0; k < compteurValChar2.length; k++) {
                if (compteurValChar2[k] == '4') {
                    index = k;
                    break;
                }
            }
            int carreVal2 = compteurValChar2.length - index - 1;


            if (carreVal1 == carreVal2) {
                if (tJoueurs[i].compteur > tJoueurs[joueurMaxScore].compteur){
					tJoueurs[i].setScore(8.5);
					tJoueurs[joueurMaxScore].setScore(8);
				if (tJoueurs[i].compteur < tJoueurs[joueurMaxScore].compteur){
					tJoueurs[i].setScore(7.5);
            } else {
                if (carreVal1 > carreVal2) {
                    tJoueurs[i].setScore(8.5);
                    tJoueurs[joueurMaxScore].setScore(8);
                } else {
                    tJoueurs[i].setScore(7.5);
                }
            }
        }

        //egalite Quinte Flush
        if (tJoueurs[i].getScore()==9){
            int QFHauteur1=0;
            int QFHauteur2=0;
            int chiffreCouleur=0;
            int compteurCouleur=0;
            String couleur = null;

            Collections.sort(this.tLes7Cartes, Collections.reverseOrder());
            Collections.sort(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes, Collections.reverseOrder());
            char []compteurCouleurChar = getCompteurCouleurChar();

            for (int k = 0; k < compteurCouleurChar.length; k++) {
                if (compteurCouleurChar[k] == '5' || compteurCouleurChar[k] == '6' || compteurCouleurChar[k] == '7') {
                    chiffreCouleur = (compteurCouleurChar.length) - k;
                    compteurCouleur++;
                }
            }
            if (compteurCouleur == 1) {
                switch (chiffreCouleur) {
                    case 1:
                        couleur = "Pique";
                        break;
                    case 2:
                        couleur = "Carreau";
                        break;
                    case 3:
                        couleur = "Coeur";
                        break;
                    case 4:
                        couleur = "Trefle";
                        break;
                }
            }

            for (int k=0; k< this.tLes7Cartes.size()-4; k++){
                if(this.tLes7Cartes.get(k).getCouleur()==couleur){
                    QFHauteur1=this.tLes7Cartes.get(k).getValeur();
                    break;
                }
            }
            for (int k=0; k< tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.size()-4; k++) {
                if(tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.get(k).getCouleur()==couleur){
                    QFHauteur2 = tJoueurs[joueurMaxScore].les7Cartes.tLes7Cartes.get(k).getValeur();
                    break;
                }
            }

            if (QFHauteur1>QFHauteur2){
                tJoueurs[i].setScore(9.5);
                tJoueurs[joueurMaxScore].setScore(9);
            }
            if (QFHauteur1<QFHauteur2){
                tJoueurs[i].setScore(8.5);
            }
        }
    }

    public char[] getCompteurValChar() {
        long compteur = 0;
        String t;
        char[] compteurValChar;

        for (int j = 0; j < this.tLes7Cartes.size(); j++) {
            int val = this.tLes7Cartes.get(j).getValeur();
            compteur += Math.pow(10, val);
        }
        //transforme en String le compteur (a changer)
        t = compteur + "";
        compteurValChar = t.toCharArray();
        return compteurValChar;
    }
		

    public char[] getCompteurCouleurChar() {
        int compteur = 0;
        String t;
        char[] compteurCouleurChar;
        int val = 0;

        for (int i = 0; i < this.tLes7Cartes.size(); i++) {
            String couleur = this.tLes7Cartes.get(i).getCouleur();
            switch (couleur) {
                case "Pique":
                    val = 0;
                    break;
                case "Carreau":
                    val = 1;
                    break;
                case "Coeur":
                    val = 2;
                    break;
                case "Trefle":
                    val = 3;
                    break;
            }
            compteur += Math.pow(10, val);
        }
        //transforme en String le compteur (a changer)
        t = compteur + "";
        compteurCouleurChar = t.toCharArray();
        return compteurCouleurChar;
    }
}
