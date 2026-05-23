package dsa_aug_25.graph;

import java.util.*;

class SerialIO {
    private Queue<Byte> rxFifo = new LinkedList<>();
    private static final int FIFO_CAPACITY = 4096;

    // Simulate status register
    private boolean isRxEmpty() {
        return rxFifo.isEmpty();
    }

    private boolean isRxFull() {
        return rxFifo.size() == FIFO_CAPACITY;
    }

    // Simulate FIFO window register (read next byte)
    private byte readFromFifoWindow() {
        if (isRxEmpty()) {
            return (byte)0xFF; // garbage byte if empty
        }
        return rxFifo.poll();
    }

    // Method to drain Rx FIFO
    public int drainRxFifo(byte[] destBuffer) {
        int count = 0;
        while (!isRxEmpty() && count < destBuffer.length) {
            destBuffer[count++] = readFromFifoWindow();
        }
        return count;
    }

    // Helper: load data into FIFO (simulate incoming bytes)
    public void loadRxData(byte[] data) {
        for (byte b : data) {
            if (!isRxFull()) {
                rxFifo.add(b);
            }
        }
    }
}

public class DrainRxDemo {
    public static void main(String[] args) {
        SerialIO serial = new SerialIO();

        // Simulate incoming data
        serial.loadRxData(new byte[]{10, 20, 30, 40, 50});

        // Destination buffer
        byte[] buffer = new byte[10];

        // Drain FIFO
        int bytesRead = serial.drainRxFifo(buffer);

        System.out.println("Bytes read: " + bytesRead);
        System.out.print("Data: ");
        for (int i = 0; i < bytesRead; i++) {
            System.out.print(buffer[i] + " ");
        }
    }
}
