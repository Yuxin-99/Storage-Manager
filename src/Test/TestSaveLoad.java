package Test;

import Model.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSaveLoad {
    private Manager manager;

    @BeforeEach
    public void runBefore(){
        manager = new Manager();
    }

    @Test
    public void TestLoad() throws IOException {
        List<String> text = manager.load();
        List<String> testText = new ArrayList<>();
        testText.add("bookshelf");
        testText.add("[textbook, notebook, laptop]");
        testText.add("white case");
        testText.add("[photo, pen, ruler, lipstick, headphones]");
        testText.add("wardrobe");
        testText.add("[coats, pants, sweater]");
        testText.add("upper drawer");
        testText.add("[ID]");
        testText.add("lower drawer");
        testText.add("[keys]");
        testText.add("middle drawer");
        testText.add("[]");
        assertEquals(text, testText);
    }

    @Test
    public void TestSave() throws IOException {
        manager.addNew("pink box");
        manager.addNew("plastic case");
        manager.getAvailableStorage().get(0).setMaxCapacity(6);
        manager.getAvailableStorage().get(1).setMaxCapacity(3);
        manager.getAvailableStorage().get(0).storeItem1("keys");
        manager.getAvailableStorage().get(0).storeItem1("tea");
        List<String> file = manager.save();
        List<String> testFile = new ArrayList<>();
        testFile.add("pink box");
        testFile.add("[keys, tea]");
        testFile.add("plastic case");
        testFile.add("[]");
        assertEquals(testFile, file);
    }
}
