package dsa_aug_25.noog;

import java.util.*;

public class SerialIO1 {
    private static final int FIFO_SIZE = 4096;
    private Queue<Byte> rxFifo = new ArrayDeque<>();

    // Simulated status register
    private int getStatus() {
        int status = 0;
        if (rxFifo.isEmpty()) status |= 0x01; // Bit 0: RX empty
        if (rxFifo.size() == FIFO_SIZE) status |= 0x10; // Bit 4: RX full
        return status;
    }

    // Simulated FIFO window read
    private byte readFifoWindow() {
        if (rxFifo.isEmpty()) {
            return (byte)0xFF; // garbage byte if empty
        }
        return rxFifo.poll();
    }

    // API: Drain RX FIFO
    public int drainRxFifo(byte[] destBuffer) {
        int count = 0;
        while ((getStatus() & 0x01) == 0 && count < destBuffer.length) {
            destBuffer[count++] = readFifoWindow();
        }
        return count;
    }

    // Helper: preload RX FIFO for testing
    public void loadRxData(byte[] data) {
        for (byte b : data) {
            if (rxFifo.size() < FIFO_SIZE) {
                rxFifo.add(b);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        SerialIO1 io = new SerialIO1();
        io.loadRxData(new byte[]{10, 20, 30, 40, 50});

        byte[] buffer = new byte[10];
        int bytesRead = io.drainRxFifo(buffer);

        System.out.println("Bytes read: " + bytesRead);
        for (int i = 0; i < bytesRead; i++) {
            System.out.print(buffer[i] + " ");
        }
    }
}
