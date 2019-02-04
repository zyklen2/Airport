package Tests;
import Airport.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirportTests {
    @Test
    public void testAirport(){
        Airport theAirport=new Airport();
        assertEquals("",theAirport.getTheAircrafts().get(0).getCurrentStatus());
        theAirport.landAircraft(theAirport.getTheAircrafts().get(0),"O8L");
        assertEquals("justLanded",theAirport.getTheAircrafts().get(0).getCurrentStatus());
    }

}
