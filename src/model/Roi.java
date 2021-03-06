package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Roi extends AbstractPiece implements Pieces{

    public Roi(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if(xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8){
            return(Math.abs(xFinal-this.getX())<=1&&Math.abs(yFinal-this.getY())<=1);
        }
        return false;
    }

    @Override
    public List<Coord> getPathCoords(int xFinal, int yFinal) {
        return new LinkedList<Coord>();
    }
}
