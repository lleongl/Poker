import java.util.LinkedList;

public class Joueur {
    public LinkedList <Carte> tLes2Cartes=new LinkedList<>();
    public Les7Cartes les7Cartes;
    private int victoire=0;
    private float score=0;


    public int getVictoire() {
        return victoire;
    }

    public float getScore() {
        return score;
    }

    public void setVictoire(int victoire) {
        this.victoire = victoire;
    }

    public void setScore(double score) {
        this.score = (float) score;
    }
}
