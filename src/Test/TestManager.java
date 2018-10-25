package Test;

import Exceptions.invalidLimit;
import Model.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;



public class TestManager {
    private Manager myManager;

    @BeforeEach
    public void runBefore(){
        myManager = new Manager();
    }

    //Test you can add a new storage to the availableStorage
    @Test
    public void TestAddNewStorage(){
        //assume no storage available at first
        assertTrue(myManager.getAvailableStorage().size() == 0);
        myManager.addNew("pink box");
        assertTrue(myManager.getAvailableStorage().size() == 1);
        assertEquals(myManager.getAvailableStorage().get(0).getName(), "pink box");
    }

    @Test
    public void TestMove(){
        //add some storage to the availableStorage
        myManager.addNew("pink box");
        myManager.addNew("plastic case");
        myManager.addNew("wardrobe");

        try {
            myManager.getAvailableStorage().get(0).setMaxCapacity(6);
        } catch (Exceptions.invalidLimit invalidLimit) {
        }
        try {
            myManager.getAvailableStorage().get(1).setMaxCapacity(3);
        } catch (Exceptions.invalidLimit invalidLimit) {
        }

        //add items to some storage
        myManager.getAvailableStorage().get(0).storeItem1("keys");
        myManager.getAvailableStorage().get(0).storeItem1("tea");

        myManager.getAvailableStorage().get(1).storeItem1("pencil");

        //move an item from the pink box to the wardrobe
    }
}
