package it.mauxilium.arduinostream;

import it.mauxilium.arduinojavaserialrpc.exception.ArduinoRpcInitializationError;
import it.mauxilium.arduinostream.core.ASStream;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ArduinoStringStream {
    private ASStream arduino;
    public ArduinoStringStream(String port, int baudRate) {
        arduino = new ASStream(port, baudRate);
    }

    public Stream<String> stream() throws ArduinoRpcInitializationError {
        arduino.connect();
        return StreamSupport.stream(arduino, false);
    }
}
