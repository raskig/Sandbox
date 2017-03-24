
public class ClassCastExperiment {

	public static void main(String[] args) {
		Inherit1 i1= new Inherit1();
		Inherit2 i2 = new Inherit2();
		
		ClassCastExperiment ci = i1;
		//ClassCastException:
		Inherit2 i3 = (Inherit2) ci;

	}

}


class Inherit1 extends ClassCastExperiment{
	
}

class Inherit2 extends ClassCastExperiment{
	
}