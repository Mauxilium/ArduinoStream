package integration.simple;

import it.mauxilium.arduinojavaserialrpc.exception.ArduinoRpcInitializationError;
import it.mauxilium.arduinostream.ArduinoIntegerStream;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerStreamTest {

    public static void main(String[] argv) throws ArduinoRpcInitializationError {
        ArduinoIntegerStream arduino = new ArduinoIntegerStream("COM5", 9600);
        List<Integer> res = arduino.stream()
                .limit(10000)
                .filter(n -> n%2 > 0)
                .collect(Collectors.toList());

        System.out.println("Ricevuti: "+res.size()+" elementi...");
    }
}
