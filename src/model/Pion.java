package model;

import model.Coord;
import model.Couleur;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Pion extends AbstractPiece implements Pieces{

    Pion(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public String getName() {
        return "Pion";
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {

        //Verification premier mouvement pion blanc
        if((xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8)){
            if(this.getCouleur() == Couleur.BLANC && this.getY() == 6){
                return((Math.abs(this.getY()-yFinal)<3)
                        && (this.getX() == xFinal));}

            //Verification premier mouvement pion noir
            if(this.getCouleur() == Couleur.NOIR && this.getY() == 1){
                return((Math.abs(this.getY()-yFinal)<3)
                        && (this.getX() == xFinal));}

            //Verification mouvement vertical pion
            return(Math.abs(this.getY()-yFinal)==1 && (xFinal == this.getX()));
        }
        return false;

    }

    @Override
    public boolean move(int xFinal, int yFinal) {
        super.move(xFinal,yFinal);
        return true;
    }
}
