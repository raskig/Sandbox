import java.util.ArrayList;
import java.util.List;

interface Edable{
	public String getName();
}

abstract class Fruit implements Edable{
	public abstract String getName();
}

class Apple extends Fruit{

	@Override
	public String getName() {
		return "apple";
	}
	
}

class Banana extends Fruit{

	@Override
	public String getName() {
		return "banana";
	}
	
}

public class GenericsExperiment<T extends Edable> {
	
	public void addToTray(List<? super T> tray, T food){
		tray.add(food);
	}
	
	public void eatAll(List<? extends T> eatMe){
		for (T t : eatMe) {
			System.out.println("Eating " + t.getName());
		}
	}

	public static void main(String[] args) {
		GenericsExperiment<Fruit> e = new GenericsExperiment<Fruit>();

		
		List<Fruit> tray = new ArrayList<Fruit>();
		e.addToTray(tray, new Banana());
		e.addToTray(tray, new Apple());
		e.eatAll(tray);
		
	}



}
