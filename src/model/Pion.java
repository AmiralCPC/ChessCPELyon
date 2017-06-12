package model;

import model.Coord;
import model.Couleur;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Pion extends AbstractPiece implements Pieces{

    private boolean firstMove = true;

    public Pion(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {

        if((xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8)){

            //Verification premier mouvement pion
            if(this.firstMove == true){
                this.firstMove = !this.firstMove;
                return((Math.abs(this.getY()-yFinal)<3) && (this.getX() == xFinal));
            }

            //Verification mouvement pion
            return(Math.abs(this.getY()-yFinal)==1 && (xFinal == this.getX()));
        }
        return false;

    }

}
