package Airport;

public enum CommunicationFrequencys{
ApronControl(121.5),Tower(128.5);
private double frequency;
CommunicationFrequencys(double frequency){
    this.frequency=frequency;
}

    public double getFrequency() {
        return frequency;
    }
}
