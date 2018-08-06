package sample;

import java.util.ArrayList;
import java.util.List;

public class ThreadMasterColor extends Thread {

    private int row;
    private int column;
    int auRow;
    int auCol;
    List<Clue> listV = new ArrayList<>();
    List<Clue> listH = new ArrayList<>();

    public ThreadMasterColor(int row, int column) {
        this.row = row;
        this.column = column;
    }

    private static Crossword model = Crossword.getInstance();

    @Override
    public void run() {

        new CrosswordSquare();
        CrosswordSquare xsqr;

        auRow = row;
        listH = model.getHorizontalClues();
        listV = model.getVerticalClues();



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

            for (int i = 0; i < listH.size(); i++) {
                if (listH.get(i).getColumn() == column && listH.get(i).getRow() == auRow) {
                    System.out.println("");
                    System.out.println("Horizontal = "  + listH.get(i).getClue());
                    listH.get(i).colorMaster();
                    model.ColorMMaster(i,true,true);
                }else {
                    model.ColorMMaster(i,true,false);
                }
            }

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
            for (int i = 0; i < listV.size(); i++) {
                if (listV.get(i).getColumn() == auCol && listV.get(i).getRow() == row) {
                    System.out.println("");
                    System.out.println("Vertical = " + listV.get(i).getClue());
                    listV.get(i).colorMaster();
                    model.ColorMMaster(i,false,true);

                }else {
                    model.ColorMMaster(i,false,false);
                }
            }
    
    }
}
