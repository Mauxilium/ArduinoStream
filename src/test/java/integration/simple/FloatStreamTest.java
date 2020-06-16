package integration.simple;

import it.mauxilium.arduinojavaserialrpc.exception.ArduinoRpcInitializationError;
import it.mauxilium.arduinostream.ArduinoFloatStream;

import java.util.List;
import java.util.stream.Collectors;

public class FloatStreamTest {

    public static void main(String[] argv) throws ArduinoRpcInitializationError {
        ArduinoFloatStream arduino = new ArduinoFloatStream("COM5", 9600);
        List<Float> res = arduino.stream()
                .limit(1000)
                .collect(Collectors.toList());

        System.out.println("Ricevuti: "+res.size()+" elementi...");
    }
}
