package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    private Lock lock = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }



    public void run() {
        lock.lock();
        try {
            while (stringIterator.hasNext()){
                copied += stringIterator.next() + " ";
            }
        } finally {
            lock.unlock();
        }
    }
}
