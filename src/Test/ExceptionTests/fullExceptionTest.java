package Test.ExceptionTests;

import Model.Manager;
import Model.IndividualStorage;
import Model.OrdinaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class fullExceptionTest {
    private Manager ma = new Manager();
    private IndividualStorage m = new IndividualStorage("box");
    private OrdinaryItem i0 = new OrdinaryItem("ruler");

    @Test
    public void TestFull0(){
        try {
            m.setMaxCapacity(1);
            m.storeItem1("ruler");
            System.out.println("Pass!Maximum set!");
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
            System.out.println("Pass!");
        }
    }
}
