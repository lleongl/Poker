import java.util.LinkedList;

public class Les7Cartes {
    LinkedList<Carte> tLes7Cartes = new LinkedList<>();

    public Les7Cartes(LinkedList<Carte> tLes5Cartes, LinkedList<Carte> tLes2Cartes) {
        for (int i = 0; i < tLes5Cartes.size() + tLes2Cartes.size(); i++) {
            if (i < tLes2Cartes.size()) {
                tLes7Cartes.add(tLes2Cartes.get(i));
            } else {
                tLes7Cartes.add(tLes5Cartes.get(i - tLes2Cartes.size()));
            }
        }
    }

    public void chaineTest(int[] tCompteurs) {
        boolean meilleureMain = false;
        char[] compteurValChar;
        char[] compteurCouleurChar;
        int[] compteurValInt;

        //tests pour la Quinte Flush
        int compteurCouleur = 0;
        int chiffreCouleur = 0;
        String couleur = null;
        LinkedList <Carte> cartesCouleur= new LinkedList<>();

        compteurCouleurChar = getCompteurCouleurChar();
        for (int j = 0; j < compteurCouleurChar.length; j++) {
            if (compteurCouleurChar[j] == '5' || compteurCouleurChar[j] == '6' || compteurCouleurChar[j] == '7') {
                chiffreCouleur = j;
                compteurCouleur++;
                compteurCouleurChar=getCompteurCouleurChar();
            }
        }
        if (compteurCouleur==1) {
            switch (chiffreCouleur) {
                case 0:
                    couleur = "Trefle";
                case 1:
                    couleur = "Coeur";
                case 2:
                    couleur = "Carreau";
                case 3:
                    couleur = "Pique";
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

            System.out.println("compteur des cartes de meme couleur : "+compteur);

            //transforme en String le compteur (a changer)
            t = compteur + "";
            compteurValChar = t.toCharArray();
            for (int k = 0; k < compteurValChar.length-4; k++) {
                if (compteurValChar[k] > 0 && compteurValChar[k+1] > 0 && compteurValChar[k+2] > 0 && compteurValChar[k+3] > 0 && compteurValChar[k+4] > 0) {
                    tCompteurs[0]++;
                    meilleureMain=true;
                    break;
                }
            }
        }

        //tests pour le Carre
        if (!meilleureMain) {
            compteurValChar = getCompteurValChar();
            for (int k = 0; k < compteurValChar.length; k++) {
                if (compteurValChar[k] == '4') {
                    tCompteurs[1]++;
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
                tCompteurs[2]++;
                meilleureMain = true;
            }
        }

        //tests pour la Couleur
        if (!meilleureMain) {
            compteurCouleurChar = getCompteurCouleurChar();
            for (int k = 0; k < compteurCouleurChar.length; k++) {
                if (compteurCouleurChar[k] == '5' || compteurCouleurChar[k] == '6' || compteurCouleurChar[k] == '7') {
                    tCompteurs[3]++;
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
                    tCompteurs[4]++;
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
                    tCompteurs[5]++;
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
                tCompteurs[6]++;
                meilleureMain = true;
            }

        }


        //tests pour la Paire
        if (!meilleureMain) {
            compteurValChar = getCompteurValChar();
            for (int k = 0; k < compteurValChar.length; k++) {
                if (compteurValChar[k] == '2') {
                    tCompteurs[7]++;
                    meilleureMain = true;
                }

            }
        }

        //tests pour la Carte Haute
        if (!meilleureMain) {
            tCompteurs[8]++;
        }

/*        //Affiche le compteur de valeur en char
        compteurValChar = getCompteurValChar();
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
/*     compteurValChar = getCompteurValChar();
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
        int[] compteurCouleur;
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
