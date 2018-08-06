package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by matok on 08/07/2017.
 */
public class Crossword extends Grid<CrosswordSquare> {

    public static int height = 15;
    public static int width = 15;
    public int ExtHClue = 9999 ;
    public int ExtVClue = 9999  ;
    private ObservableList<Clue> verticalClues = FXCollections.observableArrayList();
    private ObservableList<Clue> horizontalClues = FXCollections.observableArrayList();
    ObservableList<Clue> data = FXCollections.observableArrayList();
    private Database myData = new Database();
    private static Database myDatas = new Database();
    List<Clue> listV = new ArrayList<>();
    List<Clue> listH = new ArrayList<>();
    public static ArrayList<HashMap<String, Object>> lists;
    public final static int puzzleNumber = myDatas.getRandomPuzzleNumber();
    //public final static int puzzleNumber =10;

    public void initcross() {

        switch (puzzleNumber / 5) {
            case 0:
                this.height = 9;
                this.width = 9;
                break;
            case 1:
                this.height = 15;
                this.width = 15;
                break;
            case 2:
                this.height = 6;
                this.width = 7;
                break;
        }

        createPuzzle(myData, puzzleNumber + 0);

    }

    public Crossword(int height, int width) {
        super(height, width);

    }

    String GetProposition(int row, int column) {
        return "" + getCell(row, column).getProposition();
    }

    public boolean isBlackSquare(int row, int column) {
        return getCell(row, column).isBlack();
    }

    public void setBlackSquare(int row, int column, boolean black) {
        getCell(row, column).setBlack(black);
    }

    public char getSolution(int row, int column) {
        return getCell(row, column).getSolution();
    }

    public void setSolution(int row, int column, char solution) {
        getCell(row, column).setSolution(solution);
    }

    public char getProposition(int row, int column) {
        return getCell(row, column).getProposition();
    }

    public void setProposition(int row, int column, String proposition) {
        getCell(row, column).setProposition(proposition);
    }

    public String getClue(int row, int column, boolean horizontal) {
        if (horizontal) {
            return getCell(row, column).getHorizontalClue();
        } else {
            return getCell(row, column).getVerticalClue();
        }
    }

    public void setClue(int row, int column, boolean horizontal, String definition) {
        if (horizontal) {
            getCell(row, column).setHorizontalClue(definition);
        } else {
            getCell(row, column).setVerticalClue(definition);
        }
    }

    public ObservableList<Clue> getVerticalClues() {
        return verticalClues;
    }

    public ObservableList<Clue> getHorizontalClues() {
        return horizontalClues;
    }

    public List<Clue> getListeV() {
        return listV;
    }

    public List<Clue> getListeH() {
        return listH;
    }

    public void  ColorMMaster(int id, boolean horizontal,boolean active){
        if (horizontal){
            horizontalClues.get(id).setSelected(active);
        }else {
            verticalClues.get(id).setSelected(active);
        }
    }

    public Crossword createPuzzle(Database database, int puzzleNumber) {

        switch (puzzleNumber / 5) {
            case 0:
                this.height = 9;
                this.width = 9;
                break;
            case 1:
                this.height = 15;
                this.width = 15;
                break;
            case 2:
                this.height = 6;
                this.width = 6;
                break;
        }
        // Crossword auxcross = new Crossword(height + 0, width + 0);
        //  System.out.println("height = "+this.getHeight()+" - weight = "+this.getWidth());
        lists = database.getClues(puzzleNumber);
        //  System.out.println(" my liste = = " + lists.toString());
        if (lists != null) lists.forEach(items -> {
            String horizontal = (String) items.get("horizontal");
            items.forEach((k, v) -> {
                if (horizontal.equals("0")) {

                    String solution = (String) items.get("solution");
                    int row = Integer.valueOf(items.get("row").toString());
                    int column = Integer.valueOf(items.get("column").toString());
                    String cluea = (String) items.get("clue");

                    Clue auxClue = new Clue(cluea, row, column, true);

                    //   horizontalClues.
                    if (!horizontalClues.isEmpty()) {
                        if (horizontalClues.get(horizontalClues.size() - 1).getClue() != auxClue.getClue())
                            horizontalClues.add(auxClue);
                    } else horizontalClues.add(auxClue);
                    // if (!horizontalClues.contains(auxClue))horizontalClues.add(auxClue) ;
                    //verticalClues.add(new Clue(cluea, row, column, false));
                    System.out.println(" Solution -> " + solution.toString());
                    for (int i = 0; i < solution.length(); i++) {
                        this.setCell(row + i, column + 0, new CrosswordSquare(false, "" + cluea, "", solution.charAt(i), row + i, column + 0));
                    }
                } else {

                    String solution = (String) items.get("solution");

                    int row = Integer.valueOf(items.get("row").toString());
                    int column = Integer.valueOf(items.get("column").toString());
                    String cluea = (String) items.get("clue");
                    Clue xsclue = new Clue(cluea, row, column, true);
                    System.out.println(" Solution -> " + solution);


                    //  if (!verticalClues.contains(""+cluea+" ( "+ row+", "+ column+") "))verticalClues.add(""+cluea+" ( "+ row+", "+ column+") ");


                    Clue auxClue = new Clue(cluea, row, column, false);
                    //if (!verticalClues.contains(auxClue)) verticalClues.add(auxClue);
                    if (!verticalClues.isEmpty()) {
                        if (verticalClues.get(verticalClues.size() - 1).getClue() != auxClue.getClue())
                            verticalClues.add(auxClue);
                    } else verticalClues.add(auxClue);

                    for (int i = 0; i < solution.length(); i++) {
                        this.setCell(row + 0, column + i, new CrosswordSquare(false, "", "" + cluea, solution.charAt(i), row + 0, column + i));
                    }
                }

            });

        });


        return this;
    }

    //reste les fonction observable jusqua la fin de la class

    public void printSolution() {
        Thread thread = new Thread(new ThreadMaster());
        thread.start();
    }

    public void resetGame() {
        Thread thread = new Thread(new ThreadMasterReset());
        thread.start();
    }

    public static Crossword getInstance() {
        return CrosswordHolder.INSTANCE;

    }

    private static class CrosswordHolder {
        private static final Crossword INSTANCE = new Crossword(Crossword.height, Crossword.width);
    }

}
