package src;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestableUnitTest {
    
    @Test
    public void testableTest_01(){


        Testable car01 = new Testable(10000, 2002, "Hyundai", "Elantra", Testable.carType.CAR, false); 
        Testable suv01 = new Testable(10000, 2002, "Hyundai", "Tucson", Testable.carType.SUV, false); 
        Testable exception = new Testable(10000, 2026, "Ford", "Lightning", Testable.carType.TRUCK, false);
    
 
        try{
            assertTrue(car01.calculateCurrentPrice(2006) < 10000);
            assertTrue(car01.calculateCurrentPrice(2006) < suv01.calculateCurrentPrice(2006));
        } catch(Exception e){
            assertFalse(true);
        }
        try{

            exception.calculateCurrentPrice(2023);
            assertTrue(false);
        }
        catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void testableTest_02(){
        
    }



}
