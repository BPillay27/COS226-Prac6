
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreLock {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition con = lock.newCondition();
        private final int capacity;
        private int seats_taken = 0;
        private final Queue<Visitor> waitList = new LinkedList<>();

        public SemaphoreLock(int capacity) {
            //TODO: Complete function
        }
        
        public void lock(Visitor visitor){
            //TODO: Complete function
            
        }
        
        public void unlock(){
            //TODO: Complete function
        }
}
