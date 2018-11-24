package Test;

import Model.IndividualStorage;

import Model.OrdinaryItem;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


public class TestIndividualStorage {
    private IndividualStorage box;

    @BeforeEach
    public void runBefore(){
        box = new IndividualStorage("Box");
    }

    //Test items can be added successfully
    @Test
    public void TestAddItem(){
        //assume the box is empty at first
        assertFalse(box.getStocks().size() == 1);

        OrdinaryItem newItem = new OrdinaryItem("book");
        try {
            box.addItem(newItem);
        } catch (Exceptions.fullStorage fullStorage) {
        }
        assertTrue(box.getStocks().size() == 1);
        assertTrue(box.getStocks().contains(newItem));
        assertEquals(newItem.getIndividualStorage(), box);
    }

    //Test no more items can be added if the storage is full
    @Test
    public void TestAddMoreItems(){
        //Set the maxCapacity of the box
        try {
            box.setMaxCapacity(6);
        } catch (Exceptions.invalidLimit invalidLimit) {
        }

        //Add some items to the box first
        box.storeItem1("book");
        box.storeItem1("pen");
        box.storeItem1("hat");
        box.storeItem1("cup");
        box.storeItem1("toys");

        OrdinaryItem item5 = new OrdinaryItem("crackers");
        OrdinaryItem item6 = new OrdinaryItem("chips");
        //Add another item, and this should be added successfully
        try {
            box.addItem(item5);
        } catch (Exceptions.fullStorage fullStorage) {
        }
        assertEquals(box.getStocks().size(), 6);
        assertTrue(item5.getIndividualStorage().equals(box));

        //Add another item, and this should be unsuccessful
        try {
            box.addItem(item6);
        } catch (Exceptions.fullStorage fullStorage) {
        }
        assertEquals(box.getStocks().size(), 6);
        assertNull(item6.getIndividualStorage());
    }
}
