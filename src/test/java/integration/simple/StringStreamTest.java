package integration.simple;

import it.mauxilium.arduinojavaserialrpc.exception.ArduinoRpcInitializationError;
import it.mauxilium.arduinostream.ArduinoStringStream;

import java.util.List;
import java.util.stream.Collectors;

public class StringStreamTest {

    public static void main(String[] argv) throws ArduinoRpcInitializationError {
        ArduinoStringStream arduino = new ArduinoStringStream("COM5", 9600);
        List<String> res = arduino.stream()
                .limit(78)
//                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("Ricevuti: "+res.size()+" elementi...");
    }
}
