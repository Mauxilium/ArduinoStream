package it.mauxilium.arduinostream.core;

public class AFStream extends ArduinoSpliterator<Float> {
    public AFStream(String port, int baudRate) {
        super(port, baudRate);
    }

    public Float stream(Float value) {
        pushData(value);
        return value;
    }
}
