package Aircraft;

public interface IGear {
    void up();

    void down();

    void setBrake();

    void releaseBrake();

    boolean getIsDown();

    boolean getIsBrakeSet();
}
