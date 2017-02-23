package thread.consumerproducer;
import java.util.Date;
import java.util.Vector;

public class Producer extends Thread {
	
	private Vector<String> messages = new Vector<String>();
	private final int MAX_SIZE = 5;
	
	@Override
	public long getId() {
		return 1;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				
				putMessage();
				sleep(2000);
				//notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void putMessage() throws InterruptedException{
		while(messages.size() > MAX_SIZE){
			wait();
		}
		System.out.println("Producer: putting message :" + Thread.currentThread().getId());
		messages.addElement(new Date().toString());
		System.out.println("Producer: notifying put:" + Thread.currentThread().getId());
		notify();
	}

	public synchronized String getMessage() throws InterruptedException{
		System.out.println("Get: notifying other threads to wake up:" + Thread.currentThread().getId());
		notify();
		System.out.println("Get: checking if there are still messages left:" + Thread.currentThread().getId());
		while(messages.size() == 0){
			System.out.println("Producer/get: waiting for message............................................:" + Thread.currentThread().getId());
			wait();
		}
		System.out.println("Get: getting message:" + Thread.currentThread().getId());
		String message = messages.firstElement();
		messages.removeElement(message);
		System.out.println("Producer: returning message:" + Thread.currentThread().getId());
		return message;
	}
	

}
