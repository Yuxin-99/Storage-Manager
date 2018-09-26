package Test;

import Model.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;



public class TestStorage {
    private Storage myStorage;

    @BeforeEach
    public void runBefore(){
        myStorage = new Storage();
    }

    //Test you can add a new storage to the availableStorage
    @Test
    public void TestAddNewStorage(){
        //assume no storage available at first
        assertTrue(myStorage.availableStorage.size() == 0);
        myStorage.addNew("pink box");
        assertTrue(myStorage.availableStorage.size() == 1);
        assertEquals(myStorage.availableStorage.get(0).name, "pink box");
    }

    @Test
    public void TestMove(){
        //add some storage to the availableStorage
        myStorage.addNew("pink box");
        myStorage.addNew("plastic case");
        myStorage.addNew("wardrobe");

        myStorage.availableStorage.get(0).setMaxCapacity(6);
        myStorage.availableStorage.get(1).setMaxCapacity(3);

        //add items to some storage
        myStorage.availableStorage.get(0).storeItem("keys");
        myStorage.availableStorage.get(0).storeItem("tea");

        myStorage.availableStorage.get(1).storeItem("pencil");

        //move an item from the pink box to the wardrobe
    }
}
