package Airport;

public class EventID implements IEventID {
    private int eventID=0;

    @Override
    public int getEventID() {
        return eventID++;
    }
}
