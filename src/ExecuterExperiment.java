import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterExperiment {

	
	public static void main(String[] args){
		
		Callable<String> task = () -> {
			Thread.sleep(5000);
			return "OK";
		};
		
		
		ExecutorService exser = Executors.newFixedThreadPool(2);
		exser.submit(()->{
			System.out.println("Running thread1");
		});
		
		exser.submit(()->{
			System.out.println("Running thread2");
		});

		exser.submit(()->{
			System.out.println("Running thread3");
		});
		
		exser.submit(()->{
			System.out.println("Running thread4");
		});
		
		Future<String> result = exser.submit(task);
		
		System.out.println("shutting down");
		exser.shutdown();
		System.out.println("it is down");
		
		while(!result.isDone()){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			System.out.println("Result is: " + result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
