package vue;

import controler.ChessGameControler;
import controler.ChessGameControlers;
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

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? Color.black : Color.white );
            else
                square.setBackground( i % 2 == 0 ? Color.white : Color.black );
        }

    }

    public void mousePressed(MouseEvent e){

    }

    //Move the chess piece around

    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    //Drop the chess piece back onto the chess board

    public void mouseReleased(MouseEvent e) {

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
        for(PieceIHM piece:piecesIHM){
            path = ChessImageProvider.getImageFile(piece.getNamePiece(),piece.getCouleur());
            System.out.println(path);
            panel = (JPanel)chessBoard.getComponent(piece.getY()*8+piece.getX());
            image = new JLabel( new ImageIcon(path) );
            panel.add(image);
        }
    }
}
