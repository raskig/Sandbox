
public class ConstructorExperiment {
	
	public final String finalString;
	public static final String staticFinalString = "must initialize";
	public static String staticString = "static 01";
	public String instanceVariableString = "class variable 01";
	
	static {
		System.out.println("static initialization");
		System.out.println("Static in tsatic initioalizartiuon is: " + staticString);
		staticString = "static 02";
		System.out.println("Static in tsatic after initialization is: " + staticString);
	}
	
	
	private ConstructorExperiment(String classVariableString) throws Exception{
		//this();
		//NOT WORKING: 
		finalString = "";
		System.out.println("parameter constructor called");
		this.instanceVariableString = classVariableString;
		staticString = classVariableString;
		System.out.println("Static value is: " + staticString);
		System.out.println("instance value is: " + classVariableString);
	}
	
	

	public ConstructorExperiment() throws Exception{
		super();
		finalString = "";
		System.out.println("no parameter constructor called");
		instanceVariableString = "class variable no argument constructor";
		staticString = "instance variable no argument constructor";
		System.out.println("Static value is: " + staticString);
		System.out.println("instance value is: " + instanceVariableString);
	}



	public static void main(String[] args) {
		ConstructorExperiment ce01;
		ConstructorExperiment ce02;
		try {
			ce01 = new ConstructorExperiment("instance variable with argument constructor 01");
			ce02 = new ConstructorExperiment("instance variable with argument constructor 02");

			System.out.println("instance variable value from ce01 is: " + ce01.instanceVariableString);
			System.out.println("instance value from ce02 is: " + ce02.instanceVariableString);
			
			System.out.println("static variable value from ce01 is: " + ce01.staticString);
			System.out.println("static variable value from ce02 is: " + ce01.staticString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		
	}

}
