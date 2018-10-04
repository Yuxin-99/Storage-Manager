package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.Main.allStorage;

public class TestSaveLoad {
    private Main main;

    @BeforeEach
    public void runBefore(){
        main = new Main();
    }

    @Test
    public void TestLoad() throws IOException {
        List<String> text = main.load();
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
        main.allStorage.addNew("pink box");
        main.allStorage.addNew("plastic case");
        main.allStorage.availableStorage.get(0).setMaxCapacity(6);
        main.allStorage.availableStorage.get(1).setMaxCapacity(3);
        main.allStorage.availableStorage.get(0).storeItem("keys");
        main.allStorage.availableStorage.get(0).storeItem("tea");
        List<String> file = main.save();
        List<String> testFile = new ArrayList<>();
        testFile.add("pink box");
        testFile.add("[keys, tea]");
        testFile.add("plastic case");
        testFile.add("[]");
        assertEquals(testFile, file);
    }
}
