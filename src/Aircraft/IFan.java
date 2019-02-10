package Aircraft;

public interface IFan {
    void start();

    void increaseRPM(int value);

    void decreaseRPM(int value);

    void shutdown();

    int getRPM();

    int getId();
}
