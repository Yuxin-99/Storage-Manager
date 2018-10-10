package Test;

import Model.individualStorage;

import Model.ordinaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;


public class TestIndividualStorage {
    private individualStorage box;

    @BeforeEach
    public void runBefore(){
        box = new individualStorage("Box");
    }

    //Test items can be added successfully
    @Test
    public void TestAddItem(){
        //assume the box is empty at first
        assertFalse(box.getItems().size() == 1);

        ordinaryItem newItem = new ordinaryItem("book");
        box.getItems().add(newItem);
        assertTrue(box.getItems().size() == 1);
        assertEquals(box.getItems().get(0), newItem);
    }

    //Test no more items can be added if the storage is full
    @Test
    public void TestAddMoreItems(){
        //Set the maxCapacity of the box
        box.setMaxCapacity(6);

        //Add some items to the box first
        box.storeItem1("book");
        box.storeItem1("pen");
        box.storeItem1("hat");
        box.storeItem1("cup");
        box.storeItem1("toys");

        ordinaryItem item5 = new ordinaryItem("crackers");
        ordinaryItem item6 = new ordinaryItem("chips");
        //Add another item, and this should be added successfully
        box.addItem(item5);
        assertEquals(box.getItems().size(), 6);

        //Add another item, and this should be unsuccessful
        box.addItem(item6);
        assertEquals(box.getItems().size(), 6);
    }
}
