package sample;


import java.util.Arrays;


public class Grid<T> {
    private int height, width;
    private T[][] celles;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        celles = (T[][]) (new Object[height][width]);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public T getCell(int row, int column) {
        return celles[row][column];
    }

    public boolean correctCoords(int row, int column) {
        return true;
    }

    public void setCell(int row, int column, T cellValue) {
       //  System.out.println("Row = "+row+" - Column = "+column );
        if (celles[row][column] != null) {
         //   System.out.println(" - - 00 - - "+cellValue.toString() );
            celles[row][column] = cellValue;
        }else {
            celles[row][column] = cellValue;

        }

        // System.out.println(" - - Cell= "+cellValue.toString() );
    }

    @Override
    public String toString() {
        return "Grid{" +
                "height=" + height +
                ", width=" + width +
                ", celles=" + Arrays.toString(celles) +
                '}';
    }
}
