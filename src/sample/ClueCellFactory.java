package sample;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ClueCellFactory implements Callback<ListView<Clue>, ListCell<Clue>>
{
    @Override
    public ListCell<Clue> call(ListView<Clue> listview)
    {
        return new ClueCell();
    }
}