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
        assertTrue(myManager.getAvailableStorage().keySet().size() == 0);
        myManager.addNew("pink box");
        assertTrue(myManager.getAvailableStorage().keySet().size() == 1);
        assertTrue(myManager.getAvailableStorage().containsKey("pink box"));
    }

    @Test
    public void TestMove(){
        //add some storage to the availableStorage
        myManager.addNew("pink box");
        myManager.addNew("plastic case");
        myManager.addNew("wardrobe");

        try {
            myManager.getAvailableStorage().get("pink box").setMaxCapacity(6);
        } catch (Exceptions.invalidLimit invalidLimit) {
        }
        try {
            myManager.getAvailableStorage().get("plastic case").setMaxCapacity(3);
        } catch (Exceptions.invalidLimit invalidLimit) {
            invalidLimit.printStackTrace();
        }

        //add items to some storage
        myManager.getAvailableStorage().get("pink box").storeItem1("keys");
        myManager.getAvailableStorage().get("pink box").storeItem1("tea");

        myManager.getAvailableStorage().get("plastic case").storeItem1("pencil");

        //move an item from the pink box to the wardrobe
    }
}
