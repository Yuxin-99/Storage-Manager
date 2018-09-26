package Test;

import Model.individualStorage;
import Model.Item;

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
        assertFalse(box.Items.size() == 1);

        Item newItem = new Item("book");
        box.Items.add(newItem);
        assertTrue(box.Items.size() == 1);
        assertEquals(box.Items.get(0), newItem);
    }

    //Test no more items can be added if the storage is full
    @Test
    public void TestAddMoreItems(){
        //Set the maxCapacity of the box
        box.setMaxCapacity(6);

        //Add some items to the box first
        box.storeItem("book");
        box.storeItem("pen");
        box.storeItem("hat");
        box.storeItem("cup");
        box.storeItem("toys");

        Item item5 = new Item("crackers");
        Item item6 = new Item("chips");
        //Add another item, and this should be added successfully
        box.addItem(item5);
        assertTrue(box.verifyStore(item5));
        assertEquals(box.Items.size(), 6);

        //Add another item, and this should be unsuccessful
        box.addItem(item6);
        assertFalse(box.Items.contains(item6));
        assertEquals(box.Items.size(), 6);
    }
}
