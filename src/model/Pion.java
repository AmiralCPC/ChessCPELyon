package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Pion extends AbstractPiece implements Pieces{

    private boolean firstMove = true;

    public Pion(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isCatchOk(int xCatch, int yCatch){

        if(this.getCouleur()==Couleur.BLANC){
            return(Math.abs(this.getX()-xCatch) == 1 && this.getY()-yCatch == 1);
        }
        if(this.getCouleur()==Couleur.NOIR){
            return(Math.abs(this.getX()-xCatch) == 1 && this.getY()-yCatch == -1);
        }
        return false;
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {

        if(isCatchOk)
            return true;

        if((xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8)){

            //Verification premier mouvement pion
            if(this.firstMove == true) {
                if (!(this.getX()==xFinal && this.getY()==yFinal)){
                    this.firstMove = !this.firstMove;
                    return (
                            ((this.getY() - yFinal) < 3
                            && this.getX() == xFinal
                            && this.getCouleur() == Couleur.BLANC)
                            ||
                            (yFinal - this.getY() < 3)
                            && this.getX() == xFinal
                            && this.getCouleur() == Couleur.NOIR);
                }
            }

            //Verification mouvement pion
            return(Math.abs(this.getY()-yFinal)==1 && (xFinal == this.getX()));
        }
        return false;
    }

    @Override
    public List<Coord> getPathCoords(int xFinal, int yFinal) {
        int j = this.getCouleur() == Couleur.NOIR?1:-1;
        List<Coord> coords = new LinkedList<Coord>();
        for(int i=1;i<Math.abs(yFinal-this.getY());i++){
            coords.add(new Coord(this.getX(), this.getY()+ j*i));
        }
        return coords;
    }

}
