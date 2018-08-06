package sample;

public class ThreadMaster extends Thread {

    private static Crossword model = Crossword.getInstance();

    @Override
    public void run() {

        for (int row = 0; row < Crossword.height; row++) {
            for (int column = 0; column < Crossword.width; column++) {
                new CrosswordSquare();
                CrosswordSquare xsqr;
                xsqr = model.getCell(row, column);
                if (xsqr == null) {
                    xsqr = new CrosswordSquare(true, "", "", '0', row + 0, 0 + column);
                }else {
                    model.setProposition(row,column,""+xsqr.getSolution());
                }

            }
        }

    }
}
