package Test.ExceptionTests;


import Model.IndividualStorage;
import Model.OrdinaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class noneExistTest {
    private IndividualStorage m = new IndividualStorage("box");
    private OrdinaryItem i0 = new OrdinaryItem("ruler");

    @Test
    public void TestNoneExist0(){
        try {
            m.addItem(i0);
        } catch (Exceptions.fullStorage fullStorage) {
        }
        try {
            m.moveItem("ruler");
            System.out.println("YAY! Remove!");
            assertTrue(m.getStocks().size() == 0);
        } catch (Exceptions.noneExist noneExist) {
            fail("False exception...");
        }
    }

    @Test
    public void TestNoneExist1(){
        try{
            m.moveItem("ruler");
            fail("This item does not exist!");
        } catch (Exceptions.noneExist noneExist) {
            System.out.println("Pass!");
        }
    }
}
