package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Damien on 12/06/2017.
 */
public class Reine extends AbstractPiece implements Pieces {
    public Reine(Couleur couleur, Coord coord) {
        super(couleur, coord);
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

    @Override
    public List<Coord> getPathCoords(int xFinal, int yFinal) {
        List<Coord> coords = new LinkedList<Coord>();
        int x = this.getX();
        int y = this.getY();
        if(y!= yFinal && x!=xFinal){
            int i = x<xFinal? 1:-1;
            int j = y<yFinal? 1:-1;
            while(x != xFinal-i && y !=yFinal-j){
                x += i;
                y += j;
                coords.add(new Coord(x,y));
            }
        }
        else
        {
            boolean vertical = yFinal != y;
            int sens = y<yFinal || x<xFinal ? 1:-1;
            int distance = vertical ? Math.abs(y-yFinal) : Math.abs(x-xFinal);
            for(int i = 1; i<distance; i++){
                if(vertical)
                    coords.add(new Coord(x,y+i*sens));
                else
                    coords.add(new Coord(x+i*sens,y));
            }
        }
        return coords;
    }
}
