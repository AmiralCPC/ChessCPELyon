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

    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public String getName() {
        return "Tour";
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {

        return((xFinal != this.getX() && yFinal == this.getY()) ||(xFinal == this.getX() && yFinal != this.getY()));
    }

    @Override
    public boolean move(int xFinal, int yFinal) {
        return false;
    }
}
