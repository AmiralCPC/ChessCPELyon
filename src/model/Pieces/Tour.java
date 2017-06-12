package model.Pieces;

import model.Coord;
import model.Couleur;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Tour extends AbstractPiece implements Pieces{

    Tour(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    public boolean capture() {
        return false;
    }

    public String getName() {
        return "Tour";
    }

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {

        return((xFinal != this.getX() && yFinal == this.getY())
                ||(xFinal == this.getX() && yFinal != this.getY())
                ||(xFinal == this.getX() && yFinal == this.getY()));
    }

    public boolean move(int xFinal, int yFinal) {
       return super.move(xFinal,yFinal);
    }
}
