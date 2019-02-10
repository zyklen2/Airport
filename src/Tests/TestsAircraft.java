package Tests;

import Aircraft.*;
import Airport.*;
import People.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestsAircraft {
    @Test
    public void testAircraft(){
        Pilot[] pilots=new Pilot[2];
        FlightAttendant[] flightAttendants=new FlightAttendant[3];
        for(int j=0;j<2;j++){
            Pilot tempPilot=new Pilot();
            pilots[j]=tempPilot;
        }
        for(int j=0;j<3;j++){
            FlightAttendant flightAttendant=new FlightAttendant();
            flightAttendants[j]=flightAttendant;
        }
        Crew theCrew = new Crew(pilots,flightAttendants);
        Aircraft theAircraft = new Aircraft(AircraftID.F01,"Boing",100,200,268,"Flying","Flying",theCrew);
        IGate theGate = new Gate(true,GateID.A01);
        theAircraft.setGate(theGate);
        assertEquals(theGate,theAircraft.getCurrentGate());
        assertEquals("InGate",theAircraft.getCurrentStatus());
        assertEquals(GateID.A01.toString(),theAircraft.getLocation());
        assertEquals(AircraftID.F01,theAircraft.getId());
        theAircraft.setCurrentStatus("Landed");
        theAircraft.setLocation("S1");
        assertEquals("Landed",theAircraft.getCurrentStatus());
        assertEquals("S1",theAircraft.getLocation());
        //getRecordedData enthält einen zeitstempel der nicht beeinflusst werden kann, weshalb diese Methode nicht geprüft werden kann
    }

    @Test
    public void testFan(){
        IFan theFan = new Fan(0);
        assertEquals(0,theFan.getId());
        theFan.start();
        assertEquals(10,theFan.getRPM());
        theFan.increaseRPM(10);
        assertEquals(20,theFan.getRPM());
        theFan.decreaseRPM(10);
        assertEquals(10,theFan.getRPM());
        theFan.shutdown();
        assertEquals(0,theFan.getRPM());
    }

    @Test
    public void testFlap(){
        IFlap theFlap = new Flap(0);
        theFlap.neutral();
        assertEquals(0,theFlap.getDegree());
        theFlap.levelOne();
        assertEquals(10,theFlap.getDegree());
        theFlap.levelTwo();
        assertEquals(20,theFlap.getDegree());
        theFlap.levelThree();
        assertEquals(30,theFlap.getDegree());
    }

    @Test
    public void testFlightrecorder(){
        //Kann nicht getestet werden, da zwar Daten hinzugefügt werden könnten, diese aber aufgrund des Zeitstempels in der Getter-Methode nicht prüfbar wären
    }

    @Test
    public void testGear(){
        IGear theGear = new Gear(GearType.Front,6,0);
        theGear.setBrake();
        assertEquals(true,theGear.getIsBrakeSet());
        theGear.releaseBrake();
        assertEquals(false,theGear.getIsBrakeSet());
        theGear.down();
        assertEquals(true,theGear.getIsDown());
        theGear.up();
        assertEquals(false,theGear.getIsDown());
    }

    @Test
    public void testSeat(){
        Passenger thePassenger = new Passenger();
        ISeat theSeat = new Seat(0,BookingClass.First);
        theSeat.setThePassenger(thePassenger);
        assertEquals(thePassenger,theSeat.getThePassenger());
    }

    @Test
    public void testWing(){
        //Alles Methoden deren korrekte Ausführung nicht geprüft werden kann, die aber Aufgrund des richtrigen Szenarioablaufs stimmen.
    }
}
