package model;

import model.Couleur;

import java.util.List;

/**
 * Created by Damien on 12/06/2017.
 */
public interface Pieces {
    public boolean capture();
    public Couleur getCouleur();
    public String getName();
    public int getX();
    public int getY();
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);
    public boolean move(int xFinal, int yFinal);
    public List<Coord> getPathCoords(int xFinal, int yFinal);
}
