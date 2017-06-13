package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Damien on 12/06/2017.
 */
public class Fou extends AbstractPiece implements Pieces{
    public Fou(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        return (Math.abs(xFinal - this.getX()) == Math.abs(yFinal - this.getY()))
                && (xFinal>=0 && xFinal<8 && yFinal>=0 && yFinal<8);
    }

    @Override
    public List<Coord> getPathCoords(int xFinal, int yFinal) {
        List<Coord> coords= new LinkedList<Coord>();
        int xDepart = this.getX();
        int yDepart = this.getY();
        int i = xDepart<xFinal? 1:-1;
        int j = yDepart<yFinal? 1:-1;
        while(xDepart != xFinal-i && yDepart !=yFinal-j){
            xDepart += i;
            yDepart += j;
            coords.add(new Coord(xDepart,yDepart));
        }
        return coords;
    }

}
