package model;

/**
 * Created by Damien on 12/06/2017.
 */
public class Reine extends AbstractPiece implements Pieces {
    Reine(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public String getName() {
        return "Reine";
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if (xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8){
            return (
                ((xFinal != this.getX() && yFinal == this.getY())
                ||(xFinal == this.getX() && yFinal != this.getY())
                ||(xFinal == this.getX() && yFinal == this.getY()))
            )
            ||(Math.abs(xFinal - this.getX()) == Math.abs(yFinal - this.getY()));
        }
        return false;
    }

    public boolean move(int xFinal, int yFinal) {
        return super.move(xFinal,yFinal);
    }
}
