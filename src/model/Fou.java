package model.Pieces;

import model.Coord;
import model.Couleur;

/**
 * Created by Damien on 12/06/2017.
 */
public class Fou extends AbstractPiece implements Pieces{
    Fou(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    public boolean capture() {
        return false;
    }

    public String getName() {
        return "Fou";
    }

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        return (Math.abs(xFinal - this.getX()) == Math.abs(yFinal - this.getY()));
    }

    public boolean move(int xFinal, int yFinal) {
        super.move(xFinal,yFinal);
        return true;
    }
}
