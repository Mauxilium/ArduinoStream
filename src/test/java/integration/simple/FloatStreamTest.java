package integration.simple;

import it.mauxilium.arduinojavaserialrpc.exception.ArduinoRpcInitializationError;
import it.mauxilium.arduinostream.ArduinoFloatStream;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FloatStreamTest {

    public static void main(String[] argv) throws ArduinoRpcInitializationError {
        ArduinoFloatStream arduino = new ArduinoFloatStream("COM16", 9600);

        OffsetDateTime begin = OffsetDateTime.now();
        long res = arduino.stream()
                .peek(System.out::println)
                .limit(1000)
                .count();
        OffsetDateTime end = OffsetDateTime.now();

        long delta = (end.toInstant().toEpochMilli() - begin.toInstant().toEpochMilli());
        System.out.println("Received: "+res+" elements, time: "+delta+" mSec");
    }
}
