package fr.insalyon.poker.entity;

import java.util.LinkedList;

public class Carte {

    private String couleur;
    private int valeur;

    public Carte(int valeur, String couleur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getValeur() {
        return valeur;
    }
}
