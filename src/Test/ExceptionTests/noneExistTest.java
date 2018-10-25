package Test.ExceptionTests;


import Exceptions.noneExist;
import Model.individualStorage;
import Model.ordinaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class noneExistTest {
    private individualStorage m = new individualStorage("box");
    private ordinaryItem i0 = new ordinaryItem("ruler");

    @Test
    public void TestNoneExist0(){
        m.addItem(i0);
        try {
            m.removeItem(i0);
            System.out.println("YAY! Remove!");
            assertTrue(m.getItems().size() == 0);
        } catch (Exceptions.noneExist noneExist) {
            fail("False exception...");
        }
    }

    @Test
    public void TestNoneExist1(){
        try{
            m.removeItem(i0);
            fail("This item does not exist!");
        } catch (Exceptions.noneExist noneExist) {
            System.out.println("Catch it!");
        }
    }
}
