package model;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class Roi extends AbstractPiece implements Pieces{

    @Override
    public boolean capture() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        return false;
    }
}
