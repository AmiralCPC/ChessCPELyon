package model;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Echiquier {
    public Object getPiecesIHM() {
        return null;
    }

    public String getMessage() {
        return "";
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    public void switchJoueur() {
    }

    public boolean isEnd() {
        return false;
    }

    public Couleur getColorCurrentPlayer() {
        return Couleur.NOIR;
    }

    public Couleur getPieceColor(int x, int y) {
        return Couleur.NOIR;
    }
}
