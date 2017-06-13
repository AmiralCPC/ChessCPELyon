package model;

/**
 * Created by Damien on 12/06/2017.
 */
public abstract class AbstractPiece implements Pieces{

    private Couleur couleur;
    private Coord coord;

    AbstractPiece(Couleur couleur, Coord coord){
        this.couleur = couleur;
        this.coord = coord;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public int getX() {
        return coord.x;
    }

    public int getY() {
        return coord.y;
    }

    @Override
    public String toString() {
        return this.getName() +
                ", x = " + coord.x +
                ", y = " + coord.y+ "\n";
    }

    public boolean isCatchOk(int xCatch, int yCatch){
        return true;
    }

    @Override
    public String getName(){
        return this.getClass().getSimpleName();
    }

    public boolean move(int xFinal, int yFinal) {
        this.coord.x = xFinal;
        this.coord.y = yFinal;
        return true;
    }

    @Override
    public boolean capture(){
        this.coord.x = -1;
        this.coord.y = -1;
        return true;
    }
}
