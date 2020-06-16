package it.mauxilium.arduinostream.core;

public class ASStream extends ArduinoSpliterator<String> {
    public ASStream(String port, int baudRate) {
        super(port, baudRate);
    }

    public String stream(String value) {
        pushData(value);
        return "";
    }
}
