package it.mauxilium.arduinostream.core;

import it.mauxilium.arduinojavaserialrpc.ArduinoJavaSerialRpc;

import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

class ArduinoSpliterator<T> extends ArduinoJavaSerialRpc implements Spliterator<T> {
    private LinkedList<T> buffer = new LinkedList<>();

    public ArduinoSpliterator(String port, int baudRate) {
        super(port, baudRate);
    }

    public void pushData(T value) {
        buffer.add(value);
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        if (buffer.isEmpty() == false) {
            action.accept(buffer.poll());
        }
        return true;
    }

    @Override
    public Spliterator<T> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return buffer.size();
    }

    @Override
    public int characteristics() {
        return NONNULL;
    }
}
