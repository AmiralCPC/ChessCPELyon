package model;

/**
 * Created by Damien on 12/06/2017.
 */
public class Cavalier extends AbstractPiece implements Pieces {

    public Cavalier(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public String getName() {
        return "Cavalier";
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if((xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8)) {
            return (Math.abs(xFinal - this.getX()) == 2 && Math.abs(yFinal - this.getY()) == 1)
                    || (Math.abs(xFinal - this.getX()) == 1 && Math.abs(yFinal - this.getY()) == 2);
        }
        return false;
    }
}