package sample;

public class ThreadMasterReset extends Thread {

    private static Crossword model = Crossword.getInstance();

    @Override
    public void run() {
        for (int row = 0; row < Crossword.height; row++) {
            for (int column = 0; column < Crossword.width; column++) {
                new CrosswordSquare();
                CrosswordSquare xsqr;
                xsqr = model.getCell(row, column);
                if (xsqr == null) {
                }else {
                    model.setProposition(row,column,"");
                    xsqr.setStyle("-fx-background-color : white");
                }
            }
        }

    }
}
