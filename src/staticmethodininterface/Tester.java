package staticmethodininterface;

public class Tester {

	public static void main(String[] args) {
		StaticMethidInterface.testMethod();
		
		class StaticMethidInterfaceImpl implements StaticMethidInterface{
			
		}
		
		StaticMethidInterfaceImpl impl = new StaticMethidInterfaceImpl();
		
		System.out.println(impl.nonStaticHello);
		System.out.println(impl.staticHello);
		
			

	}

}
