package model;

import tools.ChessPiecesFactory;

import java.util.List;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Echiquier implements BoardGames{

    private Jeu jeuNoir;
    private Jeu jeuBlanc;
    private boolean tourBlanc;
    private String message;

    public Echiquier() {
        jeuNoir = new Jeu(Couleur.NOIR);
        jeuBlanc = new Jeu(Couleur.BLANC);
        tourBlanc = true;
    }

    public Object getPiecesIHM() {
        return null;
    }

    @Override
    public String toString() {
        return "Echiquier{\n"
                +"Jeu Noir: "+jeuNoir.toString()+"\n"
                +"Jeu Blanc: " + jeuBlanc +"\n"
                +"Le " + (tourBlanc?"Blanc":"Noir")+" joue\n"
                +"Le message est: " + message + '\n'
                +"}";
    }

    //methodes de manipulation du message de log
    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    public void switchJoueur() {
        this.tourBlanc = !this.tourBlanc;
    }

    public boolean isEnd() {
        return false;
    }

    public Couleur getColorCurrentPlayer() {
        return Couleur.NOIR;
    }

    public Couleur getPieceColor(int x, int y) {
        return Couleur.BLANC;
    }

    public static void main(String[] args) {

        Echiquier echiquier = new Echiquier();
        System.out.println(echiquier);

        echiquier.switchJoueur();
        System.out.println(echiquier);

    }
}
