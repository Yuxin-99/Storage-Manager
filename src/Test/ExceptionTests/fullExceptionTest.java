package Test.ExceptionTests;

import Exceptions.invalidLimit;
import Model.Manager;
import Model.individualStorage;
import Model.ordinaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class fullExceptionTest {
    private Manager ma = new Manager();
    private individualStorage m = new individualStorage("box");
    private ordinaryItem i0 = new ordinaryItem("ruler");

    @Test
    public void TestFull0(){
        try {
            m.setMaxCapacity(1);
            m.storeItem1("ruler");
            System.out.println("Maximum set!");
        } catch (Exceptions.invalidLimit invalidLimit) {
            fail("It is a valid maximum!");
        }
    }

    @Test
    public void TestFull1(){
        try {
            m.setMaxCapacity(-1);
            fail("It is not a valid maximum!");
        } catch (Exceptions.invalidLimit invalidLimit) {
            System.out.println("Catch it!");
        }
    }
}
