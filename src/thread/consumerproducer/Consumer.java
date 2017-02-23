package thread.consumerproducer;

public class Consumer extends Thread{

	Producer p;
	
	@Override
	public long getId() {
		return 2;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				System.out.println("Reading message: "+ p.getMessage() + " :" + Thread.currentThread().getId());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Consumer(Producer p){
		this.p = p;
	}
	
	public static void main(String[] args) {
		Producer p = new Producer();
		Consumer c = new Consumer(p);
		p.start();
		c.start();

	}

}
