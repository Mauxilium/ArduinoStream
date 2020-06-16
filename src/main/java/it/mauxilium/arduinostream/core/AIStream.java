package it.mauxilium.arduinostream.core;

public class AIStream extends ArduinoSpliterator<Integer> {
    public AIStream(String port, int baudRate) {
        super(port, baudRate);
    }

    public Integer stream(Integer value1, Integer value2) {
        pushData(value1);
        return value2;
    }
}
