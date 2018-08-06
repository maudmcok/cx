package sample;

import javafx.scene.control.Label;


public class Clue extends Label {

    private String clue;
    private int row;
    private int column;
    private boolean horizontal;
    private boolean Selected = false;

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }


    public Clue(String clue, int row, int column, boolean horizontal) {
        this.clue = clue;
        this.row = row;
        this.column = column;
        this.horizontal = horizontal;

        this.setStyle("-fx-background-color : green ");

        this.setOnMouseClicked(event -> {

            if (Selected) {
                this.setStyle("-fx-background-color : white");
                Selected = false;
            } else {
                this.setStyle("-fx-background-color : black");
                Selected = true;
            }
            System.out.println(" App - lol ");


        });

    }

    public void colorMaster() {

        if (Selected) {
            this.setStyle("-fx-background-color : white");
            Selected = false;
        } else {
            this.setStyle("-fx-background-color : black");
            Selected = true;
        }

        this.setStyle("-fx-background-color : green ");
    }


    public String getClue() {
        return clue;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "clue='" + clue + '\'' +
                ", row=" + row +
                ", column=" + column +
                ", horizontal=" + horizontal +
                '}';
    }
}
