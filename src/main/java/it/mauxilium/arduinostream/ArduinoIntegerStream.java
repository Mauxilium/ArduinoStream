package it.mauxilium.arduinostream;

import it.mauxilium.arduinojavaserialrpc.exception.ArduinoRpcInitializationError;
import it.mauxilium.arduinostream.core.AIStream;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ArduinoIntegerStream {
    private AIStream arduino;
    public ArduinoIntegerStream(String port, int baudRate) {
        arduino = new AIStream(port, baudRate);
    }

    public Stream<Integer> stream() throws ArduinoRpcInitializationError {
        arduino.connect();
        return StreamSupport.stream(arduino, false);
    }
}
