package it.mauxilium.arduinostream.core;

import it.mauxilium.arduinojavaserialrpc.ArduinoJavaSerialRpc;

import java.util.Spliterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

class ArduinoSpliterator<T> extends ArduinoJavaSerialRpc implements Spliterator<T> {
    private LinkedBlockingQueue<T> buffer = new LinkedBlockingQueue<>();

    public ArduinoSpliterator(String port, int baudRate) {
        super(port, baudRate);
    }

    public void pushData(T value) {
        buffer.add(value);
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        T value = null;
        do {
            try {
                value = buffer.poll(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ignored) { }
        } while (value == null);

        action.accept(value);
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
