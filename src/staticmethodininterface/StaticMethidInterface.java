package staticmethodininterface;

public interface StaticMethidInterface {
	
	public static String staticHello = "staticHello";
	public String nonStaticHello = "nonStaticHello";
	
	public static void testMethod() {
		System.out.println("Implemented in interface");
	}
}


class TestImplementation implements StaticMethidInterface{
	static{
		StaticMethidInterface.testMethod();
	}
}