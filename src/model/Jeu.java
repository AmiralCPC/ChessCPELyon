package model;

import tools.ChessPiecesFactory;

import java.util.List;

/**
 * Created by Damien on 12/06/2017.
 */
public class Jeu implements Game {

    private List<Pieces> pieces;

    public Jeu(Couleur couleur) {
        pieces = ChessPiecesFactory.newPieces(couleur);
    }

    @Override
    public boolean isPieceHere(int x, int y) {
        for(Pieces piece:pieces){
            if(piece.getX()==x && piece.getY() == y)
                return true;
        }
        return false;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        return  false;
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        return false;
    }

    @Override
    public boolean capture(int xCatch, int yCatch) {
        return false;
    }

    @Override
    public String toString() {
        String res="";
        for (Pieces piece:pieces){
            res+=piece;
        }
        return res;
    }
}
