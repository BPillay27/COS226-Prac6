import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Visitor implements Runnable {
    private final int id;
    private final SemaphoreLock seats;
    private final List<Integer> boardingLog;

    public Visitor(int id, SemaphoreLock seats, List<Integer> boardingLog) {
        this.id = id;
        this.seats = seats;
        this.boardingLog = boardingLog;
    }

    @Override
    public void run() {
        // done
        seats.lock(this);
        try {
            synchronized (boardingLog) {
                boardingLog.add(id);
            }

            try {
                int time = ThreadLocalRandom.current().nextInt(100, 300);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } finally {
            seats.unlock();
        }
    }

    public String toString() {
        return "Visitor " + id;
    }
}
