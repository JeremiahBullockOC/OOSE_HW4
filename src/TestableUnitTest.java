package src;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestableUnitTest {
    
    @Test
    public void testableTest_01(){


        Testable car01 = new Testable(10000, 2002, "Hyundai", "Elantra", Testable.carType.CAR, false); 
        Testable suv01 = new Testable(10000, 2002, "Hyundai", "Tucson", Testable.carType.SUV, false); 
        Testable exception = new Testable(10000, 2026, "Ford", "Lightning", Testable.carType.TRUCK, false);
    
 
        try{
            assertTrue(car01.calculateCurrentPrice(2006) < 10000);
            assertEquals(car01.calculateCurrentPrice(2006), 4000.00, 0.001);
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
        Testable car01 = new Testable(10000, 2002, "Hyundai", "Elantra", Testable.carType.CAR, false); 
        assertFalse(car01.getHadAccident());
        car01.setHadAccident(true);
        assertTrue(car01.getHadAccident());
    }

    @Test
    public void testableTest_03(){
        Testable suv01 = new Testable(10000, 2002, "Hyundai", "Tucson", Testable.carType.SUV, false); 
        Testable motorcycle01 = new Testable(10000, 2002, "Harley", "Davidson", Testable.carType.MOTORCYCLE, false); 

        try{

           assertEquals(suv01.findCurrentDepreciationPercent(2012), 0.17, 0.01);
           assertEquals(suv01.findCurrentDepreciationPercent(2025), 0.1, 0.01);
           assertTrue(suv01.findCurrentDepreciationPercent(2012) > motorcycle01.findCurrentDepreciationPercent(2012));
        }
        catch (Exception e){
            assertTrue(false);
        }

    }

    @Test
    public void testableMockTest(){
    }





}
