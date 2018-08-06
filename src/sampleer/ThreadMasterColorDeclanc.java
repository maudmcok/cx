package sampleer;

import sample.Clue;
import sample.Crossword;
import sample.CrosswordSquare;

import java.util.ArrayList;
import java.util.List;

public class ThreadMasterColorDeclanc extends Thread {

    private int row;
    private int column;
    int auRow;
    int auCol;
    List<Clue> V = new ArrayList<>();
    List<Clue> H = new ArrayList<>();

    public ThreadMasterColorDeclanc(int row, int column) {
        this.row = row;
        this.column = column;
    }

    private static Crossword model = Crossword.getInstance();

    @Override
    public void run() {

        new CrosswordSquare();
        CrosswordSquare xsqr;

        auRow = row;
        H = model.getHorizontalClues();
        V = model.getVerticalClues();



        xsqr = model.getCell(auRow, column);
        while (xsqr != null && auRow >= 0) {
            auRow--;
            if (auRow == 0) xsqr = model.getCell(auRow, column);
        }
        if (auRow < 0) {
            auRow = 0;
        }
        if (xsqr == null){
            auRow++;
        }

        System.out.println(" Clue Position => " + auRow + " - " + column + " ") ;
            for (int i = 0; i < H.size(); i++) {
                if (H.get(i).getColumn() == column && H.get(i).getRow() == auRow) {
                    System.out.println("");
                    System.out.println("Horizontal = "  + H.get(i).getClue());
                    H.get(i).colorMaster();
                    model.ColorMMaster(i,true,true);
                }else {
                    model.ColorMMaster(i,true,false);
                }
            }
   //     }

        auCol = column;

        xsqr = model.getCell(row, auCol);

        while (xsqr != null && auCol >= 0) {
            auCol--;
            if (auCol == 0) xsqr = model.getCell(row, auCol);

        }
        if (auCol < 0) {
            auCol = 0;
        }
        if (xsqr == null){
            auCol++;
        }
        System.out.println (" Clue Position  => " + row + " - " + auCol +" ") ;
            for (int i = 0; i < V.size(); i++) {
                if (V.get(i).getColumn() == auCol && V.get(i).getRow() == row) {
                    System.out.println("");
                    System.out.println("Vertical = " + V.get(i).getClue());
                    V.get(i).colorMaster();
                    model.ColorMMaster(i,false,true);

                }else {
                    model.ColorMMaster(i,false,false);
                }
            }
    //    }


    }
}
