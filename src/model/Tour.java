package model;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Tour extends AbstractPiece implements Pieces{

    public Tour(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    public boolean capture() {
        return false;
    }

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {

        return(((xFinal != this.getX() && yFinal == this.getY())
                ||(xFinal == this.getX() && yFinal != this.getY())
                ||(xFinal == this.getX() && yFinal == this.getY())))
                && (xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8);
    }

    public boolean move(int xFinal, int yFinal) {
       return super.move(xFinal,yFinal);
    }
}
