package model;

import tools.ChessPiecesFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Echiquier implements BoardGames{

    private Jeu jeuNoir;
    private Jeu jeuBlanc;
    private boolean tourBlanc;
    private String message;

    public Echiquier() {
        jeuNoir = new Jeu(Couleur.NOIR);
        jeuBlanc = new Jeu(Couleur.BLANC);
        tourBlanc = true;
    }

    public Object getPiecesIHM() {
        List<PieceIHMs> listPiecesIHM = new ArrayList<PieceIHMs>(this.jeuNoir.getPiecesIHM());
        listPiecesIHM.addAll(this.jeuBlanc.getPiecesIHM());
        return listPiecesIHM;
    }

    @Override
    public String toString() {
        return "Echiquier{\n"
                +"Jeu Noir: "+jeuNoir.toString()+"\n"
                +"Jeu Blanc: " + jeuBlanc +"\n"
                +"Le " + (tourBlanc?"Blanc":"Noir")+" joue\n"
                +"Le message est: " + message + '\n'
                +"}";
    }

    //methodes de manipulation du message de log
    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        boolean ret = (this.tourBlanc?
                this.jeuBlanc.isMoveOk(xInit, yInit, xFinal, yFinal, true, false)
                :this.jeuNoir.isMoveOk(xInit, yInit, xFinal, yFinal,true, false));
        if(ret)
            ret = ret&sansColisions(xInit,yInit,xFinal,yFinal);
        return ret;
    }

    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        boolean ret = this.tourBlanc?this.jeuBlanc.move(xInit, yInit, xFinal, yFinal)
                :this.jeuNoir.move(xInit, yInit, xFinal, yFinal);
        if(ret)
            this.switchJoueur();
        return ret;

    }

    public void switchJoueur() {
        this.tourBlanc = !this.tourBlanc;
    }

    public boolean isEnd() {
        return false;
    }

    public Couleur getColorCurrentPlayer() {

        return (tourBlanc?Couleur.BLANC:Couleur.NOIR);
    }

    public Couleur getPieceColor(int x, int y) {
        if(jeuBlanc.getPieceColor(x,y)!=null){
            return Couleur.BLANC;
        }else if(jeuNoir.getPieceColor(x,y)!=null){
            return Couleur.NOIR;
        }else{
            return null;
        }
    }

    private boolean sansColisions(int xInit, int yInit, int xFinal, int yFinal){
       List<Coord> coords = this.tourBlanc?jeuBlanc.getPathCoord(xInit,yInit,xFinal,yFinal):jeuNoir.getPathCoord(xInit,yInit,xFinal,yFinal);
       for(Coord coord:coords){
           if (jeuBlanc.isPieceHere(coord.x,coord.y) ||jeuNoir.isPieceHere(coord.x,coord.y)) return false;
       }
       return true;
    }

    public static void main(String[] args) {

        Echiquier echiquier = new Echiquier();
        System.out.println(echiquier);

        echiquier.switchJoueur();
        System.out.println(echiquier);

    }
}
