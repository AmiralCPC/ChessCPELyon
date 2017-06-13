package vue;

import controler.ChessGameControler;
import controler.ChessGameControlers;
import model.Coord;
import model.PieceIHM;
import tools.ChessImageProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by CheckDaGus on 12/06/2017.
 */
public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer  {
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    ChessGameControlers chessGameControler;

    public ChessGameGUI(String s, ChessGameControlers chessGameControler, Dimension dim) {
        this.chessGameControler = chessGameControler;
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(dim);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( dim );
        chessBoard.setBounds(0, 0, dim.width, dim.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add( square );
            square.setName(""+i);
            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? Color.black : Color.white );
            else
                square.setBackground( i % 2 == 0 ? Color.white : Color.black );
        }

    }

    public void mousePressed(MouseEvent e){
        chessPiece = null;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel)
            return;

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel)c;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);

    }

    //Move the chess piece around

    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    //Drop the chess piece back onto the chess board

    public void mouseReleased(MouseEvent e) {
        boolean isPlayerOk;
        boolean isMoveGood;
        JPanel aDelete;

        if(chessPiece == null) return;

        chessPiece.setVisible(false);
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
        int nbCase  =Integer.parseInt(c.getName());
        int xFinal = nbCase%8;
        int yFinal = (nbCase - xFinal)/8;

        nbCase =Integer.parseInt(chessPiece.getName());
        int xDepart = nbCase%8;
        int yDepart = (nbCase - xDepart)/8;

        isPlayerOk = chessGameControler.isPlayerOK(new Coord(xDepart, yDepart));

        if(isPlayerOk){
            isMoveGood = chessGameControler.move(new Coord(xDepart, yDepart), new Coord(xFinal, yFinal));
            if(isMoveGood){
                aDelete = (JPanel) chessBoard.getComponent(nbCase);
                aDelete.removeAll();
            }
        }
    }

    public void mouseClicked(MouseEvent e) {

    }
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {

    }

    @Override
    public void update(Observable o, Object arg) {
        java.util.List<PieceIHM> piecesIHM = (java.util.List<PieceIHM>) arg;
        String path;
        JPanel panel;
        JLabel image;
        int nbCase;
        for(PieceIHM piece:piecesIHM){
            path = ChessImageProvider.getImageFile(piece.getNamePiece(),piece.getCouleur());
            nbCase= piece.getY()*8+piece.getX();
            panel = (JPanel)chessBoard.getComponent(nbCase);
            image = new JLabel( new ImageIcon(path) );
            image.setName(""+nbCase);
            panel.add(image);
        }
    }
}
