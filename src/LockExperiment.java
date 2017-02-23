import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockExperiment {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		
		ExecutorService executors =  Executors.newFixedThreadPool(2);
		executors.submit(()->{
			//Obtaining the lock
			lock.lock();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.unlock();
		});
		
		executors.submit(()->{
			while(lock.isLocked()){
				System.out.println("Lock is clocked, doing something else...");
				try {
					System.out.println("Busy with something else...");
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			boolean isLocked = lock.tryLock();
			System.out.println("Lock is unlocked?" + isLocked);
			lock.lock();
			System.out.println("The lock is mine!!!");
			lock.unlock();
		});
		
		executors.shutdown();

	}

}
