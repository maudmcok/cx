package sample;

import javafx.scene.control.ListCell;


public class ClueCell extends ListCell<Clue>
{
    @Override
    public void updateItem(Clue item, boolean empty)
    {
        super.updateItem(item, empty);

        int index = this.getIndex();
        String name = null;

        // Format name
        if (item == null || empty)
        {
        }
        else
        {
            name = item.getClue() + " (" +
                    item.getRow() + ", " +
                    item.getColumn()+
                    ") ";
            if (item.isSelected())
                this.setStyle("-fx-background-color : green");
        }

        this.setText(name);
     //   if (item.isSelected())
       // this.setStyle("-fx-background-color : green");
        setGraphic(null);
    }
}
