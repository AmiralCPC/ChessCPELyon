package model;

import tools.ChessPiecesFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Damien on 12/06/2017.
 */
public class Jeu implements Game {

    private List<Pieces> pieces;
    private Couleur couleur;
    boolean castling = false;

    public Jeu(Couleur couleur) {
        pieces = ChessPiecesFactory.newPieces(couleur);
        this.couleur = couleur;
    }

    @Override
    public boolean isPieceHere(int x, int y) {
        return findPiece(x,y)!=null;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        Pieces piece = findPiece(xInit,yInit);
        if(piece != null)
            return piece.isMoveOk(xFinal, yFinal,isCatchOk,isCastlingPossible);
        return false;
    }

    public boolean isCatchOk(int x, int y){
        Pieces ret = this.findPiece(x,y);
        if(ret != null)
            return ret.isCatchOk(x,y);
        return false;
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        Pieces piece = findPiece(xInit,yInit);
        if(piece != null){

            return piece.move(xFinal,yFinal);
        }
        return false;
    }

    @Override
    public boolean capture(int xCatch, int yCatch) {

        if(isPieceHere(xCatch, yCatch)){
            return this.findPiece(xCatch, yCatch).capture();
        }

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

    public Couleur getCouleur(){
        return couleur;
    }

    public Couleur getPieceColor(int x, int y){
        Pieces piece = findPiece(x,y);
        if(piece != null)
            return piece.getCouleur();
        return null;
    }

    public String getPieceName(int x, int y){
        Pieces piece = findPiece(x,y);
        if(piece != null)
            return piece.getName();
        return "";
    }

    public List<PieceIHMs> getPiecesIHM(){
        PieceIHMs newPieceIHM = null;
        List<PieceIHMs> list = new LinkedList<PieceIHMs>();
        for (Pieces piece : pieces){
        // si la pièce est toujours en jeu
            if (piece.getX() != -1){
                newPieceIHM = new PieceIHM(piece);
                list.add(newPieceIHM);
            }
        }
        return list;
    }

    public List<Coord> getPathCoord(int xInit, int yInit, int xFinal, int yFinal){
        Pieces piece = findPiece(xInit,yInit);
        if(piece != null){
            return piece.getPathCoords(xFinal,yFinal);
        }
        return null;
    }

    public void setCastling(){
        castling = !castling;
    }

    private Pieces findPiece(int x, int y){
        for(Pieces piece : pieces){
            if(piece.getY() == y && piece.getX()==x)
                return piece;
        }
        return null;
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu(Couleur.NOIR);
        System.out.println(jeu);
        System.out.println(jeu.findPiece(7,0));
        System.out.println(jeu.isMoveOk(1,0,3,1,false,false));
    }
}