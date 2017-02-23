import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExperiment {

	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		ExecutorService executors =  Executors.newFixedThreadPool(4);
		executors.submit(()->{
			System.out.println("Obtaining write lock thread1...");
			lock.writeLock().lock();
			try {
				System.out.println("sleeping wite thread1");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Releaseing write lock thread1...");
			lock.writeLock().unlock();
		});
		
		executors.submit(()->{
			System.out.println("Obtaining write lock thread2...");
			lock.writeLock().lock();
			try {
				System.out.println("sleeping wite thread2");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Releaseing write lock thread2...");
			lock.writeLock().unlock();
		});
		
		executors.submit(()->{
			System.out.println("Trying to read  thread3...");
			lock.readLock().lock();
			System.out.println("Finally available for reading (Thread3)");
			try {
				System.out.println("Reading... thread 3");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Finished reading (parallel with each other)");
			lock.readLock().unlock();
		});
		
		executors.submit(()->{
			System.out.println("Trying to read thread4...");
			lock.readLock().lock();
			System.out.println("Finally available for reading (Thread4)");
			try {
				System.out.println("Reading... thread 4");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Finished reading (parallel with each other)");
			lock.readLock().unlock();
		});
		
		
		executors.shutdown();

	}

}
