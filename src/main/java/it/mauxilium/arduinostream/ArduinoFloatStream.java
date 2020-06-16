package it.mauxilium.arduinostream;

import it.mauxilium.arduinojavaserialrpc.exception.ArduinoRpcInitializationError;
import it.mauxilium.arduinostream.core.AFStream;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ArduinoFloatStream {
    private AFStream arduino;
    public ArduinoFloatStream(String port, int baudRate) {
        arduino = new AFStream(port, baudRate);
    }

    public Stream<Float> stream() throws ArduinoRpcInitializationError {
        arduino.connect();
        return StreamSupport.stream(arduino, false);
    }
}
