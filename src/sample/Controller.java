package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Controller {
    private static Crossword model = Crossword.getInstance();
    //variable de la table de jeux
    @FXML
    public Label labelNiveau;
    @FXML
    public GridPane ganetable;
    @FXML
    public Button butonQuiter;
    @FXML
    public Button butonReset;
    @FXML
    public ListView listIndicesH;
    @FXML
    public ListView listIndeceV;

    int row;
    int column;

    public void initialize() {

        //Initialisation de la partie
        model.initcross();
        System.out.println("height = " + model.getHeight() + " - weight = " + model.getWidth());
        ganetable.setGridLinesVisible(true);
        ganetable.setHgap(4);
        ganetable.setVgap(4);

        switch (Crossword.puzzleNumber) {
            case 1:
                labelNiveau.setText(" Anglais débutant 1 ");
                row = 9;
                column = 9;
                break;
            case 2:
                labelNiveau.setText(" Anglais débutant 2 ");
                row = 9;
                column = 9;
                break;
            case 3:
                labelNiveau.setText(" Anglais débutant 3 ");
                row = 9;
                column = 9;
                break;
            case 4:
                labelNiveau.setText(" Anglais débutant 4 ");
                row = 9;
                column = 9;
                break;
            case 5:
                labelNiveau.setText(" Anglais débutant 5 ");
                row = 9;
                column = 9;
                break;
            case 6:
                labelNiveau.setText(" Anglais moyen 1 ");
                row = 15;
                column = 15;
                break;
            case 7:
                labelNiveau.setText(" Anglais moyen 2 ");
                row = 15;
                column = 15;
                break;
            case 8:
                labelNiveau.setText(" Anglais moyen 3");
                row = 15;
                column = 15;
                break;
            case 9:
                labelNiveau.setText(" Anglais expert (NYT) ");
                row = 15;
                column = 15;
                break;
            case 10:
                labelNiveau.setText(" Français débutant ");
                row = 6;
                column = 6;
                break;
        }

        listIndeceV.setItems(model.getVerticalClues());
        listIndicesH.setItems(model.getHorizontalClues());
        listIndeceV.setCellFactory(new ClueCellFactory());
        listIndicesH.setCellFactory(new ClueCellFactory());



//        -fx-background-color


        for (int row = 0; row < this.row; row++) {
            for (int column = 0; column < this.column; column++) {
                new CrosswordSquare();
                CrosswordSquare xsqr;
                xsqr = model.getCell(row, column);

                if (xsqr == null) {
                    xsqr = new CrosswordSquare(true, "", "", '0', row + 0, 0 + column);
                }
                xsqr.setFont(Font.font(20));

                // System.out.println("Row = "+row+" - Column = "+column+" -- xsqr="+ xsqr);
                xsqr.setPrefHeight((ganetable.getPrefHeight() - (this.row * 4)) / this.row);
                xsqr.setPrefWidth((ganetable.getPrefWidth() - (this.column * 4)) / this.column);
                //xsqr.setMinHeight();
                ganetable.add(xsqr, row, column);


            }

        }

    }


    public void GameExit(MouseEvent mouseEvent) {

    }

    public void GameReset(MouseEvent mouseEvent) {
        model.resetGame();
    }

    public void showSolution(MouseEvent mouseEvent) {
        model.printSolution();
    }

    public void ListNotifi(MouseEvent mouseEvent) {

        listIndeceV.setItems(model.getVerticalClues());
        listIndicesH.setItems(model.getHorizontalClues());
        listIndeceV.setCellFactory(new ClueCellFactory());
        listIndicesH.setCellFactory(new ClueCellFactory());
        System.out.println("Update liste look ");
    }


    public void ListNotifed() {

        listIndeceV.setItems(model.getVerticalClues());
        listIndicesH.setItems(model.getHorizontalClues());
        listIndeceV.setCellFactory(new ClueCellFactory());
        listIndicesH.setCellFactory(new ClueCellFactory());
        System.out.println("Update liste look ");
    }

    public static Controller getInstance() {
        return Controller.CrosswordHolder.INSTANCE;

    }

    private static class CrosswordHolder {
        private static final Controller INSTANCE = new Controller();
    }
}
