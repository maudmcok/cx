package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;



public class CrosswordSquare extends TextField {

    private static Crossword model = Crossword.getInstance();
    private static Controller grid = Controller.getInstance();

    private int maxL = 1;
    private char solution;
    private String proposition;
    private String horizontalClue, verticalClue;
    private boolean black;
    //private BooleanProperty bblack;
    private int crossrow = 0;
    private int crosscolumn = 0;

    public CrosswordSquare() {
    }

    public CrosswordSquare(boolean black, String horizontalClue, String verticalClue, char solution, int crossrow, int crosscolumn) {
        this.black = black;
        this.horizontalClue = horizontalClue;
        this.verticalClue = verticalClue;
        this.solution = solution;
        this.crossrow = crossrow;
        this.crosscolumn = crosscolumn;
        this.setEditable(!black);
        //   black = model.isBlackSquare(crossrow, crosscolumn);
        // this.solution = model.getSolution(crossrow, crosscolumn);
        this.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!black) {
                System.out.println(" Clue H = " + this.horizontalClue + " V = " +this.verticalClue);
                CrosswordSquare.super.setText("");
                this.proposition = ("");
                String character = event.getCharacter();
                character = character.toLowerCase();
                if (Character.isLetter(character.charAt(0))) {


              /*  CrosswordSquare.super.setText("");
                System.out.println(" key value = " + character);*/
                    CrosswordSquare.super.setText("");
                    System.out.println(" key value = " + character.charAt(0));
                    //CrosswordSquare.super.setText(""+proposition);
                    this.proposition = ("" + character);

                    if (this.solution == character.charAt(0)) this.setStyle("-fx-background-color : green ");
                    else this.setStyle("-fx-background-color : white");


                } else {
                    System.out.println(" not Lettre ");
                    if (!black) this.setStyle("-fx-background-color : white");
                    event.consume();
                }

            }
            CrosswordSquare.super.setText("  ");
        });

        if (black) this.setStyle("-fx-background-color : black ");
        else this.setStyle("-fx-background-color : white");

        this.setOnMouseClicked(event -> {
            if (!black) {

              //  crtll.ListNotifed();
              //  Thread thread = new Thread(new ThreadMasterColor(crossrow ,crosscolumn));
              //  thread.start();



                this.setStyle("javafx fx-border-color: bleu");
    
            }

        });


        this.setOnMouseExited(event -> {


            if (!black)  this.setStyle("-fx-background-color : white");

        });

    }


    public char getProposition() {
        return this.getText().charAt(0);
    }


    public char getSolution() {
        return solution;
    }

    public void setSolution(char solution) {
        this.solution = solution;

    }

    public String propositionProperty() {
        return proposition;
    }

    public void setProposition(String proposition) {
        CrosswordSquare.super.setText("");
        System.out.println(" key value = " + proposition);
        CrosswordSquare.super.setText("" + proposition);
        this.proposition = ("" + proposition);
        if ((proposition != "") && (proposition != null)) {
            if (this.solution == proposition.charAt(0)) this.setStyle("-fx-background-color : green ");
            else this.setStyle("-fx-background-color : white");
        }

    }


    public String getHorizontalClue() {
        return horizontalClue;
    }

    public void setHorizontalClue(String horizontalClue) {
        this.horizontalClue = horizontalClue;
    }

    public String getVerticalClue() {
        return verticalClue;
    }

    public void setVerticalClue(String verticalClue) {
        this.verticalClue = verticalClue;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    @Override
    public String toString() {
        return "CrosswordSquare{" +
                "maxL=" + maxL +
                ", solution=" + solution +
                ", proposition=" + proposition +
                ", horizontalClue='" + horizontalClue + '\'' +
                ", verticalClue='" + verticalClue + '\'' +
                ", black=" + black +
                ", crossrow=" + crossrow +
                ", crosscolumn=" + crosscolumn +
                '}';
    }

    public void initblack() {
        //  setBlack();
    }


}
